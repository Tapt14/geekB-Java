package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;

public class ClientSideSelectFile implements ListSelectionListener {

    ClientCloudStorage clientCloudStorage;

    public ClientSideSelectFile(ClientCloudStorage clientCloudStorage) {
        this.clientCloudStorage = clientCloudStorage;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       String selectedFile = clientCloudStorage.getAppMain().getCommonFilesInterface().getClientSideFilesInterface().getFilesList().getSelectedValue();

        clientCloudStorage.getAppMain().getCommonFilesInterface().getClientSideFilesInterface().getTextField().setText(selectedFile);

    }
}
