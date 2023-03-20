import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

//
// Instructions:
//
// Out of the box, this is a working maze game, similar to a classic '80s game
// called Rogue.
//
// This game uses the Java Swing library to display graphics and accept keyboard
// input. Instead of printing output with System.out.println and reading from
// the keyboard with a Scanner, this displays a GUI (Graphical User Interface).
//
// GUI interfaces are most desktop and mobile applications. GUI applications
// are usually "event-driven", that is, they react to events like a timer going
// off, or a key being pressed, or an event saying to draw (paint).
//
// The maze is specified by a text file, maze.txt.
// The player is represented by the letter P.
// The player can only see a few spaces around them, so more of the maze is
// revealed as the player moves around. A little dog (represented by the letter
// "d" in maze.txt) follows the player as best it can.
//
// First, play the game and familiarize yourself with it. Make sure you
// click on the Output window to give it focus. Then use the arrow keys to
// navigate the maze. The exit to the stock maze is on the bottom right.
//
// Rubric:
//
// 1. Make your own maze! Edit the file maze.txt. You can make your own yourself,
//    or you can use a maze generator such as https://www.dcode.fr/maze-generator
//    (If you use that maze generator, select Single Character display, not Square,
//     for best results, and make sure you specify # as the wall character.)
//    Any size maze is supported, but don't make it too big because I have to play it!
//    15x15 or 20x20 is probably a decent size, although you can go smaller too.
//    Once you've generated or drawn a maze.txt, make sure you place the player, by
//    putting a capital P somewhere. To place the little dog, put a lowercase d.
//    When editing maze.txt, you may find it helpful to press the INSERT key on
//    the keyboard to enter Overwrite mode. (10 points)
//
// 2. "Re-skin" the maze graphics! Replace the original images wall.jpg, player.png,
//    etc. with images of your own choice. You can find images on the Internet, such
//    as using the Image search option on Google. If you like drawing, you could use
//    an online drawing tool such as https://jspaint.app, or even draw with pen and
//    paper and take a picture with a phone. You will probably need to save the image
//    file to the local computer and then use the Upload File button in replit.
//    Many image formats will work, but .jpg/.jpeg and .png are definitely supported.
//    IMPORTANT: Your images should be roughly square dimensions, and not be super high
//    resolution. If the images are too high-resolution, the game will run slow.
//    You can use a website like https://simpleimageresizer.com to reduce the size of
//    your images. (10 points)
//
// 3. Gamers often prefer using W (up), A (left), S (down), D (right) keys to
//    the arrow keys for movement. Look at the keyPressed method in Game.java
//    and enhance it to support WASD as well as the arrow keys. The key codes
//    for WASD start with VK_ for Virtual Key, e.g. VK_W, VK_A, VK_S, VK_D.
//    Another popular set of movement keys is H (left), J (down), K (up), and
//    L (right)... you could choose to support those as well.
//    (10 points)
//
// 4. Add a new MazeObject subclass which is a monster/creature of some kind that will
//    chase the player. Register it with the MazeObjectFactory. You will need to supply
//    an image file, just like you did in Step 2. Upload your image file to replit and
//    override the getImagePath method in your subclass to return the
//    filename of the image. Add some instances of your creature subclass to maze.txt in
//    different parts of your maze. You can make multiple classes of creature if you want,
//    but only one is required. (10 points)
//
// 5. Make the creatures move when the game invokes the "tick" method. look at the logic in
//    Dog.java for inspiration. You will need to override the tick method. (10 points)
//
// 6. The Item abstract class can be subclassed to put items in the game.
//    The way items behave in this game is that you pick them up by running
//    over them.
//    The only item that comes out of the box is PieceOfTrash, which is trash
//    spread around the maze which you can pick up as an (uncredited) good deed.
//    Add your own Item subclass which has more in-game significance, like
//    a key to unlock the door out of the maze. You'll need to find another
//    image file to represent the item, and upload it into the replit. Place
//    your item(s) around the maze. (10 points)
//
// 7. The game needs a way for the player to lose! If the player bumps into one
//    of the creatures or is bumped by it, the player should lose and the game
//    should end. The game can be ended by invoking the gameOver method of the
//    Game object. (20 points)
//
// 8. The game needs a better way to win! Currently, the player wins the game by
//    finding the exit of the maze and walking out. Make it a little harder to
//    win the game... but you can decide how you want the game to be won.
//    One idea is spread some items around the maze, and the user must collect
//    all of them to unlock the way out. Note how the Player class overrides the
//    moveTo method and ends the game if the player moves off the map.
//    Change that to block them unless your winning criteria have been met.
//    (20 points)
//

