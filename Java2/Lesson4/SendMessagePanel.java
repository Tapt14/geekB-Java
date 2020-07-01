package Java2.Lesson4;

import javax.swing.*;
<<<<<<< HEAD
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
=======
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMessagePanel extends JPanel {

    static String message;

    SendMessagePanel() {
        setLayout(new BorderLayout());
        JTextField senMessageTextField = new JTextField();
        add(senMessageTextField, BorderLayout.CENTER);
        senMessageTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = senMessageTextField.getText();
            }
        });
        JButton sendMessageButton = new JButton("Send");
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = senMessageTextField.getText();
            }
        });
        add(sendMessageButton, BorderLayout.EAST);
    }


>>>>>>> master

}
