public class Room {
  private Room north, south, west, east;

  private String name;

  public Room(String name) {
    this.name = name;
  }

  public String getDescription() {
    int numRooms = 0;

    if (null != north) {
      numRooms++;
    }

    if (null != south) {
      numRooms++;
    }

    if (null != west) {
      numRooms++;
    }

    if (null != east) {
      numRooms++;
    }

    String doorStr = "door";
    if (numRooms != 1) {
      doorStr = "doors";
    }

    return "The " + name + " has " + numRooms + " " + doorStr;
  }

  public String getName() {
    return name;
  }

  public Room getNorth() {
    return north;
  }

  public Room getSouth() {
    return south;
  }

  public Room getWest() {
    return west;
  }

  public Room getEast() {
    return east;
  }

  public void setNorth(Room room) {
    north = room;
  }

  public void setSouth(Room room) {
    south = room;
  }

  public void setWest(Room room) {
    west = room;
  }

  public void setEast(Room room) {
    east = room;
  }
}
