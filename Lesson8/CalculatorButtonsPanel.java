package Lesson8;

import javax.swing.*;
import java.awt.*;

public class CalculatorButtonsPanel extends JPanel {

    public CalculatorButtonsPanel() {

        setLayout(new GridLayout(4, 4));

        char[] buttons = {'7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '0', '.', '=', '+'};

        for (int i = 0; i < buttons.length; i++) {
            add(new Button(String.valueOf(buttons[i])));
        }


    }
}

