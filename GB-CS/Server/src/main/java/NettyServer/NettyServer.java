package NettyServer;

import CloudStorage.CloudStorageServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class NettyServer {

    private final CloudStorageServer cloudStorageServer;

    public NettyServer(CloudStorageServer cloudStorageServer) {
        this.cloudStorageServer = cloudStorageServer;
    }

    public void run() throws Exception {

        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(mainGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) {
                            socketChannel.pipeline().addLast(
                                    new ObjectDecoder(50 * 1024 * 1024, ClassResolvers.cacheDisabled(null)),
                                    new ObjectEncoder(),
                                    new AuthManager(cloudStorageServer),
                                    new ServerCommandMessageManager(cloudStorageServer)
                                    //входящий обработчик объектов-сообщений(команд) на авторизацию клиента(пользователя)
                                    //new AuthGateway(storageServer),
                                    //входящий обработчик объектов-сообщений(команд) по управлению сетевым хранилищем
                                    //new CommandMessageManager(storageServer)
                            );
                        }
                    })
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture future = b.bind(cloudStorageServer.getPORT()).sync();

            onConnectionReady(future);
            future.channel().closeFuture().sync();

        } finally {
            mainGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public void onConnectionReady(ChannelFuture future) {

        System.out.println("\n Server running...");
        //printMsg("Server running...");
    }

    public void printMsg(String msg){
       // storageServer.printMsg(msg);
    }
}
