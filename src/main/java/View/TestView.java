package View;

import javax.swing.*;

public class TestView extends JFrame {
    private JPanel panel;
    private JButton backButton;
    private JButton afisareRezultatButton;
    private JButton generareItrebariButton;
    private JButton afisareGraficButton;
    private JTextField rezultat;
    private JTextField intrebare1;
    private JTextField intrebare2;
    private JTextField intrebare3;
    private JTextField intrebare4;
    private JTextField intrebare5;
    private JTextField intrebare6;
    private JTextField intrebare7;
    private JTextField intrebare8;
    private JTextField intrebare9;
    private JTextField intrebare10;
    private JTextField raspuns1;
    private JTextField raspuns2;
    private JTextField raspuns3;
    private JTextField raspuns4;
    private JTextField raspuns5;
    private JTextField raspuns6;
    private JTextField raspuns7;
    private JTextField raspuns8;
    private JTextField raspuns9;
    private JTextField raspuns10;
    private JComboBox comboBox1;

    public TestView() {

        setContentPane(panel);
        setTitle("StartUpPage");
        setSize(1200, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JButton getBackButton() {
        return backButton;
    }
    public JButton getAfisareRezultatButton() {
        return afisareRezultatButton;
    }
    public JButton getGenerareItrebariButton() {
        return generareItrebariButton;
    }
    public JButton getAfisareGraficButton() { return afisareGraficButton; }

    public JTextField getRezultat() {
        return rezultat;
    }

    public JTextField getIntrebare1() {
        return intrebare1;
    }

    public JTextField getIntrebare2() {
        return intrebare2;
    }

    public JTextField getIntrebare3() {
        return intrebare3;
    }

    public JTextField getIntrebare4() {
        return intrebare4;
    }

    public JTextField getIntrebare5() {
        return intrebare5;
    }

    public JTextField getIntrebare6() {
        return intrebare6;
    }

    public JTextField getIntrebare7() {
        return intrebare7;
    }

    public JTextField getIntrebare8() {
        return intrebare8;
    }

    public JTextField getIntrebare9() {
        return intrebare9;
    }

    public JTextField getIntrebare10() {
        return intrebare10;
    }

    public JTextField getRaspuns1() {
        return raspuns1;
    }

    public JTextField getRaspuns2() {
        return raspuns2;
    }

    public JTextField getRaspuns3() {
        return raspuns3;
    }

    public JTextField getRaspuns4() {
        return raspuns4;
    }

    public JTextField getRaspuns5() {
        return raspuns5;
    }

    public JTextField getRaspuns6() {
        return raspuns6;
    }

    public JTextField getRaspuns7() {
        return raspuns7;
    }

    public JTextField getRaspuns8() {
        return raspuns8;
    }

    public JTextField getRaspuns9() {
        return raspuns9;
    }

    public JTextField getRaspuns10() {
        return raspuns10;
    }

}
