package Lesson8;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame () {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(new CalculatorDisplayPanel("0"), BorderLayout.NORTH);
        add(new CalculatorButtonsPanel(), BorderLayout.CENTER);
        pack();
    }
}
