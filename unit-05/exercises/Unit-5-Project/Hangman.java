// Unit 5 Project - Hangman
//
// Variable Requirements
// -------- ------------
// You must have variables to represent the following quantities in your
// program of the appropriate type and initial values:
// * the number of guesses the player has left
//   (for example. 5, you can choose this number)
// * the mystery word that the person is supposed to guess:
//   (for example: "potato")
// * the reveal word that shows how much of the word the user has guessed so far
//   (for example: "******", which would become "**t*t*" after the user would guess a t).
//    The reveal word should be created based on the choice of the mystery word
//    so that there are the same number of *&#39;s as letters. You can use underscores
//    instead of spaces if you like, but that tends to be harder)
// * the already guessed letters that show what letters the user has already guess
//   (for example: "", which would become "et" after the user guesses an e followed by a t)
//
// Randomness Requirement
// ---------- -----------
// You must select the word that the user is to guess randomly. Each possible word
// should be equally likely. At least one of your words MUST have a double letter.
//
// Output Requirement
// ------ -----------
// Although your output can vary, here are the basics you should have
// (although you can spruce things up however you like)
//
//   Welcome to Hangman! You have to guess the mystery word in 5 guesses or less.
//   Here's what you have so far: ******
//   You have 5 guesses left
//   Here are the letters you have guessed so far:
//   What letter would you like to guess next? t
//   Good job!
//   Here's what you have so far: **t*t*
//   You have 5 guesses left
//   Here are the letters you have guessed so far: t
//   What letter would you like to guess next? e
//   I'm sorry...
//   Here's what you have so far: **t*t*
//   You have 4 guesses left
//   Here are the letters you have guessed so far: te
//   What letter would you like to guess next? p
//   Good job!
//   Here's what you have so far: **t*t*
//   You have 4 guesses left
//   Here are the letters you have guessed so far: tep
// 
// What letter would you like to guess next? t
// You already guessed that letter! //Don't forget this case!
//
// (at the end, either congratulate or console the user)
//
// Correct Letter
// ------- ------
// When the user enters a guess, your program needs to find every place in the
// mystery word that matches the guess, and update the reveal word appropriately.
// For example:
//
//   Variables      Initial Values First guess Second guess Third guess
//   mystery word   potato
//   guess                         t           e            p
//   reveal word    ******         **t*t*      **t*t*       p*t*t*
// 
// Game Information Update
// ---- ----------- ------
// The number of guesses left should decrease when the user guesses incorrectly
// (you can decide what to do if they enter a guess that is longer than one letter,
// if they enter a repeated guess, etc). The variable holding the letters guessed
// already should be updated every time the user makes a guess.
//
// Winning vs Losing
// ------- -- ------
// The game should end either after the user has guessed the entire word or
// they have run out of guesses. In either case, they should be told the result
// of the game (win or loss). In the even that they lose, the mystery word
// should be displayed.
//

class Hangman {
  // This is called the "Singleton Pattern", and we'll be learning
  // about it shortly. It's a way of ensuring that only a single
  // instance of an object exists, when it doesn't make sense for
  // there to be more than one instance in a program. Note the
  // constructor is actually private, to ensure that the only
  // way to get a Hangman instance is Hangman.getInstance()
  private static Hangman instance = null;

  // The constructor is private to ensure that Hangman.getInstance()
  // is called to get a Hangman instance. You can add any logic
  // you want to the constructor, though.
  private Hangman() {
  }

  // Hangman.getInstance() is called to obtain the single instance
  // (the "Singleton") of the Hangman game.
  public static Hangman getInstance() {
    if (instance == null) {
      instance = new Hangman();
    }
    return instance;
  }

  // The main() method just obtains the Hangman instance from
  // getInstance() and calls the run() method, which is where
  // you should put your game logic.
  public static void main(String[] args) {
    Hangman.getInstance().run();
  }

  public void run() {
    // TODO put your main game logic in here!
    // But think about how to organize your code into methods,
    // and not have it all lumped in one big method.
    System.out.println("IMPLEMENT ME!");
  }
}