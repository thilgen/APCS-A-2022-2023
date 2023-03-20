//
// The List class here is a linked list implementation. This is a recursive
// data structure, where each element stores a "head" which is a data value,
// and a "tail" which is a reference to another List, which is the
// rest of the list:
//
//  list -> List(1) -> List(2) -> List(3) -> null
//
// An empty list is simply null.
// A list with one element will be one List instance with tail=null.
//
// Note that this is a generic class with type parameter T. So, this
// List class can be used with any type that supports Object.equals.
//
// Tasks:
// 1. Implement the length() method.
// 2. Implement the prepend() method.
// 3. Implement the contains() method.
//
// To test your work, simply run the program and verify that tests pass.
// (They won't pass now as the implementation is incomplete.)
//
public class List<T> {
  // The value stored in this element of the linked list
  private T head;

  // Reference to the linked list representing the rest of this list, or null.
  private List<T> tail;

  // Constructs a List with the specified head value, and no tail.
  public List(T head) {
    this(head, null);
  }

  // Constructs a list with the specified head value and tail list.
  public List(T head, List<T> tail) {
    this.head = head;
    this.tail = tail;
  }

  public T getHead() {
    return head;
  }

  public List<T> getTail() {
    return tail;
  }

  // Returns a List with the same head but with the specified tail.
  // For efficiency, returns the same List if the requested tail is the same.
  public List<T> withTail(List<T> tail) {
    if (this.tail == tail) {
      return this;
    } else {
      return new List<T>(head, tail);
    }
  }

  // Converts the List to a string representation, including any tail list.
  public String toString() {
    if (tail != null) {
      return "" + head + ", " + tail;
    } else {
      return "" + head;
    }
  }

  private static <T> List<T> makeListHelper(T[] values, int index) {
    if (index >= values.length) {
      return null;
    } else {
      return new List<T>(values[index], makeListHelper(values, index + 1));
    }
  }

  public static <T> List<T> makeList(T[] values) {
    return makeListHelper(values, 0);
  }

  //
  // To implement the length() method recursively:
  // Base case: If list is null, that's a zero-length list.
  // Recursive case: If list is non-null, the length of the whole list
  // is 1 plus the length of the rest of the list.
  //
  public static <T> int length(List<T> list) {
    // TODO IMPLEMENT ME
    return -1;
  }

  //
  // To implement the contains() method recursively:
  // Base case: If list is null, it doesn't contain the value! Return false.
  // Recursive case: If list is non-null, return true if the list's head
  // equals the target value, else recursively return whether the rest of the list
  // contains the target value.
  //
  public static <T> boolean contains(List<T> list, T value) {
    // TODO IMPLEMENT ME
    return false;
  }

  //
  // To implement the prepend() method:
  // If list is null, return a single element list with value.
  // If list is non-null, return a new List with value as head, and
  // the list that was passed in as tail.
  // Note: When constructing a new node, pass the type parameter
  // when using the new opeartor, like new List<T>(). See append.
  //
  public static <T> List<T> prepend(List<T> list, T value) {
    // TODO IMPLEMENT ME
    return null;
  }

  public static <T> List<T> append(List<T> list, T value) {
    if (list == null) {
      return new List<T>(value);
    } else {
      return list.withTail(append(list.getTail(), value));
    }
  }

  public static <T> boolean equals(List<T> list1, List<T> list2) {
    if (list1 == null || list2 == null) {
      return list1 == list2;
    } else if (!list1.getHead().equals(list2.getHead())) {
      return false;
    } else {
      return equals(list1.getTail(), list2.getTail());
    }
  }
}
