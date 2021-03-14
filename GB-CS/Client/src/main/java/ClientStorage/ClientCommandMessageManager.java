package ClientStorage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import messages.CommandMessages;
import messages.FileMessage;

public class ClientCommandMessageManager extends ChannelInboundHandlerAdapter {

    private final ClientCloudStorage clientCloudStorage;

    public ClientCommandMessageManager(ClientCloudStorage clientCloudStorage) {
        this.clientCloudStorage = clientCloudStorage;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        clientCloudStorage.setCtx(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        CommandMessages commandMessages = (CommandMessages) msg;

        switch (commandMessages.getCommand()) {

            case RESPONSE_SERVER_AUTH_OK:
                clientCloudStorage.responseServerAuthOk(commandMessages.getMessage());
                break;

            case RESPONSE_SERVER_DOWNLOAD_FILE:
                clientCloudStorage.saveFile((FileMessage) commandMessages.getObjectMessage());
                clientCloudStorage.getAppMain().clientCloudStorage.appMain.refreshClientSideFilesList();
                break;

            case RESPONSE_SERVER_REFRESH_SERVER_FILES_LIST:
                FileMessage fileMessage = (FileMessage) commandMessages.getObjectMessage();
                System.out.println("принял список");
                clientCloudStorage.getAppMain().getCommonFilesInterface().getServerSideFilesInterface().getFilesList().setListData(fileMessage.getServerFilesList());
                break;

            case RESPONSE_SERVER_DELETE_FILE_OK:
                String messageDeleteFileOk = "Файл " + commandMessages.getMessage() + " удален";
                clientCloudStorage.printMessageStatusBar(messageDeleteFileOk);
                clientCloudStorage.requestServerRefreshServerFilesList();
                break;

            case RESPONSE_SERVER_ERROR_MESSAGE:
                clientCloudStorage.printMessageStatusBar(commandMessages.getMessage());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


}
