class Canvas {

  private String rows[];

  public Canvas(int height) {
    rows = new String[height];
  }

  public int getNumRows() {
    return rows.length;
  }

  public String getRow(int rowIdx) {
    if ((rowIdx >= 0) && (rowIdx < getNumRows())) {
      return rows[rowIdx];
    }
    System.out.println("ERROR (Canvas.getRow): index out of range");
    return null;
  }

  public void setRow(int rowIdx, String rowValue) {
    if ((rowIdx >= 0) && (rowIdx < getNumRows())) {
      rows[rowIdx] = rowValue;
      return;
    }
    System.out.println("ERROR (Canvas.setRow): index out of range");
  }
}