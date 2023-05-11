package Controller;

import java.util.ArrayList;

public class Language {

    public static String lang = "en";
    public static String country = "UK";
    private static ArrayList<Observer> observers;

    public static void change(String l, String c) {
        lang = l;
        country = c;
    }

    public static void add(Observer o) {
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(o);

    }

    public static void delete(Observer o) {
        observers.remove(o);
    }

    public static void update() {

        for (Observer o : observers) {
            o.language();
        }

    }
}
