class LegendRow {

  static private final int LEGEND_VALUE_FILL_BLOCK_WIDTH = 3;

  private String label;
  private String fillBlock;

  public LegendRow(String label, Character fillBlockChar) {
    this.label = label;
    this.fillBlock = fillBlockChar.toString().repeat(LEGEND_VALUE_FILL_BLOCK_WIDTH);
  }

  public String getLabel() {
    return label;
  }

  public String getFillBlock() {
    return fillBlock;
  }
}