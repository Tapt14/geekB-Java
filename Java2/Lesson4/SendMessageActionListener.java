package Java2.Lesson4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMessageActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Messenger.sendMessage(SendMessagePanel.getSendMessageTextField().getText());
        SendMessagePanel.getSendMessageTextField().setText("");
    }
}
