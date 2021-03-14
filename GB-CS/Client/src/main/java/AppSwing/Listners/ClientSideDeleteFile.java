package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;

import java.awt.event.ActionEvent;

public class ClientSideDeleteFile extends ClientSideActionListener {

    public ClientSideDeleteFile(ClientCloudStorage clientCloudStorage) {
        super(clientCloudStorage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedFile = clientCloudStorage.getAppMain().getCommonFilesInterface().getClientSideFilesInterface().getFilesList().getSelectedValue();

        try{
            clientCloudStorage.getAppMain().getStatusBarText().setText(clientCloudStorage.deleteFileClientSide(selectedFile));
            clientCloudStorage.getAppMain().clientCloudStorage.appMain.refreshClientSideFilesList();
        } catch (NullPointerException nullPointerException){
            clientCloudStorage.getAppMain().getStatusBarText().setText("Файл для удаления не выбран");
        }
    }
}
