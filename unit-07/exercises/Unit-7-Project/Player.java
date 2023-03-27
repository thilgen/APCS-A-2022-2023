import java.util.ArrayList;

public class Player {
  private Room location;

  public Player(Room initialLocation) {
    location = initialLocation;
  }

  public void lookAround() {
    location.describe();
  }

  public void addItemToInventory(String itemName) {
    // TODO IMPLEMENT THIS
    System.out.println("The get command is waiting to be implemented!");
  }

  public void dropItemFromInventory(String itemName) {
    // TODO IMPLEMENT THIS
    System.out.println("The drop command is waiting to be implemented!");
  }

  public void listInventory() {
    // TODO IMPLEMENT THIS
    System.out.println("The inventory command is waiting to be implemented!");
  }

  public void move(String direction) {
    Room destination = location.getExitDestination(direction);
    if (destination == null) {
      System.out.println("You can't move in that direction.");
    } else {
      location = destination;
    }
  }

  public Room getLocation() { return location; }
  public void setLocation(Room location) { this.location = location; }
}
