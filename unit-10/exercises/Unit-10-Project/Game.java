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
// What's going on? It's the same Maze game from the Unit 9 Project!
//
// It's the same codebase. However, this time, your mission is quite different.
// You'll be adding "cheat" functionality that shows the player how to get out of
// the maze.
//
// There is now an "Escape Mode" in the game which is toggled on/off by pressing the
// Escape (ESC) key. When Escape Mode is on, the method plotEscapePath() will be
// called whenever the player moves to draw the path out of the maze. The problem?
// Right now, plotEscapePath() does nothing. You'll be implementing it!
//
// Since our focus is on solving the maze this time, the "darkness" has been turned
// off, and now you can see the entire maze.
//
// Rubric:
//
// 1. Customize the graphics for the maze again. You can simply copy over your graphics
//    from the Unit 9 Project, or you can pick new graphics. (10 points)
//
// 2. Your maze-solving algorithm should be demonstrated on more than one maze.
//    Create at least five mazes. You can name them maze1.txt, maze2.txt, etc.
//    Make mazes of varying sizes, and make some big to really test your
//    algorithm, like 50 x 50.
//    Like last time, you can make your own mazes by hand, or you can use a maze
//     generator such as https://www.dcode.fr/maze-generator
//    (Again, if you use that maze generator, select Single Character display,
//     not Square, for best results, and make sure you specify # as the wall character.)
//    Remember to place the player "P" somewhere in each maze. You can leave the little
//    dog out if you want.
//    (10 points)
//
// 3. Make it possible to switch between the mazes. The game should start on maze #1.
//    Handle the key presses 1, 2, 3, 4, 5. Pressing one of these keys should switch
//    to a different maze. (You can force the game to restart by calling the play()
//    method, but you'll need to modify where the maze is loaded to load the right
//    maze file.)
//    (10 points)
//
// 4. Implement the maze solving algorithm. This is probably a method of class Game,
//    say one named findEscapePath().
//    Hints for how to structure your algorithm are given below. Partial credit will
//    be given for partially working algorithms, but take care that your code compiles,
//    and that the game doesn't crash or hang. (40 points)
//    
// 5. In the method plotEscapePath(), plot the path out of the maze that was found by
//    your algorithm. There is already code in MazeView for highlighting cells with
//    translucent yellow. plotEscapePath() is already called every time the player
//    moves, and when Escape mode is turned on/off. (20 points)
//
// 6. Your maze solving algorithm should be optimal, that is, it should find not only
//    a path out of the maze, but the minimum length path out of the maze.
//    Your algorithm should not stop as soon as it finds a path out of the maze,
//    but should compare all possible paths out of the maze and pick one that has
//    minimum length. (10 points)
//
// Algorithm Hints:
//
// Finding the path out of a maze is a good use case for _depth-first search_.
// The moves to get out of the maze can be thought of as a "decision tree" that
// needs to be searched. Each branch in the tree is a move, either north/south/east/west.
//
// Each node in the tree is a (x, y) location in the maze. The goal of the algorithm
// is to find nodes for which (x, y) is not a valid location in the maze, i.e. is 
// outside the maze meaning the player has escaped.
//
// This can be expressed using a recursive algorithm. Here, FindEscapePath takes
// a maze location as input, which represents the player's location. It also takes
// a Path, which has all the cell locations that have been visited by the player
// since they started this escape attempt:
//
//   Path findEscapePath(int x, int y, Path previousSteps);
//
// findEscapePath is tasked with returning either an escape path where the first steps
// are the path previousSteps and including the cell (x, y), or null if no path out could
// be found.
//
// Part of why findEscapePath needs to know previousSteps is because it should never
// backtrack over any of the steps in previousSteps.
//
// Path findEscapePath(int x, int y, Path previousSteps)
//   BASE CASES:
//
//   If (x, y) is not a valid maze location:
//     We've escaped the maze! Return previousSteps + (x, y) as a valid escape path.
//
//   If (x, y) is a Wall:
//     We're blocked, we can't go this way. Return null, meaning no path found.
//
//   If (x, y) has been visited already in previousSteps:
//     We must not back track, so return null, meaning no path found.
//     (Path.contains may be helpful for this.)
//
//   RECURSIVE CASE:
//   Otherwise, try each direction North/South/East/West:
//     Essentially, deltas (0, -1), (0, 1), (1, 0), (-1, 0).
//     For each direction:
//       Call findEscapePath(x', y', previousSteps + (x, y)) recursively
//       If findEscapePath() returns an escape path, save it away.
//     Evaluate all the paths found by recursively calling findEscapePath(),
//     and return one with the shortest length, or null if none were found.
//
// You can write your algorithm whatever way you like, but you may find the Path class
// in Path.java helpful. This is a linked list which can be used to track a Path
// through the maze, and can efficiently add a new step to an existing Path.
// Path is immutable so it can be passed through the different levels of recursion
// without worrying about it being modified.
//
// PLOTTING THE ESCAPE PATH:
//
// To plot (draw) the escape path, there is already code in MazeView for highlighting
// cells in translucent yellow. The Maze object keeps track of what cells are highlighted.
// Every time you want to plot your escape path, you should first call
// maze.clearHighlighting() to blank out any previously drawn escape path.
// Then, call maze.highlight(x, y) for each cell that is part of the escape path.
// (Only do this if the boolean "escapeMode" is set, since the player may want to figure
//  the path out on their own!)
//
// The game code already calls plotEscapePath() when Escape mode is toggled on/off,
// or when the player moves. The game code also calls mazeView.repaint() which repaints
// the maze including any yellow highlighting, all you should need to do is call
// maze.clearHighlighting() and maze.highlight(x, y) appropriately.
//

public class Game implements KeyListener, ActionListener {
  private JFrame frame;
  private JLabel statusLine;
  private Maze maze;
  private MazeView mazeView;
  private Player player;
  private Timer timer;

  private static final int NORMAL_KEY_STATE = 0;
  private static final int CONFIRM_QUIT_STATE = 1;
  private static final int GAME_OVER_KEY_STATE = 2;

  private int keyState = NORMAL_KEY_STATE;
  private boolean playing = false;
  private boolean escapeMode = false;

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

  private void toggleEscapeMode() {
    escapeMode = !escapeMode;
    if (escapeMode) {
      statusLine.setText("Escape mode ON. Follow the yellow path to get out of the maze!");
    } else {
      statusLine.setText("Escape mode OFF. Find the way out yourself!");
    }
    plotEscapePath();
    mazeView.repaint();
  }

  public boolean getEscapeMode() {
    return escapeMode;
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
    plotEscapePath();
    mazeView.repaint();
  }

  private void plotEscapePath() {
    // TODO PUT YOUR IMPLEMENTATION HERE
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
      if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_H) {
        movePlayerBy(-1, 0);
      } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_L) {
        movePlayerBy(1, 0);
      } else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_K) {
        movePlayerBy(0, -1);
      } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_J) {
        movePlayerBy(0, 1);
      } else if (keyCode == KeyEvent.VK_ESCAPE) {
        toggleEscapeMode();
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
    escapeMode = false;

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

  public Maze getMaze() {
    return maze;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    if (this.player != null) {
      throw new RuntimeException("Error: There can be only one Player in the maze");
    }
    this.player = player;
  }
}
