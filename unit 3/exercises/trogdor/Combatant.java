public class Combatant {
  private String name, possessivePronoun;
  private int health, magic;
  private Weapon weapon;

  public Combatant(String name, String possessivePronoun) {
    this.name = name;
    this.possessivePronoun = possessivePronoun;
    health = Random.randomInt(20, 30);
    magic = Random.randomInt(10, 20);
  }

  public void wield(Weapon weapon) {
    if (this.weapon != weapon) {
      this.weapon = weapon;
      String wieldConjugated = "wields";
      if (name.equals("You")) {
        wieldConjugated = "wield";
      }
      System.out.println(name + " " + wieldConjugated + " " + possessivePronoun + " " + weapon + "!");
    }
  }

  public String getName() {
    return name;
  }

  public void printStats() {
    System.out.println("<" + name + "> Health: " + health + " Magic: " + magic);
  }

  public boolean isAlive() {
    return health > 0;
  }

  public void takeDamage(int damage) {
    health -= damage;
  }

  public void heal() {
    System.out.println("Sorry, the heal command isn't yet implemented!");
    System.out.println("You'll have to just walk it off!");
  }

  public void attack(Combatant target) {
    if (weapon == null) {
      System.out.println(name + " has no weapon to attack!");
    } else {
      int damage = weapon.calcDamage();
      if (damage == 0) {
        System.out.println(name + " missed with " + possessivePronoun + " " + weapon + ".");
      } else {
        target.takeDamage(damage);
        String formattedTargetName = target.getName();
        if (formattedTargetName.equals("You")) {
          formattedTargetName = "you";
        }
        System.out.println(name + " hit " + formattedTargetName + " with " + possessivePronoun + " " + weapon
            + " for " + damage + " health!");
      }
    }
  }
}