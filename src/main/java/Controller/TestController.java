package Controller;

import Model.Entities.Question;
import Model.Entities.Rezultat;
import Model.Entities.Test;
import Model.Persistence.AbstractPersistence;
import View.TestView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TestController extends Observer{

    private TestView testView;
    private List<String> raspunsuriIntrebari = new ArrayList<>();

    @Override
    public void language() {
        Locale l = new Locale(Language.lang,Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle",l);
        testView.getGenerareItrebariButton().setText(resourceBundle.getString("generareIntrebari"));
        testView.getAfisareRezultatButton().setText(resourceBundle.getString("afisareRezultat"));
        testView.getAfisareGraficButton().setText(resourceBundle.getString("afisareGrafic"));
        testView.getBackButton().setText(resourceBundle.getString("back"));
    }

    public TestController() {
        this.testView = new TestView();
        language();
        TestController t = this;

        testView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartUpPageController startUpPageController = new StartUpPageController();
                testView.dispose();
                Language.add(startUpPageController);
                Language.delete(t);
            }
        });

        testView.getGenerareItrebariButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generareIntrebari();
            }

        });

        testView.getAfisareRezultatButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afisareRezultat();
            }
        });

        testView.getAfisareGraficButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PieChartController pieChartController = new PieChartController();
                Language.add(pieChartController);
                Language.delete(t);
            }
        });

        testView.getComboBox1().addItem("English");
        testView.getComboBox1().addItem("Romana");
        testView.getComboBox1().addItem("Deutsch");
        testView.getComboBox1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=(String)testView.getComboBox1().getSelectedItem();
                if(s.equals("English")){
                    Language.lang="en";
                    Language.country="UK";
                    Language.update();

                }
                if(s.equals("Romana")){
                    Language.lang="ro";
                    Language.country="RO";
                    Language.update();

                }

                if(s.equals("Deutsch")){
                    Language.lang="ge";
                    Language.country="GE";
                    Language.update();

                }
            }
        });
    }

    public void generareIntrebari() {

        AbstractPersistence<Question> abstractPersistence = new AbstractPersistence<>(Question.class);
        Test test = new Test();
        test.setQuestions(abstractPersistence.readAll());
        Collections.shuffle(test.getQuestions());
        List<Question> randomQuestions = test.getQuestions().subList(0, 10);
        raspunsuriIntrebari.clear();

        testView.getIntrebare1().setText(randomQuestions.get(0).getEnunt());
        testView.getIntrebare2().setText(randomQuestions.get(1).getEnunt());
        testView.getIntrebare3().setText(randomQuestions.get(2).getEnunt());
        testView.getIntrebare4().setText(randomQuestions.get(3).getEnunt());
        testView.getIntrebare5().setText(randomQuestions.get(4).getEnunt());
        testView.getIntrebare6().setText(randomQuestions.get(5).getEnunt());
        testView.getIntrebare7().setText(randomQuestions.get(6).getEnunt());
        testView.getIntrebare8().setText(randomQuestions.get(7).getEnunt());
        testView.getIntrebare9().setText(randomQuestions.get(8).getEnunt());
        testView.getIntrebare10().setText(randomQuestions.get(9).getEnunt());

        raspunsuriIntrebari.add(randomQuestions.get(0).getRaspuns());
        raspunsuriIntrebari.add(randomQuestions.get(1).getRaspuns());
        raspunsuriIntrebari.add(randomQuestions.get(2).getRaspuns());
        raspunsuriIntrebari.add(randomQuestions.get(3).getRaspuns());
        raspunsuriIntrebari.add(randomQuestions.get(4).getRaspuns());
        raspunsuriIntrebari.add(randomQuestions.get(5).getRaspuns());
        raspunsuriIntrebari.add(randomQuestions.get(6).getRaspuns());
        raspunsuriIntrebari.add(randomQuestions.get(7).getRaspuns());
        raspunsuriIntrebari.add(randomQuestions.get(8).getRaspuns());
        raspunsuriIntrebari.add(randomQuestions.get(9).getRaspuns());

    }

    public void afisareRezultat() {

        for (String raspuns : raspunsuriIntrebari)
            System.out.println(raspuns);

        Rezultat rezultat = new Rezultat(0);
        if (testView.getRaspuns1().getText().equals(raspunsuriIntrebari.get(0)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);
        if (testView.getRaspuns2().getText().equals(raspunsuriIntrebari.get(1)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);
        if (testView.getRaspuns3().getText().equals(raspunsuriIntrebari.get(2)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);
        if (testView.getRaspuns4().getText().equals(raspunsuriIntrebari.get(3)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);
        if (testView.getRaspuns5().getText().equals(raspunsuriIntrebari.get(4)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);
        if (testView.getRaspuns6().getText().equals(raspunsuriIntrebari.get(5)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);
        if (testView.getRaspuns7().getText().equals(raspunsuriIntrebari.get(6)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);
        if (testView.getRaspuns8().getText().equals(raspunsuriIntrebari.get(7)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);
        if (testView.getRaspuns9().getText().equals(raspunsuriIntrebari.get(8)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);
        if (testView.getRaspuns10().getText().equals(raspunsuriIntrebari.get(9)))
            rezultat.setRezultat(rezultat.getRezultat() + 1);

        testView.getRezultat().setText(String.valueOf(rezultat.getRezultat()));
        AbstractPersistence<Rezultat> abstractPersistence = new AbstractPersistence<>(Rezultat.class);
        abstractPersistence.insert(rezultat);
    }
}
