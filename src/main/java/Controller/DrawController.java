package Controller;

import Model.Entities.Patrulater;
import Model.Entities.Punct;
import Model.Entities.Segment;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class DrawController extends Observer{

    private DrawView drawView;
    private Patrulater patrulaterCalcule;
    private ArrayList<Punct> listaPuncte = new ArrayList<>();

    public void language() {
        Locale l = new Locale(Language.lang,Language.country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle",l);
        drawView.getGetInfoButton().setText(resourceBundle.getString("getInfo"));
        drawView.getBackButton().setText(resourceBundle.getString("back"));
        drawView.getSaveButton().setText(resourceBundle.getString("saveFile"));
        drawView.getLoadButton().setText(resourceBundle.getString("loadFile"));
        drawView.getArieLabel().setText(resourceBundle.getString("arie"));
        drawView.getPerimetruLabel().setText(resourceBundle.getString("perimetru"));
        drawView.getUnghi1label().setText(resourceBundle.getString("unghi1"));
        drawView.getUnghi2label().setText(resourceBundle.getString("unghi2"));
        drawView.getUnghi3label().setText(resourceBundle.getString("unghi3"));
        drawView.getUnghi4label().setText(resourceBundle.getString("unghi4"));
        drawView.getLatura1label().setText(resourceBundle.getString("latura1"));
        drawView.getLatura2label().setText(resourceBundle.getString("latura2"));
        drawView.getLatura3label().setText(resourceBundle.getString("latura3"));
        drawView.getLatura4label().setText(resourceBundle.getString("latura4"));
        drawView.getConvexconcavLabel().setText(resourceBundle.getString("convexConcav"));
        drawView.getCircumscriptibilLabel().setText(resourceBundle.getString("circumscriptibil"));
        drawView.getInscriptibilLabel().setText(resourceBundle.getString("inscriptibil"));
        drawView.getRazaCercCircumscrisLabel().setText(resourceBundle.getString("razacerccircumscris"));
        drawView.getRazaCercInscrisLabel().setText(resourceBundle.getString("razacercinscris"));
        drawView.getNumeFisierLabel().setText(resourceBundle.getString("numefisier"));

    }

    public DrawController() {
        this.drawView = new DrawView();
        language();
        DrawController d = this;


        drawView.addMouseListener(new MouseAdapter() {
            @Override //I override only one method for presentation
            public void mousePressed(MouseEvent e) {

                handleClick(e.getX(), e.getY());
                drawView.getFrame().repaint();

            }
        });

        drawView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StartUpPageController startUpPageController = new StartUpPageController();
                drawView.getFrame().dispose();
                Language.add(startUpPageController);
                Language.delete(d);
            }
        });

        drawView.getGetInfoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showInfo();
                drawView.getFrame().repaint();
            }
        });

        drawView.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                saveFile();
            }
        });

        drawView.getLoadButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loadFile();
                drawView.getFrame().repaint();
            }
        });

        drawView.getComboBox1().addItem("English");
        drawView.getComboBox1().addItem("Romana");
        drawView.getComboBox1().addItem("Deutsch");
        drawView.getComboBox1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=(String)drawView.getComboBox1().getSelectedItem();
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

    public void handleClick(int x, int y) {
        if (x < 390 && y < 490) {

            System.out.println(x + "," + y);
            Punct punct = new Punct(x, y);
            listaPuncte.add(punct);

            if (listaPuncte.size() == 4) {
                System.out.println("Informatii patrulater complete");

                Patrulater patrulater = new Patrulater(listaPuncte);
                patrulaterCalcule = patrulater;
                PatrulaterDrawing patrulaterDrawing = new PatrulaterDrawing(patrulater);

                drawView.getDrawingArrayList().clear();
                drawView.getDrawingArrayList().add(patrulaterDrawing);
                listaPuncte.clear();
            }
        }
    }

    public static int roundToNearestMultiple(double number, int multiple, double threshold) {
        int rounded = Math.round((float) number / multiple) * multiple;
        double diff = number - rounded;
        if (Math.abs(diff) >= threshold * multiple) {
            return (int) Math.signum(diff) * multiple + rounded;
        } else {
            return rounded;
        }
    }

    public void showInfo() {

        int multiple = 10;
        double threshold = 0.5;

        int L1 = patrulaterCalcule.getListaSegmente().get(0).getLength();
        int L2 = patrulaterCalcule.getListaSegmente().get(1).getLength();
        int L3 = patrulaterCalcule.getListaSegmente().get(2).getLength();
        int L4 = patrulaterCalcule.getListaSegmente().get(3).getLength();

        drawView.getLatura1Field().setText(L1 + " cm");
        drawView.getLatura2Field().setText(L2 + " cm");
        drawView.getLatura3Field().setText(L3 + " cm");
        drawView.getLatura4Field().setText(L4 + " cm");

        int perimetru = L1 + L2 + L3 + L4;
        int produsulLaturilor = L1 * L2 * L3 * L4;
        double aria = 0;

        drawView.getPerimetruField().setText(perimetru + " cm");

        Punct p1 = new Punct(patrulaterCalcule.getListaPuncte().get(0).getX(), patrulaterCalcule.getListaPuncte().get(0).getY());
        Punct p2 = new Punct(patrulaterCalcule.getListaPuncte().get(1).getX(), patrulaterCalcule.getListaPuncte().get(1).getY());
        Punct p3 = new Punct(patrulaterCalcule.getListaPuncte().get(2).getX(), patrulaterCalcule.getListaPuncte().get(2).getY());
        Punct p4 = new Punct(patrulaterCalcule.getListaPuncte().get(3).getX(), patrulaterCalcule.getListaPuncte().get(3).getY());

        double midX1 = (double) (p1.getX() + p2.getX()) / 2;
        double midY1 = (double) (p1.getY() + p2.getY()) / 2;
        double midX2 = (double) (p2.getX() + p3.getX()) / 2;
        double midY2 = (double) (p2.getY() + p3.getY()) / 2;
        double midX3 = (double) (p3.getX() + p4.getX()) / 2;
        double midY3 = (double) (p3.getY() + p4.getY()) / 2;
        double midX4 = (double) (p4.getX() + p1.getX()) / 2;
        double midY4 = (double) (p4.getY() + p1.getY()) / 2;

        Segment diagonala1 = new Segment(p1, p3);
        Segment diagonala2 = new Segment(p2, p4);
        SegmentDrawing segmentDrawing1 = new SegmentDrawing(diagonala1);
        SegmentDrawing segmentDrawing2 = new SegmentDrawing(diagonala2);
        drawView.getDrawingArrayList().add(segmentDrawing1);
        drawView.getDrawingArrayList().add(segmentDrawing2);

        int D1 = diagonala1.getLength();
        int D2 = diagonala2.getLength();

        double unghi1 = roundToNearestMultiple(Math.toDegrees(Math.acos((double) (L1 * L1 + L4 * L4 - D2 * D2) / (2 * L1 * L4))), multiple, threshold);
        double unghi2 = roundToNearestMultiple(Math.toDegrees(Math.acos((double) (L1 * L1 + L2 * L2 - D1 * D1) / (2 * L1 * L2))), multiple, threshold);
        double unghi3 = roundToNearestMultiple(Math.toDegrees(Math.acos((double) (L2 * L2 + L3 * L3 - D2 * D2) / (2 * L2 * L3))), multiple, threshold);
        double unghi4 = roundToNearestMultiple(Math.toDegrees(Math.acos((double) (L3 * L3 + L4 * L4 - D1 * D1) / (2 * L3 * L4))), multiple, threshold);

        double sumaUnghiuri = unghi1 + unghi2 + unghi3 + unghi4;

        String output1 = String.format("%.3f°", unghi1);
        String output2 = String.format("%.3f°", unghi2);
        String output3 = String.format("%.3f°", unghi3);
        String output4 = String.format("%.3f°", unghi4);

        drawView.getUnghi1Field().setText(output1);
        drawView.getUnghi2Field().setText(output2);
        drawView.getUnghi3Field().setText(output3);
        drawView.getUnghi4Field().setText(output4);

        if (358 < sumaUnghiuri && sumaUnghiuri < 362) {

            aria = Math.sqrt(((double) perimetru / 2 - L1) * ((double) perimetru / 2 - L2) * ((double) perimetru / 2 - L3) *
                    ((double) perimetru / 2 - L4) - produsulLaturilor * Math.pow(Math.cos((unghi1 + unghi3) / 2), 2));

            drawView.getArieField().setText(String.format("%.2f cm2", aria));
            drawView.getConvexConcavField().setText("Convex");

            double nx = p1.getX() * L3 * L4 + p2.getX() * L4 * L1 + p3.getX() * L1 * L2 + p4.getX() * L2 * L3;
            double ny = p1.getY() * L3 * L4 + p2.getY() * L4 * L1 + p3.getY() * L1 * L2 + p4.getY() * L2 * L3;
            double d = 2.0 * (L1 + L2 + L3 + L4);

            int finalnx = (int) Math.round(nx / d);
            int finalny = (int) Math.round(ny / d);

            String s1 = Integer.toString(finalnx);
            String s2 = Integer.toString(finalny);
            int lastCharTwoIndex1 = s1.length() - 2; // 2nd character index from last
            int lastCharTwoIndex2 = s2.length() - 2; // 2nd character index from last
            int lastTwoDigits1 = Integer.parseInt(s1.substring(lastCharTwoIndex1));
            int lastTwoDigits2 = Integer.parseInt(s2.substring(lastCharTwoIndex2));

            Punct miquelPoint = new Punct(lastTwoDigits1, lastTwoDigits2);
            PunctDrawing punctDrawing = new PunctDrawing(miquelPoint);
            drawView.getDrawingArrayList().add(punctDrawing);

        } else {

            drawView.getConvexConcavField().setText("Concav");
            double unghi1obtuz = 360 - unghi1;
            double unghi2obtuz = 360 - unghi2;
            double unghi3obtuz = 360 - unghi3;
            double unghi4obtuz = 360 - unghi4;

            if (unghi1obtuz + unghi2 + unghi3 + unghi4 > 358 && unghi1obtuz + unghi2 + unghi3 + unghi4 < 362) {

                unghi1 = unghi1obtuz;
                drawView.getUnghi1Field().setText(String.format("%.3f°", unghi1));
                aria = Math.sqrt(((double) perimetru / 2 - L1) * ((double) perimetru / 2 - L2) * ((double) perimetru / 2 - L3) *
                        ((double) perimetru / 2 - L4) - produsulLaturilor * Math.pow(Math.cos((unghi1 + unghi3) / 2), 2));
                drawView.getArieField().setText(String.format("%.2f cm2", aria));

            } else if (unghi1 + unghi2obtuz + unghi3 + unghi4 > 358 && unghi1 + unghi2obtuz + unghi3 + unghi4 < 362) {

                unghi2 = unghi2obtuz;
                drawView.getUnghi2Field().setText(String.format("%.3f°", unghi2));
                aria = Math.sqrt(((double) perimetru / 2 - L1) * ((double) perimetru / 2 - L2) * ((double) perimetru / 2 - L3) *
                        ((double) perimetru / 2 - L4) - produsulLaturilor * Math.pow(Math.cos((unghi1 + unghi3) / 2), 2));
                drawView.getArieField().setText(String.format("%.2f cm2", aria));

            } else if (unghi1 + unghi2 + unghi3obtuz + unghi4 > 358 && unghi1 + unghi2 + unghi3obtuz + unghi4 < 362) {

                unghi3 = unghi3obtuz;
                drawView.getUnghi3Field().setText(String.format("%.3f°", unghi3));
                aria = Math.sqrt(((double) perimetru / 2 - L1) * ((double) perimetru / 2 - L2) * ((double) perimetru / 2 - L3) *
                        ((double) perimetru / 2 - L4) - produsulLaturilor * Math.pow(Math.cos((unghi1 + unghi3) / 2), 2));
                drawView.getArieField().setText(String.format("%.2f cm2", aria));

            } else if (unghi1 + unghi2 + unghi3 + unghi4obtuz > 358 && unghi1 + unghi2 + unghi3 + unghi4obtuz < 362) {

                unghi4 = unghi4obtuz;
                drawView.getUnghi4Field().setText(String.format("%.3f°", unghi4));
                aria = Math.sqrt(((double) perimetru / 2 - L1) * ((double) perimetru / 2 - L2) * ((double) perimetru / 2 - L3) *
                        ((double) perimetru / 2 - L4) - produsulLaturilor * Math.pow(Math.cos((unghi1 + unghi3) / 2), 2));
                drawView.getArieField().setText(String.format("%.2f cm2", aria));

            }
        }

        double suma1UnghiuriOpuse = unghi1 + unghi3;
        double suma2UnghiuriOpuse = unghi2 + unghi4;
        double razaCerculuiInscris = 0;

        if (176 < suma1UnghiuriOpuse && suma1UnghiuriOpuse < 184 && 176 < suma2UnghiuriOpuse && suma2UnghiuriOpuse < 184) {

            drawView.getInscriptibilField().setText("Da");
            razaCerculuiInscris = aria / ((double) perimetru / 2);
            drawView.getRazaCercInscrisField().setText(String.format("%.2f cm", razaCerculuiInscris));

            /*CircleDrawing circleDrawing = new CircleDrawing(p1);
            drawView.getDrawingArrayList().add(circleDrawing);*/

        } else {
            drawView.getInscriptibilField().setText("Nu");
            drawView.getRazaCercInscrisField().setText("-");
        }

        double produsDiagonale = D1 * D2;
        double produsLungimiLaturiOpuse = 2 * (L1 * L3 + L2 * L4);
        double razaCerculuiCircumscris = 0;

        if (produsDiagonale == produsLungimiLaturiOpuse) {

            drawView.getCircumscriptibilField().setText("Da");
            razaCerculuiCircumscris = produsulLaturilor / (4 * aria);
            drawView.getRazaCerCircumscrisField().setText(String.format("%.2f cm", razaCerculuiCircumscris));

            double slope1 = (midY3 - midY1) / (midX3 - midX1);
            double intercept1 = midY1 - slope1 * midX1;
            double slope2 = (midY4 - midY2) / (midX4 - midX2);
            double intercept2 = midY2 - slope2 * midX2;

            double newX = (intercept2 - intercept1) / (slope1 - slope2);
            double newY = slope1 * newX + intercept1;

            Punct newtonPoint = new Punct((int) newX, (int) newY);
            PunctDrawing punctDrawing = new PunctDrawing(newtonPoint);
            drawView.getDrawingArrayList().add(punctDrawing);

        } else {
            drawView.getCircumscriptibilField().setText("Nu");
            drawView.getRazaCerCircumscrisField().setText("-");
        }

    }

    public void saveFile(){

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("./src/main/resources/" +
                        drawView.getNumeFisierField().getText() + ".txt"), "utf-8"))) {
            writer.write(patrulaterCalcule.getListaPuncte().get(0).getX() + "," +
                    patrulaterCalcule.getListaPuncte().get(0).getY() + "," +
                    patrulaterCalcule.getListaPuncte().get(1).getX() + "," +
                    patrulaterCalcule.getListaPuncte().get(1).getY() + "," +
                    patrulaterCalcule.getListaPuncte().get(2).getX() + "," +
                    patrulaterCalcule.getListaPuncte().get(2).getY() + "," +
                    patrulaterCalcule.getListaPuncte().get(3).getX() + "," +
                    patrulaterCalcule.getListaPuncte().get(3).getY());
            System.out.println("File written");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void loadFile(){

        try {
            listaPuncte.clear();
            BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/" +
                    drawView.getNumeFisierField().getText() + ".txt"));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Punct p1 = new Punct(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
                Punct p2 = new Punct(Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
                Punct p3 = new Punct(Integer.parseInt(parts[4]),Integer.parseInt(parts[5]));
                Punct p4 = new Punct(Integer.parseInt(parts[6]),Integer.parseInt(parts[7]));
                listaPuncte.add(p1);
                listaPuncte.add(p2);
                listaPuncte.add(p3);
                listaPuncte.add(p4);
            }
            Patrulater patrulater = new Patrulater(listaPuncte);
            patrulaterCalcule = patrulater;
            PatrulaterDrawing patrulaterDrawing = new PatrulaterDrawing(patrulater);

            drawView.getDrawingArrayList().clear();
            drawView.getDrawingArrayList().add(patrulaterDrawing);
            listaPuncte.clear();
            System.out.println("File loaded");
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
