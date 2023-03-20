public class TruthGameModel {
  private String statement1, statement2, statement3;
  private boolean truth1, truth2, truth3;
  private int numGuesses;

  public TruthGameModel() {
    truth1 = truth2 = truth3 = false;
    statement1 = statement2 = statement3 = null;
    numGuesses = 0;
  }

  //
  // TODO:
  // Return whether truth1, truth2, or truth3 is true
  // depending on whether index is 1, 2, or 3,
  //
  public boolean isTruth(int index) {
    // TODO REPLACE WITH YOUR CODE HERE
    return false;
  }

  //
  // TODO:
  // Set truth1, truth2, or truth3 to true or false
  // depending on whether index is 1, 2, or 3,
  //
  public void setTruth(int index, boolean value) {
    // TODO YOUR CODE HERE
  }

  //
  // TODO:
  // Return statement1, statement2, or statement3
  // depending on whether index is 1, 2, or 3,
  //
  public String getStatement(int index) {
    // TODO REPLACE WITH YOUR CODE HERE
    return null;
  }

  //
  // TODO:
  // Set statement1, statement2, or statement3 to a string
  // depending on whether index is 1, 2, or 3,
  //
  public void setStatement(int index, String value) {
    // TODO YOUR CODE HERE
  }

  // TODO:
  // Add one to the number of guesses.
  public void incrementGuesses() {
    // TODO YOUR CODE HERE
  }

  // TODO:
  // Return the current number of guesses
  public int getNumGuesses() {
    // TODO REPLACE WITH YOUR CODE HERE
    return -1;
  }

  //
  // TODO:
  // Return the 1-based index of the next guess that the
  // computer will make.
  //
  // This method should not return the index of anything for which
  // isTruth(index) == true; that is, anything that has already been
  // guessed and was not the Lie.
  //
  // You could use randomness here, or just always make guesses in
  // the same order.
  //
  public int pickNext() {
    // TODO REPLACE WITH YOUR CODE HERE
    return -1;
  }
}