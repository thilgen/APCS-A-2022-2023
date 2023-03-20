import java.util.Random;

class File {

  public String name;

  public File() {
    Random random = new Random();
    this.name = String.format("%s-%04d", "file", random.nextInt(5000));
  }

}
