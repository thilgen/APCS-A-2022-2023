public class GrowableArray {
  // You're going to implement a growable array of strings.
  // This is an abstract data type that wraps a regular String[] array and
  // adds the ability to grow as needed.
  //
  // The array inside this object can be bigger than the actual # of strings
  // being held. The extra space is "headroom" that can be grown into.
  // When the headroom runs out, the array is grown by copying into a new array
  // of double the size. Why double? Some other growth factor could be used,
  // but doubling often does a reasonable job of minimizing the # of times
  // that we need to grow the array while not wasting too much memory.
  //
  // You will need to track these instance variables:
  // - an array of String for the values
  // - an int instance var which tracks how many Strings have been added
  // - an int instance var which tracks the total capacity of the array
  //   (or you can use the .length property of your array for this instead)
  //
  // In Unit 7, we'll learn about the ArrayList class in the Java
  // standard library, which essentially does what this class does.
  // (You can't use ArrayList in this exercise though... use regular arrays!)
  
  public GrowableArray(int initialCapacity) {
    // TODO IMPLEMENT ME
    // Start off with your String[] array having initialCapacity slots
    // However, the count of Strings should be zero.
  }

  public void add(String value) {
    // TODO IMPLEMENT ME
    // If the array is at capacity (if the number of strings being held is equal
    // to the total capacity), call the grow() method to grow the array first.
    // Then, add the string "value" to the array and increment the count of
    // strings in the array.
  }

  public int count() {
    // TODO IMPLEMENT ME
    // Return the count of strings in the array. (The count of how many strings
    // are being held... not the total capacity of strings that could be held!)
    return 0;
  }

  public String stringAt(int index) {
    // TODO IMPLEMENT ME
    // Return the index'th string in the array.
    return null;
  }

  private void grow() {
    // TODO IMPLEMENT ME
    // This method should grow the array to double its capacity.
    // You will need to new[] a new array that is twice as big as the current one,.
    // i.e. "String[] newArray = new String[capacity*2];"
    // Then, you'll need to copy all the elements from the old array into the new one
    // using some kind of loop.
    // Lastly, set your instance variable for the values array to point to the
    // new array, i.e. "array = newArray;"
    // The old array will get garbage collected once nothing references it.
  }
}
