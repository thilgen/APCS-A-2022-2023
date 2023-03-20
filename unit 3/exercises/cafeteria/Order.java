public class Order {
  private int orderNumber;
  private Food food1, food2, food3, food4, food5;

  public Order(Food food1, Food food2, Food food3, Food food4, Food food5) {
    orderNumber = generateOrderNumber();
    this.food1 = food1;
    this.food2 = food2;
    this.food3 = food3;
    this.food4 = food4;
    this.food5 = food5;
  }

  private int generateOrderNumber() {
    // You're going to be waiting for awhile for this food.
    return (int) (Math.random() * 20) + 30;
  }

  public int getOrderNumber() {
    return orderNumber;
  }

  public boolean hasFruit() {
    // TODO YOUR CODE HERE
    return false;
  }

  public boolean hasVegetable() {
    // TODO YOUR CODE HERE
    return false;
  }

  public boolean hasGrain() {
    // TODO YOUR CODE HERE
    return false;
  }

  public boolean hasProtein() {
    // TODO YOUR CODE HERE
    return false;
  }

  public boolean hasDairy() {
    // TODO YOUR CODE HERE
    return false;
  }

  public boolean isBalancedMeal() {
    // TODO YOUR CODE HERE
    return true;
  }
}