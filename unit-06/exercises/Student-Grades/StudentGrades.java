/*
 * Part 0
 *   Run the program and observe the output
 *   Observe that the program emits a formatted report of all students grades and a series of
 *   VERIFY tests. Both the formatted report and the VERIFY tests should remain unchanged as 
 *   you refactor the code in the following Parts. Note: A copy of the output has been saved
 *   saved in the Expected Output file.
 *
 * Part 1
 *   The TestResult class has five instance variables that represent a student; and five instance
 *   variables that represent the corresponding student's testResult. Replace these ten instance 
 *   variables with an Array of Students (Students[] students) and an Array of testResults
 *   (int[] testResults) - where the testResult for the student at students[index] can be found 
 *   at testScores[idx] (use the same index into both Arrays - aka Parallel Arrays). Adjust the
 *   methods of the Test class to use these new Arrays
 *   Verify with Part 0 before proceeding to the next Part.
 * 
 * Part 3
 *   The StudentGrades class has seventeen instance variables that represent Students and TestResults
 *   Replace these with an Array of Students (Students[] students) and an Array of TestResults for each 
 *   subject (TestResult[] chemistryTestResults, TestResult[] economicsTestResults, and 
 *   TestResult[] historyTestResults. Adjust the methods of the StudentGrades class to use these new
 *   Arrays. Verify with Part 0.
 * 
 */

class StudentGrades {

  // ** BEGIN - MODIFY THESE PARTS - BEGIN **

  private Student student100;
  private Student student105;
  private Student student106;
  private Student student211;
  private Student student387;

  private TestResult chemistryTest1;
  private TestResult chemistryTest2;
  private TestResult chemistryTest3;

  private TestResult economicsTest1;
  private TestResult economicsTest2;
  private TestResult economicsTest3;
  private TestResult economicsTest4;

  private TestResult historyTest1;
  private TestResult historyTest2;
  private TestResult historyTest3;
  private TestResult historyTest4;
  private TestResult historyTest5;
  
  private void initStudents() {
    student100 = new Student(100, "Susan Berry");
    student105 = new Student(105, "Carol Le");
    student106 = new Student(106, "Sharon Cardenas");
    student211 = new Student(211, "Linda Walton");
    student387 = new Student(387, "Sandra Andersen");
  }

  private void initChemistryTests() {
    chemistryTest1 = new TestResult("Chemistry Test 1");
    chemistryTest2 = new TestResult("Chemistry Test 2");
    chemistryTest3 = new TestResult("Chemistry Test 3");
  }

  private void initEconomicsTests() {
    economicsTest1 = new TestResult("Economics Test 1");
    economicsTest2 = new TestResult("Economics Test 2");
    economicsTest3 = new TestResult("Economics Test 3");
    economicsTest4 = new TestResult("Economics Test 4");
  }

  private void initHistoryTests() {
    historyTest1 = new TestResult("History Test 1");
    historyTest2 = new TestResult("History Test 2");
    historyTest3 = new TestResult("History Test 3");
    historyTest4 = new TestResult("History Test 4");
    historyTest5 = new TestResult("History Test 5");
  }

  private Student getStudent(int studentId) {
    Student student = null;
    if (100 == studentId) {
      student = student100;
    } else if (105 == studentId) {
      student = student105;
    } else if (106 == studentId) {
      student = student106;
    } else if (211 == studentId) {
      student = student211;
    } else if (387 == studentId) {
      student = student387;
    }
    return student;    
  }

  private TestResult getTestResult(String subject, String testName) {
    if (subject.equals("Chemistry")) {
      if (testName.equals(chemistryTest1.getTestName())) {
        return chemistryTest1;
      } else if (testName.equals(chemistryTest2.getTestName())) {
        return chemistryTest2;
      } else if (testName.equals(chemistryTest3.getTestName())) {
        return chemistryTest3;
      }
    } else if (subject.equals("Economics")) {
      if (testName.equals(economicsTest1.getTestName())) {
        return economicsTest1;
      } else if (testName.equals(economicsTest2.getTestName())) {
        return economicsTest2;
      } else if (testName.equals(economicsTest3.getTestName())) {
        return economicsTest3;
      } else if (testName.equals(economicsTest4.getTestName())) {
        return economicsTest4;
      }
    } else if (subject.equals("History")) {
      if (testName.equals(historyTest1.getTestName())) {
        return historyTest1;
      } else if (testName.equals(historyTest2.getTestName())) {
        return historyTest2;
      } else if (testName.equals(historyTest3.getTestName())) {
        return historyTest3;
      } else if (testName.equals(historyTest4.getTestName())) {
        return historyTest4;
      } else if (testName.equals(historyTest5.getTestName())) {
        return historyTest5;
      }
    }
    return null;
  }

  // ** END - MODIFY THESE PARTS - END **

  /******************************************/
  /******************************************/
  /******************************************/

  // ** DO NOT MODIFY BELOW HERE **
   
  // DO NOT MODIFY
  public static void main(String args[]) {
    new StudentGrades().run();
  }

  // DO NOT MODIFY
  private void run() {
    init();
    recordTests();
    printStudentGrades();
    verify();
  }

