import java.awt.Color;
import java.awt.Graphics;

public class DrawGraphics {
    BouncingBox box;

    public DrawGraphics() {
        box = new BouncingBox(200, 50, Color.RED);
    }

    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        box.draw(surface);
    }
}
