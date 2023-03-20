public class Main {
  // Write a method that takes in a name with a space in it, and formats the
  // name so that the name comes with the last name first
  // e.g. "Jack Frost" -> "Frost, Jack"
  // You can safely assume:
  // - Names are made up of only a first and last ("Barack Obama" not "Barack Hussein Obama")
  // - Names will have a single space separating the first and last name
  public static String nameFlipper(String name) {
    // Hint: Use indexOf to find the location of the space in the name
    int spacePosition; 
    return "";
  }

  public static void main(String []args){
    // Let's use .equals() to test your code
    String expectedOutput = "Garoppolo, Jimmy";
    String flippedName = nameFlipper("Jimmy Garoppolo");
    System.out.println("Did your code work? " + expectedOutput.equals(flippedName)
    );
    
    // What would happen if I used .compareTo() instead of .equals?
    // Write some code to try it out!
    // Thought experiment: In what situations would .compareTo() be more
    // useful than .equals() and vice versa?
  }
}