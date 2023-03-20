import java.util.LinkedHashMap;

public class Record {
  private LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();

  public void setField(String name, String value) {
    data.put(name, value);
  }

  public String getField(String name) {
    return data.get(name);
  }

  public String getCompany() {
    return getField("company");
  }

  public String toString() {
    StringBuilder result = new StringBuilder();
    for (String key : data.values()) {
      if (!result.isEmpty()) {
        result.append(',');
      }
      result.append(key);
    }
    return result.toString();
  }
}