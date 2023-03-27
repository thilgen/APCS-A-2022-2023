import java.io.*;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Template {
  private File templateFile;
  private String date;

  public Template(File templateFile) {
    this.templateFile = templateFile;

    String pattern = "MMMM d, yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    this.date = simpleDateFormat.format(new Date());
  }

  //
  // TODO Implement the replace method. It should replace all occurrences
  // of "searchString" with "replacement" and return the new string.
  //
  private String replace(String input, String searchString, String replacement) {
    return null;
  }

  public void generateOutputFile(GiftGiver giftGiver)
    throws IOException
  {
    String outputFileName = giftGiver.getName().replace(' ','_') + ".txt";
    File outputFile = new File("output", outputFileName);
    System.out.println("Generating letter " + outputFile.toString());

    FileInputStream templateStream = new FileInputStream(templateFile);
    FileOutputStream outputStream = new FileOutputStream(outputFile);
    PrintWriter outputPrintWriter = new PrintWriter(outputStream);

    Scanner templateScanner = new Scanner(templateStream);

    //
    // TODO The file template.txt is what's called a mail-merge template.
    // It contains some stock text (a "template" for a thank you note),
    // with placeholders ($NAME, $GIFT, etc.) that this code will
    // replace with different values on each iteration. This kind of
    // templating is used all of the time for generating Web pages,
    // e-mail notifications, push notifications, and yes, junk mail
    // delivered by old-fashioned "snail mail."
    //
    // Code has already been written to open template.txt and set up
    // a Scanner to read it, templateScanner. 
    //
    // Write a loop that reads line by line from templateScanner,
    // and replaces any template placeholders ($NAME, $GIFT, etc.) with
    // appropriate values using your replace method above.
    // Each resulting string should be written to the output file
    // with outputPrintWriter.println(). This behaves like
    // System.out.println() but writes to a file on disk, instead of
    // the console.
    //
    // The template placeholders you need to replace are:
    // $NAME - replace with field from giftGiver object
    // $GIFT - replace with field from giftGiver object
    // $ADDRESS1 - replace with field from giftGiver object
    // $ADDRESS2 - replace with field from giftGiver object
    // $ME - replace with your name
    // $DATE - replace with this.date
    // $ADJECTIVE1 - pick randomly from a few sweet, positive adjectives
    // $ADJECTIVE2 - pick another random nice adjective, not the same one!
    // $VERB - pick a random nice verb
    //

    // Close the input and output streams.
    outputPrintWriter.close();
    outputStream.close();
    templateStream.close();    
  }
}