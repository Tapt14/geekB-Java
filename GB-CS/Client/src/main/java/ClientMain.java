import AppSwing.AppMain;
import ClientStorage.ClientCloudStorage;
import ClientStorage.ClientCommandMessageManager;
import ClientStorage.NettyClient;

public class ClientMain {

    public static void main(String[] args) throws Exception {

      new ClientCloudStorage("localhost", 8180 );
    }

}

