import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class FileScanner {
  public abstract void processRecord(String[] fields);

  public boolean processFile(String path) {
    Scanner scanner;
    try {
      scanner = new Scanner(new FileInputStream(path));
    } catch (IOException e) {
      System.out.println("Error! Could not open music file " + path);
      e.printStackTrace();
      return false;
    }

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      line = line.trim();
      if (line.length() == 0) {
        continue;
      }
      String[] fields = line.split(",");
      processRecord(fields);
    }

    scanner.close();
    return true;
  }
}