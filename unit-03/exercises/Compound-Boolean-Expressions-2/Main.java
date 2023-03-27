class Main {
  public static String foodApple = "apple";
  public static String foodBanana = "banana";
  public static String foodOrange = "orange";
  public static String foodPizza = "pizza";
  
  public static String colorRed = "red";
  public static String colorGreen = "green";
  public static String colorYellow = "yellow";
  public static String colorOrange = "orange";
  
  public static String randomString() {
    StringBuilder buffer = new StringBuilder();
    for (int i = 0 ; i < 10 ; i++) {
      int alphaOffset = (int)(Math.random() * 26); // 0-25
      buffer.append((char)(97 + alphaOffset)); // 97=='a', 98=='b', 99=='c', etc.
    }
    return buffer.toString();
  }

  public static void main(String[] args) {  
    /* isApple */
    isApple(foodApple, colorRed);
    isApple(foodApple, colorGreen);
    isApple(foodApple, colorYellow);
    isApple(foodApple, colorOrange);
    isApple(foodApple, "");
    isApple(foodBanana, colorRed);
    isApple(foodBanana, colorGreen);
    isApple(foodBanana, colorYellow);
    isApple(foodBanana, colorOrange);
    isApple(foodBanana, "");
    isApple(randomString(), randomString());
    isApple(randomString(), "");
    isApple("", randomString());
    isApple("", "");
    
    /* isBanana */
    isBanana(foodApple, colorRed);
    isBanana(foodApple, colorGreen);
    isBanana(foodApple, colorYellow);
    isBanana(foodApple, colorOrange);
    isBanana(foodApple, "");
    isBanana(foodBanana, colorRed);
    isBanana(foodBanana, colorGreen);
    isBanana(foodBanana, colorYellow);
    isBanana(foodBanana, colorOrange);
    isBanana(foodBanana, "");
    isBanana(randomString(), randomString());
    isBanana(randomString(), "");
    isBanana("", randomString());
    isBanana("", "");
    
    /* isOrange */
    isOrange(foodOrange, colorRed);
    isOrange(foodOrange, colorGreen);
    isOrange(foodOrange, colorYellow);
    isOrange(foodOrange, colorOrange);
    isOrange(foodOrange, "");
    isOrange(foodPizza, colorRed);
    isOrange(foodPizza, colorGreen);
    isOrange(foodPizza, colorYellow);
    isOrange(foodPizza, colorOrange);
    isOrange(foodPizza, "");
    isOrange(randomString(), randomString());
    isOrange(randomString(), "");
    isOrange("", randomString());
    isOrange("", "");
  }
  
  public static boolean isApple(String food, String color) {
    boolean foodIsApple;

    //
    // TODO: Determine if food is an apple - color must be red, green, or yellow - and assign a value to foodIsApple
    //
    
    System.out.println("isApple(" + food + ", " + color + ") -> " + foodIsApple);
    return foodIsApple;
  }
  
  public static boolean isBanana(String food, String color) {
    boolean foodIsBanana;

    //
    // TODO: Determine if food is a banana - color must be green or yellow - and assign a value to foodIsBanana
    //
    
    System.out.println("isBanana(" + food + ", " + color + ") -> " + foodIsBanana);
    return foodIsBanana;
  }
  
  public static boolean isOrange(String food, String color) {
    boolean foodIsOrange;

    //
    // TODO: Determine if food is an orange - color must orange - and assign a value to foodIsOrange
    //
    
    System.out.println("isOrange(" + food + ", " + color + ") -> " + foodIsOrange);
    return foodIsOrange;
  }
}