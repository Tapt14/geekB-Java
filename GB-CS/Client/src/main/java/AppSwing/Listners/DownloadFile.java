package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;

import java.awt.event.ActionEvent;

public class DownloadFile extends ClientSideActionListener {

    public DownloadFile(ClientCloudStorage clientCloudStorage) {
        super(clientCloudStorage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        clientCloudStorage.requestServerDownloadFile();
    }
}
