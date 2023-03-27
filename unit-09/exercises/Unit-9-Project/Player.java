import java.util.ArrayList;

public class Player extends MazeObject {
  private ArrayList<Item> inventory = new ArrayList<Item>();

  public Player(Game game, int x, int y) {
    super(game, x, y);
    game.setPlayer(this);
  }

  @Override
  public boolean moveTo(int x, int y) {
    Maze maze = getGame().getMaze();
    if (!maze.isValidLocation(x, y)) {
      getGame().gameOver(true);
      return true;
    }
    return super.moveTo(x, y);
  }

  public String interactBy(int deltaX, int deltaY) {
    int targetX = getX() + deltaX;
    int targetY = getY() + deltaY;
    Maze maze = getGame().getMaze();

    MazeObject targetMazeObject = maze.getMazeObjectAt(targetX, targetY);
    if (targetMazeObject == null) {
      return null;
    }
    return targetMazeObject.interact();
  }

  public void pickupItem(Item item) {
    inventory.add(item);
  }

  @Override
  public String getImagePath() { return "player.png"; }

  @Override
  public String getName() { return "you"; }
}
