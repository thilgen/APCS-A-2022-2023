import java.util.Scanner;

public class TruthGameViewController {
  private TruthGameModel model = new TruthGameModel();
  private Scanner scanner = new Scanner(System.in);

  private void readStatement(int i) {
    System.out.print("Enter statement #" + i + ":");
    System.out.print(">");
    String statement = scanner.nextLine();
    if (statement.length() > 0) {
      model.setStatement(i, statement);
    } else {
      System.out.println("C'mon, work with me here.");
      readStatement(i);
    }
  }

  private boolean readYesNo() {
    System.out.print(">");
    String response = scanner.nextLine();
    if (response.equals("yes")) {
      return true;
    } else if (response.equals("no")) {
      return false;
    } else {
      System.out.println("A yes or no answer will suffice, thank you.");
      return readYesNo();
    }
  }

  private void printStatement(int index) {
    System.out.println(model.getStatement(index));
  }

  //
  // Makes a guess about which statement is the lie, and
  // asks the user if the guess is correct.
  // Returns true if the guess was correct.
  //
  private boolean guess() {
    int guessIndex = model.pickNext();
    System.out.println("I think you lied when you said:");
    printStatement(guessIndex);

    System.out.println("Am I correct?");
    model.incrementGuesses();
    boolean correct = readYesNo();

    if (correct) {
      System.out.println("Got it in " + model.getNumGuesses() + " guesses!");
    } else {
      model.setTruth(guessIndex, true);
    }

    return correct;
  }

  public void play() {
    System.out.println("Enter two truths and a lie about yourself.");

    readStatement(1);
    readStatement(2);
    readStatement(3);

    // At most two guesses are needed to figure out the lie.
    if (!guess() && !guess()) {
      System.out.println("Took me awhile, but this must be the lie then!");
      printStatement(model.pickNext());
    }
  }
}