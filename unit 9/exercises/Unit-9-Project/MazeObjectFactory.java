//
// MazeObjectFactory maps a character in maze.txt to the right class of MazeObject.
// When you create a new subclass of MazeObject, you must register it here with
// a unique char. Whenever that char is seen in maze.txt, the registered class
// will be instantiated.
//
public class MazeObjectFactory {
  public static MazeObject newMazeObject(Game game, char ch, int x, int y) {
    // The switch statement is an alternative to a chain of if-else statements.
    switch (ch) {
      case ' ':
        return null;
      case '#':
        return new Wall(game, x, y);
      case 'P':
        return new Player(game, x, y);
      case 'd':
        return new Dog(game, x, y);
      case '%':
        return new PieceOfTrash(game, x, y);
      default:
        throw new RuntimeException("No MazeObject subclass registered for char '" + ch + "'");
    }
  }
}
