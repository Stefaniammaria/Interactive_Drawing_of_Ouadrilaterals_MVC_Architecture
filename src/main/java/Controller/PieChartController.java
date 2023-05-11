package Controller;

import Model.Entities.Rezultat;
import Model.Persistence.AbstractPersistence;
import View.PieChartView;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.BiConsumer;

public class PieChartController extends Observer{

    private PieChartView pieChartView;
    DefaultPieDataset dataset = createDataset();

    public PieChartController() {
        this.pieChartView = new PieChartView(dataset);
    }

    private DefaultPieDataset createDataset() {

        var dataset = new DefaultPieDataset();

        AbstractPersistence<Rezultat> abstractPersistence = new AbstractPersistence<>(Rezultat.class);
        List<Rezultat> rezultate = abstractPersistence.readAll();
        HashMap<Integer, Integer> valoriGrafic = new HashMap<>();
        rezultate.forEach(rezultat -> {
            if (valoriGrafic.containsKey(rezultat.getRezultat())) {
                valoriGrafic.put(rezultat.getRezultat(), valoriGrafic.get(rezultat.getRezultat()) + 1);
            } else {
                valoriGrafic.put(rezultat.getRezultat(), 1);
            }
        });
        valoriGrafic.forEach((key,value) ->{

            dataset.setValue("Grade "+ key,value);

        });
        return dataset;
    }
}
