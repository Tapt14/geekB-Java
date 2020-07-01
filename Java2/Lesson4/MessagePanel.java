package Java2.Lesson4;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {

    MessagePanel () {
        setLayout(new BorderLayout());
        JTextArea sendTextArea = new JTextArea();
        JScrollPane scrollPaneSendTextArea = new JScrollPane(sendTextArea);
        add(scrollPaneSendTextArea);
        sendTextArea.setBackground(new Color(230,230,230));
        sendTextArea.setEditable(false);
    }


}
