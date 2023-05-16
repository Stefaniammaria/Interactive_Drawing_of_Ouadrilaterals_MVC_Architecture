package View;

import javax.swing.*;

public class RequestLogInView extends JFrame{
    private JTextField textNume;
    private JTextField textPrenume;
    private JTextField textEmail;
    private JPanel panel;
    private JButton requestLogInButton;
    private JButton backButton;
    private JComboBox comboBox1;
    private JLabel numeLabel;
    private JLabel prenumeLabel;
    private JLabel emailLabel;
    private JLabel tipLabel;
    private JTextField tipField;

    public RequestLogInView() {

        setContentPane(panel);
        setTitle("StartUpPage");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JLabel getNumeLabel() {
        return numeLabel;
    }

    public JLabel getPrenumeLabel() {
        return prenumeLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JTextField getTextNume() {
        return textNume;
    }

    public JTextField getTextPrenume() {
        return textPrenume;
    }

    public JTextField getTextEmail() {
        return textEmail;
    }

    public JButton getRequestLogInButton() {
        return requestLogInButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getTipLabel() {
        return tipLabel;
    }

    public JTextField getTipField() {
        return tipField;
    }

}
