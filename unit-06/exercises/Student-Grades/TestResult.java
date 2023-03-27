public class TestResult {
  private String testName;

  private Student student100;
  private int student100TestResult;

  private Student student105;
  private int student105TestResult;

  private Student student106;
  private int student106TestResult;

  private Student student211;
  private int student211TestResult;

  private Student student387;
  private int student387TestResult;

  public TestResult(String testName) {
    this.testName = testName;
  }

  public boolean setStudentTestScore(Student student, int testScore) {
    boolean bSuccess = true;
    if (100 == student.getId()) {
      student100 = student;
      student100TestResult = testScore;
    } else if (105 == student.getId()) {
      student105 = student;
      student105TestResult = testScore;
    } else if (106 == student.getId()) {
      student106 = student;
      student106TestResult = testScore;
    } else if (211 == student.getId()) {
      student211 = student;
      student211TestResult = testScore;
    } else if (387 == student.getId()) {
      student387 = student;
      student387TestResult = testScore;
    } else {
      bSuccess = false;
    }
    return bSuccess;
  }

  public int getStudentTestScore(Student student) {
    int testScore = 0;
    if ((student100 != null) && (student100.getId() == student.getId())) {
      testScore = student100TestResult;
    } else if ((student105 != null) && (student105.getId() == student.getId())) {
      testScore = student105TestResult;
    } else if ((student106 != null) && (student106.getId() == student.getId())) {
      testScore = student106TestResult;
    } else if ((student211 != null) && (student211.getId() == student.getId())) {
      testScore = student211TestResult;
    } else if ((student387 != null) && (student387.getId() == student.getId())) {
      testScore = student387TestResult;
    }
    return testScore;
  }

  public String getTestName() {
    return testName;
  }
}
