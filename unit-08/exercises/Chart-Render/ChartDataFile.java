import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class ChartDataFile {

  static public Chart createChartFromFile(String fileName) {
    Chart newChart = null;
    String filePath = "chart_data_files/" + fileName;
    try {
      int numFileLines = getNumFileLines(filePath);
      Scanner scanner = new Scanner(new FileInputStream(new File(filePath)));
      int rowIdx = 0;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (null == newChart) {
          String headerElements[] = line.split("\\|");
          String chartTitle = headerElements[0];
          String headerValues[] = Arrays.copyOfRange(headerElements, 1, headerElements.length);
          newChart = Chart.createChart(fileName, chartTitle, headerValues, numFileLines - 1);
        } else {
          String chartDataRow = line;
          String rowElements[] = chartDataRow.split("\\|");
          String rowLabel = rowElements[0];
          String rowValues[] = Arrays.copyOfRange(rowElements, 1, rowElements.length);
          newChart.appendRowData(rowIdx++, rowLabel, rowValues);
        }
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
    return newChart;
  }

  static private int getNumFileLines(String filePath) throws IOException {
    int numFileLines = 0;
    Scanner scanner = new Scanner(new FileInputStream(new File(filePath)));
    while (scanner.hasNextLine()) {
      scanner.nextLine();
      numFileLines++;
    }
    scanner.close();
    return numFileLines;
  }
}