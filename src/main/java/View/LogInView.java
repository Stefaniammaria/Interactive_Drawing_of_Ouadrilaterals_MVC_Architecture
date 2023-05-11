package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInView extends JFrame{
    private JButton logInButton;
    private JButton backButton;
    private JPanel panel;
    private JTextField textUsername;
    private JTextField textParola;
    private JComboBox comboBox1;
    private JLabel usernameLabel;
    private JLabel parolaLabel;

    public LogInView() {

        setContentPane(panel);
        setTitle("StartUpPage");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JLabel getParolaLabel() {
        return parolaLabel;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JTextField getTextUsername() {
        return textUsername;
    }

    public JTextField getTextParola() {
        return textParola;
    }
}
