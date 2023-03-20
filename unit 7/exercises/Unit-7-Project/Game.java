import java.util.Scanner;
import java.util.ArrayList;

public class Game {
  //
  // The Unit 7 Project is bringing back the Adventure game that we worked on
  // in Unit 2. This time, we now have ArrayLists and other more advanced
  // capabilities available to us, so we can build a more sophisticated
  // game!
  //
  // The game has already been enhanced to have the NPCs wander around the
  // map, and support more than 2 catchphrases. There is also a concept of
  // items that you can pick up and use. However, the item concept isn't
  // completely implemented, so part of your job is to complete it.
  //
  // 100 points possible. PLEASE READ THE INSTRUCTIONS CAREFULLY!
  //
  // Rubric:
  // 1. You must add at least 3 new rooms to the map, and there should be some
  //    creativity on display, not "Room A" "Room B" "Room C". You can add to the map
  //    that's already in the game, or you can start with a completely new map
  //    of your own. (15 pts)
  // 2. You must add at least 3 new NPCs to the game. (15 pts)
  // 3. You must add at least 3 new items to the game. (15 pts)
  // 4. Implement the command "inventory" to list out the items the player is holding.
  //    The list of items should be displayed in alphabetical order! (10 pts)
  // 5. Implement the command "get" to pick up an item in a room. This should add the
  //    item to the player's inventory, and remove it from the room's item list.
  //    Obviously, a player should only be able to pick up items that are actually
  //    in the room. Appropriate error messages should be displayed if the user
  //    does something impossible, like trying to get an item that isn't there. (10 pts)
  // 6. Implement the command "drop" to drop an item in a room. This should remove
  //    the item from the player's inventory, and add it to the room's item list.
  //    Obviously, a player should only be able to drop items they are holding,
  //    and appropriate error messages should be displayed if they aren't.
  //    (10 pts)
  // 7. Implement an "examine" command which prints out the description of an item
  //    either in the player's inventory or in the room where the player is.
  //    An error should be displayed if the user isn't holding the item and
  //    the item isn't in the user's current location. (10 pts)
  // 8. Implement at least one command that only works when the player is holding a
  //    certain item. The command might only work in a specific room, too. For instance,
  //    a key might be used to unlock a door, or some money might be used to purchase
  //    another item, or a BART ticket might be used to ride a BART train. (15 pts)
  //

  private Room compSciRoom = new Room("Computer Science Classroom", "You are in Room 5, the Computer Science classroom.");
  private Room hall = new Room("Hallway", "You are in the hall.");
  private Room schoolGrounds = new Room("School Grounds", "You are on the school grounds.");
  private Room office = new Room("School Office", "You are in the school office.");
  private Room missionRoad = new Room("Mission Road", "You are standing in the middle of Mission Road.");
  private Room bartStation = new Room("BART Station", "You are at South San Francisco BART station.");

  private NPC molina, stationAgent, gary, chris;

  private Player player = new Player(compSciRoom);
  private ArrayList<NPC> npcs = new ArrayList<NPC>();
  private boolean playing = true;

  public Game() {
    wireMap();
    createNPCs();
  }

  private static final String NORTH = "north";
  private static final String WEST  = "west";
  private static final String EAST  = "east";
  private static final String SOUTH = "south";
  
  public Player getPlayer() { return player; }

  private void createNPCs() {
    // Note: All NPCs must be added to the "npcs" list.

    molina = new NPC(this, "Ms. Molina", compSciRoom, true);
    molina.addCatchphrase("Should I jump on the stage at Bad Bunny?");
    molina.addCatchphrase("What did you think of that quiz?");
    molina.addCatchphrase("There is a unit test coming up!");
    molina.addCatchphrase("Do you feel ready for the AP Exam?");
    npcs.add(molina);

    chris = new NPC(this, "Chris", compSciRoom, false);
    chris.addCatchphrase("Can I get a volunteer to answer the question?");
    npcs.add(chris);

    gary = new NPC(this, "Gary", compSciRoom, false);
    gary.addCatchphrase("Check out this webcomic about Insertion Sort!");
    npcs.add(gary);

    stationAgent = new NPC(this, "Station Agent", bartStation, false);
    stationAgent.addCatchphrase("The train is coming soon.");
    stationAgent.addCatchphrase("The system is experiencing delays.");  
    npcs.add(stationAgent);
  }

  private void wireMap() {
    compSciRoom.addExit(EAST, hall);
    compSciRoom.addItem(new Item("laser pointer", "You see a small white laser pointer with several buttons."));

    hall.addExit(WEST, compSciRoom);
    hall.addExit(SOUTH, schoolGrounds);

    schoolGrounds.addExit(NORTH, hall);
    schoolGrounds.addExit(WEST, missionRoad);
    schoolGrounds.addExit(SOUTH, office);

    office.addExit(NORTH, schoolGrounds);

    missionRoad.addExit(EAST, schoolGrounds);
    missionRoad.addExit(WEST, bartStation);

    bartStation.addExit(EAST, missionRoad);
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

  private void doNPCActions() {
    for (NPC npc : npcs) {
      npc.tick();
    }
  }

  private void help() {
    System.out.println("Valid commands are:");
    System.out.println("north, south, east, west, inventory, get, drop, help, quit");
  }

  public void play() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to ELCO ADVENTURE!");
    System.out.println("------- -- ---- ----------");
    System.out.println();
    while (playing) {
      player.lookAround();
      for (NPC npc :  npcs) {
        if (npc.getLocation() == player.getLocation()) {
          System.out.println("You see " + npc.getName() + " here.");
        }
      }
      doRoomSpecificActions();
      doNPCActions();
      System.out.print("> ");
      String command = scanner.nextLine();
      if (command.equals("help")) {
        help();
      } else if (command.equals("north")) {
        player.move(NORTH);
      } else if (command.equals("south")) {
        player.move(SOUTH);
      } else if (command.equals("east")) {
        player.move(EAST);
      } else if (command.equals("west")) {
        player.move(WEST);
      } else if (command.equals("inventory")) {
        player.listInventory(); 
      } else if (command.startsWith("get ")) {
        player.addItemToInventory(command.substring("get ".length()));
      } else if (command.startsWith("drop ")) {
        player.dropItemFromInventory(command.substring("drop ".length()));
      } else if (command.equals("quit")) {
        playing = false;
      } else {
        System.out.println("I don't understand.");
      }
      System.out.println();
    }
  }
}
