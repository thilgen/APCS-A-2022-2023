import java.util.Scanner;

//
// Instructions:
//
// El Camino High School has a new cafeteria with a fancy new
// computer system for taking your order. The system is supposed
// to make sure that students order a balanced meal from all of
// the five food groups, but this functionality is not working,
// and it's letting all orders through. You have been asked to
// fix it. 
//
// 1. In Order.java, implement the hasFruit, hasVegetable, hasGrain,
//    hasProtein, and hasDairy methods. Hint: Use the || operator
//    and the corresponding isXYZ methods in the Food class.
//
// 2. In Order.java, implement the isBalancedMeal method to return
//    true if all of the five food groups are represented in the
//    order. Hint: Use the && operator and the hasXYZ methods
//    that you implemented in step 1.
//
// 3. When an order is rejected, the system currently doesn't tell
//    the student what food groups they were missing. Add code
//    to the rejection message to print out the list of missing
//    food groups. Hint: Use the hasXYZ methods from step 2.
//
// 4. Bonus: Change the menu items to your favorite foods that you
//    want the cafeteria to offer.
//

class Main {
  private static Scanner scanner = new Scanner(System.in);

  private static void printMenu() {
    System.out.println("Today's menu:");
    System.out.println("Fruits: apple, banana, orange, raisins");
    System.out.println("Vegetables: spinach, broccoli, potato, corn");
    System.out.println("Proteins: steak, chicken, salmon, tofu");
    System.out.println("Grains: bread, pasta, cereal, rice");
    System.out.println("Dairy: milk, yogurt, cheese, soy milk");
  }

  private static Food readFood(int i) {
    System.out.println("Enter selection #" + i + ":");
    System.out.print('>');
    String name = scanner.nextLine();
    Food food = new Food(name);
    if (food.isValid()) {
      return food;
    } else {
      System.out.println("We don't have that on the menu. Please try again.");
      return readFood(i);
    }
  }

  public static void main(String[] args) {
    System.out.println("Welcome to the ELCO Cafeteria System!");
    System.out.println();
    printMenu();
    System.out.println();

    System.out.println("Please enter five selections from the menu.");

    Food food1 = readFood(1);
    Food food2 = readFood(2);
    Food food3 = readFood(3);
    Food food4 = readFood(4);
    Food food5 = readFood(5);

    Order order = new Order(food1, food2, food3, food4, food5);

    if (order.isBalancedMeal()) {
      System.out.println("Our Artificial Intelligence has determined that you have selected a balanced meal.");
      System.out.println("Thank you for your order.");
      System.out.println("You are number #" + order.getOrderNumber());
      System.out.println("Sit down! We will call you when your order is ready!");
    } else {
      System.out.println("Our Artificial Intelligence has rejected your meal as UNBALANCED.");
      System.out.println("Please go to the end of the line and rethink your choices.");
    }
  }
}
