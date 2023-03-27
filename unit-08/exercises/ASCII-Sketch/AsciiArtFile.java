import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class AsciiArtFile {

  static public Canvas createCanvasFromFile(String fileName) {
    Canvas newCanvas = null;
    String filePath = "ascii_art_files/" + fileName;
    try {
      int canvasDimensions[] = calculateCanvasDimensions(filePath);
      int canvasWidth = canvasDimensions[0];
      int canvasHeight = canvasDimensions[1];
      newCanvas = new Canvas(fileName, canvasWidth, canvasHeight);
      copyFileToCanvas(filePath, newCanvas);
    } catch (IOException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
    return newCanvas;
  }

  static private int[] calculateCanvasDimensions(String filePath) throws IOException {
    int canvasHeight = 0;
    int canvasWidth = 0;
    Scanner scanner = new Scanner(new FileInputStream(new File(filePath)));
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      canvasWidth = Math.max(canvasWidth, line.length());
      canvasHeight++;
    }
    scanner.close();
    int canvasDimensions[] = new int[] { canvasWidth, canvasHeight };
    return canvasDimensions;
  }

  static private void copyFileToCanvas(String filePath, Canvas canvas) throws IOException {
    Scanner scanner = new Scanner(new FileInputStream(new File(filePath)));
    for (int row = 0; scanner.hasNextLine(); row++) {
      String line = scanner.nextLine();
      int col = 0;
      for (int idx = 0; idx < line.length(); idx++) {
        canvas.setPixel(row, col++, line.charAt(idx));
      }
      // pad out the remainder of the line with spaces
      for (int idx = line.length(); idx < canvas.getWidth(); idx++) {
        canvas.setPixel(row, col++, ' ');
      }
    }
    scanner.close();
  }
}