  // DO NOT MODIFY
  private void init() {
    initStudents();
    initChemistryTests();
    initEconomicsTests();
    initHistoryTests();
  }

  // DO NOT MODIFY
  private void recordTests() {
    recordChemistryTests();
    recordEconomicsTests();
    recordHistoryTests();
  }

  // DO NOT MODIFY
  private void recordChemistryTests() {
    String testName, subjectName = "Chemistry";
    
    testName = "Chemistry Test 1";
    recordTestResult(subjectName, testName, getStudent(100), 95);
    recordTestResult(subjectName, testName, getStudent(105), 85);
    recordTestResult(subjectName, testName, getStudent(106), 75);

    testName = "Chemistry Test 2";
    recordTestResult(subjectName, testName, getStudent(105), 65);
    recordTestResult(subjectName, testName, getStudent(106), 95);
    recordTestResult(subjectName, testName, getStudent(211), 85);
  
    testName = "Chemistry Test 3";
    recordTestResult(subjectName, testName, getStudent(106), 75);
    recordTestResult(subjectName, testName, getStudent(211), 65);
    recordTestResult(subjectName, testName, getStudent(387), 95);    
  }  

  // DO NOT MODIFY
  private void recordEconomicsTests() {
    String testName, subjectName = "Economics";
    
    testName = "Economics Test 1";
    recordTestResult(subjectName, testName, getStudent(211), 85);
    recordTestResult(subjectName, testName, getStudent(387), 75);
    recordTestResult(subjectName, testName, getStudent(100), 65);

    testName = "Economics Test 2";
    recordTestResult(subjectName, testName, getStudent(387), 95);
    recordTestResult(subjectName, testName, getStudent(100), 85);
    recordTestResult(subjectName, testName, getStudent(105), 75);

    testName = "Economics Test 3";
    recordTestResult(subjectName, testName, getStudent(100), 65);
    recordTestResult(subjectName, testName, getStudent(105), 95);
    recordTestResult(subjectName, testName, getStudent(106), 85);
  
    testName = "Economics Test 4";
    recordTestResult(subjectName, testName, getStudent(211), 75);
    recordTestResult(subjectName, testName, getStudent(387), 95);
    recordTestResult(subjectName, testName, getStudent(100), 95);
  }

  // DO NOT MODIFY
  private void recordHistoryTests() {
    String testName, subjectName = "History";
    
    testName = "History Test 1";
    recordTestResult(subjectName, testName, getStudent(211), 75);
    recordTestResult(subjectName, testName, getStudent(387), 65);
    recordTestResult(subjectName, testName, getStudent(100), 95);

    testName = "History Test 2";
    recordTestResult(subjectName, testName, getStudent(387), 85);
    recordTestResult(subjectName, testName, getStudent(100), 75);
    recordTestResult(subjectName, testName, getStudent(105), 65);

    testName = "History Test 3";
    recordTestResult(subjectName, testName, getStudent(100), 95);
    recordTestResult(subjectName, testName, getStudent(105), 85);
    recordTestResult(subjectName, testName, getStudent(106), 75);
  
    testName = "History Test 4";
    recordTestResult(subjectName, testName, getStudent(211), 65);
    recordTestResult(subjectName, testName, getStudent(387), 100);
    recordTestResult(subjectName, testName, getStudent(100), 90);

    testName = "History Test 5";
    recordTestResult(subjectName, testName, getStudent(105), 100);
    recordTestResult(subjectName, testName, getStudent(106), 100);
    recordTestResult(subjectName, testName, getStudent(211), 100);
  }

  private void recordTestResult(String subject, String testName, Student student, int testScore) {
    getTestResult(subject, testName).setStudentTestScore(student, testScore);
  }

  // DO NOT MODIFY
  private double getChemistryAverage(Student student) {
    double totalScore = 0.0;
    String[] chemistryTestNames = { "Chemistry Test 1", "Chemistry Test 2", "Chemistry Test 3" };
    for (int idx = 0 ; idx < chemistryTestNames.length ; idx++ ) {
      String chemistryTestName = chemistryTestNames[idx];
      TestResult chemistryTest = getTestResult("Chemistry", chemistryTestName);
      totalScore += chemistryTest.getStudentTestScore(student);
    }
    double averageScore = totalScore / chemistryTestNames.length;
    return averageScore;
  }

  // DO NOT MODIFY
  private double getEconomicsAverage(Student student) {
    double totalScore = 0;
    String[] economicsTestNames = { "Economics Test 1", "Economics Test 2", "Economics Test 3", "Economics Test 4" };
    for (int idx = 0 ; idx < economicsTestNames.length ; idx++ ) {
      String economicsTestName = economicsTestNames[idx];
      TestResult economicsTest = getTestResult("Economics", economicsTestName);
      totalScore += economicsTest.getStudentTestScore(student);
    }
    double averageScore = totalScore / economicsTestNames.length;
    return averageScore;
  }

