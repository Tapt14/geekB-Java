package AppSwing;

import javax.swing.*;

public class ClientSideFilesInterface extends FilesInterface {

    private final JButton refreshFilesListButton;
    private final JButton uploadButton;
    private final JButton downloadButton;
    private final JButton deleteFileButton;


    public ClientSideFilesInterface() {
        super();
        getPathLabel().setText("../ClientStorage");

        refreshFilesListButton = new JButton("Refresh");
        uploadButton = new JButton("Upload");
        downloadButton = new JButton("Download");
        deleteFileButton = new JButton("Delete");

        getButtonPanel().add(refreshFilesListButton);
        getButtonPanel().add(uploadButton);
        getButtonPanel().add(downloadButton);
        getButtonPanel().add(deleteFileButton);

    }

    public JButton getUploadButton() {
        return uploadButton;
    }

    public JButton getRefreshFilesListButton() {
        return refreshFilesListButton;
    }

    public JButton getDownloadButton() {
        return downloadButton;
    }

    public JButton getDeleteFileButton() {
        return deleteFileButton;
    }
}
