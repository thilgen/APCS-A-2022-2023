import javax.swing.JPanel;
import java.awt.*;

public class MazeView extends JPanel {
  // At least this many cells should be visible to player's sides
  private static final int VISIBLE_MARGIN = 2;

  // Each grid cell is this size square
  private static final int CELL_WIDTH = 32;

  private int left, top, viewWidth, viewHeight;
  private Maze maze;

  public MazeView(Maze maze) {
    this.maze = maze;
    left = top = 0;
    computeViewSize();
  }

  public void computeViewSize() {
    this.viewWidth = getWidth() / CELL_WIDTH;
    this.viewHeight = getHeight() / CELL_WIDTH;
  }

  public void scrollTo(int x, int y) {
    computeViewSize();
    if (x < left + VISIBLE_MARGIN) {
      left = x - VISIBLE_MARGIN;
    } else if (x >= left + viewWidth - VISIBLE_MARGIN) {
      left = x - viewWidth + VISIBLE_MARGIN;
    }
    if (y < top + VISIBLE_MARGIN) {
      top = y - VISIBLE_MARGIN;
    } else if (y >= top + viewHeight - VISIBLE_MARGIN) {
      top = y - viewHeight + VISIBLE_MARGIN;
    }
    repaint();
  }

  public void center(int x, int y) {
    computeViewSize();
    left = x - viewWidth / 2;
    top = y - viewHeight / 2;
    repaint();
  }

  @Override
  public void paintComponent(Graphics graphics) {
    computeViewSize();

    Graphics2D g2 = (Graphics2D) graphics;

    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.setFont(new Font("Courier", Font.BOLD, 18));

    for (int i = 0; i < viewHeight; i++) {
      int y = top + i;
      for (int j = 0; j < viewWidth; j++) {
        int x = left + j;
        Image image = null;
        // [ggrossman 04/02/23] Turn off darkness in the maze for the
        // Unit 10 Project.
        if (true /* maze.isIlluminated(x, y) */) {
          MazeObject mazeObject = maze.getMazeObjectAt(x, y);
          if (mazeObject != null) {
            image = mazeObject.getImage();
          }
        } else {
          g2.setColor(Color.BLACK);
          g2.fillRect(j * CELL_WIDTH, i * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
        }
        if (image != null) {
          g2.drawImage(image, j * CELL_WIDTH, i * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH, Color.WHITE, null);
        }
        if (maze.isHighlighted(x, y)) {
          Composite oldComposite = g2.getComposite();
          g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
          g2.setColor(Color.YELLOW);
          g2.fillRect(j * CELL_WIDTH, i * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
          g2.setComposite(oldComposite);
        }
      }
    }
  }
}