  // DO NOT MODIFY
  private double getHistoryAverage(Student student) {
    double totalScore = 0;
    String[] historyTestNames = { "History Test 1", "History Test 2", "History Test 3", "History Test 4", "History Test 5" };
    for (int idx = 0 ; idx < historyTestNames.length ; idx++ ) {
      String historyTestName = historyTestNames[idx];
      TestResult historyTest = getTestResult("History", historyTestName);
      totalScore += historyTest.getStudentTestScore(student);
    }
    double averageScore = totalScore / historyTestNames.length;
    return averageScore;
  }

  // DO NOT MODIFY
  private double getOverallAverage(Student student) {
    double totalScore = 0;
    totalScore += getChemistryAverage(student);
    totalScore += getHistoryAverage(student);
    totalScore += getEconomicsAverage(student);
    double averageScore = totalScore / 3;
    return averageScore;
  }

  // DO NOT MODIFY
  private void verify() {
    int[] studentIds = { 100, 105, 106, 211, 387 };
    String[] studentNames = { "Susan Berry", "Carol Le", "Sharon Cardenas", "Linda Walton", "Sandra Andersen" };
    String[] chemistryTestNames = { "Chemistry Test 1", "Chemistry Test 2", "Chemistry Test 3" };
    String[] economicsTestNames = { "Economics Test 1", "Economics Test 2", "Economics Test 3", "Economics Test 4" };
    String[] historyTestNames = { "History Test 1", "History Test 2", "History Test 3", "History Test 4", "History Test 5" };
    double[] chemistryAverages = { 31.67, 50.0, 81.67, 50.0, 31.67 };
    double[] economicsAverages = { 77.5, 42.5, 21.25, 40.0, 66.25 };
    double[] historyAverages = { 71.0, 50.0, 35.0, 48.0, 50.0 };
    double[] totalAverages = { 60.06, 47.5, 45.97, 46.0, 49.31 };
    
    System.out.println("\nVERIFY: Student Lookup");
    for (int idx = 0 ; idx < studentIds.length ; idx++ ) {
      int studentId = studentIds[idx];
      Student student = getStudent(studentId);
      String matchReport = studentNames[idx] == student.getName() ? "name vales matches" : "name vales does not match";
      System.out.printf("  %s : %s (%s)\n", studentNames[idx], student == null ? "NOT FOUND" : "FOUND", matchReport);
    }

    System.out.println("\nVERIFY: Chemistry Test Lookup");
    for (int idx = 0 ; idx < chemistryTestNames.length ; idx++ ) {
      String chemistryTestName = chemistryTestNames[idx];
      TestResult chemistryTest = getTestResult("Chemistry", chemistryTestName);
      System.out.printf("  %s : %s\n", chemistryTestName, chemistryTest == null ? "NOT FOUND" : "FOUND");
    }

    System.out.println("\nVERIFY: Economics Test Lookup");
    for (int idx = 0 ; idx < economicsTestNames.length ; idx++ ) {
      String economicsTestName = economicsTestNames[idx];
      Object economicsTest = getTestResult("Economics", economicsTestName);
      System.out.printf("  %s : %s\n", economicsTestName, economicsTest == null ? "NOT FOUND" : "FOUND");
    }

    System.out.println("\nVERIFY: History Test Lookup");
    for (int idx = 0 ; idx < historyTestNames.length ; idx++ ) {
      String historyTestName = historyTestNames[idx];
      Object historyTest = getTestResult("History", historyTestName);
      System.out.printf("  %s : %s\n", historyTestName, historyTest == null ? "NOT FOUND" : "FOUND");
    }

    System.out.println("\nVERIFY: Student Averages");
    for (int idx = 0 ; idx < studentIds.length ; idx++ ) {
      int studentId = studentIds[idx];
      Student student = getStudent(studentId);
      String studentName = student.getName();
      System.out.printf("  %s\n", studentName);
      System.out.printf("    EXPECTED -> Chemistry: %.2f Economics: %.2f History: %.2f OVERALL: %.2f\n", 
        chemistryAverages[idx], economicsAverages[idx], historyAverages[idx], totalAverages[idx]);
      System.out.printf("    GOT      -> Chemistry: %.2f Economics: %.2f History: %.2f OVERALL: %.2f\n", 
        getChemistryAverage(student), getEconomicsAverage(student), getHistoryAverage(student), getOverallAverage(student));
    }
  }

  // DO NOT MODIFY
  private void printStudentGrades() {
    int[] studentIds = { 100, 105, 106, 211, 387 };
    for (int idx = 0 ; idx < studentIds.length ; idx++ ) {
      int studentId = studentIds[idx];
      Student student = getStudent(studentId);
      printStudentGrade(student);
    }
  }

  // DO NOT MODIFY
  private void printStudentGrade(Student student) {
    System.out.println("\n  ------------------");
    System.out.println("  " + student.getName());
    System.out.println("  ------------------");
    System.out.printf("  %.2f in %s\n", getChemistryAverage(student), "Chemistry");
    System.out.printf("  %.2f in %s\n", getEconomicsAverage(student), "Economics");
    System.out.printf("  %.2f in %s\n", getHistoryAverage(student), "History");
    System.out.println("  ------------------");
    System.out.printf("  %.2f OVERALL\n", getOverallAverage(student));
    System.out.println("  ------------------");
  }
}
