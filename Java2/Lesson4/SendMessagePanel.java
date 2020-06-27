package Java2.Lesson4;

import javax.swing.*;
import java.awt.*;

public class SendMessagePanel extends JPanel {

    private static final JTextField sendMessageTextField = new JTextField();
    private static final JButton sendMessageButton = new JButton("Send");

    SendMessagePanel() {
        setLayout(new BorderLayout());
        add(sendMessageTextField, BorderLayout.CENTER);
        add(sendMessageButton, BorderLayout.EAST);
        sendMessageTextField.addActionListener(new SendMessageActionListener());
        sendMessageButton.addActionListener(new SendMessageActionListener());
    }

    public static JTextField getSendMessageTextField() {
        return sendMessageTextField;
    }

}
