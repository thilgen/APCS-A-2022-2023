import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;

//
// Remember this exercise?
// This program is for answering questions like:
// What words start with "g" and end with "e"?
// or
// What words start with "t" and end with "x"?
//
// The English Open Word List is a public domain list of 128,000+
// English words, freely available on the Internet. 
// Details are available at https://diginoodles.com/projects/eowl
//
// The difference from the previous WordList exercise is that the
// old program read through the words file line by line to check
// for matching words.
//
// This time, we want to load the words file into memory, and then
// we will let the user enter multiple words one after the other,
// and use the same word list in memory to answer them.
//
// The catch is that we don't know how many words are in the file.
// We could read the whole file once just to find out how many
// lines there are... but another approach is to start the array
// out small, and then grow it whenever it runs out of room.
// This approach is what you'll implement in GrowableArray.java.
// Go there and look for the TODOs!
//
class WordList {
  private GrowableArray words = new GrowableArray(100);
  
  public static void main(String[] args) {
    GrowableArrayTest test = new GrowableArrayTest();
    if (!test.runTest()) {
      System.out.println("GrowableArrayTest failed! Fix your GrowableArray implementation first.");
      return;
    }
    
    new WordList().run();
  }

  private boolean loadWordsFile() {
    try {
      System.out.println("Loading words file from eowl.txt...");
      File wordsFile = new File("eowl.txt"); 
      FileInputStream wordFileStream = new FileInputStream(wordsFile);
      Scanner wordListScanner = new Scanner(wordFileStream);
      while (wordListScanner.hasNextLine()) {
        words.add(wordListScanner.nextLine());
      }
      System.out.println(words.count() + " words loaded.");
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public void run() {
    if (!loadWordsFile()) {
      System.out.println("Error loading words file! Exiting!");
      return;
    }  

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("What should the words start with?");
      String prefix = scanner.nextLine();

      System.out.println("What should the words end with?");
      String suffix = scanner.nextLine();

      int wordCount = 0;
      for (int i=0; i<words.count(); i++) {
        String word = words.stringAt(i);
        if (word.startsWith(prefix) && word.endsWith(suffix)) {
          System.out.println(word);
          wordCount++;
        }
      }
      System.out.println(wordCount + " matching words found.");

      System.out.print("Continue? (yes/no) ");
      String yesOrNo = scanner.nextLine();
      if (!yesOrNo.equals("yes")) {
        break;
      }
    }
  }
}
