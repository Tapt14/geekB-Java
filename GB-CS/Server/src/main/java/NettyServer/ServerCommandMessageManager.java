package NettyServer;

import CloudStorage.CloudStorageServer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import messages.CommandMessages;
import messages.Commands;
import messages.FileMessage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ServerCommandMessageManager extends ChannelInboundHandlerAdapter {

    private ChannelHandlerContext ctx;
    private Path userServerRootPath;
    CloudStorageServer cloudStorageServer;

    public ServerCommandMessageManager(CloudStorageServer cloudStorageServer) {
        this.cloudStorageServer = cloudStorageServer;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("Client connected...");
        System.out.println(ctx);
        System.out.println(ctx);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        this.ctx = ctx;

        CommandMessages commandMessages = (CommandMessages) msg;

        switch (commandMessages.getCommand()) {

            case RESPONSE_SERVER_AUTH_OK:
                responseServerAuthOk(commandMessages.getMessage());
                break;


            case REQUEST_SERVER_UPLOAD_FILE:

                saveFile((FileMessage) commandMessages.getObjectMessage());
                break;

            case REQUEST_SERVER_REFRESH_FILES_LIST:

                sendServerFilesList();
                break;

            case REQUEST_SERVER_DOWNLOAD_FILE:
                sendFile(commandMessages.getMessage());
                break;

            case REQUEST_SERVER_DELETE_FILE:
                deleteFile(commandMessages.getMessage());
                break;
        }

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public void saveFile(FileMessage fileMessage) {

        Path realPath = Paths.get(getUserServerRootPath().toString(), fileMessage.getName());

        try {
            Files.write(realPath, fileMessage.getData(), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendServerFilesList();
    }

    public void deleteFile(String fileName) {
        new File(getRealPath(fileName).toString()).delete();
        ctx.writeAndFlush(new CommandMessages(Commands.RESPONSE_SERVER_DELETE_FILE_OK, fileName));
    }

    public void sendServerFilesList() {
        FileMessage fileMessage = new FileMessage(refreshFilesList());
        System.out.println(ctx);
        ctx.writeAndFlush(new CommandMessages(Commands.RESPONSE_SERVER_REFRESH_SERVER_FILES_LIST, fileMessage));
        System.out.println("fileList send");
        System.out.println(ctx);
    }

    public void sendFile(String fileName) {

        FileMessage fileMessage = new FileMessage(fileName, getRealPath(fileName));
        ctx.writeAndFlush(new CommandMessages(Commands.RESPONSE_SERVER_DOWNLOAD_FILE, fileMessage));

    }

    public void responseServerAuthOk(String login) {
        userServerRootPath = Paths.get("ServerStorage", login);
        ctx.channel().pipeline().remove(AuthManager.class);
        ctx.writeAndFlush(new CommandMessages(Commands.RESPONSE_SERVER_AUTH_OK, userServerRootPath.toString()));
    }

    public String[] refreshFilesList() {

        File f = new File(userServerRootPath.toString());
        String[] list = f.list();
        if (list != null) {
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(list));
            Collections.sort(arrayList);
            return arrayList.toArray(list);
        } else {
            list = new String[]{};
            return list;
        }
    }

    public Path getRealPath(String fileName) {

        return Paths.get(userServerRootPath.toString(), fileName);
    }

    public Path getUserServerRootPath() {
        return userServerRootPath;
    }

}
