import java.util.ArrayList;

//
// GridHelpers is the code that prints out the beautiful ASCII art grids.
// There's no need to change anything in here unless you want to change
// the look and feel of the game.
//
public class GridHelpers {
  static public void printGridHorizontal(Grid opponentGrid,
                                         ArrayList<String> opponentBanner,
                                         Grid playerGrid,
                                         ArrayList<String> playerBanner) {
    int numCols = Grid.NUM_COLS;
    int numRows = Grid.NUM_ROWS;

    int width = 7 + numCols * 6;
    String padding = " ".repeat(5);

    String headerRowOutput = "";
    for (int idx = 0; idx < 2; idx++) {
      for (int col = 0; col < numCols; col++) {
        String topPart = "";
        if (0 == col) {
          topPart += "      ┌─────";
        } else if (col != numCols - 1) {
          topPart += "┬─────";
        } else {
          topPart += "┬─────┐";
        }
        headerRowOutput += topPart;
      }
      headerRowOutput += padding;
    }
    headerRowOutput += "\n";
    for (int idx = 0; idx < 2; idx++) {
      for (int col = 0; col < numCols; col++) {
        String middlePart = "";
        if (0 == col) {
          middlePart = String.format("      │  %-2d ", col + 1);
        } else if (col != (numCols - 1)) {
          middlePart = String.format("│  %-2d ", col + 1);
        } else {
          middlePart = String.format("│  %-2d │", col + 1);
        }
        headerRowOutput += middlePart;
      }
      headerRowOutput += padding;
    }
    headerRowOutput += "\n";
    for (int idx = 0; idx < 2; idx++) {
      for (int col = 0; col < numCols; col++) {
        String bottomPart = "";
        if (0 == col) {
          bottomPart += "┌─────┼─────";
        } else if (col != (numCols - 1)) {
          bottomPart += "┼─────";
        } else {
          bottomPart += "┼─────┤";
        }
        headerRowOutput += bottomPart;
      }
      headerRowOutput += padding;
    }
    System.out.println(headerRowOutput);

    for (int row = 0; row < numRows; row++) {
      String rowOutput = "";
      Grid grids[] = new Grid[] { opponentGrid, playerGrid };
      for (Grid grid : grids) {
        rowOutput += String.format("│  %c  ", row + 'A');
        for (int col = 0; col < numCols; col++) {
          String middlePart = "";
          Cell cell = grid.getCell(new Location(row, col));
          String cellPrintChars = "  " + cell.getPrintChar() + "  ";
          Ship gridShip = cell.getShip();
          if (null != gridShip) {
            cellPrintChars = "  " + gridShip.getName().charAt(0) + cell.getPrintChar() + " ";
          }
          if (0 == col) {
            middlePart = "│" + cellPrintChars;
          } else if (col != numCols - 1) {
            middlePart += "│" + cellPrintChars;
          } else {
            middlePart += "│" + cellPrintChars + "│";
          }
          rowOutput += middlePart;
        }
        rowOutput += padding;
      }
      rowOutput += "\n";
      for (int idx = 0; idx < 2; idx++) {
        for (int col = 0; col < numCols; col++) {
          String bottomPart = "";
          if (row != numRows - 1) {
            if (0 == col) {
              bottomPart += "├─────┼─────";
            } else if (col != numCols - 1) {
              bottomPart += "┼─────";
            } else {
              bottomPart += "┼─────┤";
            }
          } else {
            if (0 == col) {
              bottomPart += "└─────┴─────";
            } else if (col != numCols - 1) {
              bottomPart += "┴─────";
            } else {
              bottomPart += "┴─────┘";
            }
          }
          rowOutput += bottomPart;
        }
        rowOutput += padding;
      }
      System.out.println(rowOutput);
    }

    String bannerOutput = "┌" + "─".repeat(width - 2) + "┐" + padding + "┌" + "─".repeat(width - 2) + "┐";
    int maxBannerRows = Math.max(opponentBanner.size(), playerBanner.size());
    for (int idx = 0; idx < maxBannerRows; idx++) {
      if (idx < opponentBanner.size()) {
        bannerOutput += "\n│ " + opponentBanner.get(idx) + " ".repeat(width - opponentBanner.get(idx).length() - 3)
            + "│";
      } else {
        bannerOutput += "\n│ " + " ".repeat(width - 3) + "│";
      }
      if (idx < playerBanner.size()) {
        bannerOutput += padding + "│ " + playerBanner.get(idx) + " ".repeat(width - playerBanner.get(idx).length() - 3)
            + "│";
      } else {
        bannerOutput += padding + "│ " + " ".repeat(width - 3) + "│";
      }
    }
    bannerOutput += "\n└" + "─".repeat(width - 2) + "┘" + padding + "└" + "─".repeat(width - 2) + "┘";
    System.out.println(bannerOutput);
  }
}
