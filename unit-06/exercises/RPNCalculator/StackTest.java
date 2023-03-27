public class StackTest {
  public boolean runTest() {
    Stack stack = new Stack(10);

    if (stack.getStackPointer() != 0) {
      System.out.println("stack.getStackPointer() must == 0 when stack is empty");
      return false;
    }

    if (!stack.isEmpty()) {
      System.out.println("stack.isEmpty() must == true when stack is empty");
      return false;
    }

    if (stack.isFull()) {
      System.out.println("stack.isFull() must == false when stack is not full");
      return false;
    }

    for (int i=1; i<=10; i++) {
      if (!stack.push(i)) {
        System.out.println("stack.push(" + i + ") failed");
        return false;      
      }
      if (stack.peek() != i) {
        System.out.println("stack.peek() should == " + i);
        return false;
      }
      if (stack.getStackPointer() != i) {
        System.out.println("stack.getStackPointer() should == " + i);
        return false;
      }
    }

    if (stack.push(11)) {
      System.out.println("stack.push() should fail when stack is full");
      return false;
    }

    if (stack.peek() != 10) {
      System.out.println("stack.peek() should have returned 10");
      return false;
    }

    if (stack.isEmpty()) {
      System.out.println("stack.isEmpty() must == true when stack is not empty");
      return false;
    }

    if (!stack.isFull()) {
      System.out.println("stack.isFull() must == true when stack is full");
      return false;
    }

    for (int i=10; i>=1; i--) {
      if (i != stack.pop()) {
        System.out.println("stack.pop() should equal " + i);
        return false;      
      }
    }

    if (!stack.isEmpty()) {
      System.out.println("stack.isEmpty() must == true when stack is empty");
      return false;
    }

    if (stack.isFull()) {
      System.out.println("stack.isFull() must == false when stack is not full");
      return false;
    }

    return true;
  }
}