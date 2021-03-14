import CloudStorage.CloudStorageServer;
import NettyServer.NettyServer;

public class MainServer {
    public static void main(String[] args) throws Exception {
        new NettyServer(new CloudStorageServer(8180)).run();
    }

}
