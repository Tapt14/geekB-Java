package ClientStorage;

import AppSwing.AppMain;

import io.netty.channel.ChannelHandlerContext;
import messages.AuthMessages;
import messages.CommandMessages;
import messages.Commands;
import messages.FileMessage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClientCloudStorage {

    private final String IP_ADDR;
    private final int PORT;
    private ChannelHandlerContext ctx;
    private final Path CLIENT_ROOT_PATH = Paths.get("ClientStorage");
    public final AppMain appMain;


    public ClientCloudStorage(String IP_ADDR, int PORT) {
        this.IP_ADDR = IP_ADDR;
        this.PORT = PORT;
        this.appMain = new AppMain(this);
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public void uploadFile() {

        try {
            String fileName = getAppMain().getCommonFilesInterface().getClientSideFilesInterface().getFilesList().getSelectedValue();
            FileMessage fileMessage = new FileMessage(fileName, getRealPath(fileName));
            ctx.writeAndFlush(new CommandMessages(Commands.REQUEST_SERVER_UPLOAD_FILE, fileMessage));
        } catch (NullPointerException e) {
            printMessageStatusBar("Файл не выбран");
        }
    }

    public String deleteFileClientSide(String fileName) {
        String message;
        if (new File(getRealPath(fileName).toString()).delete()) {
            message = "Файл " + fileName + " удален";
        } else {
            message = "Не удается удалить файл " + fileName;
        }
        return message;
    }

    public void saveFile(FileMessage fileMessage) {

        Path realPath = Paths.get(getCLIENT_ROOT_PATH().toString(), fileMessage.getName());

        try {
            Files.write(realPath, fileMessage.getData(), StandardOpenOption.CREATE_NEW);
        } catch (FileAlreadyExistsException e) {
            String message = "Файл " + fileMessage.getName() + " уже существует";
            getAppMain().getStatusBarText().setText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] clientSideFilesList() {
        File f = new File("ClientStorage");
        String[] list = f.list();
        if (list != null) {
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(list));
            Collections.sort(arrayList);
            return arrayList.toArray(list);
        } else {
            list = new String[]{""};
            return list;
        }

    }

    public void requestServerRefreshServerFilesList() {
        ctx.writeAndFlush(new CommandMessages(Commands.REQUEST_SERVER_REFRESH_FILES_LIST));
    }

    public void requestServerDownloadFile() {

        String fileName = getAppMain().getCommonFilesInterface().getServerSideFilesInterface().getTextField().getText();
        if (fileName != null) {
            ctx.writeAndFlush(new CommandMessages(Commands.REQUEST_SERVER_DOWNLOAD_FILE, fileName));
        } else {
            printMessageStatusBar("Файл для скачивания не выбран");
        }

    }

    public void requestServerDeleteFile() {

        String fileName = getAppMain().getCommonFilesInterface().getServerSideFilesInterface().getFilesList().getSelectedValue();
        if (fileName != null) {
            ctx.writeAndFlush(new CommandMessages(Commands.REQUEST_SERVER_DELETE_FILE, fileName));
        } else {
            printMessageStatusBar("Файл не выбран");
        }

    }

    public void requestServerAuthUser(String login, String password) {

        new Thread(() -> {
            try {
                new NettyClient(this).run();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }).start();

        while (ctx == null) {
            printMessageStatusBar("Connecting to server...");
        }

        printMessageStatusBar("");
        AuthMessages authMessages = new AuthMessages(login, password);
        ctx.writeAndFlush(new CommandMessages(Commands.REQUEST_SERVER_CONNECTION, authMessages));


    }

    public void responseServerAuthOk(String serverUserPath) {
        getAppMain().getCommonFilesInterface().remove(getAppMain().getCommonFilesInterface().getLoginInterface());
        getAppMain().getCommonFilesInterface().add(getAppMain().getCommonFilesInterface().getServerSideFilesInterface());
        getAppMain().getCommonFilesInterface().revalidate();
        getAppMain().getCommonFilesInterface().repaint();
        getAppMain().getCommonFilesInterface().getServerSideFilesInterface().getPathLabel().setText("../" + serverUserPath);
        requestServerRefreshServerFilesList();
    }

    public void printMessageStatusBar(String s) {
        getAppMain().getStatusBarText().setText(s);
    }


    public String getIP_ADDR() {
        return IP_ADDR;
    }

    public int getPORT() {
        return PORT;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public Path getRealPath(String itemPathname) {

        return Paths.get(CLIENT_ROOT_PATH.toString(), itemPathname);
    }

    public AppMain getAppMain() {
        return appMain;
    }

    public Path getCLIENT_ROOT_PATH() {
        return CLIENT_ROOT_PATH;
    }
}
