import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PulsingTriangle {
    int x;
    int y;
    Color color;
    int[] xPoints = new int[3];
    int[] yPoints = new int[3];
    int xIncrement;
    int yIncrement;
    int xMax;
    int yMax;

    final int N_VERTICES = 3;
    final int SIZE = 30;
    public PulsingTriangle(int startX, int startY, Color startColor) {
        x = startX;
        y = startY;
        color = startColor;;
        setTriangle();
    }

    public void draw(Graphics surface) {
        drawSurface(surface);
        pulseTriangle();
        detectLimit();
    }
    private void drawSurface(Graphics surface) {
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
    private void pulseTriangle() {
        xPoints[0] = xPoints[0] - xIncrement;
        xPoints[1] = xPoints[1] + xIncrement;
        yPoints[2] = yPoints[2] - yIncrement;
    }
    public void setPulseParams(double scaleFactor, double frequency) {
        xMax = (int)(SIZE * (scaleFactor - 1)/ 2.0 + 0.5);
        yMax = (int)(SIZE * (scaleFactor - 1) * 0.866 + 0.5);
        setIncrements(frequency);
    }
    private void setIncrements(double frequency) {
        xIncrement = frequencyToPixels(frequency, xMax);
        yIncrement = frequencyToPixels(frequency, yMax);
    }
    private int frequencyToPixels(double frequency, int axisMax) {
        return (int)(frequency * 50 * axisMax / 1000 + 0.5); // refresh rate = 50ms
    }
    private void detectLimit() {
        if ((xPoints[0] <= x - xMax) ||
                (xPoints[0] >= x)){
            xIncrement = -xIncrement;
            yIncrement = -yIncrement;
        }
    }
}
