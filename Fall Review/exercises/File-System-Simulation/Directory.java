/*
 * Create a class (Directory) that represents a directory in the file system
 *
 *  TODO: A Directory should have a name
 *
 *  TODO: A Directory should know its parent Directory (the topmost Directory 
 *        should report that its parent Directory is null)
 * 
 *  TODO: A Directory should know the Directories (the children) that it contains
 * 
 *  TODO: A Directory should know the Files (the children) that it contains
 */

class Directory {

  private Directory parentDirectory;

  public Directory(Directory parentDirectory, String directoryName) {
    
  }

  public void addDirectory(String directoryName) {
    if (directoryExists(directoryName)) {
      System.out.println("Directory already exists");
    } else {
      /*
       * TODO: Create a new Directory and add to the list of known
       *       Directories (growing the data struture as needed)
       */
    }
  }

  public void addFile(String fileName, int fileSize) {
    if (fileExists(fileName)) {
      System.out.println("File already exists");
    } else {
      /*
       * TODO: Create a new File and add to the list of known
       *       Directories (growing the data struture as needed)
       */
    }
  }

  private boolean directoryExists(String directoryName) {
    /*
     * TODO: Return true if the directoryName already exists in the 
     *       list of known Directories (children); else return false
     */
    return false;
  }

  private boolean fileExists(String fileName) {
    /*
     * TODO: Return true if the fileName already exists in the 
     *       list of known Files (children); else return false
     */
    return false;
  }

  public Directory getDirectory(String directoryName) {
    /*
     * TODO: Return the known Directory that matches directoryName;
     *       else return null
     */
    return null;
  }

  public void printDirectoryContents() {
    /*
     * TODO: Print a summary of the contents of the current Directory; should include
     *       the full path of the current Directory followed by all the known child
     *       Directories and Files. Use any order that you want, but it should be obvious
     *       in your output what is a Directory and what is a File.
     *
     *       Example
     *         
     *         Contents of /root/d2/
     *           <d4>
     *           <d5>
     *           t7.txt        800 bytes
     *           t8.txt        900 bytes
     *           t9.txt        1000 bytes
     */    
  }
  
  public String getDirectoryPath() {
    /*
     * TODO: Return a String that describes the full path to this Directory
     *       else return null
     *
     *       Examples: "/root/", "/root/d1/", "/root/d1/d2/d3/"
     */
    return "";
  }

  public Directory getParentDirectory() {
    return parentDirectory;
  }
}
