//
// This is a test harness that will check your answers for
// part (a), part (b), and part (c) of the ClimbingClub
// Free Response Question. Go over to ClimbingClub.java for
// where you need to add your code.
//
class Main {
  private void testPartA() {
    System.out.println("Testing part (a):");

    ClimbingClub hikerClub = new ClimbingClub();
    hikerClub.addClimb("Monadnock", 274);
    hikerClub.addClimb("Whiteface", 301);
    hikerClub.addClimb("Algonquin", 225);
    hikerClub.addClimb("Monadnock", 344);

    verifyClimb(hikerClub, 0, "Monadnock", 274);
    verifyClimb(hikerClub, 1, "Whiteface", 301);
    verifyClimb(hikerClub, 2, "Algonquin", 225);
    verifyClimb(hikerClub, 3, "Monadnock", 344);
  }

  private void testPartB() {
    System.out.println("Testing part (b):");

    ClimbingClub hikerClub = new ClimbingClub();
    hikerClub.addClimbAlphabetical("Monadnock", 274);
    hikerClub.addClimbAlphabetical("Whiteface", 301);
    hikerClub.addClimbAlphabetical("Algonquin", 225);
    hikerClub.addClimbAlphabetical("Monadnock", 344);

    verifyClimb(hikerClub, 0, "Algonquin", 225);
    verifyClimb(hikerClub, 1, "Monadnock", 274);
    verifyClimb(hikerClub, 2, "Monadnock", 344);
    verifyClimb(hikerClub, 3, "Whiteface", 301);
  }

  private void testPartC() {
    System.out.println("Testing part (c):");

    ClimbingClub hikerClub = new ClimbingClub();
    hikerClub.addClimbAlphabetical("Monadnock", 274);
    hikerClub.addClimbAlphabetical("Whiteface", 301);
    hikerClub.addClimbAlphabetical("Algonquin", 225);
    hikerClub.addClimbAlphabetical("Monadnock", 344);
    int numNames = hikerClub.distinctPeakNames();
    if (numNames == 3) {
      System.out.println("distinctPeakNames: PASS");
    } else {
      System.out.println("distinctPeakNames: Expected 3, actual " + numNames);
    }
  }

  private void verifyClimb(ClimbingClub climbingClub, int index, String peakName, int time) {
    ClimbInfo climbInfo = climbingClub.getClimb(index);
    if (climbInfo == null) {
      System.out.println("FAIL: climbingClub.getClimb(" + index + ") == null");
      return;
    }
    if (climbInfo.getName().equals(peakName) && climbInfo.getTime() == time) {
      System.out.println("PASS: " + index + " == new ClimbInfo(" + peakName + ", " + time + ")");
    } else {
      System.out.println("FAIL: " + index);
      System.out.println("  Expected: name = " + peakName + ", " + time);
      System.out.println("  Actual:   name = " + climbInfo.getName() + ", " + climbInfo.getTime());      
    }
  }

  private void run() {
    testPartA();
    testPartB();
    testPartC();
  }

  public static void main(String[] args) {
    new Main().run();
  }
}