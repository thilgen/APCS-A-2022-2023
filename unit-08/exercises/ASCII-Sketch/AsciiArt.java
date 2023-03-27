import java.util.Scanner;
import java.util.ArrayList;

class AsciiArt {

  /*

  "ASCII art is a graphic design technique that uses computers for presentation and 
  consists of pictures pieced together from the 95 printable characters defined by 
  the ASCII Standard." - Wikipedia (https://en.wikipedia.org/wiki/ASCII_art)

  ASCII Art Archive (https://www.asciiart.eu/)

  This program allows you to load 'ASCII Art' files and 'draw' them to the console
  output.

  INSTRUCTIONS

  • Complete the Canvas class
  • Test your work

  IF YOU HAVE TIME

  • The program comes with three sample files - Try adding other files to the 
    ascii_art_files directory and 'load' and 'draw' them
  • Enhance the draw command with a transformation - e.g. 'draw <canvasName> flipped',
  • Add commands to edit and save a Canvas
  
  */
  
  private final String PROGRAM_NAME = "🎨 ASCII SKETCH 🎨";

  private boolean running = true;

  private ArrayList<Canvas> canvases = new ArrayList<Canvas>();

  public AsciiArt() {
    canvases.add(createDuckCanvas());
  }

  private Canvas createDuckCanvas() {
    Canvas canvas = new Canvas("duck", 9, 4);
    String rows[] = {
        "   __    ",
        " <(o )___",
        "  ( ._> /",
        "   `---' "
    };
    for (int rowIdx = 0; rowIdx < rows.length; rowIdx++) {
      String row = rows[rowIdx];
      for (int colIdx = 0; colIdx < row.length(); colIdx++) {
        canvas.setPixel(rowIdx, colIdx, row.charAt(colIdx));
      }
    }
    return canvas;
  }

  private void printHelp() {
    System.out.println("Available Commands:");
    System.out.println("  load <fileName>    -> loads an ascii art file from the ascii_art_files directory");
    System.out.println("  list               -> lists all the loaded canvases");
    System.out.println("  draw <canvasName>  -> draws the canvas");
    System.out.println("  help               -> print help information");
    System.out.println("  quit               -> quit the program");
  }

  private void printWelcomeBanner() {
    System.out.println("-".repeat(PROGRAM_NAME.length() + 10));
    System.out.println("     " + PROGRAM_NAME + "     ");
    System.out.println("-".repeat(PROGRAM_NAME.length() + 10));
  }

  private Canvas loadCanvas(String fileName) {
    Canvas canvas = findCanvas(fileName);
    if (null != canvas) {
      System.out.println(fileName + " is already loaded");
      return canvas;
    }
    canvas = AsciiArtFile.createCanvasFromFile(fileName);
    if (null != canvas) {
      canvases.add(canvas);
      System.out.println(fileName + " has been loaded");
    }
    return canvas;
  }

  private Canvas findCanvas(String canvasName) {
    for (Canvas canvas : canvases) {
      if (canvas.getName().equalsIgnoreCase(canvasName)) {
        return canvas;
      }
    }
    return null;
  }

  private void listCanvansas() {
    System.out.println("Loaded Canvases:");
    for (Canvas canvas : canvases) {
      System.out.println("  " + canvas.getName());
    }
  }

  private void drawCanvas(String canvasName) {
    Canvas canvas = findCanvas(canvasName);
    if (null != canvas) {
      int canvasWidth = canvas.getWidth();
      int canvasHeight = canvas.getHeight();
      for (int row = 0; row < canvasHeight; row++) {
        String rowOutput = " ";
        for (int col = 0; col < canvasWidth; col++) {
          rowOutput += canvas.getPixel(row, col);
        }
        System.out.println(rowOutput);
      }
    } else {
      System.out.println("ERROR: " + canvasName + " is not in the list of loaded canvases");
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
        loadCanvas(fileName);
      } else if (command.equals("list")) {
        listCanvansas();
      } else if (command.startsWith("draw ")) {
        String canvasName = command.substring("draw ".length());
        drawCanvas(canvasName);
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
