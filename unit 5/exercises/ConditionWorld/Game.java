import java.util.Scanner;

//
// Exercises:
// This is an adventure game like the one we did in Unit 2, but this time, instead
// of exploring a virtual El Camino High School, you will be entering the virtual
// world of Java itself, and interacting with some of the built-in methods that
// we have been learning about.
//
// CharAtMethod.java is fully implemented. When you interact with charAt, it can
// tell you the method signature, preconditions, and postconditions. You can call
// charAt and it will check the preconditions before actually calling the method,
// and will print the postcondition (the return value).
//
// YOUR TASK: Follow the pattern in CharAtMethod.java and complete the implementation
// of IndexOfMethod.java, SqrtMethod.java, and SubstringMethod.java.
// If you have time, maybe add some more methods of your own.
//

public class Game {
  private Room stringRoom = new Room("String", new Method[] {
    new CharAtMethod(),
    new IndexOfMethod(),
    new SubstringMethod()
  });
  private Room mathRoom = new Room("Math", new Method[] {
    new SqrtMethod()
  });
  
  private Player player = new Player(stringRoom);
  private boolean playing = true;

  public Game() {
    wireMap();  
  }

  private void wireMap() {
    stringRoom.setRight(mathRoom);
    mathRoom.setLeft(stringRoom);
  }


  private void help() {
    System.out.println("Valid commands are:");
    System.out.println("left, right, exit");
    System.out.println("Type the name of a method to interact with it.");
  }

  public void play() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Precondition/Postcondition World!");
    System.out.println();
    System.out.println("You feel yourself descending into a world of pure code.");
    System.out.println("You have become digital, one with the machine.");
    System.out.println("You have entered the Java standard library itself!");
    while (playing) {
      player.lookAround();
      System.out.print(">");
      String command = scanner.nextLine();
      if (command.equals("help")) {
        help();
      } else if (command.equals("left")) {
        player.moveLeft();
      } else if (command.equals("right")) {
        player.moveRight();
      } else if (command.equals("exit")) {
        playing = false;
      } else if (!player.getLocation().invokeMethod(command)) {
        System.out.println("I don't understand.");
      }
      System.out.println();
    }
    System.out.println("You feel yourself emerging from the matrix, returning to physical form.");
  }
}
