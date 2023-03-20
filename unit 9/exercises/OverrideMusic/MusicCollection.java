//
// This is a simplified version of the Music Collection exercise we did
// several units ago. Instead of scanning the songs file over and over
// again, we want to load all of the songs into memory as an ArrayList.
//
// The class FileScanner is an *abstract* class. That means you can't
// "new" it, because it's incomplete... it declares *abstract* methods
// that have no method body, and MUST be overridden in a subclass to
// work.
//
// - Write a subclass of FileScanner called MusicScanner which defines
//   the abstract method processRecord. The processRecord method should decode
//   the fields in songs.txt, create a new Song object, and add it to
//   an ArrayList. Return the ArrayList so MusicCollection can get it.
//
// - In MusicCollection, use the new MusicScanner class to scan in
//   songs.txt and populate the ArrayList of songs.
//
// - Implement the toString() method in the Song class
//   so that the output of the "songs" command is reasonable.
//
// - Look at how the "artists" command has been implemented by subclassing
//   the Query class. Write your own Query subclass to implement the'
//   "albums" command.
//
// - If you have time: Implement any other commands you think might
//   be useful.
//

import java.util.Scanner;
import java.util.ArrayList;

class MusicCollection {
  private ArrayList<Song> songs = new ArrayList<Song>();

  public static void main(String[] args) {
    new MusicCollection().run();
  }

  private void loadSongs() {
    // TODO implement me using the new MusicScanner class
    System.out.println("TODO you need to implement loadSongs to load the songs!");
  }

  private void songs() {
    for (Song song : songs) {
      System.out.println(song);
    }
  }

  private void artists() {
    new ArtistsQuery().execute(songs);
  }

  private void albums() {
    // TODO
    System.out.println("TODO implement me!");
  }

  private void run() {
    loadSongs();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to your music collection!");
    System.out.println("Type help for a list of commands.");
    while (true) {
      System.out.print('>');
      String command = scanner.nextLine();
      if (command.equals("help")) {
        System.out.println("songs: List all songs");
        System.out.println("artists: List all artists");
        System.out.println("albums: List all albums");
        System.out.println("songs: List all songs");
        System.out.println("quit: Exit the program");
      } else if (command.equals("quit")) {
        break;
      } else if (command.equals("songs")) {
        songs();
      } else if (command.equals("artists")) {
        artists();
      } else if (command.equals("albums")) {
        albums();
      } else {
        System.out.println("I don't know that command! Type help for a list.");
      }
    }
  }
}