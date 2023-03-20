import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class HtmlGenerator {
  private String htmlBuffer;

  public HtmlGenerator() {
    htmlBuffer = "<style type=\"text/css\">\n";
    try {
      htmlBuffer += Files.readString(Paths.get("MultiplicationTable.css"));
    } catch (IOException e) {
      System.out.println("Could not load CSS from MultiplicationTable.css! No formatting for you!");
      e.printStackTrace();
    }      
    htmlBuffer += "</style>\n";
  }

  public void printHeader2(String value) {
    htmlBuffer += "<h2>" + value + "</h2>\n";
  }

  public void startTable() {
    htmlBuffer += "<table>\n";
  }

  public void endTable() {
    htmlBuffer += "</table>\n";
  }

  public void startTableRow() {
    htmlBuffer += "  <tr>\n";
  }

  public void endTableRow() {
    htmlBuffer += "  </tr>\n";
  }

  public void printTableColumn(String value, String cssClass) {
    htmlBuffer += "    <td class=\"" + cssClass + "\">" + value + "</td>\n";
  }

  public void printTableColumn(int value, String cssClass) {
    printTableColumn(Integer.toString(value), cssClass);
  }

  public String getHTML() {
    return htmlBuffer;
  }
}