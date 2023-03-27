public abstract class Item extends MazeObject {
  protected Item(Game game, int x, int y) {
    super(game, x, y);
  }

  @Override
  public String interact() {
    getGame().getPlayer().pickupItem(this);
    getGame().getMaze().setMazeObjectAt(getX(), getY(), null);
    return "You picked up " + getName();
  }

  public abstract String getName();
}