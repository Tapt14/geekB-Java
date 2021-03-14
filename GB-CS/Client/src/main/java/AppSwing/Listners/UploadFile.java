package AppSwing.Listners;

import ClientStorage.ClientCloudStorage;
import java.awt.event.ActionEvent;

public class UploadFile extends ClientSideActionListener {

    public UploadFile(ClientCloudStorage clientCloudStorage) {
        super(clientCloudStorage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clientCloudStorage.uploadFile();
    }
}
