package Java2.Lesson6;

import java.awt.font.TextHitInfo;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try (ServerSocket serverSocket = new ServerSocket(8181)) {
            System.out.println("Server is UP. Waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        System.out.println(dataInputStream.readUTF());
                    }
                } catch (IOException e) {
                    System.err.println("Lost client connection...");
                    new Server();
                }
            }).start();

            new Thread(() -> {
                try {
                    while (true) {
                        dataOutputStream.writeUTF("Server: " + new Scanner(System.in).nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
