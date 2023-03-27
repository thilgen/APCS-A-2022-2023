public class Player {
  private Room location;

  public Player(Room initialLocation) {
    location = initialLocation;
  }

  public void lookAround() {
    location.describe();
  }

  public void moveLeft() { tryToMove(location.getLeft()); }
  public void moveRight() { tryToMove(location.getRight()); }

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
