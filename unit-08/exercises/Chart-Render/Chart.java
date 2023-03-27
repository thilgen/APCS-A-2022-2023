class Chart {

  private ChartRow chartRows[][];
  private LegendRow legendRows[];

  private int getMaxSegmentTotal() {
    /*
     * TODO - getMaxSegmentTotal()
     * 
     * Traverse every ChartRow in chartRows[rowIdx][segmentIdx]
     * Identify the largest of all the ChartRow totals
     * Return it
     * 
     */
    return 0;
  }

  private int getMaxRowLabelWidth() {
    /*
     * TODO - getMaxRowLabelWidth()
     * 
     * Traverse every ChartRow in chartRows[rowIdx][segmentIdx]
     * Identify the longest length of all ChartRow labels
     * Return it
     * 
     */
    return 0;
  }

  private void adjustFillBlocks(int maxSegmentTotal) {
    /*
     * TODO - adjustFillBlocks()
     * 
     * Traverse every ChartRow in chartRows[rowIdx][segmentIdx]
     * And invoke the adjustFillBlock(maxSegmentTotal) method
     * 
     */
  }

  // NO EDITS NEEDED BELOW THIS POINT
  // NO EDITS NEEDED BELOW THIS POINT
  // NO EDITS NEEDED BELOW THIS POINT

  static public final Character SEGMENT_FILLS[] = { '█', '░', '▒', '▓' };

  private String name;
  private String chartTitle;

  static public Chart createChart(String name, String chartTitle, String headerValues[], int numRows) {
    Chart chart = null;
    if (headerValues.length < SEGMENT_FILLS.length) {
      chart = new Chart(name, chartTitle, headerValues, numRows);
    } else {
      System.out.println("ERROR: Currently only support a maxmium of " + SEGMENT_FILLS.length + " row segments");
    }
    return chart;
  }

  private Chart(String name, String chartTitle, String headerValues[], int numRows) {
    this.name = name;
    this.chartTitle = chartTitle;
    int numRowSegments = headerValues.length;
    chartRows = new ChartRow[numRows][numRowSegments];
    legendRows = new LegendRow[numRowSegments];
    for (int idx = 0; idx < numRowSegments; idx++) {
      legendRows[idx] = new LegendRow(headerValues[idx], SEGMENT_FILLS[idx]);
    }
  }

  public String getName() {
    return name;
  }

  public String getChartTitle() {
    return chartTitle;
  }

  private int getNumChartRows() {
    return chartRows.length;
  }

  private int getNumRowSegments(int rowIdx) {
    String error = "ERROR (getNumRowSegments): rowIdx out of range";
    if ((rowIdx >= 0) && (rowIdx < getNumChartRows())) {
      return chartRows[rowIdx].length;
    }
    System.out.println(error);
    return -1;
  }

  private ChartRow getChartRow(int rowIdx, int segmentIdx) {
    String error = "ERROR (getRowSegmentValue): rowIdx out of range";
    if ((rowIdx >= 0) && (rowIdx < getNumChartRows())) {
      error = "ERROR (getRowSegmentValue): segmentIdx out of range";
      if ((segmentIdx >= 0) && (segmentIdx < getNumRowSegments(rowIdx))) {
        return chartRows[rowIdx][segmentIdx];
      }
    }
    System.out.println(error);
    return null;
  }

  public Canvas getCanvas() {
    int maxSegmentTotal = getMaxSegmentTotal();
    if (maxSegmentTotal <= 0) {
      System.out.println("ERROR (Chart.getCanvas): maxSegmentTotal is <= 0");
      return null;
    }

    int maxRowLabelWidth = getMaxRowLabelWidth();
    if (maxRowLabelWidth <= 0) {
      System.out.println("ERROR (Chart.getCanvas): maxRowLabelWidth is <= 0");
      return null;
    }

    Canvas canvas = new Canvas(3 + (chartRows.length * legendRows.length) + 1 + legendRows.length);

    int canvasRowIdx = 0;

    canvas.setRow(canvasRowIdx++, "");
    canvas.setRow(canvasRowIdx++, getChartTitle());
    canvas.setRow(canvasRowIdx++, "");

    adjustFillBlocks(maxSegmentTotal);

    for (int rowIdx = 0; rowIdx < getNumChartRows(); rowIdx++) {
      for (int segmentIdx = 0; segmentIdx < getNumRowSegments(rowIdx); segmentIdx++) {
        ChartRow rowItem = getChartRow(rowIdx, segmentIdx);
        String label = "";
        if (0 == segmentIdx) {
          label = rowItem.getLabel();
        }
        label = String.format("%-" + maxRowLabelWidth + "s", label);
        String result = String.format("%s %s %s", label, rowItem.getFillBlock(), rowItem.getTotal());
        if (segmentIdx == (getNumRowSegments(rowIdx) - 1)) {
          if (rowIdx != (getNumChartRows() - 1)) {
            // add a newline if we are on the last segment of a row (except the last row)
            result += "\n";
          }
        }
        canvas.setRow(canvasRowIdx++, result);
      }
    }
    canvas.setRow(canvasRowIdx++, "");

    for (int idx = 0; idx < legendRows.length; idx++) {
      String legendRow = String.format("%s %s %s", " ".repeat(maxRowLabelWidth),
          legendRows[idx].getFillBlock(), legendRows[idx].getLabel());
      canvas.setRow(canvasRowIdx++, legendRow);
    }
    return canvas;
  }

  public void appendRowData(int rowIdx, String rowLabel, String rowValues[]) {
    if ((rowIdx < 0) || (rowIdx >= chartRows.length)) {
      System.out.println("ERROR (appendRowData): index out of range");
      return;
    }
    if (rowValues.length != legendRows.length) {
      System.out.println("ERROR (appendRowData): number of row elements (" + rowValues.length
          + ") does not equal number of legend/header values (" + legendRows.length + ")");
      return;
    }
    for (int idx = 0; idx < rowValues.length; idx++) {
      chartRows[rowIdx][idx] = new ChartRow(rowLabel, SEGMENT_FILLS[idx], Integer.parseInt(rowValues[idx]));
    }
  }
}