class Main {
  public static String foodApple = "apple";
  public static String foodBanana = "banana";
  public static String foodOrange = "orange";
  public static String foodPizza = "pizza";

  public static String randomString() {
    StringBuilder buffer = new StringBuilder();
    for (int i = 0 ; i < 10 ; i++) {
      int alphaOffset = (int)(Math.random() * 26); // 0-25
      buffer.append((char)(97 + alphaOffset)); // 97=='a', 98=='b', 99=='c', etc.
    }
    return buffer.toString();
  }

  public static void main(String[] args) {
    /* isFruit */
    isFruit(foodApple);
    isFruit(foodBanana);
    isFruit(foodOrange);
    isFruit(foodPizza);
    isFruit(randomString());
    isFruit("");
  
    /* isNotFruit */
    isNotFruit(foodApple);
    isNotFruit(foodBanana);
    isNotFruit(foodOrange);
    isNotFruit(foodPizza);
    isNotFruit(randomString());
    isNotFruit("");
  }

  public static boolean isFruit(String food) {
    boolean foodIsFruit;
    
    //
    // TODO: Determine if food is a fruit and assign a value to foodIsFruit
    //
    
    System.out.println("isFruit(" + food + ") -> " + foodIsFruit);
    return foodIsFruit;
  }
  public static boolean isNotFruit(String food) {
    boolean foodIsNotFruit;

    //
    // TODO: Determine if food is NOT a fruit and assign a value to foodIsNotFruit
    //
    
    System.out.println("isNotFruit(" + food + ") -> " + foodIsNotFruit);
    return foodIsNotFruit;
  }
}
