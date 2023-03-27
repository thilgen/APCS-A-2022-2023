public class Song {
  public int trackNumber;
  public String name;
  public String artist;
  public String album;
  public String duration;

  public String toString() {
    return String.format("%d. %s (%s) [artist: %s, album: %s]",
                         trackNumber, name, duration, artist, album);
  }
}