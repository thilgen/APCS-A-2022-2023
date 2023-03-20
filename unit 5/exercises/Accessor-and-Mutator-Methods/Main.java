/*
 * 5.4 & 5.5: Accessor and Mutator Methods
 * 
 * The Student and Contact classes are currently allowing full public 
 * access to their variables
 *
 * Part 1: The Student class constructor uses the initFirstName and 
 *         initLastName parameters to create the Student.firstName, 
 *         Student.lastName, and Student.fullName instance variables.
 *         Since these instance variables are public there is no 
 *         protection against code outside of Student directly assigning 
 *         values that would lead to unexpected behavior.
 * 
 *         TODO: Make the Student name variables private and add the 
 *               necessary Accessor and Mutator methods to ensure the
 *               program continues to work as expected.
 * 
 * Part 2: The Contact class constructor uses the initPhoneNumber 
 *         parameter to create the Contact.phoneNumber and 
 *         Contact.areaCode instance variables. Since these instance 
 *         variables are public there is no protection against code 
 *         outside of Contact directly assigning values that would lead
 *         to unexpected behavior.
 * 
 *         TODO: Make the Contact variables private and add the 
 *               necessary Accessor and Mutator methods to ensure the 
 *               program continues to work as expected.
 *
 */

public class Main {
    public static void main(String args[]) {

      Contact contact;
      Student student;
      
      contact = new Contact("3124745230");
      student = new Student("Dallas", "Poole", contact);
      student.callStudent();

      contact = new Contact("5691017711");
      student = new Student("Erin", "Logan", contact);
      student.callStudent();

      contact = new Contact("5086780702");
      student = new Student("Stephanie", "Diaz", contact);
      student.callStudent();

      contact = new Contact("2564694689");
      student = new Student("Elias", "Ramos", contact);
      student.callStudent();

      contact = new Contact("9476264471");
      student = new Student("Brendan", "Cannon", contact);
      student.callStudent();
      student.firstName = "Griffen";
      student.callStudent(); // Expect: "Calling Griffen Cannon at 947-626-4471"
      student.lastName = "Thompson";
      student.callStudent(); // Expect: "Calling Griffen Thompson at 947-626-4471"
      contact.phoneNumber = "8005551212";
      student.callStudent(); // Expect: "Calling Griffen Thompson at 800-555-1212"
    }
}