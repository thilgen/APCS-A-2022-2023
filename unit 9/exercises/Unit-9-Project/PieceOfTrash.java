public class PieceOfTrash extends Item {
  public PieceOfTrash(Game game, int x, int y) {
    super(game, x, y);
  }

  @Override
  public String interact() {
    super.interact();
    return "You picked up trash someone littered. Thanks for keeping the dungeon clean!";
  }

  @Override
  public String getImagePath() { return "piece_of_trash.jpg"; }

  @Override
  public String getName() { return "a piece of trash"; }
}
