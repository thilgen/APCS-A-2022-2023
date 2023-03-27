public class Random {
  // This is an example of a "utility class" containing "utility methods"
  // that other code can use to avoid repeating the same code pattern
  // over and over again.
  public static int randomInt(int minValue, int maxValue) {
    return minValue + (int) (Math.random() * (maxValue - minValue + 1));
  }
}