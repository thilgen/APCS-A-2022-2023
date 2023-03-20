/*

    INSTRUCTIONS

    1. Review the file system functions defined in FSIterative and run the 
       program to observer how the validation works.

    2. Add recursive versions of the FSIterative functions ito the FSRecursive
       file and run the program to verify your results.

    NOTE: Each time it is run the program creates a file system with a random 
       number of files and folders

*/

class Main {
  public static void main(String[] args) {
    new Main().run();
  }

  public void run() {
    Folder root = FSUtil.createFS();
    validateFileNames(root);
    validateFolderNames(root);
    validateFilePaths(root);
    System.out.println();
  }

  private void printResults(String[] results, String message) {
    System.out.println("\n-----------------------------------");
    System.out.println(message);
    System.out.println("-----------------------------------");
    for (String str : results) {
      System.out.println("  " + str);
    }
    System.out.println("-----------------------------------");
  }

  private void printCompareResults(boolean bValidated) {
    System.out.println(String.format("  Validated: ** %b **", bValidated));
    System.out.println("-----------------------------------");
  }

  private void validateFileNames(Folder root) {
    String[] fileNamesExpected = FSUtil.getFileNames();
    printResults(fileNamesExpected, "File Names Expected");

    String[] fileNamesDiscoveredNonRecursive = FSIterative.getFileNames(root);
    printResults(fileNamesDiscoveredNonRecursive, "File Names Discovered Non-Recursive");
    printCompareResults(FSUtil.validateDiscoveredFileNames(fileNamesDiscoveredNonRecursive));

    String[] fileNamesDiscoveredRecursive = FSRecursive.getFileNames(root);
    printResults(fileNamesDiscoveredRecursive, "File Names Discovered Recursive");
    printCompareResults(FSUtil.validateDiscoveredFileNames(fileNamesDiscoveredRecursive));
  }

  private void validateFolderNames(Folder root) {
    String[] folderNamesExpected = FSUtil.getFolderNames();
    printResults(folderNamesExpected, "Folder Names Expected");

    String[] folderNamesDiscoveredNonRecursive = FSIterative.getFolderNames(root);
    printResults(folderNamesDiscoveredNonRecursive, "Folder Names Discovered Non-Recursive");
    printCompareResults(FSUtil.validateDiscoveredFolderNames(folderNamesDiscoveredNonRecursive));

    String[] folderNamesDiscoveredRecursive = FSRecursive.getFolderNames(root);
    printResults(folderNamesDiscoveredRecursive, "Folder Names Discovered Recursive");
    printCompareResults(FSUtil.validateDiscoveredFolderNames(folderNamesDiscoveredRecursive));
  }

  private void validateFilePaths(Folder root) {
    String[] filePathsExpected = FSUtil.getFilePaths();
    printResults(filePathsExpected, "File Paths Expected");

    String[] filePathsDiscoveredNonRecursive = FSIterative.getFilePaths(root);
    printResults(filePathsDiscoveredNonRecursive, "File Paths Discovered Non-Recursive");
    printCompareResults(FSUtil.validateDiscoveredFilePaths(filePathsDiscoveredNonRecursive));

    String[] filePathsDiscoveredRecursive = FSRecursive.getFilePaths(root);
    printResults(filePathsDiscoveredRecursive, "File Paths Discovered Recursive");
    printCompareResults(FSUtil.validateDiscoveredFilePaths(filePathsDiscoveredRecursive));
  }    
}