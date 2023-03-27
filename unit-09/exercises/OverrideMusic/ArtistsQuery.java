public class ArtistsQuery extends Query {
  public String extractField(Song song) { return song.getArtist(); }
}