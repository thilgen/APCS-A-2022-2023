//
// Cell is a single Grid cell.
// It may represent a cell of the player's own grid, or a cell of the player's view of the opponent's grid.
// A Cell either has a Ship on it, or not.
// A Cell starts out not fired upon, and may be fired upon once.
// 
public class Cell {
  static public final char BLANK = ' ';
  static public final char HIT = '*';
  static public final char MISS = '-';

  private Ship ship;
  private boolean firedOn;

  public void fireOn() {
    if (firedOn) {
      throw new IllegalArgumentException("Internal error! You cannot fire on a cell more than once.");
    }
    firedOn = true;
  }

  public boolean isFiredOn() {
    return firedOn;
  }

  public boolean isHit() {
    return ship != null && firedOn;
  }

  public boolean isMiss() {
    return ship == null && firedOn;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
  }

  public Ship getShip() {
    return ship;
  }

  public char getPrintChar() {
    if (isHit()) {
      return HIT;
    } else if (isMiss()) {
      return MISS;
    } else {
      return BLANK;
    }
  }
}