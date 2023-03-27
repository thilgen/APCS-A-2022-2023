import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.RenderingHints;

public class GamePanel extends JPanel implements ActionListener {
  private Timer timer;
  private BufferedImage coltImage;
  private double t = 0.0;
  private double v = 0.01;
  private double g = 0.001;
  private boolean stopped = false;

  public GamePanel() {
    timer = new Timer(10, this);
    timer.start();

    try {
      coltImage = ImageIO.read(new File("colt.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void paint(Graphics graphics) {
    Graphics2D g2 = (Graphics2D)graphics;

    RenderingHints rh = new RenderingHints(
             RenderingHints.KEY_TEXT_ANTIALIASING,
             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.setRenderingHints(rh);
    g2.setStroke(new BasicStroke(4));
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.setFont(new Font("Helvetica", Font.BOLD, 14));

    double x0 = 0.25;
    double y0 = 0;

    double y = y0 + v * t - 0.5 * g * t * t;
    if (y < 0.0) {
      y = 0.0;
      stopped = true;
    }
    double x = x0 + v * t;

    int viewX = (int) (getWidth() * x);
    int viewY = (int) (getHeight() * (0.7 - y));

    //System.out.println("x="+viewX + " y="+viewY);

    g2.drawImage(coltImage, viewX-50, viewY-50, 100, 100, null);
  }

  public void actionPerformed(ActionEvent event) {
    repaint();
    if (!stopped) {
      t += 0.1;
    }
  }
}