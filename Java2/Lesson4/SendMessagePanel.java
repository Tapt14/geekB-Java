package Java2.Lesson4;

import javax.swing.*;
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



}
