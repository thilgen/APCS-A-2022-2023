public class HistoryTest {
  private static String subjectName = "History";
  private static int totalTests = 0;

  private String testName;  

  private Student student1;
  private int student1TestScore;

  private Student student2;
  private int student2TestScore;

  private Student student3;
  private int student3TestScore;

  private Student student4;
  private int student4TestScore;

  private Student student5;
  private int student5TestScore;

  public HistoryTest(String testName) {
    this.testName = testName;
    totalTests++;
  }

  public boolean setStudentTestScore(Student student, int testScore) {
    boolean bSuccess = true;
    if (1 == student.getId()) {
      student1 = student;
      student1TestScore = testScore;
    } else if (2 == student.getId()) {
      student2 = student;
      student2TestScore = testScore;
    } else if (3 == student.getId()) {
      student3 = student;
      student3TestScore = testScore;
    } else if (4 == student.getId()) {
      student4 = student;
      student4TestScore = testScore;
    } else if (5 == student.getId()) {
      student5 = student;
      student5TestScore = testScore;
    } else {
      bSuccess = false;
    }
    return bSuccess;
  }

  public int getStudentTestScore(Student student) {
    int testScore = 0;
    if ((student1 != null) && (student1.getId() == student.getId())) {
      testScore = student1TestScore;
    } else if ((student2 != null) && (student2.getId() == student.getId())) {
      testScore = student2TestScore;
    } else if ((student3 != null) && (student3.getId() == student.getId())) {
      testScore = student3TestScore;
    } else if ((student4 != null) && (student4.getId() == student.getId())) {
      testScore = student4TestScore;
    } else if ((student5 != null) && (student5.getId() == student.getId())) {
      testScore = student5TestScore;
    }
    return testScore;
  }

  public String getTestName() {
    return testName;
  }

  public static String getSubjectName() {
    return subjectName;
  }

  public static int getNumTests() {
    return totalTests;
  }
}
