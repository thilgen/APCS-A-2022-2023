import java.util.Scanner;

public class Game {
  //
  // Exercises:
  // 1. Run the Repl and play the game to get familiar with it!
  //
  // 2. The "heal" command isn't yet implemented.
  //    Code the "heal" command to subtract 3 magic points and
  //    adds back 1-6 health. It should not let you heal
  //    when you no longer have at least 3 magic points;
  //    print an error message instead.
  //    It should also not let you heal to more health than
  //    you started with... healing should max out at
  //    your original health.
  //
  // 3. If you have time, add any other commands, weapons,
  //    and magic spells that you like. Give Trogdor more attacks!
  private Scanner scanner;

  private Combatant trogdor, you;

  // Trogdor's weapons
  private Weapon burninate, tail, beefcakeFist;

  // Your weapons
  private Weapon sword, axe;

  public Game() {
    System.out.println("You are facing Trogdor the Burninator in mortal combat!");
    System.out.println("Only you can save the townspeople from being burninated!");
    scanner = new Scanner(System.in);
    setupGame();
  }

  private void setupGame() {
    trogdor = new Combatant("Trogdor", "his");
    you = new Combatant("You", "your");

    burninate = new Weapon("burninating breath", 0.3, 3, 12);
    tail = new Weapon("scaly tail", 0.2, 1, 6);
    beefcakeFist = new Weapon("beefcake fist", 0.5, 4, 8);

    sword = new Weapon("sword", 0.6, 1, 8);
    axe = new Weapon("axe", 0.4, 2, 12);

    you.wield(sword);
  }

  public void play() {
    boolean stillPlaying = combatRound();
    if (stillPlaying) {
      // This is an example of tail recursion. A loop would also work.
      play();
    }
  }

  // combatRound returns true if the game should continue, or
  // false if the game is over.
  private boolean combatRound() {
    you.printStats();
    trogdor.printStats();

    System.out.print(">");

    String command = scanner.nextLine();

    if (command.equals("quit")) {
      System.out.println("Trogdor laughs as you flee in terror!");
      System.out.println("Trogdor burninates the countryside to celebrate!");
      return false;
    } else if (command.equals("attack")) {
      you.attack(trogdor);
    } else if (command.equals("heal")) {
      you.heal();
    } else if (command.equals("wield axe")) {
      you.wield(axe);
    } else if (command.equals("wield sword")) {
      you.wield(sword);
    } else if (command.equals("help")) {
      System.out.println("Commands include attack, quit, wield, help");
      return true;
    } else {
      System.out.println("I didn't understand! Type help for commands.");
      return true;
    }

    if (!trogdor.isAlive()) {
      System.out.println("You have killed Trogdor the Burninator!");
      System.out.println("The townspeople emerge from their thatched-roof cottages to celebrate!");
      return false;
    }

    // Trogdor is alive and well and going to attack you.
    // Trogdor will randomly select a different weapon each time
    int weaponChoice = Random.randomInt(0, 2);
    if (weaponChoice == 0) {
      trogdor.wield(burninate);
    } else if (weaponChoice == 1) {
      trogdor.wield(tail);
    } else {
      trogdor.wield(beefcakeFist);
    }
  
    trogdor.attack(you);

    if (!you.isAlive()) {
      System.out.println("Trogdor has killed you! Trogdor burninates the countryside to celebrate!");
      return false;
    }

    return true;
  }
}