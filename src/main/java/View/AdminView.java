package View;

import javax.swing.*;

public class AdminView extends JFrame{
    private JPanel panel;
    private JButton backButton;
    private JTextField textNume;
    private JTextField textPrenume;
    private JTextField textUsername;
    private JTextField textParola;
    private JTextField textEmail;
    private JTextField textTip;
    private JButton createAccountButton;
    private JButton showListButton;
    private JTable usersRequestsTable ;
    private JLabel numeLabel;
    private JLabel prenumeLabel;
    private JLabel usernameLabel;
    private JLabel parolaLabel;
    private JLabel emailLabel;
    private JLabel tipLabel;
    private JComboBox comboBox1;
    private JComboBox filterListComboBox;
    private JButton showFilteredListButton;

    public AdminView() {
        setContentPane(panel);
        setTitle("StartUpPage");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public JButton getBackButton() {
        return backButton;
    }

    public JTextField getTextNume() {
        return textNume;
    }

    public JTextField getTextPrenume() {
        return textPrenume;
    }

    public JTextField getTextUsername() {
        return textUsername;
    }

    public JTextField getTextParola() {
        return textParola;
    }

    public JTextField getTextEmail() {
        return textEmail;
    }

    public JTextField getTextTip() {
        return textTip;
    }

    public JButton getCreateAccountButton() {
        return createAccountButton;
    }

    public JButton getShowListButton() {
        return showListButton;
    }

    public JTable getUsersRequestsTable() {
        return usersRequestsTable;
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

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JLabel getParolaLabel() {
        return parolaLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JLabel getTipLabel() {
        return tipLabel;
    }

    public JComboBox getFilterListComboBox() {
        return filterListComboBox;
    }

    public JButton getShowFilteredListButton() {
        return showFilteredListButton;
    }
}
