import java.io.*;

//
// The Thank You Machine automates one of the tedious, time-consuming
// tasks of modern life: Writing heartfelt "thank you" notes to all
// the friends and family who gave you gifts for your birthday.
//
// Simply provide contact information and the gifts they gave you
// as an input text file, and provide template text using our
// special placeholder syntax. Thank You Machine will do the rest,
// and rapidly generate ready-to-print letters as individual text
// files.
//

class Main {
  public static void main(String[] args) throws IOException {
    File outputDirectory = new File("output");
    if (!outputDirectory.exists()) {
      outputDirectory.mkdir();
    } else if (!outputDirectory.isDirectory()) {
      System.out.println("output should be a directory!");
      return;
    }

    MailingList mailingList = new MailingList();
    Template template = new Template(new File("template.txt"));

    // TODO Write a loop that iterates through the MailingList
    // object for each GiftGiver that it contains.
    // For each GiftGiver, invoke Template.generateOutputFile
    // to generate a thank you note for that person.

    // See also the TODOs in MailingList.java and Template.java
  }
}