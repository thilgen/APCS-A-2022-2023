/*
 * Part 0
 *   Run the program and observe the output
 *   Observe that the program emits a formatted report of all students grades and a series of
 *   VERIFY tests. Both the formatted report and the VERIFY tests should remain unchanged as 
 *   you refactor the code in the following Parts. Note: A copy of the output has been saved
 *   saved in the Expected Output file.
 *
 * Part 1
 *   ChemistryTest, HistoryTest, and EconomicsTest are 99% identical
 *   Replace these three classes with a single class (Test) that can represent any kind of test
 *   Replace the usage of ChemistryTest, HistoryTest, and EconomicsTest in StudentGrades to use 
 *   the Test class.
 *   Verify with Part 0 before proceeding to the next Part.
 * 
 * Part 2
 *   The unified Test class you created in Part 1 has five instance variables that represent
 *   a student; and five instance variables that represent the corresponding student's testScore.
 *   Replace these ten instance variables with an Array of Students (Students[] students) and an 
 *   Array of testScores (int[] testScores) - where the testScore for the student at students[index]
 *   can be found at testScores[idx] (use the same index into both Arrays - aka Parallel Arrays)
 *   Adjust the methods of the Test class to use these new Arrays
 *   Verify with Part 0 before proceeding to the next Part.
 * 
 * Part 3
 *   The StudentGrades class has seventeen instance variables that represent Students and Tests
 *   Replace these with an Array of Students (Students[] students) and an Array of Tests for each 
 *   subject (Test[] chemistryTests, Test[] economicsTests, and Test[] historyTests
 *   Adjust the methods of the StudentGrades class to use these new Arrays.
 *   Verify with Part 0.
 * 
 */

class StudentGrades {
  public static void main(String args[]) {
    new StudentGrades().run();
  }

  private Student student1;
  private Student student2;
  private Student student3;
  private Student student4;
  private Student student5;

  private ChemistryTest ct1;
  private ChemistryTest ct2;
  private ChemistryTest ct3;

  private EconomicsTest et1;
  private EconomicsTest et2;
  private EconomicsTest et3;
  private EconomicsTest et4;

