public class Player {
  private Room location;

  public Player(Room initialLocation) {
    location = initialLocation;
  }

  public void lookAround() {
    location.describe();
  }

  public void moveNorth() { tryToMove(location.getNorth()); }
  public void moveSouth() { tryToMove(location.getSouth()); }
  public void moveEast() { tryToMove(location.getEast()); }
  public void moveWest() { tryToMove(location.getWest()); }

  private void tryToMove(Room destination) {
    if (destination == null) {
      System.out.println("You can't move in that direction.");
    } else {
      location = destination;
    }
  }

  public Room getLocation() { return location; }
  public void setLocation(Room room) { this.location = room; }
}
