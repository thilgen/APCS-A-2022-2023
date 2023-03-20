//
// There is no exercise to do here... this repl.it is just to
// demonstrate benchmarking of different implementations of the
// same method. Here we compare:
//
// 1. isPalindrome() by direct comparison of the chars in the string
// 2. isPalindrome() by comparing the string and its reverse,
//    using string concatenation to reverse the string
// 3. isPalindrome() by comparing the string and its reverse,
//    using StringBuilder's built-in reverse() method
//

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;

class Main {
  private static final int NUM_PASSES = 10;
  private static final int NUM_WORDS = 128985;

  public static String reverseString(String s) {
    String result = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      result += s.charAt(i);
    }
    return result;
  }

  public static String reverseStringBuilder(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  public static boolean isPalindrome(String word) {
    for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
      if (word.charAt(i) != word.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindromeReversed(String word) {
    return word.equals(reverseString(word));
  }

  public static boolean isPalindromeReverseBuilder(String word) {
    return word.equals(reverseStringBuilder(word));
  }
  
  public static String[] readWordsFile() throws IOException {
    //
    // We are loading the file into memory so that we don't
    // throw off the benchmark results with the noise of
    // reading the file again and again. We want the
    // benchmark to be "pure" isPalindrome method execution
    // with as little other overhead as possible.
    //
    String[] words = new String[NUM_WORDS];
    FileInputStream in = new FileInputStream(new File("eowl.txt"));
    Scanner scanner = new Scanner(in);
    int i = 0;
    while (scanner.hasNextLine()) {
      words[i++] = scanner.nextLine();
    }
    return words;
  }

  public static void main(String[] args) throws IOException {
    String[] words = readWordsFile();

    long startTime = System.nanoTime();
    for (int pass = 0; pass < NUM_PASSES; pass++) {
      for (int i = 0; i < words.length; i++) {
        isPalindrome(words[i]);
      }
    }
    long elapsed = System.nanoTime() - startTime;
    System.out.println("isPalindrome: " + (elapsed/1e9) + " s");

    startTime = System.nanoTime();
    for (int pass = 0; pass < NUM_PASSES; pass++) {
      for (int i = 0; i < words.length; i++) {
        isPalindromeReversed(words[i]);
      }
    }
    elapsed = System.nanoTime() - startTime;
    System.out.println("isPalindromeReversed: " + (elapsed/1e9) + " s");

    startTime = System.nanoTime();
    for (int pass = 0; pass < NUM_PASSES; pass++) {
      for (int i = 0; i < words.length; i++) {
        isPalindromeReverseBuilder(words[i]);
      }
    }
    elapsed = System.nanoTime() - startTime;
    System.out.println("isPalindromeReverseBuilder: " + (elapsed/1e9) + " s");
  }
}