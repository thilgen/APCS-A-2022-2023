import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

//
// In this exercise, we'll be implementing the Binary Search algorithm.
//
// Your implementation of binary search will go in the binarySearch method below.
// There is already test code which will invoke your binary search algorithm with
// a variety of different length arrays to ensure it's properly working.
//
// The pseudocode for binary search goes like this:
// You need variables to track the "low" and the "high" indices of the portion of the
// array you're searching. You'll start with considering the entire array.
//
// Write a loop, and the loop should terminate if there are no elements in the
// interval from "low" to "high":
//   Figure out the middle of the low...high interval.
//   Compare the element at array[middle] with the target.
//   If array[middle] == target, we're done, return middle as the solution.
//   If array[middle] <  target, change low/high so only elements to the right
//                               of middle are considered on the next loop.
//   If array[middle] >  target, change low/high so only elements to the left
//                               of middle are considered on the next loop.
// If the loop terminates because there are no elements from low...high, return -1 to
// indicate nothing was found.
//
// DEBUGGING NOTES:
// Binary search algorithms are notoriously hard to get right. It's very easy to
// have off-by-one errors, where the algorithm kind of works but blows up on 
// certain length inputs, or can't find certain items.
//
// To be able to debug effectively, it's helpful to have debugging output to tell
// you what your algorithm is doing on each loop iteration.
// The binarySearch method here has a "boolean verbose" parameter.
// You can write code like
//    if (verbose) {
//      System.out.println("middle index = " + blah + " middle element = " + blah);
//    }
// The testing harness will first call your code with verbose=false, but if that
// test fails, it will call it again with verbose=true, so any debugging output you
// put in will be printed out for a failed test.
//
// (In everyday life, you generally can use an existing implementation of binary search
// such as Arrays.binarySearch.)
//

public class BinarySearch {
  private ArrayList<String> readWordsFile() throws IOException {
    ArrayList<String> words = new ArrayList<String>();
    FileInputStream fileInputStream = new FileInputStream("eowl.txt");
    Scanner scanner = new Scanner(fileInputStream);
    while (scanner.hasNextLine()) {
      words.add(scanner.nextLine());
    }
    scanner.close();
    fileInputStream.close();
    return words;
  }

  private int binarySearch(ArrayList<String> words, String targetWord, boolean verbose) {
    // TODO Put your binary search implementation here!
    return -1;
  }

  private void testBinarySearch(ArrayList<String> arrayList, String target, int expected) {
    int actual = binarySearch(arrayList, target, false);
    if (actual == expected) {
      System.out.println("PASS: binarySearch(" + arrayList + ", \"" + target + "\") == " + expected);
    } else {
      System.out.println("FAIL: binarySearch(" + arrayList + ", \"" + target + "\") != " + expected + ", got " + actual);
      System.out.println("Verbose mode:");
      binarySearch(arrayList, target, true);
    }
  }

  private void testBinarySearch(ArrayList<String> words) {
    ArrayList<String> list = new ArrayList<String>();

    for (int numWords=0; numWords<20; numWords++) {
      for (int i=0; i<numWords; i++) {
        testBinarySearch(list, words.get(i), i);
      }
      testBinarySearch(list, "notthere", -1);
      testBinarySearch(list, "doesntexist", -1);
      list.add(words.get(numWords));
    }
  }

  private void run() {
    ArrayList<String> words;
    try {
      words = readWordsFile();
    } catch (IOException e) {
      System.out.println("Could not read the words file!");
      e.printStackTrace();
      return;
    }

    testBinarySearch(words);

    // TODO After your binarySearch implementation passes all of the tests in
    // testBinarySearch...
    // Write a loop that asks the user for a word, and then uses binarySearch to
    // check whether the word is in the EOWL dictionary (already loaded for you
    // into the ArrayList "words"). Keep asking for words until the user enters
    // an empty line, and then exit.
    // This program could be used by Scrabble players to see whether a word is a
    // real word or not! (Well, it should use an official Scrabble dictionary.)
  }

  public static void main(String args[]) {
    new BinarySearch().run();
  }
}