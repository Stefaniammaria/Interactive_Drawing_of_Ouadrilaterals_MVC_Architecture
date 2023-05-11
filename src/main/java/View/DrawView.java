package View;


import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawView extends JPanel {

    JFrame frame = new JFrame("MyPanel");
    private JButton getInfoButton;
    private JButton backButton;
    private JButton saveButton;
    private JButton loadButton;
    private JTextField numeFisierField;
    private JTextField arieField;
    private JTextField perimetruField;
    private JTextField latura1Field;
    private JTextField latura2Field;
    private JTextField latura3Field;
    private JTextField latura4Field;
    private JTextField unghi1Field;
    private JTextField unghi2Field;
    private JTextField unghi3Field;
    private JTextField unghi4Field;
    private JLabel unghi1label;
    private JLabel unghi2label;
    private JLabel unghi3label;
    private JLabel unghi4label;
    private JLabel latura1label;
    private JLabel latura2label;
    private JLabel latura3label;
    private JLabel latura4label;
    private JLabel arieLabel;
    private JLabel perimetruLabel;
    private JTextField convexConcavField;
    private JLabel convexconcavLabel;
    private JTextField inscriptibilField;
    private JLabel inscriptibilLabel;
    private JTextField circumscriptibilField;
    private JLabel circumscriptibilLabel;
    private JTextField razaCerCircumscrisField;
    private JLabel razaCercCircumscrisLabel;
    private JTextField razaCercInscrisField;
    private JLabel razaCercInscrisLabel;
    private JLabel numeFisierLabel;
    private JComboBox comboBox1;
    private ArrayList<Drawing> drawingArrayList = new ArrayList<>();
    public DrawView() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adjust size and set layout
        getInfoButton = new JButton("Get Info");
        backButton = new JButton("Back");
        saveButton = new JButton("Save File");
        loadButton = new JButton("Load File");
        numeFisierField = new JTextField(5);
        arieField = new JTextField(5);
        perimetruField = new JTextField(5);
        latura1Field = new JTextField(5);
        latura2Field = new JTextField(5);
        latura3Field = new JTextField(5);
        latura4Field = new JTextField(5);
        unghi1Field = new JTextField(5);
        unghi2Field = new JTextField(5);
        unghi3Field = new JTextField(5);
        unghi4Field = new JTextField(5);
        unghi1label = new JLabel("Unghi 1");
        unghi2label = new JLabel("Unghi 2");
        unghi3label = new JLabel("Unghi 4");
        unghi4label = new JLabel("Unghi 3");
        latura1label = new JLabel("Latura 1");
        latura2label = new JLabel("Latura 2");
        latura3label = new JLabel("Latura 3");
        latura4label = new JLabel("Latura 4");
        arieLabel = new JLabel("Arie");
        perimetruLabel = new JLabel("Perimetru");
        convexConcavField = new JTextField(5);
        convexconcavLabel = new JLabel("Convex/Concav");
        inscriptibilField = new JTextField(5);
        inscriptibilLabel = new JLabel("Inscriptibil");
        circumscriptibilField = new JTextField(5);
        circumscriptibilLabel = new JLabel("Circumscriptibil");
        razaCerCircumscrisField = new JTextField(5);
        razaCercCircumscrisLabel = new JLabel("Raza cercului circumscris");
        razaCercInscrisField = new JTextField(5);
        razaCercInscrisLabel = new JLabel("Raza cercului inscris");
        numeFisierLabel = new JLabel("Nume fisier:");
        comboBox1 = new JComboBox<>();

        //set component bounds (only needed by Absolute Positioning)
        getInfoButton.setBounds(450, 25, 120, 25);
        backButton.setBounds(650, 395, 100, 25);
        saveButton.setBounds(650, 425, 100, 25);
        loadButton.setBounds(650, 455, 100, 25);
        arieField.setBounds(650, 20, 100, 25);
        numeFisierField.setBounds(450,425,180,25);
        perimetruField.setBounds(650, 60, 100, 25);
        latura1Field.setBounds(535, 110, 80, 25);
        latura2Field.setBounds(625, 145, 75, 25);
        latura3Field.setBounds(535, 180, 80, 25);
        latura4Field.setBounds(450, 145, 75, 25);
        unghi1Field.setBounds(450, 110, 75, 25);
        unghi2Field.setBounds(625, 110, 75, 25);
        unghi3Field.setBounds(625, 180, 75, 25);
        unghi4Field.setBounds(450, 180, 75, 25);
        unghi1label.setBounds(465, 90, 65, 20);
        unghi2label.setBounds(640, 90, 50, 20);
        unghi3label.setBounds(465, 200, 55, 20);
        unghi4label.setBounds(640, 200, 55, 20);
        latura1label.setBounds(550, 90, 60, 20);
        latura2label.setBounds(700, 150, 60, 15);
        latura3label.setBounds(550, 200, 50, 25);
        latura4label.setBounds(400, 145, 50, 25);
        arieLabel.setBounds(590, 20, 60, 25);
        perimetruLabel.setBounds(590, 60, 60, 25);
        convexConcavField.setBounds(650, 245, 100, 25);
        convexconcavLabel.setBounds(500, 245, 95, 25);
        inscriptibilField.setBounds(650, 275, 100, 25);
        inscriptibilLabel.setBounds(500, 275, 65, 25);
        circumscriptibilField.setBounds(650, 305, 100, 25);
        circumscriptibilLabel.setBounds(500, 305, 95, 25);
        razaCerCircumscrisField.setBounds(650, 335, 100, 25);
        razaCercCircumscrisLabel.setBounds(500, 335, 155, 25);
        razaCercInscrisField.setBounds(650, 365, 100, 25);
        razaCercInscrisLabel.setBounds(500, 365, 130, 25);
        numeFisierLabel.setBounds(450, 400, 130, 25);
        comboBox1.setBounds(450,450,180,25);
        //add components
        frame.add(getInfoButton);
        frame.add(arieField);
        frame.add(perimetruField);
        frame.add(latura1Field);
        frame.add(latura2Field);
        frame.add(latura3Field);
        frame.add(latura4Field);
        frame.add(unghi1Field);
        frame.add(unghi2Field);
        frame.add(unghi3Field);
        frame.add(unghi4Field);
        frame.add(unghi1label);
        frame.add(unghi2label);
        frame.add(unghi3label);
        frame.add(unghi4label);
        frame.add(latura1label);
        frame.add(latura2label);
        frame.add(latura3label);
        frame.add(latura4label);
        frame.add(arieLabel);
        frame.add(perimetruLabel);
        frame.add(convexConcavField);
        frame.add(convexconcavLabel);
        frame.add(inscriptibilField);
        frame.add(inscriptibilLabel);
        frame.add(circumscriptibilField);
        frame.add(circumscriptibilLabel);
        frame.add(razaCerCircumscrisField);
        frame.add(razaCercCircumscrisLabel);
        frame.add(razaCercInscrisField);
        frame.add(razaCercInscrisLabel);
        frame.add(backButton);
        frame.add(saveButton);
        frame.add(loadButton);
        frame.add(numeFisierField);
        frame.add(numeFisierLabel);
        frame.add(comboBox1);

        frame.getContentPane().add(this);
        frame.setResizable(true);
        frame.pack();
        frame.setSize(new Dimension(800, 550));
        frame.setVisible(true);

    }
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        drawingArrayList.forEach(drawing -> {

            drawing.draw(g);

        });

    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getGetInfoButton() {
        return getInfoButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JTextField getNumeFisierField() {
        return numeFisierField;
    }

    public JTextField getArieField() {
        return arieField;
    }

    public JTextField getPerimetruField() {
        return perimetruField;
    }

    public JTextField getLatura1Field() {
        return latura1Field;
    }

    public JTextField getLatura2Field() {
        return latura2Field;
    }

    public JTextField getLatura3Field() {
        return latura3Field;
    }

    public JTextField getLatura4Field() {
        return latura4Field;
    }

    public JTextField getUnghi1Field() {
        return unghi1Field;
    }

    public JTextField getUnghi2Field() {
        return unghi2Field;
    }

    public JTextField getUnghi3Field() {
        return unghi3Field;
    }

    public JTextField getUnghi4Field() {
        return unghi4Field;
    }

    public JTextField getConvexConcavField() {
        return convexConcavField;
    }

    public JTextField getInscriptibilField() {
        return inscriptibilField;
    }

    public JTextField getCircumscriptibilField() {
        return circumscriptibilField;
    }

    public JTextField getRazaCerCircumscrisField() {
        return razaCerCircumscrisField;
    }

    public JTextField getRazaCercInscrisField() {
        return razaCercInscrisField;
    }

    public ArrayList<Drawing> getDrawingArrayList() {
        return drawingArrayList;
    }

    public JLabel getUnghi1label() {
        return unghi1label;
    }

    public JLabel getUnghi2label() {
        return unghi2label;
    }

    public JLabel getUnghi3label() {
        return unghi3label;
    }

    public JLabel getUnghi4label() {
        return unghi4label;
    }

    public JLabel getLatura1label() {
        return latura1label;
    }

    public JLabel getLatura2label() {
        return latura2label;
    }

    public JLabel getLatura3label() {
        return latura3label;
    }

    public JLabel getLatura4label() {
        return latura4label;
    }

    public JLabel getArieLabel() {
        return arieLabel;
    }

    public JLabel getPerimetruLabel() {
        return perimetruLabel;
    }

    public JLabel getConvexconcavLabel() {
        return convexconcavLabel;
    }

    public JLabel getInscriptibilLabel() {
        return inscriptibilLabel;
    }

    public JLabel getCircumscriptibilLabel() {
        return circumscriptibilLabel;
    }

    public JLabel getRazaCercCircumscrisLabel() {
        return razaCercCircumscrisLabel;
    }

    public JLabel getRazaCercInscrisLabel() {
        return razaCercInscrisLabel;
    }

    public JLabel getNumeFisierLabel() {
        return numeFisierLabel;
    }
}