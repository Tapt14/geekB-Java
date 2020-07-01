package Java2.Lesson4;

import javax.swing.*;
import java.awt.*;

public class Messenger extends JFrame {

<<<<<<< HEAD
   static SendMessagePanel sendMessagePanel = new SendMessagePanel();
    static MessagePanel messagePanel = new MessagePanel();

=======
>>>>>>> master
    Messenger() {
        setTitle("Messenger");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 150, 400, 500);
<<<<<<< HEAD
        add(sendMessagePanel, BorderLayout.PAGE_END);
        add(messagePanel, BorderLayout.CENTER);
=======
        add(new SendMessagePanel(), BorderLayout.PAGE_END);
        add(new MessagePanel(), BorderLayout.CENTER);
>>>>>>> master
        setMinimumSize(new Dimension(200, 250));
        setVisible(true);
    }

<<<<<<< HEAD
    static void sendMessage (String text) {
        if(!text.equals(""))
        MessagePanel.getSendTextArea().append("Name: " +text + "\n");
    }

=======
>>>>>>> master
}
