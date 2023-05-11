package View;

import Controller.StartUpPageController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUpPage extends JFrame {
    private JButton drawButton;
    private JButton logInButton;
    private JButton requestLogInButton;
    private JPanel panel;
    private JButton exitButton;
    private JComboBox comboBox1;

    public StartUpPage() {

        setContentPane(panel);
        setTitle("StartUpPage");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JButton getDrawButton() {
        return drawButton;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public JButton getRequestLogInButton() {
        return requestLogInButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }
}
