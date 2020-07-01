package Java2.Lesson4;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {

<<<<<<< HEAD
    static private final JTextArea sendTextArea = new JTextArea();
    static private final JScrollPane scrollPanelSendTextArea = new JScrollPane(sendTextArea);

    MessagePanel () {
        setLayout(new BorderLayout());
        add(scrollPanelSendTextArea);
=======
    MessagePanel () {
        setLayout(new BorderLayout());
        JTextArea sendTextArea = new JTextArea();
        JScrollPane scrollPaneSendTextArea = new JScrollPane(sendTextArea);
        add(scrollPaneSendTextArea);
>>>>>>> master
        sendTextArea.setBackground(new Color(230,230,230));
        sendTextArea.setEditable(false);
    }

<<<<<<< HEAD
    public static JTextArea getSendTextArea() {
        return sendTextArea;
    }
=======

>>>>>>> master
}
