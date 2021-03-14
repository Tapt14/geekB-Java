package AppSwing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

abstract class FilesInterface extends JPanel {

    private final JTextField textField;

    private final JList<String> filesList;
    private final JScrollPane filesListScrollPane;
    private final JPanel buttonPanel;
    private final JPanel buttonPlusFilesListPanel;
    private final JLabel pathLabel;

    public FilesInterface() {
        setLayout(new BorderLayout());
        textField = new JTextField();
        textField.setEditable(false);
        textField.setMaximumSize(new Dimension(2147483647, 20));
        textField.setBackground(new Color(244,244,244));
        pathLabel = new JLabel();
        filesList = new JList<>();
        filesList.setBorder(new EmptyBorder(5, 5, 5, 5));
        filesList.setBackground(new Color(244, 244, 244));
        filesListScrollPane = new JScrollPane();
        filesListScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        filesListScrollPane.setViewportView(filesList);
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        buttonPlusFilesListPanel = new JPanel(new BorderLayout(10, 0));
        buttonPlusFilesListPanel.add(buttonPanel, BorderLayout.NORTH);
        buttonPlusFilesListPanel.add(filesListScrollPane, BorderLayout.CENTER);
        buttonPlusFilesListPanel.setBorder(new EmptyBorder(0, 5, 5, 5));
        add(textField, BorderLayout.NORTH);
        add(pathLabel, BorderLayout.SOUTH);
        add(buttonPlusFilesListPanel, BorderLayout.CENTER);
    }

    public JTextField getTextField() {
        return textField;
    }

    public JList<String> getFilesList() {
        return filesList;
    }

    public JScrollPane getFilesListScrollPane() {
        return filesListScrollPane;
    }

    public JPanel getButtonPlusFilesListPanel() {
        return buttonPlusFilesListPanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JLabel getPathLabel() {
        return pathLabel;
    }
}
