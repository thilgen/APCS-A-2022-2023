//
// Grid is the Battleship playing grid.
// A Player object owns two Grids: one to represent the player's own grid
// with the player's ships, and a second which indicates where the player
// has fired upon the opponent and whether it was a hit/miss and on what ships.
//
public class Grid {
  public static final int NUM_ROWS = 10;
  public static final int NUM_COLS = 10;

  private Cell cells[][];

  public Grid() {
    cells = new Cell[NUM_ROWS][NUM_COLS];
    for (int row = 0; row < NUM_ROWS; row++) {
      for (int col = 0; col < NUM_COLS; col++) {
        cells[row][col] = new Cell();
      }
    }
  }

  public Cell getCell(Location location) {
    return cells[location.getRow()][location.getCol()];
  }

  // Returns true if row/col represents a legal Grid position.
  public static boolean isLegal(int row, int col) {
    return row >= 0 && row < NUM_ROWS && col >= 0 && col < NUM_COLS;
  }
}