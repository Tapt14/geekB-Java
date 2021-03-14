package AppSwing;

import javax.swing.*;

public class ServerSideFilesInterface extends FilesInterface{

    private final JButton refreshFilesListButton;
    private final JButton deleteFileButton;
    private final JButton disconnectServer;

    public ServerSideFilesInterface() {
        super();

        refreshFilesListButton = new JButton("Refresh");
        deleteFileButton = new JButton("Delete");
        disconnectServer = new JButton("Disconnect");

        getButtonPanel().add(refreshFilesListButton);
        getButtonPanel().add(deleteFileButton);
        getButtonPanel().add(disconnectServer);
    }

    public JButton getRefreshFilesListButton() {
        return refreshFilesListButton;
    }

    public JButton getDeleteFileButton() {
        return deleteFileButton;
    }

    public JButton getDisconnectServer() {
        return disconnectServer;
    }
}
