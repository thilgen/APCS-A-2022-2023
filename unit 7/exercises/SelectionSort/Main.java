import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

//
// The file fortune500.csv contains a CSV-formatted (Comma Separated Value) table
// of the most valuable US companies, the "Fortune 500." For some reason, actually,
// this table has the top 1000 companies in it.
//
// The fortune500.csv file is sorted by how valuable the companies are, that is,
// by their ranking in the Fortune 500.
//
// Code is already written here to parse the CSV file into an ArrayList<Record>.
// The Record class has a getCompany() method which will return the company name.
//
// Write the method selectionSort() to sort the ArrayList by company name.
//
// The test code will check to make sure your sorted array is really in sorted
// order, and tell you where the first out-of-order elements are if it finds any.
// Whether it's sorted or not, your output array will be written to the
// file fortune500_sorted_name.csv where you can inspect it.
//
// Note that the compareTo method regards the lowercase letter "a" as being "after"
// the uppercase letter "Z". So, "salesforce.com".compareTo("Xilinx") > 0, which
// isn't what humans expect when reading an alphabetized list.
// Java is just comparing Unicode code points, and "a" is a higher code point than
// "Z".
// One way to fix this is to call toUpperCase() or toLowerCase() on both inputs.
// Alternatively, there is a String.compareToIgnoreCase() method which behaves
// like String.compareTo() but is case-insensitive.
//

class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  private void selectionSort(ArrayList<Record> records) {
    // TODO INSERT YOUR SELECTION SORT CODE HERE
    // Pseudo-code for the algorithm:
    // For each element at index "i" in the array:
    //   Find the index "minIndex" of the minimum value from index "i" to index N-1
    //   Swap the element at index "i" with the element at index "minIndex"
  }

  private boolean isSortedByCompany(ArrayList<Record> records) {
    for (int i=1, n=records.size(); i<n; i++) {
      if (records.get(i).getCompany().compareToIgnoreCase(records.get(i-1).getCompany()) < 0) {
        System.out.println("FAIL: Array is not sorted by company name");
        System.out.println();
        System.out.println("Record at index " + (i-1) + ":");
        System.out.println(records.get(i-1));
        System.out.println();        
        System.out.println("Record at index " + i + ":");
        System.out.println(records.get(i));
        return false;
      }
    }
    return true;
  }

  private void run() throws IOException {
    ArrayList<Record> records = new ArrayList<Record>();
    FileInputStream fileInputStream = new FileInputStream(new File("fortune500.csv"));
    Scanner scanner = new Scanner(fileInputStream);
    String header = scanner.nextLine();
    String[] columns = header.split(",");
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if (line.isEmpty()) {
        continue;
      }
      String[] row = line.split(",");
      Record record = new Record();
      for (int i = 0; i < row.length; i++) {
        record.setField(columns[i], row[i]);
      }
      records.add(record);
    }

    selectionSort(records);

    if (isSortedByCompany(records)) {
      System.out.println("PASS: Your records array is sorted by company name correctly.");
    }

    File outputFile = new File("fortune500_sorted_name.csv");
    System.out.println("Writing sorted data to " + outputFile);
    FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
    PrintWriter pw = new PrintWriter(fileOutputStream);
    pw.println(header);
    for (Record record : records) {
      pw.println(record);
    }
    pw.close();
  }
}