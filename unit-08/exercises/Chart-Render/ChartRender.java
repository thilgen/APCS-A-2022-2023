import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class ChartRender {

  /*

  This program allows you to 'load' chart data files and 'draw' them to the
  console output.
    
  INSTRUCTIONS
    
  • Complete the following methods
    
    Chart.getMaxSegmentTotal()
    Chart.getMaxRowLabelWidth()
    Chart.adjustFillBlocks()
    
  • Test your work (expected output for pre-loaded examples)
    
    > draw example0
    
    Survey Response
    
    Yes   ████████████████████████████ 28
    
    No    ██████████████████████████████████████████████████ 51
    
    Maybe █████████ 9
    
          ███ Number

    > draw example1
    
    Revenue (USD) By Quarter
    
    2022-Q1 ██████████████████████ 114338
            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 265411
            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ 162807
    
    2022-Q2 ▏ 0
            ░░░░░░░░░░░░░░░░░░ 92687
            ▒▒▒▒▒▒ 27912
    
    2022-Q3 ████████████████ 83595
            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ 218206
            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ 101006
    
    2022-Q4 ███ 11578
            ░░░░░░░░░░░░░░░░░░░░░░ 112960
            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ 96975
    
            ███ New Sales
            ░░░ Customer Renewals
            ▒▒▒ Licenses
    
  IF YOU HAVE TIME
    
  • The program comes with two sample files - Try adding other files to the
    chart_data_files directory and 'load' and 'draw' them
    
  • Omit drawing the chart legend if there is only one data segment
    
  • Currently the program is limited to charts with a maximum of 4 row
    segments. Add a fifth item to Chart.SEGMENT_FILLS and create and load a chart
    data file that has 5 segments.
    
  */

  private final String PROGRAM_NAME = "📊 CHART RENDER 📊";

  private boolean running = true;

  private ArrayList<Chart> charts = new ArrayList<Chart>();

  public ChartRender() {
    createExampleCharts();
  }

  private void createExampleCharts() {
    String exampleChartsData[][] = {
        {
            "Survey Response|Number|",
            "Yes|28|",
            "No|51|",
            "Maybe|9|"
        },
        {
            "Revenue (USD) By Quarter|New Sales|Customer Renewals|Licenses|",
            "2022-Q1|114338|265411|162807|",
            "2022-Q2|0|92687|27912|",
            "2022-Q3|83595|218206|101006|",
            "2022-Q4|11578|112960|96975|"
        }

    };
    for (int idx = 0; idx < exampleChartsData.length; idx++) {
      String chartDataLines[] = exampleChartsData[idx];
      String headerElements[] = chartDataLines[0].split("\\|");
      String chartTitle = headerElements[0];
      String headerValues[] = Arrays.copyOfRange(headerElements, 1, headerElements.length);
      Chart newChart = Chart.createChart("example" + idx, chartTitle, headerValues, chartDataLines.length - 1);
      if (null != newChart) {
        for (int chartDataLineIdx = 1; chartDataLineIdx < chartDataLines.length; chartDataLineIdx++) {
          String chartDataRow = chartDataLines[chartDataLineIdx];
          String rowElements[] = chartDataRow.split("\\|");
          String rowLabel = rowElements[0];
          String rowValues[] = Arrays.copyOfRange(rowElements, 1, rowElements.length);
          newChart.appendRowData(chartDataLineIdx - 1, rowLabel, rowValues);
        }
      }
      charts.add(newChart);
    }
  }

  private void printHelp() {
    System.out.println("Available Commands:");
    System.out.println("  load <fileName>   -> loads a chart data file from the chart_data_files directory");
    System.out.println("  list              -> lists all the loaded charts");
    System.out.println("  draw <chartName>  -> draws the chart");
    System.out.println("  help              -> print help information");
    System.out.println("  quit              -> quit the program");
  }

  private void printWelcomeBanner() {
    System.out.println("-".repeat(PROGRAM_NAME.length() + 10));
    System.out.println("     " + PROGRAM_NAME + "     ");
    System.out.println("-".repeat(PROGRAM_NAME.length() + 10));
  }

  private Chart loadChart(String fileName) {
    Chart chart = findChart(fileName);
    if (null != chart) {
      System.out.println(fileName + " is already loaded");
      return chart;
    }
    chart = ChartDataFile.createChartFromFile(fileName);
    if (null != chart) {
      charts.add(chart);
      System.out.println(fileName + " has been loaded");
    }
    return chart;
  }

  private Chart findChart(String chartName) {
    for (Chart chart : charts) {
      if (chart.getName().equalsIgnoreCase(chartName)) {
        return chart;
      }
    }
    return null;
  }

  private void listCharts() {
    System.out.println("Loaded Charts:");
    for (Chart chart : charts) {
      System.out.println("  " + chart.getName());
    }
  }

  private void drawChart(String chartName) {
    Chart chart = findChart(chartName);
    if (null != chart) {
      Canvas canvas = chart.getCanvas();
      if (null != canvas) {
        for (int idx = 0; idx < canvas.getNumRows(); idx++) {
          System.out.println(canvas.getRow(idx));
        }
      }
    } else {
      System.out.println("ERROR: " + chartName + " is not in the list of loaded charts");
    }
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);
    printWelcomeBanner();
    System.out.println();
    printHelp();
    System.out.println();
    while (running) {
      System.out.print("> ");
      String command = scanner.nextLine();
      if (command.equals("help")) {
        printHelp();
      } else if (command.startsWith("load ")) {
        String fileName = command.substring("load ".length());
        loadChart(fileName);
      } else if (command.equals("list")) {
        listCharts();
      } else if (command.startsWith("draw ")) {
        String chartName = command.substring("draw ".length());
        drawChart(chartName);
      } else if (command.equals("quit")) {
        running = false;
      } else {
        System.out.println("I don't understand.");
      }
      System.out.println();
    }
    scanner.close();
  }
}