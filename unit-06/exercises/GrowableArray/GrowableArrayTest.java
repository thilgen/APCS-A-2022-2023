public class GrowableArrayTest {
  public boolean runTest() {
    System.out.println("GrowableArrayTest starting...");
    GrowableArray growableArray = new GrowableArray(10);
    int N = 10000;
    for (int i = 0; i < N; i++) {
      growableArray.add(Integer.toString(i));
    }
    if (growableArray.count() != N) {
      System.out.println("growableArray.count() should return " + N);
      return false;
    }
    for (int i = 0; i < N; i++) {
      if (!growableArray.stringAt(i).equals(Integer.toString(i))) {
        System.out.println("growableArray.stringAt(" + i + ") should equal " + i);
        return false;
      }
    }
    System.out.println("GrowableArrayTest succeeded!");
    return true;
  }
}