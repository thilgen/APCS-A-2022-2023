class Main {
  public static void main(String args[]) {
    new Main().run();
  }

  public void run() {
    Directory directory = new Directory();

    System.out.println("\n** Get Each Name Individually **");
    String name1 = directory.getName1();
    String name2 = directory.getName2();
    String name3 = directory.getName3();
    String name4 = directory.getName4();
    String name5 = directory.getName5();
    System.out.printf("%s\n%s\n%s\n%s\n%s\n", name1, name2, name3, name4, name5);

    System.out.println("\n** Get All The Names **");
    String[] names = directory.getNames();
    for (int idx = 0 ; idx < names.length ; idx++) {
      System.out.printf("%s\n", names[idx]);
    }
  }
}