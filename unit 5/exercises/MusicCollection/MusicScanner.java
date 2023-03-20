import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class MusicScanner {
  private Scanner scanner;

  public MusicScanner(String path) {
    try {
      scanner = new Scanner(new FileInputStream(path));
    } catch (IOException e) {
      System.out.println("Error! Could not open music file " + path);
      e.printStackTrace();
    }
  }

  public Song next() {
    if (scanner == null) {
      // We weren't able to open the music file.
      return null;
    }
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      line = line.trim();
      if (line.length() == 0) {
        continue;
      }
      String[] fields = line.split(",");
      Song song = new Song();
      song.trackNumber = Integer.parseInt(fields[0]);
      song.artist = fields[1];
      song.album = fields[2];
      song.name = fields[3];
      song.duration = fields[4];
      return song;      
    }
    return null;
  }
}