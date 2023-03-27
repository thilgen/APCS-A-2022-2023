import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.lang.reflect.*;

public class TestRunner {
  private static String testClassNames[] = new String[] {
    "ContactTests",
    "RoomTests",
    "PlayerTests",
  };

  public void run() {
    System.out.println("\n*************************");
    System.out.println("****** TEST RUNNER ******");
    System.out.println("*************************");
    try {
      for (String testClassName : testClassNames) {
        Result result = JUnitCore.runClasses(Class.forName(testClassName));
        int numTests = result.getRunCount();
        int failureCount = result.getFailureCount();
        System.out.println(String.format("\nRunning Test: %s (%s)",
          testClassName, failureCount == 0 ? "PASSED" : "FAILED"));
        System.out.println("  Tests           : " + numTests);
        System.out.println("  Tests Successful: " + (numTests - failureCount));
        System.out.println("  Tests Failed    : " + failureCount);
        for (Failure failure : result.getFailures()) {
          System.out.println("    " + failure.toString());
        }
      }      
    } catch (Exception e) {
      //
    }
    System.out.println("\n*************************");
    System.out.println("*************************\n");
  }
}      
