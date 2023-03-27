public class Food {
  private String name;

  public Food(String name) {
    this.name = name;
  }

  public boolean isValid() {
    return isFruit() || isVegetable() || isProtein() || isGrain() || isDairy();
  }

  public boolean isFruit() {
    return name.equals("apple") || name.equals("banana") || name.equals("orange") || name.equals("raisins");
  }

  public boolean isVegetable() {
    return name.equals("spinach") || name.equals("broccoli") || name.equals("potato") || name.equals("corn");
  }

  public boolean isProtein() {
    return name.equals("steak") || name.equals("chicken") || name.equals("salmon") || name.equals("tofu");
  }

  public boolean isGrain() {
    return name.equals("bread") || name.equals("pasta") || name.equals("cereal") || name.equals("rice");
  }

  public boolean isDairy() {
    return name.equals("milk") || name.equals("yogurt") || name.equals("cheese") || name.equals("soy milk");
  }
}