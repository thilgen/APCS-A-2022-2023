//
// This is an incomplete implementation of the game
// "Two Truths and a Lie."
// The user will be prompted for three statements about themselves,
// two truths and one lie.
// The computer will then guess which statement is the lie.
// If the computer is wrong, it should make another guess.
//
// This game is built using a design pattern called Model-View-Controller,
// or MVC. (https://en.wikipedia.org/wiki/Model-view-controller)
// This is a very popular pattern used by many frameworks
// used to build Web sites and mobile and desktop applications.
// All of the state (variables) of the game and the game logic
// are in the TruthGameModel class, which you will be implementing.
//
// The TruthGameModel class is not finished, but it comes with
// a test suite, TruthGameModelTest, which will verify that it is
// correctly implemented. This test suite will run automatically
// when the program starts, and the game won't run until the self-test
// passes.
//
// The TruthGameViewController class is responsible for the
// view and controller parts of the MVC pattern, that is, the input
// and output interaction with the user. It is already complete and
// you won't need to modify it. (But you can if you want to!)
//
// Exercises:
// All of your work wil be in the TruthGameModel.java file.
// 1. Implement all of the methods marked TODO in TruthGameModel.java.
//    You can run the program at any time to see if you have
//    correctly implemented it. If you haven't implemented all of
//    the methods correctly, the self test will fail and terminate
//    the game.
//
// 2. Once the self test passes, verify for yourself that the game
//    plays correctly!
//
class Main {
  public static void main(String[] args) {
    if (new TruthGameModelTest().runTests()) {
      new TruthGameViewController().play();
    }
  }
}