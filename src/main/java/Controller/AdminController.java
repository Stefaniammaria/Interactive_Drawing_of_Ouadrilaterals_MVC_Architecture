package Controller;

import Model.Entities.RequestLogIn;
import Model.Entities.User;
import Model.Persistence.AbstractPersistence;
import View.AdminView;
import View.StartUpPage;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class AdminController extends Observer {

    private AdminView adminView;

    @Override
    public void language() {
        Locale l = new Locale(Language.lang, Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", l);
        adminView.getCreateAccountButton().setText(resourceBundle.getString("createAccount"));
        adminView.getShowListButton().setText(resourceBundle.getString("showlist"));
        adminView.getBackButton().setText(resourceBundle.getString("back"));
        adminView.getNumeLabel().setText(resourceBundle.getString("nume"));
        adminView.getUsernameLabel().setText(resourceBundle.getString("username"));
        adminView.getPrenumeLabel().setText(resourceBundle.getString("prenume"));
        adminView.getEmailLabel().setText(resourceBundle.getString("email"));
        adminView.getTipLabel().setText(resourceBundle.getString("tip"));
        adminView.getParolaLabel().setText(resourceBundle.getString("parola"));
        adminView.getFilterListComboBox().removeAllItems();
        adminView.getFilterListComboBox().addItem(resourceBundle.getString("admin"));
        adminView.getFilterListComboBox().addItem(resourceBundle.getString("elev"));
        adminView.getShowFilteredListButton().setText(resourceBundle.getString("filtered"));

    }

    public AdminController() {
        this.adminView = new AdminView();
        language();
        AdminController a = this;

        adminView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StartUpPageController st = new StartUpPageController();
                adminView.dispose();
                Language.add(st);
                Language.delete(a);
            }
        });

        adminView.getComboBox1().addItem("English");
        adminView.getComboBox1().addItem("Romana");
        adminView.getComboBox1().addItem("Deutsch");
        adminView.getComboBox1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) adminView.getComboBox1().getSelectedItem();
                if (s.equals("English")) {
                    Language.lang = "en";
                    Language.country = "UK";
                    Language.update();

                }
                if (s.equals("Romana")) {
                    Language.lang = "ro";
                    Language.country = "RO";
                    Language.update();

                }

                if (s.equals("Deutsch")) {
                    Language.lang = "ge";
                    Language.country = "GE";
                    Language.update();

                }
            }
        });

        adminView.getShowFilteredListButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) adminView.getFilterListComboBox().getSelectedItem();
                if(s.equals("Studentin") || s.equals("Student") || s.equals("Elev"))
                    showFilteredList("elev");
                if(s.equals("Administratorin") || s.equals("Administrator"))
                    showFilteredList("admin");
            }
        });

        adminView.getShowListButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });

        adminView.getCreateAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
    }

    public void showList() {

        AbstractPersistence<RequestLogIn> abstractPersistence = new AbstractPersistence<>(RequestLogIn.class);
        List<RequestLogIn> logIns = abstractPersistence.readAll();

        String[] columnNames = {"Nume", "Prenume", "Email", "Tip"};
        int rowIndex = 0;
        int numberRows = logIns.size();
        Object[][] data = new String[numberRows][4];

        for (RequestLogIn r : logIns) {

            data[rowIndex][0] = r.getNume();
            data[rowIndex][1] = r.getPrenume();
            data[rowIndex][2] = r.getEmail();
            data[rowIndex][3] = r.getTip();

            rowIndex++;

        }

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnNames);
        adminView.getUsersRequestsTable().setModel(defaultTableModel);
    }

    public void createAccount() {

        AbstractPersistence<User> abstractPersistence = new AbstractPersistence<>(User.class);
        AbstractPersistence<RequestLogIn> abstractPersistence2 = new AbstractPersistence<>(RequestLogIn.class);

        User user = new User();
        user.setNume(adminView.getTextNume().getText());
        user.setPrenume(adminView.getTextPrenume().getText());
        user.setUsername(adminView.getTextUsername().getText());
        user.setParola(adminView.getTextParola().getText());
        user.setEmail(adminView.getTextEmail().getText());
        user.setTip(adminView.getTextTip().getText());

        abstractPersistence.insert(user);

        List<RequestLogIn> logIns = abstractPersistence2.readAll();
        logIns.forEach(l -> {
            if (l.getEmail().equals(user.getEmail())) {

                abstractPersistence.delete(l);

            }
        });

        List<RequestLogIn> logInsUpdated = abstractPersistence2.readAll();

        String[] columnNames = {"Nume", "Prenume", "Email", "Tip"};
        int rowIndex = 0;
        int numberRows = logInsUpdated.size();
        Object[][] data = new String[numberRows][4];

        for (RequestLogIn r : logIns) {

            data[rowIndex][0] = r.getNume();
            data[rowIndex][1] = r.getPrenume();
            data[rowIndex][2] = r.getEmail();
            data[rowIndex][3] = r.getTip();

            rowIndex++;

        }

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnNames);
        adminView.getUsersRequestsTable().setModel(defaultTableModel);

    }

    public void showFilteredList(String filter) {

        AbstractPersistence<RequestLogIn> abstractPersistence = new AbstractPersistence<>(RequestLogIn.class);
        List<RequestLogIn> logIns = abstractPersistence.readAll();

        String[] columnNames = {"Nume", "Prenume", "Email", "Tip"};
        int rowIndex = 0;
        int numberRows = 0;
        for (RequestLogIn r : logIns) {

            if (r.getTip().equals(filter)) numberRows++;

        }

        Object[][] data = new String[numberRows][4];

        for (RequestLogIn r : logIns) {

            if (r.getTip().equals(filter)) {
                data[rowIndex][0] = r.getNume();
                data[rowIndex][1] = r.getPrenume();
                data[rowIndex][2] = r.getEmail();
                data[rowIndex][3] = r.getTip();

                rowIndex++;
            }
        }

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnNames);
        adminView.getUsersRequestsTable().setModel(defaultTableModel);
    }

}
