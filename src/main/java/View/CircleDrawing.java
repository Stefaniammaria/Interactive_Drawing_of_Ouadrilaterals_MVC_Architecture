package View;

import Model.Entities.Punct;

import java.awt.*;

public class CircleDrawing implements Drawing{

    private final Punct punct;

    public CircleDrawing(Punct punct) {
        this.punct = punct;
    }

    @Override
    public void draw(Graphics g) {
        int x = punct.getX();
        int y = punct.getY();
        g.drawOval(x, y, 10, 10);
    }
}
