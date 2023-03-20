//
// See List.java for instructions. (This file is mostly the test harness.)
//
class Main {
  private static List<String> makeStringList(String... args) {
    return List.makeList(args);
  }

  public static void main(String[] args) {
    testContains();
    testPrepend();
    testAppend();
    testLength();
  }

  private static void testEqual(String name,
                                List<String> actual,
                                List<String> expected) {
    boolean pass = List.equals(actual, expected);
    String passFail = pass ? "PASS" : "FAIL";
    System.out.println(passFail + " " + name + " expected=[" + expected + "], actual=[" + actual + "]");
  }

  private static void testContains(List<String> list, String value, boolean expected) {
    boolean actual = List.contains(list, value);
    String passFail = (actual == expected) ? "PASS" : "FAIL";
    System.out.println(passFail + " List.contains([" + list + "], " + value + ")  expected=" + expected + " actual=" + actual);
  }

  private static void testContains() {
    testContains(null, "xyz", false);
    testContains(makeStringList("xyz"), "xyz", true);
    testContains(makeStringList("foo"), "xyz", false);
    testContains(makeStringList("Alice", "Bob"), "Alice", true);
    testContains(makeStringList("Alice", "Bob"), "Bob", true);
    testContains(makeStringList("Alice", "Bob"), "Calvin", false);
    testContains(makeStringList("Alice", "Bob", "Calvin"), "Alice", true);
    testContains(makeStringList("Alice", "Bob", "Calvin"), "Bob", true);
    testContains(makeStringList("Alice", "Bob", "Calvin"), "Calvin", true);
    testContains(makeStringList("Alice", "Bob", "Calvin"), "David", false);
  }

  private static void testPrepend() {
    testEqual("List.prepend",
              List.prepend(null, "xyz"),
              makeStringList("xyz"));
    testEqual("List.prepend",
              List.prepend(makeStringList("Bob"), "Alice"),
              makeStringList("Alice", "Bob"));
    testEqual("List.prepend",
              List.prepend(makeStringList("Bob", "Calvin"), "Alice"),
              makeStringList("Alice", "Bob", "Calvin"));
  }

  private static void testAppend() {
    testEqual("List.append",
              List.append(null, "xyz"),
              makeStringList("xyz"));
    testEqual("List.append",
              List.append(makeStringList("Alice"), "Bob"),
              makeStringList("Alice", "Bob"));
    testEqual("List.append",
              List.append(makeStringList("Alice", "Bob"), "Calvin"),
              makeStringList("Alice", "Bob", "Calvin"));
  }
  
  private static void testLength() {
    for (int i=0; i<10; i++) {
      List<String> list = null;
      for (int j=0; j<i; j++) {
        list = List.append(list, "xyz");
      }
      int actual = List.length(list);
      int expected = i;
      String passFail = (actual == expected) ? "PASS" : "FAIL";
      System.out.println(passFail + " List.length([" + list + "]) expected=" + expected + ", actual=" + actual);
    }
  }
}