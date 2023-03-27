import java.io.*;
import java.util.*;

//
// The file t8.shakespeare.txt contains the complete works of Shakespeare
// concatenated together into a single large text file.
//
// This was downloaded from
// https://ocw.mit.edu/ans7870/6/6.006/s08/lecturenotes/files/t8.shakespeare.txt
//
// Each work starts off with a header like this:
//
// "1609"
// "" (there may be more than one empty string)
// "THE SONNETS"
// ""
// "by William Shakespeare"
//
// and it ends with
// "THE END"
//
// We want to read through the entire file and print out the year of publication,
// title, and number of lines and words in each work.
//
// At the end, we want to print out the total line count, and how
// long it took to process the file, and how many lines we processed
// per second.
//
// Also, the infographic in today's class slides said Shakespeare's plays are
// 884,429 words. Let's verify that. Count up the total words in all of the works,
// and print that out at the end of the program.
//
// Sample output:
// ---BEGIN SAMPLE OUTPUT---
// THE SONNETS was written in 1609 and has 2310 lines and 17739 words
// ALLS WELL THAT ENDS WELL was written in 1603 and has 2993 lines and 25635 words
// .....
// THE WINTER'S TALE was written in 1611 and has 3406 lines and 27177 words
// A LOVER'S COMPLAINT was written in 1609 and has 330 lines and 2562 words
//
// The combined works span a total of ##### lines and ##### words
// It took 0.215785625 seconds (from nanoTime) to process the data
// It took 0.216 seconds (from currentTimeMillis) to process the data
// We processed 529446.7599498344 lines per second
// ---END SAMPLE OUTPUT---
//
// We are going to build what's called a "Finite State Machine"
// to solve this problem.
// The states are:
// - WAIT_FOR_YEAR_STATE: I'm waiting to see the year of publication.
//   - When I do see it, I save the year into an instance variable, and
//     transition to WAIT_FOR_TITLE_STATE.
// - WAIT_FOR_TITLE_STATE: I'm waiting to see the title of the work.
//   - When I do see it, I save the title into an instance variable, and
//     transition to WAIT_FOR_END_STATE.
// - WAIT_FOR_END_STATE: I'm waiting to see THE END signaling the end of the work's text.
//   - When I do see it, I do the following:
//     - Print out the year, title, and # of lines and words in the work.
//     - Transition to WAIT_YEAR_STATE.
//   - If THE END was not seen, this is just a line of text in the
//     work, so I just increment the # of lines counter, and add
//     the number of words in this line to the words counter.
//     Don't count any blank lines!
//

class Shakespeare {
  private static final int WAIT_FOR_YEAR_STATE  = 0;
  private static final int WAIT_FOR_TITLE_STATE = 1;
  private static final int WAIT_FOR_END_STATE   = 2;

  private int state = WAIT_FOR_YEAR_STATE;

  public static void main(String[] args) throws IOException {
    new Shakespeare().analyze();
  }

  public Shakespeare() {
    state = WAIT_FOR_YEAR_STATE;
  }

  private void handleWaitForYearState(String s) {
    // TODO:
    // Write code that checks if "s" contains a 4-digit year.
    //
    // String.charAt(index) can be used to extract a single character from a string.
    // Character.isDigit() can be used to check if a character is a digit.
    //
    // If "s" contains a 4 digit year, record the year in an instance variable and
    // set state to WAIT_FOR_TITLE_STATE.
  }

  private void handleWaitForTitleState(String s) {
    // TODO:
    // Here, we're waiting to see the title after seeing the year.
    // There may be one or more empty lines between the year and the title.
    //
    // When "s" contains a non-empty string, that's the title.
    // Capture it in an instance variable and set state to WAIT_FOR_END_STATE.
    // You'll need instance variables to track the line and word counters.
    // Make sure the line and word counters are initialized to 0 here.
    //
    // If "s" is an empty string, do nothing and stay in WAIT_FOR_TITLE_STATE.
  }

  private void handleWaitForEndState(String s) {
    // TODO:
    // If s equals the string "THE END", then we're at the
    // end of a work. Now we print the year of publication,
    // title, and the # of lines and words in the work, using
    // the instance variables that we've been tracking for them.
    //
    // Then we transition back to WAIT_FOR_YEAR_STATE to wait
    // to capture information about the next work, if any.
    //
    // If s does NOT equal the string "THE END", then this is
    // one of the lines of text in the work, so increment
    // the running counter of the # of lines in the work,
    // and count up the words in the line and add them to the
    // words counter. Ignore blank lines.
  }

  public void analyze() throws IOException {
    File file = new File("t8.shakespeare.txt");
    Scanner scanner = new Scanner(file);

    // TODO:
    // Add code to time the execution of the while loop.
    // At the end of the loop, print out how many seconds
    // the loop took, and the number of lines processed per
    // second. You can use System.currentTimeMillis() or
    // System.nanoTime(). Try both... does one seem more accurate?

    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      if (state == WAIT_FOR_YEAR_STATE) {
        handleWaitForYearState(s);
      } else if (state == WAIT_FOR_TITLE_STATE) {
        handleWaitForTitleState(s);
      } else if (state == WAIT_FOR_END_STATE) {
        handleWaitForEndState(s);
      }
    }

    // TODO Remember to print out the total number of words
    // and lines in all of the works combined!
    // And for benchmarking purposes, print out the time
    // elapsed when processing the file, and how many
    // lines were processed per second!
  }
}