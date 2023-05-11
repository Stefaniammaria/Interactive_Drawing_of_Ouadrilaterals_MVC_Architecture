package Controller;

import Model.Entities.RequestLogIn;
import Model.Persistence.AbstractPersistence;
import View.RequestLogInView;
import View.StartUpPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class RequestLogInController extends Observer{

    private RequestLogInView requestLogInView;

    @Override
    public void language() {
        Locale l = new Locale(Language.lang,Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle",l);
        requestLogInView.getRequestLogInButton().setText(resourceBundle.getString("requestlogin"));
        requestLogInView.getBackButton().setText(resourceBundle.getString("back"));
        requestLogInView.getNumeLabel().setText(resourceBundle.getString("nume"));
        requestLogInView.getPrenumeLabel().setText(resourceBundle.getString("prenume"));
        requestLogInView.getEmailLabel().setText(resourceBundle.getString("email"));
    }

    public RequestLogInController() {
        this.requestLogInView = new RequestLogInView();
        language();
        RequestLogInController r = this;

        requestLogInView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StartUpPageController startUpPageController = new StartUpPageController();
                requestLogInView.dispose();
                Language.add(startUpPageController);
                Language.delete(r);
            }
        });

        requestLogInView.getRequestLogInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                requestLogIn();

            }
        });

        requestLogInView.getComboBox1().addItem("English");
        requestLogInView.getComboBox1().addItem("Romana");
        requestLogInView.getComboBox1().addItem("Deutsch");
        requestLogInView.getComboBox1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=(String)requestLogInView.getComboBox1().getSelectedItem();
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

    public void requestLogIn (){

        AbstractPersistence<RequestLogIn> abstractPersistence = new AbstractPersistence<>(RequestLogIn.class);
        RequestLogIn requestLogIn = new RequestLogIn();
        requestLogIn.setNume(requestLogInView.getTextNume().getText());
        requestLogIn.setPrenume(requestLogInView.getTextPrenume().getText());
        requestLogIn.setEmail(requestLogInView.getTextEmail().getText());
        abstractPersistence.insert(requestLogIn);

    }

}