  private HistoryTest ht1;
  private HistoryTest ht2;
  private HistoryTest ht3;
  private HistoryTest ht4;
  private HistoryTest ht5;

/*
 * DO NOT MODIFY
 */
  private void run() {
    init();
    recordTests();
    printStudentGrades();
    verify();
  }

/*
 * DO NOT MODIFY
 */
  private void init() {
    initStudents();
    initChemistryTests();
    initEconomicsTests();
    initHistoryTests();
  }

/*
 * TODO: Modify in Part 3
 */
  private void initStudents() {
    student1 = new Student("Susan Berry");
    student2 = new Student("Carol Le");
    student3 = new Student("Sharon Cardenas");
    student4 = new Student("Linda Walton");
    student5 = new Student("Sandra Andersen");
  }

/*
 * DO NOT MODIFY
 */
  private void recordTests() {
    recordChemistryTests();
    recordEconomicsTests();
    recordHistoryTests();
  }

/*
 * TODO: Modify in Part 1 & Part 3
 */
  private void initChemistryTests() {
    ct1 = new ChemistryTest("Chemistry Test 1");
    ct2 = new ChemistryTest("Chemistry Test 2");
    ct3 = new ChemistryTest("Chemistry Test 3");
  }

/*
 * TODO: Modify in Part 1 & Part 3
 */
  private void initEconomicsTests() {
    et1 = new EconomicsTest("Economics Test 1");
    et2 = new EconomicsTest("Economics Test 2");
    et3 = new EconomicsTest("Economics Test 3");
    et4 = new EconomicsTest("Economics Test 4");
  }

/*
 * TODO: Modify in Part 1 & Part 3
 */
  private void initHistoryTests() {
    ht1 = new HistoryTest("History Test 1");
    ht2 = new HistoryTest("History Test 2");
    ht3 = new HistoryTest("History Test 3");
    ht4 = new HistoryTest("History Test 4");
    ht5 = new HistoryTest("History Test 5");
  }

/*
 * TODO: Modify in Part 3
 */
  private void recordChemistryTests() {
    ct1.setStudentTestScore(student1, 95);
    ct1.setStudentTestScore(student2, 85);
    ct1.setStudentTestScore(student3, 75);
  
    ct2.setStudentTestScore(student2, 65);
    ct2.setStudentTestScore(student3, 95);
    ct2.setStudentTestScore(student4, 85);
      
    ct3.setStudentTestScore(student3, 75);
    ct3.setStudentTestScore(student4, 65);
    ct3.setStudentTestScore(student5, 95);
  }

/*
 * TODO: Modify in Part 3
 */
  private void recordEconomicsTests() {
    et1.setStudentTestScore(student4, 85);
    et1.setStudentTestScore(student5, 75);
    et1.setStudentTestScore(student1, 65);
  
    et2.setStudentTestScore(student5, 95);
    et2.setStudentTestScore(student1, 85);
    et2.setStudentTestScore(student2, 75);
  
    et3.setStudentTestScore(student1, 65);
    et3.setStudentTestScore(student2, 95);
    et3.setStudentTestScore(student3, 85);  

    et4.setStudentTestScore(student4, 75);
    et4.setStudentTestScore(student5, 95);
    et4.setStudentTestScore(student1, 95);  
  }

/*
 * TODO: Modify in Part 3
 */
  private void recordHistoryTests() {
    ht1.setStudentTestScore(student4, 75);
    ht1.setStudentTestScore(student5, 65);
    ht1.setStudentTestScore(student1, 95);
  
    ht2.setStudentTestScore(student5, 85);
    ht2.setStudentTestScore(student1, 75);
    ht2.setStudentTestScore(student2, 65);
  
    ht3.setStudentTestScore(student1, 95);
    ht3.setStudentTestScore(student2, 85);
    ht3.setStudentTestScore(student3, 75);  

    ht4.setStudentTestScore(student4, 65);
    ht4.setStudentTestScore(student5, 100);
    ht4.setStudentTestScore(student1, 90);  

    ht5.setStudentTestScore(student2, 100);
    ht5.setStudentTestScore(student3, 100);
    ht5.setStudentTestScore(student4, 100);  
  }

/*
 * TODO: Modify in Part 1 & Part 3
 */
  private double getChemistryAverage(Student student) {
    double totalScore = 0.0;
    totalScore += ct1.getStudentTestScore(student);
    totalScore += ct2.getStudentTestScore(student);
    totalScore += ct3.getStudentTestScore(student);
    double averageScore = totalScore / ChemistryTest.getNumTests();
    return averageScore;
  }

/*
 * TODO: Modify in Part 1 & Part 3
 */
  private double getEconomicsAverage(Student student) {
    double totalScore = 0;
    totalScore += et1.getStudentTestScore(student);
    totalScore += et2.getStudentTestScore(student);
    totalScore += et3.getStudentTestScore(student);
    totalScore += et4.getStudentTestScore(student);
    double averageScore = totalScore / EconomicsTest.getNumTests();
    return averageScore;
  }

/*
 * TODO: Modify in Part 1 & Part 3
 */
  private double getHistoryAverage(Student student) {
    double totalScore = 0;
    totalScore += ht1.getStudentTestScore(student);
    totalScore += ht2.getStudentTestScore(student);
    totalScore += ht3.getStudentTestScore(student);
    totalScore += ht4.getStudentTestScore(student);
    totalScore += ht5.getStudentTestScore(student);
    double averageScore = totalScore / HistoryTest.getNumTests();
    return averageScore;
  }

/*
 * DO NOT MODIFY
 */
  private double getOverallAverage(Student student) {
    double totalScore = 0;
    totalScore += getChemistryAverage(student);
    totalScore += getHistoryAverage(student);
    totalScore += getEconomicsAverage(student);
    double averageScore = totalScore / 3;
    return averageScore;
  }

/*
 * TODO: Modify in Part 3
 */
  private void printStudentGrades() {
    printStudentGrade(student1);
    printStudentGrade(student2);
    printStudentGrade(student3);
    printStudentGrade(student4);
    printStudentGrade(student5);
  }

/*
 * TODO: Modify in Part 1
 */
  private void printStudentGrade(Student student) {
    System.out.println("\n  ------------------");
    System.out.println("  " + student.getName());
    System.out.println("  ------------------");
    System.out.printf("  %.2f in %s\n", getChemistryAverage(student), ChemistryTest.getSubjectName());
    System.out.printf("  %.2f in %s\n", getEconomicsAverage(student), EconomicsTest.getSubjectName());
    System.out.printf("  %.2f in %s\n", getHistoryAverage(student), HistoryTest.getSubjectName());
    System.out.println("  ------------------");
    System.out.printf("  %.2f OVERALL\n", getOverallAverage(student));
    System.out.println("  ------------------");
  }

/*
 * TODO: Modify in Part 3
 */
  private Student getStudent(String studentName) {
    if (studentName.equals(student1.getName())) {
      return student1;
    } else if (studentName.equals(student2.getName())) {
      return student2;
    } else if (studentName.equals(student3.getName())) {
      return student3;
    } else if (studentName.equals(student4.getName())) {
      return student4;
    } else if (studentName.equals(student5.getName())) {
      return student5;
    }
    return null;
  }

/*
 * TODO: Modify in Part 3
 */
  private ChemistryTest getChemistryTest(String testName) {
    if (testName.equals(ct1.getTestName())) { 
      return ct1;
    } else if (testName.equals(ct2.getTestName())) { 
      return ct2;
    } else if (testName.equals(ct3.getTestName())) { 
      return ct3;
    } else {
      return null;
    }    
  }

/*
 * TODO: Modify in Part 3
 */
  private EconomicsTest getEconomicsTest(String testName) {
    if (testName.equals(et1.getTestName())) { 
      return et1;
    } else if (testName.equals(et2.getTestName())) { 
      return et2;
    } else if (testName.equals(et3.getTestName())) { 
      return et3;
    } else if (testName.equals(et4.getTestName())) { 
      return et4;
    } else {
      return null;
    }    
  }

/*
 * TODO: Modify in Part 3
 */
  private HistoryTest getHistoryTest(String testName) {
    if (testName.equals(ht1.getTestName())) { 
      return ht1;
    } else if (testName.equals(ht2.getTestName())) { 
      return ht2;
    } else if (testName.equals(ht3.getTestName())) { 
      return ht3;
    } else if (testName.equals(ht4.getTestName())) { 
      return ht4;
    } else if (testName.equals(ht5.getTestName())) { 
      return ht5;
    } else {
      return null;
    }
  }

/*
 * DO NOT MODIFY
 */
  private void verify() {
    String[] studentNames = { "Susan Berry", "Carol Le", "Sharon Cardenas", "Linda Walton", "Sandra Andersen" };
    String[] chemistryTestNames = { "Chemistry Test 1", "Chemistry Test 2", "Chemistry Test 3" };
    String[] economicsTestNames = { "Economics Test 1", "Economics Test 2", "Economics Test 3", "Economics Test 4" };
    String[] historyTestNames = { "History Test 1", "History Test 2", "History Test 3", "History Test 4", "History Test 5" };
    double[] chemistryAverages = { 31.67, 50.0, 81.67, 50.0, 31.67 };
    double[] economicsAverages = { 77.5, 42.5, 21.25, 40.0, 66.25 };
    double[] historyAverages = { 71.0, 50.0, 35.0, 48.0, 50.0 };
    double[] totalAverages = { 60.06, 47.5, 45.97, 46.0, 49.31 };
    
    System.out.println("\nVERIFY: Student Lookup");
    for (int idx = 0 ; idx < studentNames.length ; idx++ ) {
      String studentName = studentNames[idx];
      Student student = getStudent(studentName);
      System.out.printf("  %s : %s\n", studentName, student == null ? "NOT FOUND" : "FOUND");
    }

    System.out.println("\nVERIFY: Chemistry Test Lookup");
    for (int idx = 0 ; idx < chemistryTestNames.length ; idx++ ) {
      String chemistryTestName = chemistryTestNames[idx];
      Object chemistryTest = getChemistryTest(chemistryTestName);
      System.out.printf("  %s : %s\n", chemistryTestName, chemistryTest == null ? "NOT FOUND" : "FOUND");
    }

    System.out.println("\nVERIFY: Economics Test Lookup");
    for (int idx = 0 ; idx < economicsTestNames.length ; idx++ ) {
      String economicsTestName = economicsTestNames[idx];
      Object economicsTest = getEconomicsTest(economicsTestName);
      System.out.printf("  %s : %s\n", economicsTestName, economicsTest == null ? "NOT FOUND" : "FOUND");
    }

    System.out.println("\nVERIFY: History Test Lookup");
    for (int idx = 0 ; idx < historyTestNames.length ; idx++ ) {
      String historyTestName = historyTestNames[idx];
      Object historyTest = getHistoryTest(historyTestName);
      System.out.printf("  %s : %s\n", historyTestName, historyTest == null ? "NOT FOUND" : "FOUND");
    }

    System.out.println("\nVERIFY: Student Averages");
    for (int idx = 0 ; idx < studentNames.length ; idx++ ) {
      String studentName = studentNames[idx];
      Student student = getStudent(studentName);
      System.out.printf("  %s\n", studentName);
      System.out.printf("    EXPECTED -> Chemistry: %.2f Economics: %.2f History: %.2f OVERALL: %.2f\n", 
        chemistryAverages[idx], economicsAverages[idx], historyAverages[idx], totalAverages[idx]);
      System.out.printf("    GOT      -> Chemistry: %.2f Economics: %.2f History: %.2f OVERALL: %.2f\n", 
        getChemistryAverage(student), getEconomicsAverage(student), getHistoryAverage(student), getOverallAverage(student));
    }
  }
}