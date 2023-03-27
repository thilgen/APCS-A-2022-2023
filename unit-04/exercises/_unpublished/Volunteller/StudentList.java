import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class StudentList {
  // A newline (\n) delimited list of student names.
  private String students;

  public StudentList() {
    students = "";
  }

  public boolean load(String path) {
    try {
      students = Files.readString(Paths.get(path));
      return true;
    } catch (IOException e) {
      System.out.println("Error loading students file from " + path);
      e.printStackTrace();
      return false;
    }
  }

  public void removeStudentAtIndex(int targetIndex) {
    // TODO: Remove the student at index "targetIndex" from the student list,
    // and return the updated student list. You will need to find the character
    // index where the student's name begins, and then remove the substring
    // starting at that index up to and including the following '\n' character.
  }

  public int pickVolunteer() {
    // TODO Use countStudents to count how many students there are and return
    // a random index from [0, numOfStudents).
    // Return -1 if there are no students left.
    return -1;
  }

  public int countStudents() {
    // TODO: All of the students' names are in the String students.
    // Every student name is terminated by a '\n' character, including
    // the last one. So, you can count the number of '\n' characters
    // to get the total number of students.
    return 0;
  }

  public String studentAtIndex(int targetIndex) {
    // TODO: Return the name of the student at 0-based index "targetIndex".
    // You need to skip forward targetIndex-1 '\n' characters to find
    // the starting character index of the name, and then extract only
    // characters up to the subsequent '\n'.
    return null;
  }

  public boolean selfTest() {
    int numTestStudents = 10;
    students = "Alice\nBob\nCalvin\nDavid\nEric\nFred\nGary\nHarry\nIsildur\nJanus\n";

    int count = countStudents();
    if (count != numTestStudents) {
      System.out.println("There should be " + numTestStudents + " students! I counted " + count);
      return false;
    }

    for (int i=0; i<count; i++) {
      int volunteerIndex = pickVolunteer();

      String volunteerName = studentAtIndex(volunteerIndex);
      if (volunteerName.isEmpty()) {
        System.out.println("Got back an empty volunteer name for index " + volunteerIndex);
        return false;
      }

      if (students.indexOf(volunteerName) == -1) {
        System.out.println("Volunteer " + volunteerName + " isn't in student list");
        return false;
      }

      removeStudentAtIndex(volunteerIndex);
      if (students.indexOf(volunteerName) != -1) {
        System.out.println("Removal of " + volunteerName + " failed");
        return false;
      }
    }

    if (pickVolunteer() != -1) {
      System.out.println("There should be no students left!");
      return false;
    }

    return true;
  }
}