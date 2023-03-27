public class Navy {
  private Grid grid;
  private Ship ships[];

  public Navy(Grid grid) {
    this.grid = grid;
    ships = new Ship[] {
      new Ship(grid, "Aircraft Carrier", 5),
      new Ship(grid, "Battleship", 4),
      new Ship(grid, "Cruiser", 3),
      new Ship(grid, "Submarine", 3),
      new Ship(grid, "Destroyer", 2)
    };
  }

  public Ship[] getShips() {
    return ships;
  }
}