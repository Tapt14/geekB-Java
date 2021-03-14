package CloudStorage;

import DataBase.UserAuthHandler;

import java.nio.file.Path;

public class CloudStorageServer {

    private final int PORT;
    private Path STORAGE_ROOT_PATH;
    private final UserAuthHandler userAuthHandler;

    public CloudStorageServer(int PORT) {
        this.PORT = PORT;
        userAuthHandler = new UserAuthHandler(this);
    }

    public int getPORT() {
        return PORT;
    }

    public Path getSTORAGE_ROOT_PATH() {
        return STORAGE_ROOT_PATH;
    }

    public void setSTORAGE_ROOT_PATH(Path STORAGE_ROOT_PATH) {
        this.STORAGE_ROOT_PATH = STORAGE_ROOT_PATH;
    }

    public UserAuthHandler getUserAuthHandler() {
        return userAuthHandler;
    }
}
