import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Query {
  public void execute(ArrayList<Song> songs) {
    HashSet<String> resultSet = new HashSet<String>();
    for (Song song : songs) {
      resultSet.add(extractField(song));
    }
    ArrayList<String> resultArray = new ArrayList<String>();
    resultArray.addAll(resultSet);
    Collections.sort(resultArray);
    for (String result : resultArray) {
      System.out.println(result);
    }
  }

  // Override this method to extract the desired field for the query
  public abstract String extractField(Song song);
}