package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerSideDeleteFile implements ActionListener {

    ClientCloudStorage clientCloudStorage;

    public ServerSideDeleteFile(ClientCloudStorage clientCloudStorage) {
        this.clientCloudStorage = clientCloudStorage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clientCloudStorage.requestServerDeleteFile();
    }
}
