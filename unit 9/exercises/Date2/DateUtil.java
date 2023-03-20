import java.util.Date;
import java.util.Calendar;

public class DateUtil {

  private static Calendar cal = Calendar.getInstance();

  private static boolean isDateWeekend(Date d) {
    cal.setTime(d);
    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    return ((Calendar.SUNDAY == dayOfWeek) || (Calendar.SATURDAY == dayOfWeek));
  }

  private static boolean hasCaseOfTheMondays(Date d) {
    cal.setTime(d);
    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    return (Calendar.MONDAY == dayOfWeek);
  }

  private static boolean isDateLeapYear(Date d) {
    /*
     * For the Gregorian calendar, each leap year has 366 days instead of 365,
     * by extending February to 29 days rather than the common 28. This extra
     * leap day occurs in each year that is an integer multiple of 4 (except
     * for years evenly divisible by 100, but not by 400).
     */
    cal.setTime(d);
    int year = cal.get(Calendar.YEAR);
    boolean isLeapYear = false;
    if (0 == year % 4) {
      if (0 == year % 100) {
        if (0 == year % 400) {
          isLeapYear = true;
        }
      } else {
        isLeapYear = true;
      }
    }
    return isLeapYear;
  }

  private static boolean isDateH1(Date d) {
    cal.setTime(d);
    int month = cal.get(Calendar.MONTH);
    return (month <= 5);
  }

  private static boolean isDateH2(Date d) {
    cal.setTime(d);
    int month = cal.get(Calendar.MONTH);
    return (month >= 6);
  }

  public static String getDateInfo(Date d) {
    String result = d.toString();
    result += "\n  hasCaseOfTheMondays: " + hasCaseOfTheMondays(d);
    result += "\n  isDateWeekend: " + isDateWeekend(d);
    result += "\n  isDateLeapYear: " + isDateLeapYear(d);
    result += "\n  isDateH1: " + isDateH1(d);
    result += "\n  isDateH2: " + isDateH2(d);
    return result;
  }
}