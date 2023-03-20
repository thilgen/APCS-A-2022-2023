import javax.swing.*;

//
// We've mostly printed text to the console using System.out.println.
// Many applications render their output as HTML. This program
// is incomplete, but with your help, it can generate truth tables
// for DeMorgan's Law as a HTML page that will render within repl.it.
//
// To show HTML, we accumulate the HTML that we are generating into
// a string, and then pass it to Java Swing to render in a
// JEditorPane. Notice how we construct the HTML tag by tag using
// helper methods like printHeader2, printTableColumn, etc.
// Notice how a table is constructed using tags like
//    <table>
//      <tr>
//        <th>Header #1</th>
//        <th>Header #2</th>
//      </tr>
//      <tr>
//        <td>Data #1</td>
//        <td>Data #2</td>
//      </tr>
//      ...
//    </table>
// To see how the HTML is being generated, look at HtmlGenerator.java.
// The HTML generated is logged to the console as well as rendered in
// the Output window.
//
// Exercises:
// 1. Run the program to see what its output looks like.
// 2. The first row of each table only has column headings for p and q.
//    Add two more column headings for the DeMorgan's equivalences:
//    !(p && q) <=> !p || !q
//    !(p || q) <=> !p && !q
//    Note that printTruthTable is called twice with different
//    values for "equivalence" to indicate which DeMorgan's Law
//    should be printed.
// 3. There should be four rows for each possible combination of
//    p and q, but right now, there's only one. Add the other rows.
// 4. Right now, each row of the truth table other than the header
//    only has columns for p and q. There should be 2 additional columns 
//    for !(p && q) and !p || !q (first table),
//    and !(p || q) and !p && !q (second table). Calculate the
//    values, don't hard code them!
//

public class TruthTable {
  // Constants used for enumeration are often declared "final" to
  // tell Java that they cannot change.
  private static final int NOT_P_AND_Q = 0; // !(p && q) == !p || !q
  private static final int NOT_P_OR_Q  = 1; // !(p || q) == !p && !q

  private JFrame frame;
  private HtmlGenerator html;

  public TruthTable() {
    frame = new JFrame("TruthTable");
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
    html.printHeader2("DeMorgan's Laws");

    printTruthTable(0);
    printTruthTable(1);

    System.out.println("Generated this HTML:");
    System.out.println(html.getHTML());
  }

  private void printTruthTableRow(int equivalence, boolean p, boolean q) {
    html.startTableRow();
    html.printTableColumn(p);
    html.printTableColumn(q);
    html.endTableRow();
  }

  private void printTruthTableHeader(int equivalence) {
    html.startTableRow();
    html.printTableHeader("p");
    html.printTableHeader("q");
    html.endTableRow();
  }

  private void printTruthTable(int equivalence) {
    if (equivalence == NOT_P_AND_Q) {
      html.printHeader3("!(p && q) is equivalent to !p || !q");
    } else if (equivalence == NOT_P_OR_Q) {
      html.printHeader3("!(p || q) is equivalent to !p && !q");
    } else {
      System.out.println("printTruthTable: Inalid equivalence value!");
      return;
    }

    html.startTable();
    printTruthTableHeader(equivalence);
    printTruthTableRow(equivalence, false, false);
    html.endTable();
  }
}