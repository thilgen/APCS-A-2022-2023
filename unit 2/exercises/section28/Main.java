import java.util.Scanner;

class Main {
  // Exercises:
  //
  // 1. Write the method printBinaryAddition.
  //    Write a static method that prints out two ints being
  //    added together in binary.
  //    Your output should look like this:
  //
  //   printBinaryAddition(1, 1); should print out the addition
  //   that is happening in binary and decimal
  //
  //   00000000000000000000000000000001 (1)
  // + 00000000000000000000000000000001 (1)
  //   --------------------------------
  //   00000000000000000000000000000010 (2)
  //   (put a newline after to separate your output nicely)
  //
  //   printBinaryAddition can use the provided method
  //   intToBinaryString to do the int-to-binary string conversion.
  //
  // 2. Run the code, and study the output. Think about why Two's
  //    Complement work well for representing negative
  //    numbers? What happens when you subtract 1 from
  //    Integer.MIN_VALUE, or add 1 to Integer.MAX_VALUE?
  //
  // 3. Write code at the bottom of main to ask the user
  //    for two ints. Then print them being added out using
  //    printBinaryAddition.
  //
  // 4. Change all of the code to use primitive types instead
  //    of wrapper classes wherever possible.
  
  private static String intToBinaryString(Integer i) {
    // Integer.toBinaryString is an example of an integer-related method
    // that makes its home as an Integer static method.
    // String.format takes a "format string" and formats text. Here we use
    // it to pad the binary representation of i with leading spaces to get,
    // it to be exactly 32 chars long, and then change the spaces to 0's.
    return String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0');
  }

  private static void printBinaryAddition(Integer x, Integer y) {
    // YOUR CODE HERE: Implement printBinaryAddition
    System.out.println("TODO IMPLEMENT ME");
  }

  public static void main(String[] args) {
    printBinaryAddition(1, 1);
    printBinaryAddition(1, -1);
    printBinaryAddition(Integer.MIN_VALUE, -1);
    printBinaryAddition(Integer.MAX_VALUE, 1);

    // YOUR CODE HERE:
    // Ask the user for two numbers and print them being added
    // using printBinaryAddition. Try it with some positive and
    // negative inputs of your own choosing.
    //Scanner scanner = new Scanner(System.in);
  }
}