package Java2.Lesson4;

import javax.swing.*;
import java.awt.*;

public class Messenger extends JFrame {

   static SendMessagePanel sendMessagePanel = new SendMessagePanel();
    static MessagePanel messagePanel = new MessagePanel();

    Messenger() {
        setTitle("Messenger");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 150, 400, 500);
        add(sendMessagePanel, BorderLayout.PAGE_END);
        add(messagePanel, BorderLayout.CENTER);
        setMinimumSize(new Dimension(200, 250));
        setVisible(true);
    }

    static void sendMessage (String text) {
        if(!text.equals(""))
        MessagePanel.getSendTextArea().append("Name: " +text + "\n");
    }

}
