package Java2.Lesson4;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {

    static private final JTextArea sendTextArea = new JTextArea();
    static private final JScrollPane scrollPanelSendTextArea = new JScrollPane(sendTextArea);

    MessagePanel () {
        setLayout(new BorderLayout());
        add(scrollPanelSendTextArea);
        sendTextArea.setBackground(new Color(230,230,230));
        sendTextArea.setEditable(false);
    }

    public static JTextArea getSendTextArea() {
        return sendTextArea;
    }
}
