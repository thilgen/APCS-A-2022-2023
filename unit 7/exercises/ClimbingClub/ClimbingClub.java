import java.util.List;
import java.util.ArrayList;

public class ClimbingClub {
  /**
   * The list of climbs completed by members of the club.
   * Guaranteed not to be null. Contains only non-null
   * references.
   */
  private List<ClimbInfo> climbList;

  /** Creates a new ClimbingClub object. */
  public ClimbingClub() {
    climbList = new ArrayList<ClimbInfo>();
  }

  /**
   * Adds a new climb with name peakName and time climbTime
   * to the list of climbs.
   * 
   * @param peakName  the name of the mountain peak climbed
   * @param climbTime the number of minutes taken to complete
   *                  the climb
   */
  public void addClimb(String peakName, int climbTime) {
    // TODO YOUR CODE HERE FOR PART (a)
    // Part a. Write an implementation of the ClimbingClub method addClimb that stores
    // the ClimbInfo objects in the order they were added. This implementation of addClimb
    // should create a new ClimbInfo object with the given name and time.
    // It appends a reference to that object to the end of climbList.
  }

  public void addClimbAlphabetical(String peakName, int climbTime) {
    // TODO YOUR CODE HERE FOR PART (b)
    // Part b. Write an implementation of the ClimbingClub method addClimb that
    // stores the elements of climbList in alphabetical order by name (as determined
    // by the compareTo method of the String class). This implementation of addClimb
    // should create a new ClimbInfo object with the given name and time and then insert
    // the object into the appropriate position in climbList. Entries that have the
    // same name will be grouped together and can appear in any order within the group.
  }

  /** @return the number of distinct names in the list of climbs */
  public int distinctPeakNames() {
    // TODO YOUR CODE HERE FOR PART (c)
    // Part c. The ClimbingClub method distinctPeakNames is intended to return
    // the number of different names in climbList.
    return 0;
  }

  // There may be instance variables, constructors, and methods
  // that are not shown.

  // [Gary] I added these for testing purposes...
  public int getNumClimbs() {
    return climbList.size();
  }

  public ClimbInfo getClimb(int index) {
    if (index < 0 || index >= getNumClimbs()) {
      return null;
    }
    return climbList.get(index);
  }
}