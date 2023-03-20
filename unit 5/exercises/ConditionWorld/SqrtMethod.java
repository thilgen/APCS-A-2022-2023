import java.util.Scanner;

public class SqrtMethod extends Method {
  public String getName() {
    return "sqrt";
  }

  public String getMethodSignature() {
    return "double sqrt(sqrt value)";
  }

  public void showPreConditions() {
    // TODO Add code here to show the preconditions of String.indexOf(String substring)
    System.out.println("I'm not sure about my preconditions! I need someone to fill that in.");
  }

  public void showPostConditions() {
    // TODO Add code here to show the postconditions of String.indexOf(String substring)
    System.out.println("I'm not sure about my postconditions! I need someone to fill that in.");
  }

  public void call() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("What double would you like to call me on?");
    double value = scanner.nextDouble();
    scanner.nextLine();

    // TODO Add code here to check the preconditions and warn the user if they
    // have not been met.
    System.out.println("Help, I need someone to implement checking the preconditions.");
    
    System.out.println("OK, here goes!");

    // TODO Add code to call the method and print out the postcondition (the result).
    System.out.println("Help, I need someone to implement calling the method.");
  }
}