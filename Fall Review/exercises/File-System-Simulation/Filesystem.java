/*
 * Let's build an interactive file system simulator!
 * 
 * BACKGROUND
 * 
 * A file system is composed of files and directories (folders).
 *
 * Files
 *   Have a size
 *   Have a name
 *   The file name must be unique compared to other files in the same directory
 *
 * Directories
 *   Can contain files and other directories
 *   Have a name
 *   The directory name must be unique compared to other directories in the same directory
 *
 * EXERCISE
 *
 * Build a command line tool that allows for the following commands
 *
 * dir
 *   Print the contents of the current directory
 *
 * mkdir <directory name>
 *   Create a new directory with the name <directory name>; Fail if a directory 
 *   named <directory name> already exists in the current directory
 *
 * mkfile <file name> <file size>
 *   Create a new file with the name <file name>; Fail if a file named <file name>
 *   already exists in the current directory
 *
 * cd <directory name>
 *   Change the current directory to <directory name>; Fail if a directory named 
 *   <directory name> does not exist in the current directory
 * 
 * up
 *   Change the current directory to the parent of the current directory; Fail if 
 *   the current directory is already the topmost directory
 * 
 * verify
 *   Run tests
 * 
 * quit
 *   Quit
 *
 * EXPERIMENT
 *
 * Once you have the basics working - Enhance the program with other functions!
 * 
 * -> Add a 'find' command that locates a file or directory via a fully-qualified path
 * 
 * -> Enhance the 'dir' command so that directory items include a total size (sum of all
      file sizes beneath that directory (including the files in sub-directories)
 *
 * -> Delete a file
 *
 * -> Copy a file
 *
 * -> Enhance the 'dir' command so that it prints information for the directory and all 
 *     sub-directories
 * 
 * -> Do not allow directories and files of the same name to exist in the same directory
 * 
 * -> Something else!
 */

import java.util.Scanner;

class Filesystem {
  public static void main(String args[]) {
    new Filesystem().run();
  }

  private Directory currentDirectory;

  private Filesystem() {
    currentDirectory = new Directory(null, "root");
  }

  private void commandMkdir(String directoryName) {
    System.out.printf("Command: mkdir %s\n", directoryName);
    currentDirectory.addDirectory(directoryName);
  }

  private void commandMkfile(String fileName, int fileSize) {
    System.out.printf("Command: mkfile %s %d\n", fileName, fileSize);
    currentDirectory.addFile(fileName, fileSize);
  }

  private void commandCd(String directoryName) {
    System.out.printf("Command: cd %s\n", directoryName);
    Directory newCurrentDirectoy = currentDirectory.getDirectory(directoryName);
    if (null == newCurrentDirectoy) {
      System.out.println("Directory does not exist");
    } else {
      currentDirectory = newCurrentDirectoy;
    }
  }

  private void commandUp() {
    System.out.printf("Command: up\n");
    Directory newCurrentDirectoy = currentDirectory.getParentDirectory();
    if (null == newCurrentDirectoy) {
      System.out.printf("Already at root\n");
    } else {
      currentDirectory = newCurrentDirectoy;
    }
  }

  private void commandDir() {
    System.out.printf("Command: dir\n");
    currentDirectory.printDirectoryContents();
  }
  
  private void commandVerify() {
    System.out.printf("Command: verify\n");
    verify();
  }
  
  private void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("-------------------------");
    System.out.println("Welcome to the filesystem");
    System.out.println("-------------------------");
    while (true) {
      System.out.print("> ");
      String command = scanner.nextLine();
      if (command.equals("dir")) {
        commandDir();
      } else if (command.startsWith("mkdir ")) {
        String directoryName = command.substring(6);
        commandMkdir(directoryName);
      } else if (command.startsWith("mkfile ")) {
        String[] params = command.substring(7).split(" ");
        String fileName = params[0];
        int fileSize = Integer.parseInt(params[1]);
        commandMkfile(fileName, fileSize);
      } else if (command.startsWith("cd ")) {
        String directoryName = command.substring(3);
        commandCd(directoryName);
      } else if (command.equals("up")) {
        commandUp();
      } else if (command.equals("verify")) {
        commandVerify();
      } else if (command.equals("quit")) {
        break;
      } else {
        System.out.println("I don't understand.");
      }
   }
   scanner.close();  
 }

 private void verify() {
  commandMkdir("d1");
  commandMkdir("d2");
  commandMkdir("d3");
  commandMkfile("t1.txt", 100);
  commandMkfile("t2.txt", 200);
  commandMkfile("t3.txt", 300);
  commandDir();
  commandCd("d1");
  commandMkfile("t4.txt", 500);
  commandMkfile("t5.txt", 600);
  commandMkfile("t6.txt", 700);
  commandDir();
  commandUp();
  commandCd("d2");
  commandMkfile("t7.txt", 800);
  commandMkfile("t8.txt", 900);
  commandMkfile("t9.txt", 1000);
  commandDir();
  commandUp();
  commandUp();
  commandMkfile("t3.txt", 600);
  commandDir();
  commandCd("d5");
 }
}