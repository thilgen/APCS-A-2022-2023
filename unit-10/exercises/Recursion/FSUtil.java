import java.util.ArrayList;
import java.util.Random;

public class FSUtil {

  private static ArrayList<String> fileNames = new ArrayList<String>();
  private static ArrayList<String> folderNames = new ArrayList<String>();
  private static ArrayList<String> filePaths = new ArrayList<String>();

  public static String[] getFolderNames() {
    return folderNames.toArray(new String[0]);
  }

  public static String[] getFileNames() {
    return fileNames.toArray(new String[0]);
  }

  public static String[] getFilePaths() {
    return filePaths.toArray(new String[0]);
  }

  private static boolean validateResults(ArrayList<String> expected, String[] results) {
    if ((null == results) || (0 == results.length) || (results.length != expected.size())) {
      return false;
    }
    for (int idx = 0 ; idx < results.length ; idx++) {
      if (!expected.contains(results[idx])) {
        return false;
      }
    }
    return true;
  }

  public static boolean validateDiscoveredFolderNames(String[] folderNamesDiscovered) {
    return validateResults(folderNames, folderNamesDiscovered);
  }

  public static boolean validateDiscoveredFileNames(String[] fileNamesDiscovered) {
    return validateResults(fileNames, fileNamesDiscovered);
  }

  public static boolean validateDiscoveredFilePaths(String[] filePathsDiscovered) {
    return validateResults(filePaths, filePathsDiscovered);
  }

  public static Folder createFS() {
    Random random = new Random();
    Folder root = new Folder(null, "root");
    int depth = 10;
    ArrayList<Folder> parentFolders = new ArrayList<Folder>();
    parentFolders.add(root);
    for (int idx = 0 ; idx < depth ; idx++) {
      ArrayList<Folder> newParentFolders = new ArrayList<Folder>();
      for (Folder parentFolder : parentFolders) {
        int numFolders = Math.max(3, random.nextInt(10));
        for (int jdx = 0 ; jdx < numFolders ; jdx++) {
          int numFiles = Math.max(3, random.nextInt(5));
          Folder newChildFolder = new Folder(parentFolder, String.valueOf(idx));
          for (int fdx = 0 ; fdx < numFiles ; fdx++) {
            File newFile = new File();
            newChildFolder.files.add(newFile);
            fileNames.add(newFile.name);
            filePaths.add(FSIterative.getFolderPath(newChildFolder) + "/" + newFile.name);
          }
          parentFolder.folders.add(newChildFolder);
          folderNames.add(newChildFolder.name);
        }
      }
      parentFolders = newParentFolders;
    }
    folderNames.add(root.name);
    return root;   
  }
}