public class Game implements KeyListener, ActionListener {
  private JFrame frame;
  private JLabel statusLine;
  private Maze maze;
  private MazeView mazeView;
  private Player player;
  private Timer timer;

  private static final int NORMAL_KEY_STATE    = 0;
  private static final int CONFIRM_QUIT_STATE  = 1;
  private static final int GAME_OVER_KEY_STATE = 2;

  private int keyState = NORMAL_KEY_STATE;
  private boolean playing = false;

  public Game() {
    maze = new Maze(this);

    statusLine = new JLabel();
    statusLine.setFont(new Font("Serif", Font.PLAIN, 24));
    statusLine.setText("Welcome to ElCoRogue!");

    mazeView = new MazeView(maze);

    frame = new JFrame("Maze");
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(mazeView, BorderLayout.CENTER);
    frame.getContentPane().add(statusLine, BorderLayout.NORTH);
    frame.addKeyListener(this);
    frame.setSize(800, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setVisible(true);

    timer = new Timer(250, this);
    timer.start();
  }

  private void movePlayerBy(int deltaX, int deltaY) {
    String interaction = player.interactBy(deltaX, deltaY);
    if (interaction != null) {
      statusLine.setText(interaction);
    } else {
      resetStatusLine();
    }

    // Attempt to move in the direction
    player.moveBy(deltaX, deltaY);

    // Light the maze around the player and scroll if needed
    maze.illuminate(player.getX(), player.getY());
    mazeView.scrollTo(player.getX(), player.getY());
    mazeView.repaint();
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    if (playing) {
      maze.tick();
      mazeView.repaint();
    }
  }

  @Override
  public void keyPressed(KeyEvent event) {
    int keyCode = event.getKeyCode();
    if (keyState == NORMAL_KEY_STATE) {
      if (keyCode == KeyEvent.VK_LEFT) {
        movePlayerBy(-1, 0);
      } else if (keyCode == KeyEvent.VK_RIGHT) {
        movePlayerBy(1, 0);
      } else if (keyCode == KeyEvent.VK_UP) {
        movePlayerBy(0, -1);
      } else if (keyCode == KeyEvent.VK_DOWN) {
        movePlayerBy(0, 1);
      } else if (keyCode == KeyEvent.VK_Q) {
        keyState = CONFIRM_QUIT_STATE;
        statusLine.setText("Are you sure you want to quit? (Y/N)");
      }
    } else if (keyState == CONFIRM_QUIT_STATE) {
      if (keyCode == KeyEvent.VK_Y) {
        quit();
      } else {
        keyState = NORMAL_KEY_STATE;
        resetStatusLine();
      }
    } else if (keyState == GAME_OVER_KEY_STATE) {
      if (keyCode == KeyEvent.VK_N) {
        quit();
      } else if (keyCode == KeyEvent.VK_Y) {
        play();
        keyState = NORMAL_KEY_STATE;
        resetStatusLine();
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent event) {
  }

  @Override
  public void keyReleased(KeyEvent event) {
  }

  public void resetStatusLine() {
    // We use a single space to keep the status line from disappearing.
    statusLine.setText(" ");
  }

  public void gameOver(boolean winner) {
    if (winner) {
      statusLine.setText("You win, you escaped the maze! Play again? Y/N");
    } else {
      statusLine.setText("Sorry, you died! Play again? Y/N");
    }
    keyState = GAME_OVER_KEY_STATE;
    playing = false;
  }

  private void quit() {
    timer.stop();
    timer = null;

    frame.dispose();
    frame = null;

    System.exit(0);
  }

  public void play() {
    player = null;

    try {
      maze.loadMaze("maze.txt");
    } catch (IOException e) {
      System.out.println("Error loading maze!");      
      e.printStackTrace();
      return;
    }

    if (player == null) {
      throw new RuntimeException("Your maze.txt must have a P for Player somewhere");
    }
    maze.illuminate(player.getX(), player.getY());

    mazeView.center(player.getX(), player.getY());

    playing = true;
  }

  public Maze getMaze() { return maze; }
  public Player getPlayer() { return player; }

  public void setPlayer(Player player) {
    if (this.player != null) {
      throw new RuntimeException("Error: There can be only one Player in the maze");
    }
    this.player = player;
  }
}