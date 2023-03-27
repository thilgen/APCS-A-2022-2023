import java.util.Scanner;

public class CharAtMethod extends Method {
  public String getName() {
    return "charAt";
  }

  public String getMethodSignature() {
    return "char charAt(int index)";  
  }

  public void showPreConditions() {
    System.out.println("index must be in the range [0, length of string)");
  }

  public void showPostConditions() {
    System.out.println("I will return the character at index 'index' in the string");    
  }

  public void call() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("What string would you like to call me on?");

    String str = scanner.nextLine();

    System.out.println("What would you like to pass for index?");
    int index = scanner.nextInt();
    scanner.nextLine();

    if (index < 0 || index >= str.length()) {
      System.out.println("It looks like you have violated my preconditions!");
      System.out.println("Calling me may result in unexpected behavior, even an exception!");
      System.out.println("Are you sure you want to call me? (yes or no)");
      String answer = scanner.nextLine();
      if (!answer.equals("yes")) {
        System.out.println("Thanks anyway! Come again soon!");
        return;
      }
    } else {
      System.out.println("Thanks, it looks like you have satisfied my preconditions!");
    }
    
    System.out.println("OK, here goes!");
    try {
      char ch = str.charAt(index);
      System.out.println("Here's my postcondition! The character at index " + index + " is " + ch);
    } catch (Exception ex) {
      System.out.println("Ouch, an exception happened. Here it is:");
      ex.printStackTrace();
    }
  }
}