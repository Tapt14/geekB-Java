package Java2.Lesson4;

import javax.swing.*;
import java.awt.*;

public class Messenger extends JFrame {

    Messenger() {
        setTitle("Messenger");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 150, 400, 500);
        add(new SendMessagePanel(), BorderLayout.PAGE_END);
        add(new MessagePanel(), BorderLayout.CENTER);
        setMinimumSize(new Dimension(200, 250));
        setVisible(true);
    }

}
