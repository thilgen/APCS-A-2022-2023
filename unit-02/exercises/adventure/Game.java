import java.util.Scanner;

public class Game {
  //
  // Exercises:
  // 1. Customize the map to be your own personal adventure game. You can add rooms and
  //    NPCs (Non-Player Characters) to what is already there, modify the existing rooms
  //    and people, or change it all to a new game map completely of your own creation.
  // 2. Users like to type "n", "s", "e", "w" as shortcuts instead of typing
  //    "north", "south", "east", "west". Can you add support for these shortcuts?
  // 3. Can you make it possible to go up and down, not just north/south/east/west?
  // 4. Modify the doRoomSpecificActions method to add more room-specific actions that
  //    happen randomly in certain rooms.
  // 5. Can you add any more interesting commands to the game?
  //

  private Room compSciRoom = new Room("Computer Science Classroom", "You are in Room 5, the Computer Science classroom.");
  private Room hall = new Room("Hallway", "You are in the hall.");
  private Room schoolGrounds = new Room("School Grounds", "You are on the school grounds.");
  private Room office = new Room("School Office", "You are in the school office.");
  private Room missionRoad = new Room("Mission Road", "You are standing in the middle of Mission Road.");
  private Room bartStation = new Room("BART Station", "You are at South San Francisco BART station.");

  private NPC molina = new NPC("Ms. Molina", "Should I jump on the stage at Bad Bunny?", "Have you finished your homework?");
  private NPC stationAgent = new NPC("Station Agent", "The train is coming soon.", "The system is experiencing delays.");

  private Player player = new Player(compSciRoom);
  private boolean playing = true;

  public Game() {
    wireMap();  
  }

  private void wireMap() {
    compSciRoom.setEast(hall);
    compSciRoom.setNPC(molina);

    hall.setWest(compSciRoom);
    hall.setSouth(schoolGrounds);

    schoolGrounds.setNorth(hall);
    schoolGrounds.setWest(missionRoad);
    schoolGrounds.setSouth(office);

    office.setNorth(schoolGrounds);

    missionRoad.setEast(schoolGrounds);
    missionRoad.setWest(bartStation);

    bartStation.setEast(missionRoad);
    bartStation.setNPC(stationAgent);
  }

  private void doRoomSpecificActions() {
    if (player.getLocation() == missionRoad) {
      if (Math.random() < 0.1) {
        // 10% probability of a car almost hitting you
        System.out.println();
        System.out.println("Careful! A speeding car almost hit you!");
        System.out.println("Maybe it's best to get out of the middle of the street!");
      }
    }
  }

  private void help() {
    System.out.println("Valid commands are:");
    System.out.println("north, south, east, west, talk, help, quit");
  }

  public void play() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to ELCO ADVENTURE!");
    System.out.println("------- -- ---- ----------");
    System.out.println();
    while (playing) {
      player.lookAround();
      doRoomSpecificActions();
      System.out.print(">");
      String command = scanner.nextLine();
      if (command.equals("help")) {
        help();
      } else if (command.equals("north")) {
        player.moveNorth();
      } else if (command.equals("south")) {
        player.moveSouth();
      } else if (command.equals("east")) {
        player.moveEast();
      } else if (command.equals("west")) {
        player.moveWest();
      } else if (command.equals("talk")) {
        NPC npc = player.getLocation().getNPC();
        if (npc != null) {
          npc.talk();
        } else {
          System.out.println("There's nobody here!");
        }
      } else if (command.equals("quit")) {
        playing = false;
      } else {
        System.out.println("I don't understand.");
      }
      System.out.println();
    }
  }
}
