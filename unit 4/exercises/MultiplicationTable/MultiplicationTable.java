import javax.swing.*;

//
// Exercise:
// Using nested loops, display a multiplication table that
// goes from 1*1 to 10*10.
//
// The multiplication table will be rendered using HTML,
// like the DeMorgan's Law Truth Table exercise. The provided
// HtmlGenerator class will be familiar from that earlier exercise.
//
// One change is that the method printTruthTableColumn now
// accepts a second parameter, cssClass, which is the "class name"
// in a different language: Cascading Style Sheets (CSS).
// CSS is how most web pages are "styled," that is, given their
// fonts and colors and layout.
//
// The cssClass parameter tells the built-in HTML browser how
// to nicely format the table cell.
// The CSS classes that can be used are defined in the file
// MultiplicationTable.css. They are named "leftSide", "topSide",
// and "cell". Try passing these strings as the cssClass parameter.
//
// Remember that to be easy to read, the multiplication table
// should have a top row of numbers 1 - 10, and a leftmost column
// of numbers 1 - 10, so that the user can easily locate the
// product they want. The top-left corner should just be a blank cell.
//
// To change the colors used, you can edit the file
// MultiplicationTable.css. The colors are specified as
// hexadecimal numbers #RRGGBB where RR, GG, and BB are the
// red, green, and blue color components.
// You can use an online color code chart to find colors you like:
// https://htmlcolorcodes.com/es/tabla-de-colores/
// Then modify the colors in the MultiplicationTable.css file.
//

public class MultiplicationTable {
  private JFrame frame;
  private HtmlGenerator html;

  public static void main(String args[]) {
    new MultiplicationTable();
  }

  public MultiplicationTable() {
    frame = new JFrame("MultiplicationTable");
    frame.setSize(800, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JEditorPane editorPane = new JEditorPane();
    editorPane.setEditable(false);

    generateHTML();

    editorPane.setContentType("text/html");
    editorPane.setText(html.getHTML());

    frame.add(editorPane);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  private void generateHTML() {
    html = new HtmlGenerator();
    html.printHeader2("Multiplication Table");

    printMultiplicationTable(10, 10);

    System.out.println("Generated this HTML:");
    System.out.println(html.getHTML());
  }

  private void printMultiplicationTable(int rows, int cols) {
    // TODO Add your code to print the multiplication table with
    // the specified numbers of rows and columns.
    // Start by calling html.startTable.
    // For each row, use html.startTableRow, then call
    // html.printTableColumn, and then html.endTableRow to finish the row.
    // Then call html.endTable to complete the entire table.
  }
}