import javax.swing.JFrame;
import java.awt.BorderLayout;

class Main {
  private JFrame frame;

  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    frame = new JFrame("Angry Colts");
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(new ControlPanel(), BorderLayout.NORTH);
    frame.getContentPane().add(new GamePanel(), BorderLayout.CENTER);
    frame.setSize(800, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }
}