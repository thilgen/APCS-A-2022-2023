class Main {
  public static void main(String[] args) {
    // TODO Write a loop that prints out the first 50 Fibonacci numbers.
    // This is not a nested loop, but it is a kind of loop that comes
    // up often... one where you need to track some information from
    // previous iterations, in this case, the values of the pervious
    // TWO iterations.
    //
    // If you were tracking just the previous value, you could do that
    // with one more variable besides the loop counter.
    // int previousValue = 0;
    // int sum = 0;
    // for (int i=0; i<100; i++) {
    //   sum += 1 + previousValue;
    //   previousValue = sum;
    // }
    //
    // Think: What if you need to track two previous values?
    //
    // The Fibonacci sequence is defined as
    // F(0) = 0
    // F(1) = 1
    // F(n) = F(n-1) + F(n-2) for n > 1
    //
    // Note that if you use type "int", the Fibonacci numbers get so
    // big that they will overflow around #48. You can use "long"
    // to keep going. Even "long" will only get you to #93, but
    // it's enough to do the first 50.
    //
    // "double" will look like it's working but will be losing
    // precision once the numbers are too many digits, and the
    // default string conversion will render the numbers in scientific
    // notation which is undesirable for our purposes.
    //
    // Once you've got your output, you can manually check your work
    // against fibonacci.txt
    //
  }
}