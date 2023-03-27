import java.util.ArrayList;
import java.util.Scanner;

class MainFri {

  private ArrayList<Table> tables = new ArrayList<Table>();
  private Table currentTable;

  private void commandListTables() {
    if (tables.isEmpty()) {
      System.out.println("No tables");
    } else {
      /* TODO - FRIDAY */

      /* EXAMPLE OUTPUT

         > new Table-1 5 10
         > new Table-2 20 3
         > new Table-3 5 5

         > list

             0. Table-1
             1. Table-2
             2. Table-3

         > 
      */

      /* add your code here */
      
    }
    System.out.println("");
  }

  private void commandNewTable(String tableName, int tableColumns, int tableRows) {
    /* TODO - FRIDAY */
    /* add your code here */
  }

  private void commandSelectTable(int tableId) {
    if (tables.isEmpty()) {
      System.out.println("No tables");
    } else {
      if ((tableId >= 0) && (tableId < tables.size())) {
        currentTable = tables.get(tableId);
        System.out.println("\n    Table Selected: " +  currentTable.getTableName() + "\n");
      } else {
        System.out.println("Invalid tableId - Use 'list' for available tableIds");
      }
    }
  }

  private void commandPrint() {
    if (null == currentTable) {
      System.out.println("You must first select a table");
    } else {
      Util.printTable(currentTable);
    }
  }

  private void commandVerify() {
    if (null == currentTable) {
      System.out.println("You must first select a table");
    } else {
      Util.verifyTable(currentTable);
    }
  }

  private void commandHelp() {
    System.out.println("\n    ** Available Commands **\n");
    System.out.println("    list\t\t\t\tDisplay the list of multiplication tables");
    System.out.println("    new <tableName> <columns> <rows>\tCreate a new multiplication table");
    System.out.println("    select <tableId>\t\t\tSelect the current multiplication table");
    System.out.println("    print\t\t\t\tPrint the current multiplication table");
    System.out.println("    verify\t\t\t\tVerify the current multiplication table");
    System.out.println("    help\t\t\t\tDisplay this information");
    System.out.println("    quit\t\t\t\tExit the program\n");
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("---------------------");
    System.out.println("Multiplication Tables");
    System.out.println("---------------------");
    while (true) {
      String prompt = "> ";
      if (null != currentTable) {
        prompt = currentTable.getTableName() + prompt;
      }
      System.out.print(prompt);
      String command = scanner.nextLine();
      if (command.equals("list")) {
        commandListTables();
      } else if (command.startsWith("new ")) {
        String[] params = command.split(" ");
        String tableName = params[1];
        int tableColumns = Integer.parseInt(params[2]);
        int tableRows = Integer.parseInt(params[3]);
        commandNewTable(tableName, tableColumns, tableRows );
      } else if (command.startsWith("select ")) {
        String[] params = command.split(" ");
        int tableId = Integer.parseInt(params[1]);
        commandSelectTable(tableId);
      } else if (command.equals("print")) {
        commandPrint();
      } else if (command.equals("verify")) {
        commandVerify();
      } else if (command.equals("help")) {
        commandHelp();
      } else if (command.equals("quit")) {
        break;
      } else {
        System.out.println("I don't understand - Use 'help' for available commands");
      }
    }
    scanner.close();
  }  
}