import java.util.Calendar;
import java.util.Date;

public class Main {
  /*
   * This program currently uses a static helper class DateUtil to print out
   * information about a Date object. However, this is not a great example of
   * Object Oriented Programming.
   * 
   * INSTRUCTIONS
   * 
   * 1. Create a new class called Date2 that *extends* the standard (non-final)
   *    Date class provided by the Java language
   * 
   * 2. Enhance the Date2 class so that it contains all the functionality provided
   *    by the DateUtil static helpers. Specifically, it should be possible to call
   *    methods directly on Date2 that are currently only available in DateUtil
   * 
   *    Date2 d2;           |  instead of...  |  Date d;
   *    d2.isDateWeekend()  |                 |  DateUtil.isDateWeekend(d)
   * 
   * 3. Run the program - which will compare the results of using DateUtil
   *    and Date2 - and indicate if the results match
   * 
   * IF YOU HAVE TIME
   * 
   * 1. Add other useful functionality to DateUtil and Date2
   * 
   * 2. This program makes use of the Calendar class (since most of the really
   *    interesting features of Date have been deprecated). Read up on the
   *    Calendar class and explore its functionality.
   * 
   */

  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();

    cal.set(2020, Calendar.JANUARY, 1);
    Date startDate = cal.getTime();

    cal.set(2021, Calendar.DECEMBER, 31);
    Date endDate = cal.getTime();

    System.out.println("Checking date values from " + startDate + " to " + endDate);

    Date currentDate = startDate;

    while (!currentDate.after(endDate)) {
      long msTime = currentDate.getTime();

      Date d1 = new Date(msTime);
      String d1Result = DateUtil.getDateInfo(d1);

      Date2 d2 = new Date2(msTime);
      String d2Result = d2.getDateInfo();

      if (d1Result.equals(d2Result)) {
        System.out.println(currentDate + " - Comparison MATCHES");
      } else {
        System.out.println(currentDate + " - Comparison DOES NOT MATCH");
        System.out.println("  ** EXPECTED **");
        System.out.println("  " + d1Result);
        System.out.println("  ** RECEIVED **");
        System.out.println("  " + d2Result);
      }

      cal.setTime(currentDate);
      cal.add(Calendar.DATE, 1);
      currentDate = cal.getTime();
    }
  }
}