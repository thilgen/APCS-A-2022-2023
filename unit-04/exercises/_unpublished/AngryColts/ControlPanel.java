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
import javax.swing.JButton;
import java.awt.FlowLayout;

public class ControlPanel extends JPanel implements ActionListener {
  public ControlPanel() {
    setLayout(new FlowLayout());
    add(new JButton("+"));
    add(new JButton("-"));
    add(new JButton("Fire!"));
  }

  public void actionPerformed(ActionEvent event) {
    //repaint();
  }
}
