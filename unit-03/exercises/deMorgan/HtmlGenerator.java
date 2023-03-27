public class HtmlGenerator {
  private String htmlBuffer;

  public HtmlGenerator() {
    htmlBuffer = "<style type=\"text/css\">\n";
    htmlBuffer += "  table { width: 80%; }\n";
    htmlBuffer += "  table, th, td { padding: 8px; border: 1px solid; }\n";
    htmlBuffer += "</style>\n";
  }

  public void printHeader2(String value) {
    htmlBuffer += "<h2>" + value + "</h2>\n";
  }

  public void printHeader3(String value) {
    htmlBuffer += "<h3>" + value + "</h3>\n";
  }

  public void printTableHeader(String value) {
    htmlBuffer += "    <th>" + value + "</th>\n";
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

  public void printTableColumn(String value) {
    htmlBuffer += "    <td>" + value + "</td>\n";
  }

  public void printTableColumn(boolean value) {
    printTableColumn(Boolean.toString(value));
  }

  public String getHTML() {
    return htmlBuffer;
  }
}