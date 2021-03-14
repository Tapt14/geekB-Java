package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;

import java.awt.event.ActionListener;

public abstract class ClientSideActionListener implements ActionListener {

    ClientCloudStorage clientCloudStorage;

    public ClientSideActionListener(ClientCloudStorage clientCloudStorage) {
        this.clientCloudStorage = clientCloudStorage;
    }

}
