public class NPC {
  private String name;
  private String catchphrase1;
  private String catchphrase2;

  public NPC(String name, String catchphrase1, String catchphrase2) {
    this.name = name;
    this.catchphrase1 = catchphrase1;
    this.catchphrase2 = catchphrase2;
  }

  public String getName() { return name; }

  public void talk() {
    if (Math.random() < 0.5) {
      System.out.println(name + " says: " + catchphrase1);
    } else {
      System.out.println(name + " says: " + catchphrase2);
    }
  }

  public String toString() { return name; }
}