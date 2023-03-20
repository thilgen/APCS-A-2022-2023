class ChartRow {

  static private final int MAX_BLOCK_WIDTH = 50;

  private String label;
  private Character fillBlockChar;
  private int total;

  private String fillBlock;  

  public ChartRow(String label, Character fillBlockChar, int total) {
    this.label = label;
    this.fillBlockChar = fillBlockChar;
    this.total = total;
  }

  public String getLabel() {
    return label;
  }

  public int getTotal() {
    return total;
  }

  public String getFillBlock() {
    return fillBlock;
  }

  public void adjustFillBlock(int maxSegmentTotal) {
    int fillBlockWidth = (int) (Math.ceil(1.0 * getTotal() / maxSegmentTotal * MAX_BLOCK_WIDTH));
    if (0 == fillBlockWidth) {
      fillBlock = "▏";
    } else {
      fillBlock = fillBlockChar.toString().repeat(fillBlockWidth);
    }
  }
}