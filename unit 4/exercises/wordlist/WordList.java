import java.net.URL;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.io.FileOutputStream;

//
// This program is for answering questions like:
// How many 7 letter words start with "g" and end with "e"?
// or
// How many 10 letter words start with "t" and end with "x"?
//
// The English Open Word List is a public domain list of 128,000+
// English words, freely available on the Internet. 
// Details are available at https://diginoodles.com/projects/eowl
//
// The starter code provided here downloads the EOWL into 
// this repl's home directory. The first time you run this
// program, a file eowl.txt should appear. Click on eowl.txt
// in the Files pane to see what it looks like.
// (Saving the file locally so that we don't have to
//  download it every time is a form of "caching".)
// Then code the TODOs listed below.
//
class WordList {
  private static File wordsFile = new File("eowl.txt"); 

  private static boolean downloadWords() {
    if (wordsFile.exists()) {
      // We already have the words file cached.
      return true;
    } else {
      try {
        URL url = new URL("https://github.com/BartMassey/wordlists/raw/master/eowl.txt.gz");
        InputStream is = new GZIPInputStream(url.openStream());
        FileOutputStream os = new FileOutputStream(wordsFile);
        int bufferSize = 1024;
        byte[] b = new byte[bufferSize];
        int len;
        while ((len = is.read(b, 0, bufferSize)) > 0) {
          os.write(b, 0, len);
        }
        is.close();
        os.close();
        System.out.println("eowl.txt downloaded successfully");
        return true;
      } catch (IOException e) {
        System.out.println("Something bad happened on my way to get the words list!");
        e.printStackTrace();
        return false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    if (!downloadWords()) {
      System.out.println("Could not get words list! Exiting!");
      return;
    }

    // TODO, here prompt the user for three questions using
    // a Scanner like we usually do.
    // Scanner scanner = new Scanner(System.in);
    // Prompt the user for
    // 1. What letter should the words start with?
    // 2. What letter should the words end with?
    // 3. How many letters should the words be?
  
    FileInputStream wordFileStream = new FileInputStream(wordsFile);
    Scanner wordListScanner = new Scanner(wordFileStream);

    // TODO Add your loop here which scans for desired words.
    // Note that we have another Scanner here, wordListScanner,
    // which is for scanning the EOWL text file line by line.
    // You want to write a loop that goes through the whole file.
    // You can use wordListScanner.hasNextLine() to see if
    // there are more words to read.
    // wordListScanner.nextLine() will return the next word.
    // If the current word matches the criteria the user input
    // above, print it out with System.out.println.
    // String.startsWith and String.endsWith may come in handy.
  }
}
