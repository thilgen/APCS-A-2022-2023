class Main {
  public static void main(String[] args) {
    new TestRunner().run();
    new Main().run();
  }

  private void run() {
    Room hallway = new Room("hallway");

    Room cafeteria = new Room("cafeteria");
    cafeteria.setSouth(hallway);
    hallway.setNorth(cafeteria);

    Room chemistry = new Room("chemistry");
    chemistry.setEast(hallway);
    hallway.setWest(chemistry);

    Room courtyard = new Room("courtyard");
    courtyard.setNorth(hallway);
    hallway.setSouth(courtyard);

    Room mathLab = new Room("math lab");
    mathLab.setWest(hallway);
    hallway.setEast(mathLab);

    Player player = new Player(hallway, "Tony Stark", "4155551212");

    System.out.println(String.format("%s is in the %s", player.getName(), player.getLocation().getName()));
    player.lookAround();
    System.out.println(String.format("Calling them at %s\n", player.getPhoneNumber()));
  }
}
