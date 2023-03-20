import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
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
// Code is already written here to parse the CSV file into a Record[] array.
// The Record class has a getField() method which returns a named field.
// The first line of fortune500.csv is the CSV "header", and tells us that the
// column names are:
// ranking,lon,lat,company,industry,state,city
//
// Write the method insertionSort() to sort the array by the specified field,
// in either ascending or descending order.
//
// When you run the program, the test harness will call your insertionSort()
// method to sort the Fortune 500 data in several different ways:
// By company name, industry, city, and state, and in ascending and
// descending order for each of those fields. Each one of the combinations
// will be written to a separate CSV file.
//
// Once you get the sorted output working, inspect the resulting files. What
// would be the value of sorting data like this by city, state, or industry?
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

  // TODO implement compareRecord
  // compareRecord() is a helper method that insertionSort() will use to compare records.
  // Its return value is similar to String.compareTo():
  //   < 0 if record1.fieldName is less than record2.fieldName
  //   > 0 if record1.fieldName is greater than record2.fieldName
  //  == 0 if record1.fieldName is equal to record2.fieldName
  // However, it'll return the opposite if the "ascending" parameter is false.
  // You can simply negate the comparison result if "ascending" is false to get the opposite.
  //
  // In a sense, compareRecord() is a "drop-in" replacement where you would ordinarily use
  // String.compareTo or String.compareToIgnoreCase, that does a bit more like pulling the
  // right field out of the object, and accounting for descending (reversed) sort order.
  //  
  // It encapsulates the comparison logic, which is:
  // - Extract the field "fieldName" from record1 and record2
  // - Compare the extracted values using compareToIgnoreCase and return it.
  // - BUT: If "ascending" is false, you need to return the opposite comparison result.
  //   You could compare record2 to record1, or just negate the result of
  //   comparing record1 to record2.
  //
  private int compareRecord(Record record1, Record record2, String fieldName, boolean ascending) {
    // TODO YOUR CODE HERE
    return 0;
  }

  // Precondition: "records" is a fully-populated array of Record objects, from records[0]
  // to records[records.length-1]
  private void insertionSort(Record[] records,
                             String fieldName,
                             boolean ascending) {
    // TODO INSERT YOUR INSERTION SORT CODE HERE
    // Pseudo-code for the algorithm:
    // For each index i in the array, starting with second element i = 1:
	  //    # Loop invariant: The array to the left of i is a sorted sub-array.  
    //    # Save away the value at A[i], because it might be overwritten
    //    Let saved value = A[i]
    // 	  # j will represent the insertion point of the value.
    //    Let j start at i.
    //    While j > 0 and A[j-1] > A[i]
		//      # As we scan for insertion point, we move elements to the right
		//      # to make room for the value being inserted.
		//      Copy A[j-1] into A[j]
		//      j = j - 1
    //    # Here, we don't need to make room to insert the value...
    //    # because the loop above already did it!
    //    Set A[j] = value of A[i] we saved above
  }

  // This method is used by the test harness to validate your sorted output.
  private boolean hasDuplicates(Record[] records) {
    HashSet<Record> seenSet = new HashSet<Record>();
    for (Record record : records) {
      if (!seenSet.add(record)) {
        System.out.println("FAIL: Your array has a duplicate record:");
        System.out.println(record);
        return true;
      }
    }
    return false;
  }

  // This method is used by the test harness to validate your sorted output.
  private boolean isSorted(Record[] records, String fieldName, boolean ascending) {
    for (int i=1, n=records.length; i<n; i++) {
      String value1 = records[i].getField(fieldName);
      String value2 = records[i-1].getField(fieldName);
      int compareResult = value1.compareToIgnoreCase(value2);
      if (!ascending) {
        compareResult = -compareResult;
      }      
      if (compareResult < 0) {
        System.out.println("FAIL: Array is not sorted by " + fieldName);
        System.out.println();
        System.out.println("Record at index " + (i-1) + ":");
        System.out.println(records[i-1]);
        System.out.println();        
        System.out.println("Record at index " + i + ":");
        System.out.println(records[i]);
        return false;
      }
    }
    return true;
  }

  private Record[] loadRecords() throws IOException {
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
    Record[] result = new Record[records.size()];
    records.toArray(result);
    return result;
  }

  private void run() throws IOException {
    String[] sortFields = { "company", "industry", "city", "state" };
    for (String sortField : sortFields) {
      for (int orderPass=0; orderPass<2; orderPass++) {
        // The records array is reloaded on each sort pass, to give your algorithm a fresh
        // start if there are any bugs.
        Record[] records = loadRecords();

        boolean ascending = orderPass == 0;
      
        insertionSort(records, sortField, ascending);

        if (!isSorted(records, sortField, ascending)) {
          System.out.println("FAIL: Your records are not properly sorted. sortField=" + sortField + " ascending=" + ascending);
        } else if (hasDuplicates(records)) {
          System.out.println("FAIL: Your records contain duplicates after sorting. sortField=" + sortField + " ascending=" + ascending);
        } else {
          System.out.println("PASS: Correctly sorted data for sortField=" + sortField + " ascending=" + ascending);
        }

        String orderString = ascending ? "ascending" : "descending";
        File outputFile = new File("fortune500_sorted_" + sortField + "_" + orderString + ".csv");
        System.out.println("sortField=" + sortField + " ascending=" + ascending + ": Writing sorted data to " + outputFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        PrintWriter pw = new PrintWriter(fileOutputStream);
        pw.println("ranking,lon,lat,company,industry,state,city");
        for (Record record : records) {
          pw.println(record);
        }
        pw.close();
      }
    }
  }
}