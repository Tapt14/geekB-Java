package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;

import java.awt.event.ActionEvent;

public class DisconnectActionListener extends ClientSideActionListener{

    public DisconnectActionListener(ClientCloudStorage clientCloudStorage) {
        super(clientCloudStorage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clientCloudStorage.getCtx().close();
        clientCloudStorage.getAppMain().getCommonFilesInterface().remove(clientCloudStorage.getAppMain().getCommonFilesInterface().getServerSideFilesInterface());
        clientCloudStorage.getAppMain().getCommonFilesInterface().add(clientCloudStorage.getAppMain().getCommonFilesInterface().getLoginInterface());
        clientCloudStorage.getAppMain().getCommonFilesInterface().revalidate();
        clientCloudStorage.getAppMain().getCommonFilesInterface().repaint();
    }
}
