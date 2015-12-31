import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PulsingTriangle {
    int x;
    int y;
    Color color;
    int xDirection = 0;
    int yDirection = 0;
    int[] xPoints = new int[3];
    int[] yPoints = new int[3];

    final int N_VERTICES = 3;
    final int SIZE = 30;
    public PulsingTriangle(int startX, int startY, Color startColor) {
        x = startX;
        y = startY;
        color = startColor;;
    }

    public void draw(Graphics surface) {
        drawSurface(surface);
        //pulseTriangle();
    }
    private void drawSurface(Graphics surface) {
        setTriangle();
        surface.setColor(color);
        surface.fillPolygon(xPoints, yPoints, N_VERTICES);
        surface.setColor(Color.GREEN);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawPolygon(xPoints, yPoints, N_VERTICES);
    }
    private void setTriangle() {
        genXCoordinates();
        genYCoordinates();
    }
    private void genXCoordinates() {
        xPoints[0] = x;
        xPoints[1] = x + SIZE;
        xPoints[2] = x + (SIZE / 2);
    }
    private void genYCoordinates() {
        yPoints[0] = y;
        yPoints[1] = y;
        yPoints[2] = y - (int)(SIZE * 0.866 + 0.5); // 0.866 ~ sqrt(3) / 2
    }
}
