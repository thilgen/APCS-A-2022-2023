import java.util.ArrayList;

public class Room {
  private String name, description;
  private ArrayList<Exit> exits = new ArrayList<Exit>();
  private ArrayList<Item> items = new ArrayList<Item>();

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public Item getItemByName(String name) {
    for (Item item : items) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    return null;
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public void addExit(String direction, Room destination) {
    exits.add(new Exit(direction, destination));
  }

  public void describe() {
    System.out.println(name);
    System.out.println();
    System.out.println(description);
    for (Exit exit : exits) {
      System.out.println("You see " + exit.getDestination() + " to the " + exit.getDirection() + ".");
    }
    for (Item item : items) {
      System.out.println("You see a " + item.getName() + " here.");
    }
  }

  public String getName() { return name; }
  public String getDescription() { return description; }

  public Room getExitDestination(String direction) {
    for (Exit exit : exits) {
      if (exit.getDirection().equals(direction)) {
        return exit.getDestination();
      }
    }
    return null;
  }

  public Exit getRandomExit() {
    if (exits.isEmpty()) {
      return null;
    } else {
      return exits.get((int) (Math.random() * exits.size()));
    }
  }

  public String toString() { return name; }
}
