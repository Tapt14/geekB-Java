package NettyServer;

import CloudStorage.CloudStorageServer;
import DataBase.UserAuthHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import messages.AuthMessages;
import messages.CommandMessages;
import messages.Commands;

public class AuthManager extends ChannelInboundHandlerAdapter {

    ChannelHandlerContext ctx;
    CloudStorageServer cloudStorageServer;
    UserAuthHandler userAuthHandler;

    public AuthManager(CloudStorageServer cloudStorageServer) {
        this.cloudStorageServer = cloudStorageServer;
        this.userAuthHandler = cloudStorageServer.getUserAuthHandler();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
        System.out.println("Client connected");
        System.out.println(ctx);
        System.out.println(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        CommandMessages commandMessages = (CommandMessages) msg;

        switch (commandMessages.getCommand()) {
            case REQUEST_SERVER_CONNECTION:

                if(userAuthHandler.authorizeUser(commandMessages, ctx)) {

                    AuthMessages authMessages = (AuthMessages) commandMessages.getObjectMessage();
                    String login = authMessages.getLogin();
                    System.out.println(login + " auth - ok");
                    ctx.fireChannelRead(new CommandMessages(Commands.RESPONSE_SERVER_AUTH_OK, login));
                }
                break;
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
