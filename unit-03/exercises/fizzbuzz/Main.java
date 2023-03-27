class Main {
  //
  // Fizz buzz is a group word game for children to teach them about division.
  // Players take turns to count incrementally, replacing any number divisible
  // by three with the word "fizz", and any number divisible by five with the word "buzz".
  // (https://en.wikipedia.org/wiki/Fizz_buzz)
  //
  // This is also a common programming interview question!
  //
  // Exercises:
  // 1. In FizzBuzz.java, implement the calcFizzBuzz method.
  // 2. In TestSuite.java, implement the missing methods.
  //

  private static void printFizzBuzz(int i, int n) {
    System.out.println("FizzBuzz("+i+") = " + FizzBuzz.calcFizzBuzz(i));
    if (i < n) {
      // Looping using recursion since we haven't officially learned loop statements yet!
      printFizzBuzz(i+1, n);
    }
  }

  public static void main(String[] args) {
    printFizzBuzz(1, 50);

    TestSuite testSuite = new TestSuite();
    testSuite.runTests();
  }
}