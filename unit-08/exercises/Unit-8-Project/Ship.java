public class Ship {
  private Grid grid;
  private String name;
  private int length;
  private Location locations[];

  public Ship(Grid grid, String name, int length) {
    this.grid = grid;
    this.name = name;
    this.length = length;
  }

  public String getName() {
    return name;
  }

  public int getLength() {
    return length;
  }

  public boolean isSunk() {
    for (Location g : locations) {
      if (!grid.getCell(g).isHit()) {
        return false;
      }
    }
    return true;
  }

  public void placeShipRandomly() {
    boolean placed = false;
    while (!placed) {
      Location location = Location.random();
      boolean vertical = Math.random() < 0.5;
      placed = placeShip(location, vertical);
    }
  }

  // placeShip attempts to place a ship either horizontally (vertical=false)
  // or vertically (vertical=true).
  // If vertical=true, location is the topmost cell to use.
  // If vertical=false, location is the leftmost cell to use.
  // placeShip returns true if it successfully placed the ship.
  // It returns false if the ship could not be placed. Reasons for this include
  // the ship going off the end of the grid, or other ships already being in
  // one or more of the cells. If placeShip returns false, pick a different
  // location and call it again.
  public boolean placeShip(Location location, boolean vertical) {
    int rowDelta = 0, colDelta = 0;
    if (vertical) {
      rowDelta = 1;
    } else {
      colDelta = 1;
    }
    Location locations[] = new Location[length];
    for (int i=0; i<length; i++) {
      if (grid.getCell(location).getShip() != null) {
        return false;
      }
      locations[i] = location;
      location = location.add(rowDelta, colDelta);
      if (location == null && i != length-1) {
        // Must've gone off the edge of the grid.
        return false;
      }
    }
    for (Location g : locations) {
      grid.getCell(g).setShip(this);
    }
    this.locations = locations;
    return true;
  }

  public String describe() {
    String description = "";
    for (Location location : locations) {
      if (!description.isEmpty()) {
        description += " ";
      }
      description += "(" + location + ")";
    }
    return description;
  }
}