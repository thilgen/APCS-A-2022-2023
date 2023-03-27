public class Player extends Contact {
  private Room location;
  private String name;

  public Player(Room initialLocation, String name, String phoneNumber) {
    super(phoneNumber);
    location = initialLocation;
    this.name = name;
  }

  public void lookAround() {
    System.out.println(location.getDescription());
  }

  public void moveNorth() {
    tryToMove(location.getNorth());
  }

  public void moveSouth() {
    tryToMove(location.getSouth());
  }

  public void moveWest() {
    tryToMove(location.getWest());
  }

  public void moveEast() {
    tryToMove(location.getEast());
  }

  private void tryToMove(Room destination) {
    if (destination == null) {
      System.out.println("You can't move in that direction.");
    } else {
      location = destination;
    }
  }

  public Room getLocation() {
    return location;
  }

  public String getName() {
    return name;
  }

  public void setLocation(Room room) {
    this.location = room;
  }
}
