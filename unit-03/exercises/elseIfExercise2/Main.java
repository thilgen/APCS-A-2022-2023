import java.util.Scanner;

class Main {
  // Write a program that asks the user for a test score from 0-100.
  // Print the letter grade for the given score.
  // (A-, B+, etc. modifiers not required, but you can if you want.)
  //
  // A    90-100
  // B    80-89
  // C    70-79
  // D    60-69
  // F    59 and under
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your score.");
    int score = scanner.nextInt();
    if (score >= 90) {
      System.out.println("You got an A!");
    } else if (score >= 80) {
      System.out.println("You got an B!");
    } else if (score >= 70) {
      System.out.println("You got a C!");
    } else if (score >= 60) {
      System.out.println("You got a D!");
    } else {
      System.out.println("You got a F!");      
    }
  }
}