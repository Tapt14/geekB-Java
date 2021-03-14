package messages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMessage extends Message {

    private String name;
    private byte[] data;
    private String[] serverFilesList;


    public FileMessage(String name, Path filePath) {
        this.name = name;
        try {
            this.data = Files.readAllBytes(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileMessage(String[] serverFilesList) {
        this.serverFilesList = serverFilesList;
    }

    public byte[] getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public String[] getServerFilesList() {
        return serverFilesList;
    }
}
