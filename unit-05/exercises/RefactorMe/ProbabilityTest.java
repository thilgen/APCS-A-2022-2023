//
// This program shows the probability distribution for the sums
// of rolling 2d6 (2 six-sided dice).
//
// This code is in need of refactoring! It is extremely repetitious.
// The variables are poorly named. All of the concerns - the computation
// of probability, the randomized trials, the formatting of the output,
// are all mixed up together in one long main method.
// Constants like the number of rolls and the table column widths
// are "hard coded" and have to be changed in multiple places.
// It would be difficult to reuse any part of this code except by
// copy and paste.
//
// See if you can DRY up this code (Don't Repeat Yourself), and
// organize it into classes that could hopefully be reused in other
// contexts. Some suggested classes have been created in the repl.it
// folder pane. You could move bits of code from this giant main
// method into individual methods in those classes. Perhaps the
// giant main method should be split up into more methods that get
// called by main. Think you how the code could be better organized
// such that a newcomer to it would understand quickly how it works.
//
class ProbabilityTest {
  public static void main(String[] args) {
    System.out.println("Measured and Computed Probability of rolling 2d6:");
    System.out.println();

    for (int j=0; j<3; j++) {
      String s;
      if (j == 0) {
        s = "Roll";
      } else if (j == 1) {
        s = "Measured";
      } else {
        s = "Computed";
      }
      System.out.print(s);
      for (int k=0; k<10-s.length(); k++) {
        System.out.print(' ');
      }
    }
    System.out.println();

    for (int i=2; i<=12; i++) {
      // Count up ways that 2d6 can add up to i
      int ways=0;
      for (int j=1; j<=6; j++) {
        for (int k=1; k<=6; k++) {
          if (j+k == i) {
            ways++;
          }
        }
      }
      double computedProbability = ways / (6.0 * 6.0);
      // Experimentally trial
      int rolls=0;
      for (int j=0; j<1000000; j++) {
        int die1 = (int)(Math.random() * 6) + 1;
        int die2 = (int)(Math.random() * 6) + 1;
        if (die1 + die2 == i) {
          rolls++;
        }
      }
      double measuredProbability = rolls / 1000000.0;
      for (int j=0; j<3; j++) {
        String s;
        if (j == 0) {
          s = Integer.toString(i);
        } else if (j == 1) {
          s = Double.toString(measuredProbability * 100.0);
          int k = s.indexOf(".");
          if (k >= 0) {
            s = s.substring(0, k+3);
          }
          s += "%";
        } else {
          s = Double.toString(computedProbability * 100.0);
          int k = s.indexOf(".");
          if (k >= 0) {
            s = s.substring(0, k+3);
          }
          s += "%";
        }
        System.out.print(s);
        for (int k=0; k<10-s.length(); k++) {
          System.out.print(' ');
        }
      }
      System.out.println();
    }
  }
}