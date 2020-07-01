package Java2.Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        new Client();
    }

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;


    public Client() {
        openConnection();
    }

    public void openConnection() {
        try {
            socket = new Socket("localhost", 8181);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String inputMassage = dataInputStream.readUTF();
                        if (inputMassage.equalsIgnoreCase("close")) {
                            closeConnection();
                            break;
                        } else {
                            System.out.println(inputMassage);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    while (true) {
                        String outputMessage = new Scanner(System.in).nextLine();
                        if (outputMessage.equalsIgnoreCase("close")) {
                            closeConnection();
                            break;
                        } else {
                            dataOutputStream.writeUTF("Client: " + outputMessage);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void closeConnection() {

        try {
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
