import java.io.*;

//
// How do we find all prime numbers up to N?
//
// The naive algorithm to do it is "trial division", that is, for each number,
// try dividing it by every other positive integer less than it. If it is divisible
// by only 1, it is prime.
//
// The problem with the trial division algorithm is it's O(N^2). If you tried to
// find primes up to 1 million, the program would do on the order of
// 1,000,000 * 1,000,000 operations... a quadrillion operations!
//
// A better algorithm was discovered ... over 2,000 years ago.
//
// From https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
// In mathematics, the sieve of Eratosthenes is an ancient algorithm for finding
// all prime numbers up to any given limit.
//
// It does so by iteratively marking as composite (i.e., not prime) the multiples
// of each prime, starting with the first prime number, 2."
//
// The earliest known reference to the sieve is in Nicomachus of Gerasa's
// Introduction to Arithmetic, an early 2nd cent. CE book, which describes it and
// attributes it to Eratosthenes of Cyrene, a 3rd cent. BCE Greek mathematician.
//
// EXERCISE:
// - Implement the TODO in the sieveOfEratosthenes method.
// - Implement the TODO in the countTrues method.
// - When you run the program, the file "primes.txt" will be written with all
//   of the prime numbers that your algorithm found.
// - The program will compare "primes.txt" to "test_primes.txt", which already
//   has the correct output in it. If the files are the same, you will be
//   duly congratulated. You calculated prime numbers up to 1,000,000!
// - Pick a few big prime numbers from primes.txt and check with Google:
//   For example, "Is 631459 prime?"
//

class SieveOfEratosthenes {

  // Calculate which integers up to maxValue are prime numbers
  // using the Sieve of Eratosthenes.
  //
  // The return value is a boolean[] where
  //   result[i] = true   if i is prime
  //   result[i] = false  if i is not prime
  //
  public boolean[] sieveOfEratosthenes(int maxValue) {
    boolean[] prime = new boolean[maxValue+1];

    // TODO: Put your Sieve of Eratosthenes implementation here!
    //
    // The output of this algorithm is a boolean[] array, where
    //   prime[i] = true if i is a prime number
    // Example: After running with maxValue = 6,
    //     prime[1], prime[3], prime[5] should be true
    //     prime[0], prime[2], prime[4], prime[6] should be false
    //
    // First, write a loop to set every element in the prime[] array
    // to true, except for prime[0] because we know 0 is not a prime number.
    // All other numbers are assumed to be prime until proven otherwise.
    //
    // Second, write another loop that iterates from 2 to maxValue.
    // For each iteration, check:
    //   Is prime[i] true?
    //   If it is:
    //     Do a loop on j where j = each multiple of "i", that is, i*2, i*3, i*4, ..., while j <= maxValue
    //       Set prime[j] = false
    //       (Because a multiple of a prime is NOT prime.)

    return prime;
  }

  // Count how many booleans are set to true in the passed array.
  public int countTrues(boolean[] array) {
    // TODO Implement this method! It should count how many true values
    // appear in "array" and return the total.
    return 0;
  }

  // Compare two text files. If there are differences, return the line number
  // of the first line that is different. Return 0 if no differences.
  int compareTextFiles(String path1, String path2) {
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(path1));
			BufferedReader reader2 = new BufferedReader(new FileReader(path2));
      int lineNumber = 1;
      while (true) {
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        if (line1 == null && line2 == null) {
          return 0;
        } else if (line1 == null || line2 == null || !line1.equals(line2)) {
          return lineNumber;
        }
        lineNumber++;
      }
		} catch (IOException e) {
			e.printStackTrace();
      return -1;
		}
  }

  public static void main(String[] args) throws IOException {
    new SieveOfEratosthenes().run();
  }

  public void run() {
    int N = 1000000;

    // Calculate primes up to N.
    boolean[] prime = sieveOfEratosthenes(N);

    System.out.println("Found " + countTrues(prime) + " primes");

    // Write all primes to the file "primes.txt"
    try {
      FileOutputStream os = new FileOutputStream(new File("primes.txt"));
      PrintWriter pw = new PrintWriter(os);
      for (int i=1; i<=N; i++) {
        if (prime[i]) {
          pw.println(i);
        }
      }
      pw.close();
      os.close();
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    // Compare "primes.txt" and "test_primes.txt"
    int diffLineNumber = compareTextFiles("primes.txt", "test_primes.txt");
    if (diffLineNumber == 0) {
      System.out.println("primes.txt matches the test_primes.txt file... good work!");
    } else if (diffLineNumber == -1) {
      System.out.println("Couldn't compare the files, an error occurred!");
    } else {
      System.out.println("ERROR! Check your code... the files differ on line " + diffLineNumber);
    }
  }
}