public class Room {
  private Room north, east, west, south;
  private NPC npc;
  private String name, description;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public void describe() {
    System.out.println(name);
    System.out.println();
    System.out.println(description);
    printMove(north, "north");
    printMove(south, "south");
    printMove(east, "east");
    printMove(west, "west");
    if (npc != null) {
      System.out.println("You see " + npc + " here. Type 'talk' to talk to them.");
    }
  }

  private void printMove(Room room, String direction) {
    if (room != null) {
      System.out.println("You see " + room + " to the " + direction + ".");
    }
  }

  public String getName() { return name; }
  public String getDescription() { return description; }

  public Room getNorth() { return north; }
  public Room getSouth() { return south; }
  public Room getEast() { return east; }
  public Room getWest() { return west; }

  public void setNorth(Room north) { this.north = north; }
  public void setSouth(Room south) { this.south = south; }
  public void setEast(Room east) { this.east = east; }
  public void setWest(Room west) { this.west = west; }

  public NPC getNPC() { return npc; }
  public void setNPC(NPC npc) { this.npc = npc; }

  public String toString() { return name; }
}
