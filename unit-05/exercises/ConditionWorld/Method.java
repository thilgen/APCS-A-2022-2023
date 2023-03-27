import java.util.Scanner;

public abstract class Method {
  public abstract String getName();
  public abstract String getMethodSignature();
  public abstract void showPreConditions();
  public abstract void showPostConditions();
  public abstract void call();

  private void help() {
    System.out.println("Type 'preconditions' to ask about my preconditions.");
    System.out.println("Type 'postconditions' to ask about my postconditions.");
    System.out.println("Type 'signature' to see my method signature.");
    System.out.println("Type 'call' to call me.");
    System.out.println("Type 'exit' to go back.");
  }

  public void interact() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Hi, I'm " + getName() + ". How can I help you?");
      System.out.println("(Type help to see a list of conversational topics.)");
      System.out.print(">");
      String command = scanner.nextLine();
      if (command.equals("help")) {
        help();
      } else if (command.equals("preconditions")) {
        showPreConditions();
      } else if (command.equals("postconditions")) {
        showPostConditions();
      } else if (command.equals("signature")) {
        System.out.println("My method signature? It's " + getMethodSignature());
      } else if (command.equals("call")) {
        call();
      } else if (command.equals("exit")) {
        return;
      } else {
        System.out.println("I don't understand.");
      }
      System.out.println();
    }
  }
}