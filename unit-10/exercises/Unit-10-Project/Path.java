/**
 * Path is a linked list of maze locations. Path can be used to efficiently track multiple
 * possible paths from a starting point to a destination.
 * 
 * A Path is constructed for a starting location using Path.startingAt, and then additional
 * steps may be added using Path.prepend.
 * 
 * Because Path is immutable, each "fork in the road" does not require copying the previous
 * steps in the Path.
 */
public class Path {
  private final int x, y;
  private final Path previousSteps;

  /**
   * Construct a Path with location (x, y) and with the given path to here.
   * @param x The x-coordinate of this step's location in the maze
   * @param y The y-coordinate of this step's location in the maze
   * @param previousSteps Path leading to this point, or null if this is the starting point.
   */
  public Path(int x, int y, Path previousSteps) {
    this.x = x;
    this.y = y;
    this.previousSteps = previousSteps;
  }

  /**
   * Prepends a new (x, y) location to path, returning a new Path.
   * @param path Path to prepend, can be null if empty.
   * @return new Path object with (x, y) prepended.
   */
  public static Path prepend(int x, int y, Path previousSteps) {
    return new Path(x, y, previousSteps);
  }

   /**
   * Returns x-coordinate of this step's location in the Path.
   * @return x-coordinate of this Path
   */
  public int getX() { return x; }

  /**
   * Returns y-coordinate of this step's location in the Path.
   * @return y-coordinate of this Path
   */
  public int getY() { return y; }

  /**
   * Returns the path to here associated with this Path.
   * @return Path object representing path leading to this point.
   */
  public Path getPreviousSteps() { return previousSteps; }

  /**
   * Returns true if (x, y) is a part of this Path, false otherwise.
   * @param x The x-coordinate of the location to test for
   * @param y The y-coordinate of the location to test for
   * @return boolean indicating whether (x, y) is in the path
   */
  public boolean contains(int x, int y) {
    if (getX() == x && getY() == y) {
      return true;
    }
    return previousSteps != null && previousSteps.contains(x, y);
  }

  /**
   * Returns the length of this path.
   * @return Length of this path in maze cells
   */
  public int length() {
    if (previousSteps == null) {
      return 1;
    } else {
      return 1 + previousSteps.length();
    }
  }
}
