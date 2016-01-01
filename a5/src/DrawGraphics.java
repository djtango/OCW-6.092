import java.awt.Color;
import java.awt.Graphics;

public class DrawGraphics {
    BouncingBox box;
    BouncingCircle circle;
    PulsingTriangle triangle;

    public DrawGraphics() {
        box = new BouncingBox(200, 50, Color.YELLOW);
        box.setMovementVector(2,2);

        circle = new BouncingCircle(100, 100, Color.ORANGE);
        circle.setMovementVector(4,4);

        triangle = new PulsingTriangle(50, 250, Color.MAGENTA);
        triangle.setPulseParams(5, 8);
    }

    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        box.draw(surface);
        circle.draw(surface);
        triangle.draw(surface);
    }
}
