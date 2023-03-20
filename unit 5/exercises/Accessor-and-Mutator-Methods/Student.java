public class Student
{
  public String firstName;
  public String lastName;
  public String fullName;

  private Contact contact;
  
  public Student(String initFirstName, String initLastName, Contact studentContact) {
    firstName = initFirstName;
    lastName = initLastName;
    fullName = firstName + " " + lastName;
    contact = studentContact;
  }

  public void callStudent() {
    System.out.println("Calling " + fullName + " at " + contact.phoneNumber);
  }
}
