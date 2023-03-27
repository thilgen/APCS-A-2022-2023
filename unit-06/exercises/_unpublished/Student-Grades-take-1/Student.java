public class Student {
  private static int totalStudents = 0;
  
  private int id;
  private String name;

  public Student(String name) {
    this.name = name;
    this.id = ++totalStudents;
  }

  public int getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
}
