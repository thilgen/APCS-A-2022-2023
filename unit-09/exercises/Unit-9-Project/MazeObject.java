import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public abstract class MazeObject {
  private Game game;
  private Image image;
  private int x, y;

  protected MazeObject(Game game, int x, int y) {
    this.game = game;
    this.x = x;
    this.y = y;
  }

  public boolean moveBy(int deltaX, int deltaY) {
    return moveTo(x + deltaX, y + deltaY);
  }

  public boolean moveTo(int x, int y) {
    Maze maze = game.getMaze();
    if (!maze.isValidLocation(x, y)) {
      return false;
    }
    MazeObject targetMazeObject = maze.getMazeObjectAt(x, y);
    if (targetMazeObject != null) {
      return false;
    }
    maze.setMazeObjectAt(x, y, this);
    maze.setMazeObjectAt(this.x, this.y, null);
    this.x = x;
    this.y = y;
    return true;
  }

  private static HashMap<String, Image> imageCache = new HashMap<String, Image>();

  public Image getImage() {
    if (image != null) {
      return image;
    }
    String path = getImagePath();
    if ((image = imageCache.get(path)) != null) {
      return image;
    }
    try {
      image = ImageIO.read(new File(path));
      imageCache.put(path, image);
      return image;
    } catch (IOException e) {
      throw new RuntimeException("Could not read image file: " + getImagePath());
    }
  }

  // Subclasses must override getImagePath to return the path of the image file to use.
  public abstract String getImagePath();

  // Subclasses must override getName to return a descriptive name.
  public abstract String getName();

  // Subclasses may override this to indicate whether light cannot pass through.
  // (Wall, for instance, overrides this to return true.)
  public boolean isOpaque() { return false; }

  // Subclasses may override this to provide per-tick behavior, such as movement.
  public void tick() {}

  // Subclasses may override this to provide interactive behavior. The status to be displayed
  // should be returned, or null if none.
  public String interact() { return null; }

  public int getX() { return x; }
  public int getY() { return y; }
  public Game getGame() { return game; }
}