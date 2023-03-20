import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.RenderingHints;

public class Spiral extends JPanel implements ActionListener {
  private Timer timer;
  private double scale = 100.0;

  public Spiral() {
    timer = new Timer(40, this);
    timer.start();
  }

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    RenderingHints rh = new RenderingHints(
             RenderingHints.KEY_TEXT_ANTIALIASING,
             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.setRenderingHints(rh);
    g2.setStroke(new BasicStroke(4));
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.setFont(new Font("Helvetica", Font.BOLD, 14));

    Fibonacci fibonacci = new Fibonacci();

    double x = getWidth()/2;
    double y = getHeight()/2;
    int direction = 0; 
    
    for (int i=0; i<100; i++) {
      long f = fibonacci.next();
      if (f != 0) {
        // Scale up f for drawing
        double fScaled = (double)f * scale;

        double oldX = x;
        double oldY = y;

        if (direction == 0) {
          x += fScaled;
          y += fScaled;
        } else if (direction == 1) {
          x += fScaled;
          y -= fScaled;
        } else if (direction == 2) {
          x -= fScaled;
          y -= fScaled;
        } else {
          x -= fScaled;
          y += fScaled;
        }

        int x1 = (int) Math.round(Math.min(x, oldX));
        int x2 = (int) Math.round(Math.max(x, oldX));
        int y1 = (int) Math.round(Math.min(y, oldY));
        int y2 = (int) Math.round(Math.max(y, oldY));
        int width = (int) Math.round(fScaled);
        int height = (int) Math.round(fScaled);

        if (x1 > getWidth() || x2 < 0 || y2 < 0 || y1 > getHeight()) {
          break;
        }

        if (width > 0) {
          if (direction == 0) {
            g2.setColor(new Color(213, 245, 227));
          } else if (direction == 1) {
            g2.setColor(new Color(232, 218, 239));
          } else if (direction == 2) {
            g2.setColor(new Color(253, 235, 208));
          } else {
            g2.setColor(new Color(242, 215, 243));
          }

          Rectangle2D r = new Rectangle(x1, y1, width, height);
          g2.fill(r);

          g2.setColor(Color.black);
          g2.draw(r);

          if (direction == 0) {
            g2.drawArc(x1, y1-height, width*2, height*2, 180, 90);
          } else if (direction == 1) {
            g2.drawArc(x1-width, y1-height, width*2, height*2, 270, 90);
          } else if (direction == 2) {
            g2.drawArc(x1-width, y1, width*2, height*2, 0, 90);
          } else {
            g2.drawArc(x1, y1, width*2, height*2, 90, 90);
          }

          String label = String.valueOf(f);
          Rectangle2D labelBounds = g2.getFontMetrics().getStringBounds(label, g);
          if (width > labelBounds.getWidth() && height > labelBounds.getHeight()) {
            int labelX = (x1 + x2) / 2 - (int)labelBounds.getWidth() / 2;
            int labelY = (y1 + y2) / 2;
            g2.drawString(label, labelX, labelY);
          }
        }

        direction = (direction+1) % 4;
      }
    }
  }

  public void actionPerformed(ActionEvent event) {
    scale *= 0.995;
    repaint();
  }
}