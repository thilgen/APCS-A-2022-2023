public class TruthGameModelTest {
  private boolean selfTestPassed;

  private void testAssertion(boolean assertionValid, String message) {
    if (!assertionValid) {
      System.out.println("SELF TEST FAILED: " + message);
      selfTestPassed = false;
    }
  }

  public boolean runTests() {
    TruthGameModel model = new TruthGameModel();

    selfTestPassed = true;

    testAssertion(!model.isTruth(1), "isTruth(1) should be false");
    testAssertion(!model.isTruth(2), "isTruth(2) should be false");
    testAssertion(!model.isTruth(3), "isTruth(3) should be false");

    model.setTruth(1, true);
    testAssertion(model.isTruth(1), "isTruth(1) should be true");

    model.setTruth(2, true);
    testAssertion(model.isTruth(2), "isTruth(2) should be true");

    model.setTruth(3, true);
    testAssertion(model.isTruth(3), "isTruth(3) should be true");

    model.setTruth(1, false);
    testAssertion(!model.isTruth(1), "isTruth(1) should be false");

    model.setTruth(2, false);
    testAssertion(!model.isTruth(2), "isTruth(2) should be false");

    model.setTruth(3, false);
    testAssertion(!model.isTruth(3), "isTruth(3) should be false");

    testAssertion(model.getNumGuesses() == 0, "gameState.getNumGuesses() should be 0");
    model.incrementGuesses();
    testAssertion(model.getNumGuesses() == 1, "gameState.getNumGuesses() should be 1 after incrementGuesses");
    model.incrementGuesses();
    testAssertion(model.getNumGuesses() == 2, "gameState.getNumGuesses() should be 2 after incrementGuesses");

    model.setStatement(1, "foo");
    model.setStatement(2, "bar");
    model.setStatement(3, "abcxyz");
    testAssertion("foo".equals(model.getStatement(1)), "statement 1 should be foo");
    testAssertion("bar".equals(model.getStatement(2)), "statement 2 should be bar");
    testAssertion("abcxyz".equals(model.getStatement(3)), "statement 3 should be abcxyz");

    int choice1 = model.pickNext();
    model.setTruth(choice1, true);

    int choice2 = model.pickNext();
    model.setTruth(choice2, true);

    int choice3 = model.pickNext();
    model.setTruth(choice3, true);

    testAssertion(choice1 != choice2 && choice2 != choice3, "pickNext must return different values for each of 3 invocations: returned " + choice1 + ", " + choice2 + ", " + choice3);
    testAssertion(choice1 >= 1 && choice1 <= 3, "pickNext must return first choice between 1 and 3");
    testAssertion(choice2 >= 1 && choice2 <= 3, "pickNext must return second choice between 1 and 3");
    testAssertion(choice3 >= 1 && choice3 <= 3, "pickNext must return third choice between 1 and 3");

    // Make sure pickNext returns the sole remaining choice.
    model.setTruth(1, true);
    model.setTruth(2, false);
    model.setTruth(3, true);
    testAssertion(model.pickNext() == 2, "pickNext should return 2 when isTruth(1)==true and isTruth(3)==true");

    model.setTruth(1, true);
    model.setTruth(2, true);
    model.setTruth(3, false);
    testAssertion(model.pickNext() == 3, "pickNext should return 3 when isTruth(1)==true and isTruth(2)==true");

    model.setTruth(1, false);
    model.setTruth(2, true);
    model.setTruth(3, true);
    testAssertion(model.pickNext() == 1, "pickNext should return 1 when isTruth(2)==true and isTruth(3)==true");

    if (selfTestPassed) {
      System.out.println("*** SELF TEST PASSED - GAME STARTING ***");
    } else {
      System.out.println("*** SELF TEST FAILED - GAME NOT STARTED ***");
    }

    return selfTestPassed;
  }
}