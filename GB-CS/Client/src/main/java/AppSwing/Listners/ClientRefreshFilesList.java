package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;

import java.awt.event.ActionEvent;

public class ClientRefreshFilesList extends ClientSideActionListener {


    public ClientRefreshFilesList(ClientCloudStorage clientCloudStorage) {
        super(clientCloudStorage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clientCloudStorage.getAppMain().clientCloudStorage.appMain.refreshClientSideFilesList();
    }

}
