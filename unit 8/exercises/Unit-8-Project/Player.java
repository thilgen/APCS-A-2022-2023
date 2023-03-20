import java.util.ArrayList;

public class Player {
  private String name;

  // playerGrid is the grid where the player's ships will be placed.
  private Grid playerGrid = new Grid();

  // navy is the set of ships that the player has, which will be placed on
  // playerGrid.
  private Navy navy = new Navy(playerGrid);

  // opponentGrid is this player's view of the opponent's grid. It only indicates
  // where the player has fired on the opponent, and what ships were hit in any
  // cells that were fired upon.
  private Grid opponentGrid = new Grid();

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void autoDeployShips() {
    for (Ship ship : navy.getShips()) {
      ship.placeShipRandomly();
    }
  }

  public Location selectTarget() {
    // TODO Implement your computer opponent "AI" here to
    // make this better than just shooting randomly.
    Location location;
    while (true) {
      location = Location.random();
      if (!opponentGrid.getCell(location).isFiredOn()) {
        break;
      }
    }
    return location;
  }

  public void recordAttack(Location location, Ship ship) {
    Cell cell = opponentGrid.getCell(location);
    cell.setShip(ship);
    cell.fireOn();
  }

  public boolean alreadyFiredOn(Location location) {
    return playerGrid.getCell(location).isFiredOn();
  }

  public Ship takeFire(Location location) {
    Cell cell = playerGrid.getCell(location);
    if (cell.isFiredOn()) {
      throw new IllegalArgumentException("takeFire cannot be called on a cell already fired upon.");
    }

    cell.fireOn();

    Ship ship = cell.getShip();
    if (ship != null) {
      System.out.println("  HIT: " + ship.getName().toUpperCase());
      if (ship.isSunk()) {
        System.out.println("  " + name.toUpperCase() + "'S " + ship.getName().toUpperCase() + " HAS BEEN DESTROYED!");
      }
    } else {
      System.out.println("  MISS");
    }

    return ship;
  }

  public void printGrids(String opponentDamageReport[]) {
    ArrayList<String> opponentBanner = new ArrayList<String>();
    opponentBanner.add("YOUR OPPONENT");
    opponentBanner.add("");
    opponentBanner.add("  [" + Cell.HIT + "] Hit");
    opponentBanner.add("  [" + Cell.MISS + "] Miss");
    opponentBanner.add("");
    for (String opponentDamageReportLine : opponentDamageReport) {
      opponentBanner.add(opponentDamageReportLine);
    }
    opponentBanner.add("");
    opponentBanner.add("⛛ DESTROYED");

    ArrayList<String> playerBanner = new ArrayList<String>();
    playerBanner.add("YOUR NAVY");
    playerBanner.add("");
    playerBanner.add("  [" + Cell.HIT + "] Hit");
    playerBanner.add("  [" + Cell.MISS + "] Miss");
    playerBanner.add("");
    String damageReport[] = getDamageReport();
    for (String damageReportLine : damageReport) {
      playerBanner.add(damageReportLine);
    }
    playerBanner.add("");
    playerBanner.add("⛛ DESTROYED");
    playerBanner.add("");
    GridHelpers.printGridHorizontal(opponentGrid, opponentBanner, playerGrid, playerBanner);
  }

  public String[] getDamageReport() {
    ArrayList<String> damageReport = new ArrayList<String>();
    for (Ship ship : navy.getShips()) {
      String shipName = ship.getName();
      damageReport.add(String.format("%s [%s] %s (%d)",
          ship.isSunk() ? "⛛" : " ",
          shipName.charAt(0),
          shipName,
          ship.getLength()));
    }
    return damageReport.toArray(new String[0]);
  }

  public boolean allShipsDestroyed() {
    Ship[] ships = navy.getShips();
    boolean allShipsDestroyed = (0 != ships.length);
    for (Ship ship : ships) {
      if (!ship.isSunk()) {
        return false;
      }
    }
    return allShipsDestroyed;
  }
}
