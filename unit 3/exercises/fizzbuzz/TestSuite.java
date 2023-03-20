public class TestSuite {
  private int numTests, failedTests, successfulTests;

  private void resetTestStats() {
    numTests = 0;
    failedTests = 0;
    successfulTests = 0;
  }

  public void runTests() {
    resetTestStats();
    testFizzBuzz();
    printTestStats();
  }

  private void printTestStats() {
    // TODO
    // Your implementation should print out the number of
    // tests that were successful, tests that failed, and
    // total number of tests.
    // Print out SUCCESS if all tests passed, and FAIL if any failed.
  }

  private void assertFizzBuzzEquals(int i, String expected) {
    // TODO
    // Your implementation should call FizzBuzz.calcFizzBuzz(i)
    // and check it against the expected return value "expected".
    //
    // If it matches, add 1 to successfulTests.
    // If it does not match, add 1 to failedTests and print out
    // the value of i, the expected value, and the actual value.
    //
    // In both cases, add 1 to numTests to track the total number
    // of tests performed.
  }

  private void testFizzBuzz() {
    assertFizzBuzzEquals(1,  "1");
    assertFizzBuzzEquals(2,  "2");
    assertFizzBuzzEquals(3,  "Fizz");
    assertFizzBuzzEquals(4,  "4");
    assertFizzBuzzEquals(5,  "Buzz");
    assertFizzBuzzEquals(6,  "Fizz");
    assertFizzBuzzEquals(7,  "7");
    assertFizzBuzzEquals(8,  "8");
    assertFizzBuzzEquals(9,  "Fizz");
    assertFizzBuzzEquals(10, "Buzz");
    assertFizzBuzzEquals(11, "11");
    assertFizzBuzzEquals(12, "Fizz");
    assertFizzBuzzEquals(13, "13");
    assertFizzBuzzEquals(14, "14");
    assertFizzBuzzEquals(15, "FizzBuzz");
    assertFizzBuzzEquals(16, "16");
    assertFizzBuzzEquals(17, "17");
    assertFizzBuzzEquals(18, "Fizz");
    assertFizzBuzzEquals(19, "19");
    assertFizzBuzzEquals(20, "Buzz");
    assertFizzBuzzEquals(21, "Fizz");
    assertFizzBuzzEquals(22, "22");
    assertFizzBuzzEquals(23, "23");
    assertFizzBuzzEquals(24, "Fizz");
    assertFizzBuzzEquals(25, "Buzz");
    assertFizzBuzzEquals(26, "26");
    assertFizzBuzzEquals(27, "Fizz");
    assertFizzBuzzEquals(28, "28");
    assertFizzBuzzEquals(29, "29");
    assertFizzBuzzEquals(30, "FizzBuzz");
  }
}