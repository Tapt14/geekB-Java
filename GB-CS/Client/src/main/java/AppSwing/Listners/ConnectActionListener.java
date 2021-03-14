package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;
import ClientStorage.NettyClient;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectActionListener implements ActionListener {

    ClientCloudStorage clientCloudStorage;

    public ConnectActionListener(ClientCloudStorage clientCloudStorage) {
        this.clientCloudStorage = clientCloudStorage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String login = clientCloudStorage.getAppMain().getCommonFilesInterface().getLoginInterface().getLoginField().getText();
        String password = clientCloudStorage.getAppMain().getCommonFilesInterface().getLoginInterface().getPasswordField().getText();
        clientCloudStorage.requestServerAuthUser(login, password);

    }
}

