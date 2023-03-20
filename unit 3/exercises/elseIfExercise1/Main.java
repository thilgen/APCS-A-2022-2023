import java.util.Scanner;

class Main {
  // Write a program that asks the user for an integer.
  // Print "The number is positive." or
  //       "The number is negative." or
  //       "The number is zero."
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a number.");
    int x = scanner.nextInt();
    if (x < 0) {
      System.out.println("The number is negative.");
    } else if (x > 0) {
      System.out.println("The number is positive.");
    } else {
      System.out.println("The number is zero.");
    }
  }
}
