import java.io.FileInputStream;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MailingList {
  private FileInputStream in;
  private Scanner scanner;
  
  public MailingList() throws IOException {
    in = new FileInputStream(new File("mailing_list.csv"));
    scanner = new Scanner(in);
    scanner.useDelimiter(",|\n");
  }

  public boolean hasNext() {
    return scanner.hasNext();
  }

  public GiftGiver next() {
    //
    // TODO The file mailing_list.csv is what's caled a CSV (Comma Separated Value)
    // file. It contains a table of data, but formatted with each row on its own line,
    // and each column separated by a comma. This is a common format used for
    // interchange of data, supported by most spreadsheet programs and database
    // products.
    //
    // Read a CSV (Comma Separated Value) record from the input file
    // using scanner, and return a new GiftGiver object containing the
    // information.
    //
    // Note: Since the delimiter for the scanner is set to ",|\n",
    // scanner.next() should give you the next field from this line,
    // and advance to the next line automatically.
    //
    // If you want, you can edit mailing_list.csv to contain different people
    // to your liking.
    //
    return null;
  }
}