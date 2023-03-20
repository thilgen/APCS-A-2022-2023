import javax.swing.JFrame;

//
// In this exercise, you'll implement a class that uses the
// Iterator Pattern (https://en.wikipedia.org/wiki/Iterator_pattern)
// to generate the sequence of Fibonacci numbers.
//
// This is a little different from calculating the Fibonacci
// numbers in a loop, because your object will need to keep the
// state of the computation in instance variables, instead of
// tracking them in local variables. You will be able to reuse
// the logic that you did in the previous Fibonacci exercise,
// though.
//
// Go to Fibonacci.java and implement the TODO's there. Once you've
// done that correctly, the self-test should succeed when you run.
// The first 20 Fibonacci numbers will be printed, and then your
// Fibonacci number generator will be used to visualize the
// Fibonacci Spiral (https://en.wikipedia.org/wiki/Golden_spiral).
//

public class Main {
  private JFrame frame;

  private boolean testFibonacci(Fibonacci fibonacci, int i, long expected) {
    long actual = fibonacci.next();
    if (actual == expected) {
      return true;
    } else {
      System.out.println("Fibonacci sequence mismatch at #" + i + ": expected " + expected + ", got " + actual);
      return false;
    }
  }
  public boolean testFibonacci() {
    Fibonacci fibonacci = new Fibonacci();
    return (testFibonacci(fibonacci, 0, 0) &&
            testFibonacci(fibonacci, 1, 1) &&
            testFibonacci(fibonacci, 2, 1) &&
            testFibonacci(fibonacci, 3, 2) &&
            testFibonacci(fibonacci, 4, 3) &&
            testFibonacci(fibonacci, 5, 5) &&
            testFibonacci(fibonacci, 6, 8) &&
            testFibonacci(fibonacci, 7, 13) &&
            testFibonacci(fibonacci, 8, 21));
  }

  public Main() {
    Fibonacci fibonacci = new Fibonacci();
    for (int i=0; i<20; i++) {
      System.out.println(fibonacci.next());
    }

    if (!testFibonacci()) {
      System.out.println("Fibonacci self-test failed!");
      return;
    }

    frame = new JFrame("Fibonacci");
    frame.getContentPane().add(new Spiral());
    frame.setSize(800, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public static void main(String args[]) {
    new Main();
  }
}