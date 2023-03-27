public class Weapon {
  private String name;
  private double hitProbability;
  private int minDamage, maxDamage;

  public Weapon(String name, double hitProbability, int minDamage, int maxDamage) {
    this.name = name;
    this.hitProbability = hitProbability;
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
  }

  public String getName() { return name; }

  public String toString() { return name; }

  public int calcDamage() {
    if (Math.random() < hitProbability) {
      return Random.randomInt(minDamage, maxDamage);
    } else {
      return 0;
    }
  }
}