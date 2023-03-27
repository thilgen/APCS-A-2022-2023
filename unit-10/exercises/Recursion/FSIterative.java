import java.util.ArrayList;

public class FSIterative {

  public static String getFolderPath(Folder folder) {
    String path = folder.name;
    for (Folder parentFolder = folder.parent; parentFolder != null; parentFolder = parentFolder.parent) {
      path = parentFolder.name + "/" + path;
    }
    return "/" + path;
  }

  public static String[] getFileNames(Folder folder) {
    ArrayList<Folder> folders = new ArrayList<Folder>();
    folders.add(folder);
    while (true) {
      int originalNumberOfFolders = folders.size();
      for (int idx = 0; idx < folders.size(); idx++) {
        Folder parentFolder = folders.get(idx);
        for (Folder childFolder : parentFolder.folders) {
          if (!folders.contains(childFolder)) {
            folders.add(childFolder);
          }
        }
      }
      if (originalNumberOfFolders == folders.size()) {
        break;
      }
    }
    ArrayList<String> fileNames = new ArrayList<String>();
    for (Folder folder2 : folders) {
      for (File file : folder2.files) {
        fileNames.add(file.name);
      }
    }
    return fileNames.toArray(new String[0]);
  }

  public static String[] getFolderNames(Folder folder) {
    ArrayList<Folder> folders = new ArrayList<Folder>();
    folders.add(folder);
    while (true) {
      int originalNumberOfFolders = folders.size();
      for (int idx = 0; idx < folders.size(); idx++) {
        Folder parentFolder = folders.get(idx);
        for (Folder childFolder : parentFolder.folders) {
          if (!folders.contains(childFolder)) {
            folders.add(childFolder);
          }
        }
      }
      if (originalNumberOfFolders == folders.size()) {
        break;
      }
    }
    ArrayList<String> folderNames = new ArrayList<String>();
    for (Folder folder2 : folders) {
      folderNames.add(folder2.name);
    }
    return folderNames.toArray(new String[0]);
  }

  public static String[] getFilePaths(Folder folder) {
    ArrayList<String> filePaths = new ArrayList<String>();
    ArrayList<Folder> folders = new ArrayList<Folder>();
    folders.add(folder);
    while (true) {
      int originalNumberOfFolders = folders.size();
      for (int idx = 0; idx < folders.size(); idx++) {
        Folder parentFolder = folders.get(idx);
        for (Folder childFolder : parentFolder.folders) {
          if (!folders.contains(childFolder)) {
            folders.add(childFolder);
            for (File file : childFolder.files) {
              filePaths.add(getFolderPath(childFolder) + "/" + file.name);
            }
          }
        }
      }
      if (originalNumberOfFolders == folders.size()) {
        break;
      }
    }
    return filePaths.toArray(new String[0]);
  }

}
