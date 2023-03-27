//
// Location represents a location on the grid. Internally, this is stored
// as a zero-based integer row and column. When printed, it is displayed
// in Battleship's letter-digits notation, e.g. A5 is row=0 col=4,
// B10 is row=1 col=9.
//
// Location also includes factory methods for picking random locations,
// getting a Location for a particular spot on the grid or null if the
// row/col is invalid, and advancing a location by some delta.
//
public class Location {
  private int row, col;

  public Location(int row, int col) {
    if (!Grid.isLegal(row, col)) {
      throw new IllegalArgumentException("Location out of range: row=" + row + " col=" + col);
    }
    this.row = row;
    this.col = col;
  }

  // Construct a Location; returns null if invalid row/col.
  public static Location at(int row, int col) {
    if (Grid.isLegal(row, col)) {
      return new Location(row, col);
    } else {
      return null;
    }
  }

  // Construct a random Location
  public static Location random() {
    int row = (int) (Math.random() * Grid.NUM_ROWS);
    int col = (int) (Math.random() * Grid.NUM_COLS);
    return new Location(row, col);
  }

  // Construct a Location from alpha+number notation, e.g. D4
  public static Location parse(String str) {
    if (str.length() < 2) {
      return null;
    }
    char letter = str.toUpperCase().charAt(0);
    if (letter < 'A' || letter >= 'A' + Grid.NUM_ROWS) {
      return null;
    }
    try {
      int number = Integer.parseInt(str.substring(1));
      if (number < 1 || number > Grid.NUM_COLS) {
        return null;
      }
      return new Location(letter - 'A', number - 1);
    } catch (NumberFormatException e) {
      return null;
    }
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public boolean equals(Object o) {
    if (!(o instanceof Location)) {
      return false;
    }
    Location otherLocation = (Location) o;
    return col == otherLocation.col && row == otherLocation.row;
  }

  // Returns a new Location based on a Location plus some row and column delta.
  // Returns null if the resulting Location is off the grid.
  public Location add(int rowDelta, int colDelta) {
    return at(row + rowDelta, col + colDelta);
  }

  public String toString() {
    char letter = (char) (row + 'A');
    int number = col + 1;
    return "" + letter + number;
  }
}