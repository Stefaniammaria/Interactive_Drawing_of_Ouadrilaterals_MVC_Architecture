package View;

import Model.Entities.Punct;

import java.awt.*;

public class PunctDrawing implements Drawing {

    private final Punct punct;

    public PunctDrawing(Punct punct) {
        this.punct = punct;
    }

    @Override
    public void draw(Graphics g) {

        int x = punct.getX() - (10 / 2);
        int y = punct.getY() - (10 / 2);
        g.fillOval(x, y, 10, 10);

    }
}
