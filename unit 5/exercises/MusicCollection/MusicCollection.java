import java.util.Scanner;
import java.util.HashSet;

//
// MusicCollection is a simple application for tracking your music
// collection. You know, all the physical pieces of plastic and vinyl
// that contain the music that you put into a device to play.
// (Do people still have music collections these days...? No?)
//
// TODO:
// 0. Run the app and play around with the commands, see what it does.
// 1. The songs.txt is preloaded with a bunch of Gary/Chris
//    boomer music. Add your own favorite album(s) to songs.txt.
//    The format is: trackNumber,artist,album,song,duration
// 2. Look at the Song class. Is it the right thing for all those
//    member variables to be public? See if you can improve that.
//    Perhaps there should be a constructor, and the code that
//    creates new Song instances in MusicCollection should use it.
// 3. Most of the commands are implemented, except the "songs on"
//    command which prints the songs on a particular album.
//    Implement this command.
// 4. Look at the run method in this class. Isn't it a lengthy
//    sprawling mess? What methods could you break the code out
//    into? Try to simplify the run method by moving some of
//    the code out into separate methods that are called by run.
//    See if there are any other repetitive bits you can improve
//    with the DRY (Don't Repeat Yourself) principle.
//

class MusicCollection {
  public static void main(String[] args) {
    new MusicCollection().run();
  }

  private void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to your music collection!");
    System.out.println("Type help for a list of commands.");
    while (true) {
      System.out.print('>');
      String command = scanner.nextLine();
      if (command.equals("help")) {
        System.out.println("albums: List all albums");
        System.out.println("albums by <artist>: List albums by an artist");
        System.out.println("artists: List all artists");
        System.out.println("songs: List all songs");
        System.out.println("songs by <artist>: List songs by an artist");
        System.out.println("songs on <album>: List songs on an album");
        System.out.println("quit: Exit the program");
      } else if (command.equals("quit")) {
        break;
      } else if (command.equals("songs")) {
        MusicScanner musicScanner = new MusicScanner("songs.txt");
        Song song;
        while ((song = musicScanner.next()) != null) {
          System.out.println(song);
        }
      } else if (command.startsWith("artists")) {
        MusicScanner musicScanner = new MusicScanner("songs.txt");
        Song song;
        // HashSet is a built-in Java collection class which represents
        // a set of objects. We use it here to de-duplicate the artists,
        // so each artist is printed only once.
        HashSet<String> artists = new HashSet<String>();
        boolean foundAny = false;
        while ((song = musicScanner.next()) != null) {
          if (artists.add(song.artist)) {
            System.out.println(song.artist);
            foundAny = true;
          }
        }
        if (!foundAny) {
          System.out.println("No artists found! Load some music up!");
        }
      } else if (command.equals("albums")) {
        MusicScanner musicScanner = new MusicScanner("songs.txt");
        Song song;
        // HashSet is a built-in Java collection class which represents
        // a set of objects. We use it here to de-duplicate the albums,
        // so each album is printed only once.
        HashSet<String> albums = new HashSet<String>();
        boolean foundAny = false;
        while ((song = musicScanner.next()) != null) {
          if (albums.add(song.album)) {
            System.out.println(song.album + " (by " + song.artist + ")");
            foundAny = true;
          }
        }
        if (!foundAny) {
          System.out.println("No albums found! Load some music up!");
        }
      } else if (command.startsWith("albums by ")) {
        String artist = command.substring("albums by ".length());
        System.out.println("Showing albums by " + artist + ":");
        MusicScanner musicScanner = new MusicScanner("songs.txt");
        Song song;
        // HashSet is a built-in Java collection class which represents
        // a set of objects. We use it here to de-duplicate the albums,
        // so each album is printed only once.
        HashSet<String> albums = new HashSet<String>();
        boolean foundAny = false;
        while ((song = musicScanner.next()) != null) {
          if (artist.equalsIgnoreCase(song.artist)) {
            if (albums.add(song.album)) {
              System.out.println(song.album);
              foundAny = true;
            }
          }
        }
        if (!foundAny) {
          System.out.println("No albums by that artist found.");
        }
      } else if (command.startsWith("songs by ")) {
        String artist = command.substring("songs by ".length());
        System.out.println("Showing songs by " + artist + ":");
        MusicScanner musicScanner = new MusicScanner("songs.txt");
        Song song;
        boolean foundAny = false;
        while ((song = musicScanner.next()) != null) {
          if (artist.equalsIgnoreCase(song.artist)) {
            System.out.println(song);
            foundAny = true;
          }
        }
        if (!foundAny) {
          System.out.println("No songs by that artist found.");
        }
      } else if (command.startsWith("songs on ")) {
        String album = command.substring("songs on ".length());
        // TODO You write this part!
        System.out.println("HELP IMPLEMENT ME");
      } else {
        System.out.println("I don't know that command! Type help for a list.");
      }
    }
  }
}