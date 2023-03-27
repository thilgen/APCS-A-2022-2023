public class Song {
  private int trackNumber;
  private String name;
  private String artist;
  private String album;
  private String duration;

  public Song(int trackNumber, String name, String artist, String album, String duration) {
    this.trackNumber = trackNumber;
    this.name = name;
    this.artist = artist;
    this.album = album;
    this.duration = duration;
  }

  public int getTrackNumber() { return trackNumber; }
  public String getArtist() { return artist; }
  public String getAlbum() { return album; }
  public String getDuration() { return duration; }
  public String getName() { return name; }

  // TODO this class really needs a toString method...
}