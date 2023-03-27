public class Stack {
  // A Stack is a LIFO (Last In First Out) data structure. You can "push"
  // values onto it, and "pop" them off. Like a stack of dishes, the values
  // will pop off in reverse from the order you pushed them on. For example,
  // if you call:
  //   stack.push(1);
  //   stack.push(2);
  //   stack.push(3);
  // The first call to stack.pop() will return 3
  // The first call to stack.pop() will return 2
  // The first call to stack.pop() will return 1
  //
  // A Stack is implemented using an array, and with another variable
  // called the "stack pointer" which is just an integer. It "points"
  // to the next slot on the stack where a "push" will write.
  // The stack pointer is just the index in the stack array where
  // the next write should go.
  
  // TODO: The Stack constructor should create an array that can accommodate
  // stackSize values of type double, and store the array in an instance
  // variable.
  // There should be an int variable for the "stack pointer", which should
  // start off as zero.
  public Stack(int stackSize) {
    // FIXME
  }

  // TODO: isEmpty should return true if the stack is empty, that is,
  // the stack pointer is zero.
  public boolean isEmpty() {
    // FIXME
    return true;
  }

  // TODO: isFull should return true if the stack is full, that is,
  // the stack pointer is equal to stackSize.
  public boolean isFull() {
    // FIXME
    return false;
  }

  // TODO: If the stack is not empty, return the value that was most
  // recently pushed on the stack, that is, the "top" of the stack.
  // Don't actually pop the value off the stack, though... the
  // stack pointer should remain unchanged!
  // If the stack is empty, return 0.0.
  public double peek() {
    // FIXME
    return 0.0;
  }

  // TODO: Push the value passed onto the stack. Do this by writing
  // to stack[stackPointer], and then increment stackPointer and
  // return true.
  // If stackPointer == stackSize, though, the stack is full and
  // can't take any more elements, so return false.
  public boolean push(double value) {
    // FIXME
    return false;
  }

  // TODO: Pop the value at the top off the stack and return it.
  // Do this by decrementing the stack pointer, and then returning
  // the value at stack[stackPointer]. However, if the stack is empty,
  // return 0.0.
  public double pop() {
    // FIXME
    return 0.0;
  }

  // TODO: Return the current stack pointer.
  public int getStackPointer() {
    // FIXME
    return 0;
  }

  // TODO: Print the contents of the stack from 0..stackPointer-1
  // using System.out.println. Format it whatever way you like!
  public void dump() {
    // FIXME
  }
}