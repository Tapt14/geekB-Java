package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ServerSideSelectFile implements ListSelectionListener {

    ClientCloudStorage clientCloudStorage;

    public ServerSideSelectFile(ClientCloudStorage clientCloudStorage) {
        this.clientCloudStorage = clientCloudStorage;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        String selectedFile = clientCloudStorage.getAppMain().getCommonFilesInterface().getServerSideFilesInterface().getFilesList().getSelectedValue();
        clientCloudStorage.getAppMain().getCommonFilesInterface().getServerSideFilesInterface().getTextField().setText(selectedFile);
    }
}
