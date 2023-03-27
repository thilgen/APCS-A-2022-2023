import java.util.ArrayList;
import java.util.Random;

class Folder {

  public Folder parent;
  public String name;
  
  public ArrayList<Folder> folders = new ArrayList<Folder>();
  public ArrayList<File> files = new ArrayList<File>();

  private void init(Folder parent, String name) {
    this.parent = parent;
    Random random = new Random();
    this.name = String.format("%s-%04d", name, random.nextInt(5000));
  }

  public Folder(Folder parent) {
    init(parent, "folder");
  }

  public Folder(Folder parent, String name) {
    init(parent, name);
  }

}
