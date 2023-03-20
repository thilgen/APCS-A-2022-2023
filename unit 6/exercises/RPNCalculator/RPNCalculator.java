//
// Everyone is accustomed to doing math with *infix notation*,
// where the operator sits between the operands in a mathematical operation:
//   2 + 2
//
// Polish notation, or prefix notation, was invented in 1924 by Jan Lukasiewicz
// (who was Polish). In Polish notation, the operator goes before the operands:
//   + 2 2
// Prefix notation is used by programming languages such as Lisp and Scheme.
//
// Reverse Polish Notation (RPN), also known as postfix notation, puts the
// operator AFTER the operands:
//   2 2 +
//
// Programming languages such as Forth and PostScript use postfix notation.
// It was also used by HP calculators by decades.
//
// Why use postfix notation? People in jobs requiring lots of math such as
// engineers preferred HP's RPN calculators. For one, you never need
// parentheses when using postfix notation, so you don't need to figure
// out how many open or closed parentheses to put in your expressions!
// Example: The infix expression
//   (x+2)*(x-3)
// is equivalent to the postfix expression
//   x 2 + x 3 - *
//
// In this exercise, we'll get a Reverse Polish Notation calculator
// working.
//
// Fundamental to a RPN calculator is a Stack. A Stack is an abstract
// data type that is Last In, First Out (LIFO). You can "push" items
// onto the stack, and "pop" them off. Like a stack of dishes, you
// can easily put something on top of the stack ("push"), or get
// something off the top of the stack ("pop").
//
// Go to Stack.java and follow the instructions for implementing the
// Stack. Run the program to see if the Stack test suite passes.
// When it does, the RPN calculator will start and you can enter
// some RPN expressions to try it out.
//

import java.util.Scanner;

class RPNCalculator {
  public static void main(String[] args) {
    StackTest stackTest = new StackTest();
    System.out.println("Running Stack test suite...");
    if (stackTest.runTest()) {
      System.out.println("Stack test suite succeeded.");            
    } else {
      System.out.println("Stack test suite failed!");
      return;
    }

    new RPNCalculator().run();
  }

  public static final int MAX_STACK = 100;

  private Stack stack = new Stack(MAX_STACK);

  private void help() {
    System.out.println("Enter one of the following, followed by <return>:");
    System.out.println("help - print this message");
    System.out.println("quit - quit the calculator");
    System.out.println("dump - dump out the contents of the stack");
    System.out.println("pop  - pops an element off the stack");
    System.out.println("+, -, *, / - operators");
    System.out.println("Any other input will be treated as a number to push.");
    System.out.println("Example: 2 2 + <return> will print 4");
  }

  private boolean ensureStack(int minimumValues, String operator) {
    if (stack.getStackPointer() < minimumValues) {
      System.out.println("There must be at least " + minimumValues + " on the stack to do " + operator);
      return false;
    } else {
      return true;
    }
  }

  private void displayTopOfStack() {
    if (stack.isEmpty()) {
      System.out.println("Stack is empty");
    } else {
      System.out.println(stack.getStackPointer() + ": " + stack.peek());
    }    
  }

  void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to the RPN Calculator!");
    while (true) {
      System.out.print('>');
      String line = scanner.nextLine();
      for (String token : line.split(" ")) {
        token = token.trim();
        if (token.equals("help")) {
          help();
        } else if (token.equals("quit")) {
          return;
        } else if (token.equals("dump")) {
          stack.dump();
        } else if (token.equals("pop")) {
          if (ensureStack(1, "pop")) {
            stack.pop();
            displayTopOfStack();
          }
        } else if (token.equals("+")) {
          if (ensureStack(2, "+")) {
            stack.push(stack.pop() + stack.pop());
            displayTopOfStack();
          }
        } else if (token.equals("-")) {
          if (ensureStack(2, "-")) {
            double b = stack.pop();
            double a = stack.pop();
            stack.push(a - b);
            displayTopOfStack();
          }
        } else if (token.equals("*")) {
          if (ensureStack(2, "*")) {
            stack.push(stack.pop() * stack.pop());
            displayTopOfStack();
          }
        } else if (token.equals("/")) {
          if (ensureStack(2, "/")) {
            double b = stack.pop();
            double a = stack.pop();
            stack.push(a / b);
            displayTopOfStack();
          }
        } else {
          try {
            stack.push(Double.valueOf(token));
            displayTopOfStack();
          } catch (Exception e) {
            System.out.println("Invalid input");
          }
        }
      }
    }
  }
}