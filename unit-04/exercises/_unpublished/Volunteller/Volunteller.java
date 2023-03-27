//
// Volunteller(tm) is an App built to address the historic inequities
// in In-Class Question Answering by democratizing and systematizing
// the selection of enthusiastic, willing volunteers through state-of-the-art
// randomized algorithms. Volunteller(tm) is backed by a Series Z
// round of $42 million from Frobozz-Ossifrage Ventures. Our slogan:
// "Volunteller(tm) is the App that tells YOU when you've been Voluntold
//  to do something!"
//
// The list of students in the class is in the text file students.txt,
// with each name on its own line. Last names have been reduced to a
// single initial because, like, laws and stuff.
// The file has been loaded into a single String for you, named "students".
//
// This basic logic is already implemented:
// Prompt the user to hit Enter to get a fresh victim, I mean, volunteer,
// or to type "quit" to exit.
// Every time the user hits Enter, display the name of a randomly
// selected volunteer.
//
// The TODO work is all in StudentList.java, which defines the StudentList class
// that manages the student list.
//
// Easy enough? Here's the catch: Don't pick the same volunteer more than once.
// When there are no more possible volunteers, we print an error message
// (e.g., "you have picked too many volunteers - try answering yourself
//  for a change?") and exit.
//
// Your solution may be used in class!
// BUT your source code will be carefully scrutinized to ensure you
// haven't added a back door that keeps you from ever getting
// questions ahahaha.
//

import java.util.Scanner;

class Volunteller {
  private StudentList studentList;

  private boolean selfTest() {
    StudentList testStudentList = new StudentList();
    return testStudentList.selfTest();
  }

  public void run() {
    if (!selfTest()) {
      System.out.println("Self test FAILED! Fix me please!");
      return;
    }

    studentList = new StudentList();
    studentList.load("students.txt");
    
    Scanner scanner = new Scanner(System.in);

    System.out.println("VOLUNTELLER booting");
    System.out.println("Predictive Volunteer Selection System initialized");
    System.out.println();

    while (true) {
      System.out.println("Press Enter to pick a fresh volunteer, or type quit.");
      String command = scanner.nextLine();
      if (command.equals("quit")) {
        break;
      }

      // Pick a random volunteer.
      int volunteerIndex = studentList.pickVolunteer();
      if (volunteerIndex == -1) {
        System.out.println("There's nobody left! Answer it yourself!");
        break;
      }

      // Find the volunteer and display them.
      System.out.println("The Happy Volunteer is: " + studentList.studentAtIndex(volunteerIndex) + "!!!");
      System.out.println();

      // Delete the volunteer so they are not picked again.
      studentList.removeStudentAtIndex(volunteerIndex);
    }
  }

  public static void main(String[] args) {
    new Volunteller().run();
  }
}