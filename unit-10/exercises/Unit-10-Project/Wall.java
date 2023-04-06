public class Wall extends MazeObject {
  public Wall(Game game, int x, int y) {
    super(game, x, y);
  }

  @Override
  public String getName() { return "a wall"; }

  @Override
  public boolean isOpaque() { return true; }

  @Override
  public String getImagePath() { return "wall.jpg"; }

  @Override
  public String interact() {
    String[] wallResponses = {
            "You bumped into the wall. Why?",
            "You bump into the wall. Ouch.",
            "You scrape your shin on the wall. That hurt.",
            "It is indeed a great wall.",
            "The wall is indifferent to your bumping into it."
    };
    return wallResponses[(int) (Math.random() * wallResponses.length)];
  }
}