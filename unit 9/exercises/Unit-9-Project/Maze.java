import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Maze {
  private static final int TORCH_DISTANCE = 10;

  private int width, height;
  private MazeObject[][] mazeObjects;
  private boolean[][] illuminated;
  private Game game;

  public Maze(Game game) {
    this.game = game;
  }

  public void loadMaze(String path) throws IOException {
    // First pass determines size of maze
    int newHeight = 0;
    int newWidth = 0;
    FileInputStream fileInputStream = new FileInputStream(path);
    Scanner scanner = new Scanner(fileInputStream);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      newWidth = Math.max(newWidth, line.length());
      newHeight++;
    }
    fileInputStream.close();

    // Second pass reads in the cells
    MazeObject[][] newMazeObjects = new MazeObject[newWidth][newHeight];
    fileInputStream = new FileInputStream(path);
    scanner = new Scanner(fileInputStream);
    int y = 0;
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      for (int x=0, n=line.length(); x<n; x++) {
        newMazeObjects[x][y] = MazeObjectFactory.newMazeObject(game, line.charAt(x), x, y);
      }
      y++;
    }
    fileInputStream.close();

    mazeObjects = newMazeObjects;
    illuminated = new boolean[newWidth][newHeight];
    width = newWidth;
    height = newHeight;
  }

  public int getWidth() { return width; }
  public int getHeight() { return height; }

  public boolean isValidLocation(int x, int y) {
    return x >= 0 && x < width && y >= 0 && y < height; 
  }

  public boolean isIlluminated(int x, int y) {
    return isValidLocation(x, y) && illuminated[x][y];
  }

  public void castRayOfLight(int x, int y, double theta) {
    // Illuminate the path in front of the player in a particular direction, indicated
    // by the angle "theta" measured in radians. Polar coordinates are used to compute
    // a path up to TORCH_DISTANCE in that direction. Any opaque MazeObject will block
    // the path of light.
    double r = 0.0;
    while (r <= TORCH_DISTANCE) {
      int rx = (int) Math.round(x + r * Math.cos(theta));
      int ry = (int) Math.round(y + r * Math.sin(theta));
      if (!isValidLocation(rx, ry)) {
        return;
      }
      illuminated[rx][ry] = true;
      MazeObject mazeObject = getMazeObjectAt(rx, ry);
      if (mazeObject != null && mazeObject.isOpaque()) {
        return;
      }
      r += 0.5;
    }
  }

  public void illuminate(int x, int y) {
    // Illuminate the area around the player by casting rays of light at many angles
    // in a 360 degree circle.
    for (double theta = 0.0; theta <= 2*Math.PI; theta += 0.05) {
      castRayOfLight(x, y, theta);
    }
  }

  public void tick() {
    for (MazeObject[] row : mazeObjects) {
      for (MazeObject mazeObject : row) {
        if (mazeObject != null) {
          mazeObject.tick();
        }
      }
    }
  }

  public MazeObject getMazeObjectAt(int x, int y) {
    if (isValidLocation(x, y)) {
      return mazeObjects[x][y];
    } else {
      return null;
    }
  }

  public void setMazeObjectAt(int x, int y, MazeObject mazeObject) {
    if (isValidLocation(x, y)) {
      mazeObjects[x][y] = mazeObject;
    } else {
      throw new RuntimeException("setMazeObjectAt called with invalid location");
    }    
  }
}