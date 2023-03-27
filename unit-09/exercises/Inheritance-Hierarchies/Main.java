class Main {
  /*
    1.  Add these 12 classes to the project

        GroceryItem
        Dairy
        Cheese
        CheddarCheese
        SwissCheese
        Milk
        LowfatMilk
        WholeMilk
        Eggs
        Deli
        Turkey
        Ham
        
        VERIFY with Verify.validateClassesAreDefined()

    2. Modify the classes so that they adhere to the following inheritance hierarchy

       GroceryItem
         Dairy
           Cheese
             CheddarCheese
             SwissCheese
           Milk
             LowfatMilk
             WholeMilk
           Eggs
         Deli
           Turkey
           Ham

      VERIFY Verify.validateInheritanceHierarchy()


    3. Add two instance variables to GroceryItem

         private double price;
         private String itemName;

       Add a public getter (getItemName) that returns itemName

       Add constructors to all classes such that you can create any item in the hierarchy
       by passing in a price and an itemName (in that order); and the values in 
       GroceryItem are set

       VERIFY with Verify.validateConstructors()

    4. Add an instance variable to Eggs

         private int eggCount;

       Add a public getter (getEggCount) that returns eggCount

       Modify the constructor for Eggs to additionally have an eggCount parameter; and 
       set the value in Eggs
       
       VERIFY with Verify.validateEggs()

    5. Add an instance variable to Milk

         private double milkVolumeOz;

       Add a public getter (getMilkVolumeOz) that returns milkVolumeOz

       Modify the constructors for Milk (and all the subclasses of Milk) to additionally have 
       a milkVolumeOz parameter; and set the value in Milk

       VERIFY with Verify.validateMilk()

  */
  public static void main(String[] args) {
    new Main().run();
  }
  public void run() {
    Verify.validateClassesAreDefined();
    Verify.validateInheritanceHierarchy();
    Verify.validateConstructors();
    Verify.validateEggs();
    Verify.validateMilk();
    System.out.println("");
  }
}