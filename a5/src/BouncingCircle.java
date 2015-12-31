import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BouncingCircle {
    int x;
    int y;
    Color color;
    int xDirection = 0;
    int yDirection = 0;

    final int SIZE = 40;
    public BouncingCircle(int startX, int startY, Color startColor) {
        x = startX;
        y = startY;
        color = startColor;
    }

    public void draw(Graphics surface) {
        drawSurface(surface);
        moveCircle();
        detectEnd();
    }

    private void drawSurface(Graphics surface) {
        surface.setColor(color);
        surface.fillOval(x, y, SIZE, SIZE);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(x, y, SIZE, SIZE);
    }

    private void moveCircle() {
        x += xDirection;
        y += yDirection;
    }

    public void setMovementVector(int xInput, int yInput) {
        xDirection = xInput;
        yDirection = yInput;
    }

    private void detectEnd() {
        if ((x + SIZE/2 <= 50 && xDirection < 0) ||
                (x + SIZE/2 >= 250 && xDirection > 0)) {
            xDirection = -xDirection;
        }
        if ((y + SIZE/2 <= 50 && yDirection < 0) ||
                (y + SIZE/2 >= 250 && yDirection > 0)) {
            yDirection = -yDirection;
        }
    }
}
