import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;

//
// This exercise, like the WordList exercise from Wed 10/12,
// uses the English Open Word List (EOWL).
//
// The English Open Word List is a public domain list of 128,000+
// English words, freely available on the Internet. 
// Details are available at https://diginoodles.com/projects/eowl
//
// In this exercise, we dispense with the code for downloading eowl.txt and
// just start with it already in the repl files.
//
// Exercise:
// - Implement the isPalindrome() method to return whether a string
//   is a palindrome, that is, if it's the same string when reversed.
//   Examples: "bob", "civic", "deified"
// - In the testInPalindrome method, write some tests using the if statement
//   that test whether isPalindrome() works properly.
// - Write a loop like you did for WordList to scan the entire
//   word list file, and print out any words that are palindromes.
// - Also, keep a running total of how many palindromes were found
//   and print out the count at the end.
//

class Palindrome {
  private static File wordsFile = new File("eowl.txt");

  public static boolean isPalindrome(String word) {
    // TODO replace the "return false;" with your code to detect palindromes
    // For the purposes of this method, a 1-letter word will be considered a palindrome,
    // and an empty string can be considered a palindrome too.
    // You probably want to do a string loop of some kind...
    return false;
  }

  private static boolean testIsPalindrome() {
    // TODO write some basic tests that check whether isPalindrome behaves as expected.
    // Test isPalindrome on several words and see if the return value is what's expected.
    // Print out an error and return false if isPalindrome is broken.
    // Return true if isPalindrome is working properly, that is,
    // returning true for palindromes and false for anything else.
    return false;
  }

  public static void main(String[] args) throws IOException {
    if (!testIsPalindrome()) {
      System.out.println("isPalindrome tests have failed! Exiting!");
      return;
    }

    FileInputStream wordFileStream = new FileInputStream(wordsFile);
    Scanner wordListScanner = new Scanner(wordFileStream);
    // TODO your code here
    // Write the loop to scan the word list file and print out palindromes.
    // Use your isPalindrome() method.
    // Also keep a running total of # of palindromes and print it out at the en.
  }
}
