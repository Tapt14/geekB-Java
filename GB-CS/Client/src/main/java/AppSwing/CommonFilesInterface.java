package AppSwing;

import javax.swing.*;
import java.awt.*;

public class CommonFilesInterface extends JPanel {

   private final ClientSideFilesInterface clientSideFilesInterface;
   private final ServerSideFilesInterface serverSideFilesInterface;
   LoginInterface loginInterface;


    public CommonFilesInterface() {
        clientSideFilesInterface = new ClientSideFilesInterface();
        serverSideFilesInterface = new ServerSideFilesInterface();
        loginInterface = new LoginInterface();
        setLayout(new GridLayout(1, 2, 5, 5));
        add(clientSideFilesInterface);
        //add(serverSideFilesInterface);
        add(loginInterface);
    }

    public ClientSideFilesInterface getClientSideFilesInterface() {
        return clientSideFilesInterface;
    }

   public ServerSideFilesInterface getServerSideFilesInterface() {
        return serverSideFilesInterface;
    }

    public LoginInterface getLoginInterface() {
        return loginInterface;
    }
}

