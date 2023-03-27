public class Dog extends MazeObject {
  public Dog(Game game, int x, int y) {
    super(game, x, y);
  }

  @Override
  public void tick() {
    if (Math.random() < 0.5) {
      // Follow the player
      Player player = getGame().getPlayer();
      boolean moved = false;
      if (getX() < player.getX()) {
        moved = moveBy(1, 0);
      }
      if (!moved && getX() > player.getX()) {
        moved = moveBy(-1, 0);
      }
      if (!moved && getY() < player.getY()) {
        moved = moveBy(0, 1);
      }
      if (!moved && getY() > player.getY()) {
        moved = moveBy(0, -1);
      }
      if (!moved) {
        // Try up to 4x to move in a random direction
        int deltas[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i=0; i<4; i++) {
          int direction = (int) (Math.random() * deltas.length);
          if (moveBy(deltas[direction][0], deltas[direction][1])) {
            break;
          }
        }
      }
    }
  }

  @Override
  public String getName() { return "a little dog"; }

  @Override
  public String interact() {
    String[] dogResponses = {
            "The little dog wags its tail.",
            "Woof!",
            "The little dog barks supportively.",
            "You pet the little dog."
    };
    return dogResponses[(int) (Math.random() * dogResponses.length)];
  }

  @Override
  public String getImagePath() { return "dog.png"; }
}