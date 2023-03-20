public class Util {
  public static void printTable(Table table) {
    /* TODO - FRIDAY */

    /* EXAMPLE OUTPUT

        > new Table-1 5 10
        > new Table-2 20 3
        > new Table-3 5 5
        > list

            0. Table-1
            1. Table-2
            2. Table-3

        > select 0

            Table Selected: Table-1

        Table-1> print

            Print Table: Table-1 (5, 10)

                1       2       3       4       5
            1   1       2       3       4       5
            2   2       4       6       8       10
            3   3       6       9       12      15
            4   4       8       12      16      20
            5   5       10      15      20      25
            6   6       12      18      24      30
            7   7       14      21      28      35
            8   8       16      24      32      40
            9   9       18      27      36      45
            10  10      20      30      40      50            
    */

    Integer numColumns = table.getNumColumns();
    Integer numRows = table.getNumRows();
    System.out.println("\n    Print Table: " + table.getTableName() + " (" + numColumns + ", " + numRows + ")");

    /* add your code here */
  }

  public static void verifyTable(Table table) {
    Integer numColumns = table.getNumColumns();
    Integer numRows = table.getNumRows();
    System.out.println("\n    Verify Table: " + table.getTableName() + " (" + numColumns + ", " + numRows + ")\n");

    if (table.getNumColumns() != numColumns) {
      System.out.println("    FAILED : Expected " + numColumns + " columns - got " + table.getNumColumns());
    } else {
      System.out.println("    SUCCESS: There are " + numColumns + " columns");
    }

    boolean bRowSizesVerified = true;
    for (Integer colsIdx = 0 ; colsIdx < table.getNumColumns() ; colsIdx++) {
      if (table.getColumn(colsIdx).getNumRows() != numRows) {
        System.out.println("    FAILED : Expected every column to have " + numRows + " rows - column " + (colsIdx+1) + " has " + table.getColumn(colsIdx).getNumRows()); 
        bRowSizesVerified = false;
      }
    }
    if (bRowSizesVerified) {
      System.out.println("    SUCCESS: Every column has " + numRows + " rows"); 
    }

    for (Integer colsIdx = 1; colsIdx <= table.getNumColumns(); colsIdx++) {
      boolean bColVerified = true;
      for (Integer rowsIdx = 1; rowsIdx <= table.getColumn(colsIdx-1).getNumRows(); rowsIdx++) {
        Integer expected = rowsIdx * colsIdx;
        Integer got = table.getColumn(colsIdx-1).getRowValue(rowsIdx-1);
        if (expected != got) {
          System.out.println("    FAILED : Expected value of column " + colsIdx + " to have the value " + expected  + " - got " + got); 
          bColVerified = false;
        }
      }
      if (bColVerified) {
        System.out.println("    SUCCESS: Values of column " + colsIdx + " are correct"); 
      }
    }
    System.out.println(""); 
  }
}