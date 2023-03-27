class MainWed {
  public void run() {
    Table table;

    table = new Table("Table 1", 5, 5);
    Util.verifyTable(table);
    
    table = new Table("Table 2", 20, 5);
    Util.verifyTable(table);

    table = new Table("Table 3", 5, 10);
    Util.verifyTable(table);
  }
}