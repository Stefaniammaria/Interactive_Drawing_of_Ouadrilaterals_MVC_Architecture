package Controller;

import Model.Entities.User;
import Model.Persistence.AbstractPersistence;
import View.AdminView;
import View.LogInView;
import View.StartUpPage;
import View.TestView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class LogInController extends Observer{

    private LogInView logInView;

    @Override
    public void language() {
        Locale l = new Locale(Language.lang,Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle",l);
        logInView.getLogInButton().setText(resourceBundle.getString("login"));
        logInView.getBackButton().setText(resourceBundle.getString("back"));
        logInView.getUsernameLabel().setText(resourceBundle.getString("username"));
        logInView.getParolaLabel().setText(resourceBundle.getString("parola"));
    }

    public LogInController() {
        this.logInView = new LogInView();
        language();
        LogInController l = this;

        logInView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StartUpPageController startUpPageController = new StartUpPageController();
                logInView.dispose();
                Language.add(startUpPageController);
                Language.delete(l);
            }
        });

        logInView.getLogInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                logIn();
                Language.delete(l);

            }
        });

        logInView.getComboBox1().addItem("English");
        logInView.getComboBox1().addItem("Romana");
        logInView.getComboBox1().addItem("Deutsch");
        logInView.getComboBox1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=(String)logInView.getComboBox1().getSelectedItem();
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

    public void logIn() {

        AbstractPersistence<User> abstractPersistence = new AbstractPersistence<>(User.class);
        List<User> userList = abstractPersistence.readAll();

        for (User u : userList) {
            if (u.getUsername().equals(logInView.getTextUsername().getText()) && u.getParola().equals(logInView.getTextParola().getText())) {
                if (u.getTip().equals("admin")) {
                    AdminController adminController = new AdminController();
                    Language.add(adminController);
                    break;
                }
                if (u.getTip().equals("elev")) {
                    TestController testController = new TestController();
                    Language.add(testController);
                    break;
                }
            }
        }
        logInView.dispose();

    }

}
