package AppSwing;

import AppSwing.Listners.*;
import ClientStorage.ClientCloudStorage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AppMain extends JFrame {

    private final CommonFilesInterface commonFilesInterface;
    private final JTextField statusBarText;
    public final ClientCloudStorage clientCloudStorage;


    public AppMain(ClientCloudStorage clientCloudStorage) {
        this.clientCloudStorage = clientCloudStorage;
        setTitle("MyCloud");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(150, 150);

        statusBarText = new JTextField();
        statusBarText.setEditable(false);
        statusBarText.setMaximumSize(new Dimension(2147483647, 25));
        statusBarText.setBackground(new Color(238, 238, 238));
        statusBarText.setHorizontalAlignment(JTextField.CENTER);
        commonFilesInterface = new CommonFilesInterface();
        setMinimumSize(new Dimension(640, 300));
        setPreferredSize(new Dimension(1200, 750));
        getRootPane().setBorder(new EmptyBorder(5, 5, 5, 5));
        add(statusBarText, BorderLayout.SOUTH);
        add(commonFilesInterface, BorderLayout.CENTER);
        refreshClientSideFilesList();

        getCommonFilesInterface().getLoginInterface().getConnectServerButton().addActionListener(new ConnectActionListener(clientCloudStorage));

        getCommonFilesInterface().getClientSideFilesInterface().getUploadButton().addActionListener(new UploadFile(clientCloudStorage));
        getCommonFilesInterface().getClientSideFilesInterface().getRefreshFilesListButton().addActionListener(new ClientRefreshFilesList(clientCloudStorage));
        getCommonFilesInterface().getClientSideFilesInterface().getFilesList().addListSelectionListener(new ClientSideSelectFile(clientCloudStorage));
        getCommonFilesInterface().getClientSideFilesInterface().getDownloadButton().addActionListener(new DownloadFile(clientCloudStorage));
        getCommonFilesInterface().getClientSideFilesInterface().getDeleteFileButton().addActionListener(new ClientSideDeleteFile(clientCloudStorage));

        getCommonFilesInterface().getServerSideFilesInterface().getRefreshFilesListButton().addActionListener(new ServerRefreshFilesList(clientCloudStorage));
        getCommonFilesInterface().getServerSideFilesInterface().getFilesList().addListSelectionListener(new ServerSideSelectFile(clientCloudStorage));
        getCommonFilesInterface().getServerSideFilesInterface().getDisconnectServer().addActionListener(new DisconnectActionListener(clientCloudStorage));
        getCommonFilesInterface().getServerSideFilesInterface().getDeleteFileButton().addActionListener(new ServerSideDeleteFile(clientCloudStorage));
        setVisible(true);
        pack();


    }

    public CommonFilesInterface getCommonFilesInterface() {
        return commonFilesInterface;
    }

    public JTextField getStatusBarText() {
        return statusBarText;
    }

    public ClientCloudStorage getClientCloudStorage() {
        return clientCloudStorage;
    }

    public void refreshClientSideFilesList() {
        getCommonFilesInterface().getClientSideFilesInterface().getFilesList().setListData(clientCloudStorage.clientSideFilesList());
    }
}

