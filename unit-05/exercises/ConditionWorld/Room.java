public class Room {
  private Room left, right;
  private Method[] methods;

  private String name;

  public Room(String name, Method[] methods) {
    this.name = name;
    this.methods = methods;
  }

  public void describe() {
    System.out.println("You are in the " + name + " class.");
    System.out.println();
    System.out.println("You see these methods here:");
    for (Method method : methods) {
      System.out.println(method.getName());
    }
    printMove(left, "left");
    printMove(right, "right");
  }

  private void printMove(Room room, String direction) {
    if (room != null) {
      System.out.println("You see " + room + " to the " + direction + ".");
    }
  }

  public boolean invokeMethod(String name) {
    for (Method method : methods) {
      if (method.getName().equals(name)) {
        method.interact();
        return true;
      }
    }
    return false;
  }

  public String getName() {
    return name;
  }

  public Room getLeft() {
    return left;
  }

  public Room getRight() {
    return right;
  }

  public void setLeft(Room left) {
    this.left = left;
  }

  public void setRight(Room right) {
    this.right = right;
  }

  public String toString() {
    return name;
  }
}
