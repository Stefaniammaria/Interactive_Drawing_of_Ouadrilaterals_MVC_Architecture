package Controller;

import View.DrawView;
import View.StartUpPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class StartUpPageController extends Observer{

    private StartUpPage startUpPage;

    @Override
    public void language() {
        Locale l = new Locale(Language.lang,Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle",l);
        startUpPage.getLogInButton().setText(resourceBundle.getString("login"));
        startUpPage.getDrawButton().setText(resourceBundle.getString("draw"));
        startUpPage.getRequestLogInButton().setText(resourceBundle.getString("requestlogin"));
        startUpPage.getExitButton().setText(resourceBundle.getString("exit"));

    }

    public StartUpPageController() {

        this.startUpPage = new StartUpPage();
        language();
        StartUpPageController s = this;


        startUpPage.getDrawButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DrawController drawView = new DrawController();
                startUpPage.dispose();
                Language.add(drawView);
                Language.delete(s);
            }
        });

        startUpPage.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        startUpPage.getLogInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LogInController lgc = new LogInController();
                startUpPage.dispose();
                Language.add(lgc);
                Language.delete(s);
            }
        });

        startUpPage.getRequestLogInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RequestLogInController rlgc = new RequestLogInController();
                startUpPage.dispose();
                Language.add(rlgc);
                Language.delete(s);
            }
        });

        startUpPage.getComboBox1().addItem("English");
        startUpPage.getComboBox1().addItem("Romana");
        startUpPage.getComboBox1().addItem("Deutsch");
        startUpPage.getComboBox1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=(String)startUpPage.getComboBox1().getSelectedItem();
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
}
