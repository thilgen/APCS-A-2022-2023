/*

   6. Add a new class called ShoppingCart to the project with the following private instance variable

        private ArrayList<GroceryItem> items = new ArrayList<GroceryItem>();  

      Add a public method called addItem(GroceryItem item) that adds a GroceryItem to items
      and returns a boolean indicateing that the item was added to the cart

      VERIFY with VerifyShoppingCart.validateShoppingCartDefinition();

   7. Add a public method to ShoppingCart that prints out the contents of the cart

        public void describeContents()

      The output must include the name of each item in the cart (the rest of the format is up to you)

      VERIFY with VerifyShoppingCart.validateShoppingCartContentsDescription();

   8. Add public price methods to GroceryItem and ShoppingCart

      GroceryItem : double getItemPrice()
                  : Return price

      ShoppingCart: double getTotalPrice()
                  : Return the total price for the contents of the cart

      VERIFY with VerifyShoppingCart.validatePriceMethods();

   9. We are having a Sale this week in the Deli Department - Every item is 25% off!

      Add a getItemPrice() override method in Deli that returns a price that is 25% off

      WARNING: It is very easy to fall into an infinite loop with this step. Be certain
               that your override is making proper use of the super keyword when requesting
               the item price that is stored in GroceryItem

      VERIFY with VerifyShoppingCart.validateDeliSale();

  10. We have received complaints that some GroceryItems are being added to ShoppingCarts
      that should not be sold (Milk that is expired; Ham that is moldy; Eggs that smell bad)

      Add a public method called isAvailableForPurchase() to GroceryItem that returns a
      boolean (should be hard-coded to return true)

      Add a public boolean variable on Dairy called expired

      Add an isAvailableForPurchase() override method on Dairy that returns false if 
      expired is true

      Modify the ShoppingCart addItem() method so that it rejects adding an item to the
      ShoppingCart if isAvailableForPurchase() (on the item to be added) returns false

      VERIFY with VerifyShoppingCart.validateBlockingUnavailableItems();

  ** IF YOU HAVE TIME **

      Add other criteria why various GroceryItems should blocked from being added to
      the ShoppingCart

  */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class VerifyShoppingCart {
  static public void validateShoppingCart() {
    validateShoppingCartDefinition();
    validateShoppingCartContentsDescription();
    validatePriceMethods();
    validateDeliSale();
    validateBlockingUnavailableItems();
  }

  static private void validateShoppingCartDefinition() {
    System.out.println("\n6. Validating ShoppingCart Definition");
    boolean shoppingCartIsDefined = true;
    {
      boolean isValid = true;
      isValid = (isValid && (null != ShoppingCartClass));
      System.out.println("  ShoppingCart (class exists): " + isValid);
      shoppingCartIsDefined = shoppingCartIsDefined && isValid;
    }
    {
      boolean isValid = true;
      isValid = (isValid && classHasField(ShoppingCartClass, "items", true, ArrayList.class));
      shoppingCartIsDefined = shoppingCartIsDefined && isValid;
      System.out.println("  ShoppingCart (ArrayList): " + isValid);
    }
    {
      boolean isValid = true;
      Method addItemMethod = getMethod(ShoppingCartClass, "addItem", false, GroceryItemClass, boolean.class);
      isValid = (isValid && (null != addItemMethod));
      shoppingCartIsDefined = shoppingCartIsDefined && isValid;
      System.out.println("  ShoppingCart (addItem method defined): " + isValid);
    }
    System.out.println(String.format("** %s **", shoppingCartIsDefined ? "SUCCESS" : "FAILURE"));
  }

  static private void validateShoppingCartContentsDescription() {
    System.out.println("\n7. Validating ShoppingCart Contents Description");
    boolean shoppingCartContentsDescriptionIsValid = true;
    Object shoppingCartObject = createShoppingCartObject();
    Method describeContentsMethod = null;
    {
      boolean isValid = true;
      describeContentsMethod = getMethod(ShoppingCartClass, "describeContents", false, null, void.class);
      isValid = (isValid && (null != describeContentsMethod));
      shoppingCartContentsDescriptionIsValid = shoppingCartContentsDescriptionIsValid && isValid;
      System.out.println("  ShoppingCart (describeContents method defined): " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && addTestItemsToShoppingCart(shoppingCartObject));
      shoppingCartContentsDescriptionIsValid = shoppingCartContentsDescriptionIsValid && isValid;
      System.out.println("  ShoppingCart (test items added): " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && verifyDescribeContentsOutput(shoppingCartObject, describeContentsMethod));
      shoppingCartContentsDescriptionIsValid = shoppingCartContentsDescriptionIsValid && isValid;
      System.out.println("  ShoppingCart (describeContents output verified): " + isValid);
    }
    System.out.println(String.format("** %s **", shoppingCartContentsDescriptionIsValid ? "SUCCESS" : "FAILURE"));
  }

  static private void validatePriceMethods() {
    System.out.println("\n8. Validating Price Methods");
    Object shoppingCartObject = createShoppingCartObject();
    Method getTotalPriceMethod = null;
    boolean priceMethodsValidated = true;
    {
      boolean isValid = true;
      Method itemPriceGetter = getMethod(GroceryItemClass, "getItemPrice", false, null, double.class);
      isValid = (isValid && (null != itemPriceGetter));
      priceMethodsValidated = priceMethodsValidated && isValid;
      System.out.println("  GroceryItem (getPrice method defined): " + isValid);
    }
    {
      boolean isValid = true;
      getTotalPriceMethod = getMethod(ShoppingCartClass, "getTotalPrice", false, null, double.class);
      isValid = (isValid && (null != getTotalPriceMethod));
      priceMethodsValidated = priceMethodsValidated && isValid;
      System.out.println("  ShoppingCart (getTotalPrice method defined): " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && addTestItemsToShoppingCart(shoppingCartObject));
      priceMethodsValidated = priceMethodsValidated && isValid;
      System.out.println("  ShoppingCart (test items added): " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && verifyTotalPrice(shoppingCartObject, getTotalPriceMethod));
      priceMethodsValidated = priceMethodsValidated && isValid;
      System.out.println("  ShoppingCart (totalPrice summation verified): " + isValid);
    }
    System.out.println(String.format("** %s **", priceMethodsValidated ? "SUCCESS" : "FAILURE"));
  }

  static private void validateDeliSale() {
    System.out.println("\n9. Validating The Deli Sale");
    Object shoppingCartObject = createShoppingCartObject();
    Method getTotalPriceMethod = null;
    boolean deliSaleValidated = true;
    {
      boolean isValid = true;
      Method itemPriceGetter = getMethod(DeliClass, "getItemPrice", false, null, double.class);
      isValid = (isValid && (null != itemPriceGetter));
      deliSaleValidated = deliSaleValidated && isValid;
      System.out.println("  Deli (getItemPrice override method defined): " + isValid);
    }
    {
      boolean isValid = true;
      getTotalPriceMethod = getMethod(ShoppingCartClass, "getTotalPrice", false, null, double.class);
      isValid = (isValid && (null != getTotalPriceMethod));
      deliSaleValidated = deliSaleValidated && isValid;
      System.out.println("  ShoppingCart (getTotalPrice method defined): " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && addTestItemsToShoppingCart(shoppingCartObject));
      deliSaleValidated = deliSaleValidated && isValid;
      System.out.println("  ShoppingCart (test items added): " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && verifyTotalPriceWithDeliDiscount(shoppingCartObject, getTotalPriceMethod));
      deliSaleValidated = deliSaleValidated && isValid;
      System.out.println("  ShoppingCart (totalPrice summation - with Deli discount - verified): " + isValid);
    }
    System.out.println(String.format("** %s **", deliSaleValidated ? "SUCCESS" : "FAILURE"));
  }  

  static private void validateBlockingUnavailableItems() {
    System.out.println("\n10. Validating The Blocking of Unavailable Items");
    boolean blockingUnavailableItemsValidated = true;
    {
      boolean isValid = true;
      Method isAvailableForPurchaseMethod = getMethod(GroceryItemClass, "isAvailableForPurchase", false, null, boolean.class);
      isValid = (isValid && (null != isAvailableForPurchaseMethod));
      blockingUnavailableItemsValidated = blockingUnavailableItemsValidated && isValid;
      System.out.println("  GroceryItem (isAvailableForPurchase method defined): " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && classHasField(DairyClass, "expired", false, boolean.class));
      blockingUnavailableItemsValidated = blockingUnavailableItemsValidated && isValid;
      System.out.println("  Dairy (expired field defined): " + isValid);
    }
    {
      boolean isValid = true;
      Method isAvailableForPurchaseMethod = getMethod(DairyClass, "isAvailableForPurchase", false, null, boolean.class);
      isValid = (isValid && (null != isAvailableForPurchaseMethod));
      blockingUnavailableItemsValidated = blockingUnavailableItemsValidated && isValid;
      System.out.println("  Dairy (isAvailableForPurchase override defined): " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && verifyAddingUnavailableItemsIsBlocked());
      blockingUnavailableItemsValidated = blockingUnavailableItemsValidated && isValid;
      System.out.println("  ShoppingCart (unavailable items are being blocked from add - verified): " + isValid);
    }
    System.out.println(String.format("** %s **", blockingUnavailableItemsValidated ? "SUCCESS" : "FAILURE"));
  }

  static private boolean classHasField(Class c, String fieldName, boolean isPrivate, Type fieldType) {
    if (null != c) {
      Field[] fields = c.getDeclaredFields();
      for (int idx = 0; idx < fields.length; idx++) {
        Field field = fields[idx];
        if (field.getName().equals(fieldName)) {
          if (isPrivate == Modifier.isPrivate(field.getModifiers())) {
            if (field.getType().equals(fieldType)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  static private Method getMethod(Class c, String methodName, boolean isPrivate, Type paramType, Type returnType) {
    if (null != c) {
      Method[] methods = c.getDeclaredMethods();
      for (int idx = 0; idx < methods.length; idx++) {
        Method method = methods[idx];
        if (method.getName().equals(methodName)) {
          if (isPrivate == Modifier.isPrivate(method.getModifiers())) {
            if (returnType == method.getReturnType()) {
              Type[] paramTypes = method.getGenericParameterTypes();
              if (null == paramType ) {
                if (0 == paramTypes.length) {
                  return method;
                }
              } else {
                if (1 == paramTypes.length) {
                  if (paramTypes[0].equals(paramType)) {
                    return method;
                  }
                }
              }
            }
          }
        }
      }
    }
    return null;
  }

  static private boolean verifyAddingUnavailableItemsIsBlocked() {
    try {
      Method addItemMethod = getMethod(ShoppingCartClass, "addItem", false, GroceryItemClass, boolean.class);
      Method getTotalPriceMethod = getMethod(ShoppingCartClass, "getTotalPrice", false, null, double.class);
      Object shoppingCartObject = createShoppingCartObject();
      if ((null != addItemMethod) && (null != shoppingCartObject) && (null != testItems) && (null != getTotalPriceMethod)) {
        addItemMethod.invoke(shoppingCartObject, testItems[0]);
        addItemMethod.invoke(shoppingCartObject, testItems[1]);
        double oldTotalCartPrice = (double) getTotalPriceMethod.invoke(shoppingCartObject);
        addItemMethod.invoke(shoppingCartObject, expiredMilkItem);
        double newTotalCartPrice = (double) getTotalPriceMethod.invoke(shoppingCartObject);
        return (oldTotalCartPrice == newTotalCartPrice);
      }      
    } catch (Exception e) {
      // * //
    }
    return false;
  }

  static private boolean verifyTotalPriceWithDeliDiscount(Object shoppingCartObject, Method getTotalPriceMethod) {
    boolean totalPriceWithDeliDiscountVerified = false;
    try {
      if ((null != shoppingCartObject) && (null != getTotalPriceMethod) && (null != GroceryItemClass)) {
        double totalCartPrice = (double) getTotalPriceMethod.invoke(shoppingCartObject);
        double testItemsTotalPrice = 0;
        Method method = GroceryItemClass.getMethod("getItemPrice");
        for (Object o : testItems) {
          if (o.getClass().equals(HamClass)) {
            testItemsTotalPrice += normalHamPrice / 4;
          } else if (o.getClass().equals(TurkeyClass)) {
            testItemsTotalPrice += normalTurkeyPrice / 4;
          } else {
            testItemsTotalPrice += (double) method.invoke(o);
          }          
          totalPriceWithDeliDiscountVerified = true;
        }
        totalPriceWithDeliDiscountVerified = (totalCartPrice == testItemsTotalPrice);
      }
    } catch (Exception e) {
      totalPriceWithDeliDiscountVerified = false;
    }
    return totalPriceWithDeliDiscountVerified;
  }

  static private boolean verifyTotalPrice(Object shoppingCartObject, Method getTotalPriceMethod) {
    boolean totalPriceVerified = false;
    try {
      if ((null != shoppingCartObject) && (null != getTotalPriceMethod) && (null != GroceryItemClass)) {
        double totalCartPrice = (double) getTotalPriceMethod.invoke(shoppingCartObject);
        double testItemsTotalPrice = 0;
        Method method = GroceryItemClass.getMethod("getItemPrice");
        for (Object o : testItems) {
          testItemsTotalPrice += (double) method.invoke(o);
          totalPriceVerified = true;
        }
        totalPriceVerified = (totalCartPrice == testItemsTotalPrice);
      }
    } catch (Exception e) {
      totalPriceVerified = false;
    }
    return totalPriceVerified;
  }

  static private boolean verifyDescribeContentsOutput(Object shoppingCartObject, Method describeContentsMethod) {
    boolean contentsVerified = false;
    try {
      if ((null != shoppingCartObject) && (null != describeContentsMethod) && (null != GroceryItemClass)) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);

        describeContentsMethod.invoke(shoppingCartObject);

        System.setOut(originalPrintStream);
        String commandOutput = new String(stream.toByteArray());

        Method method = GroceryItemClass.getMethod("getItemName");
        for (Object o : testItems) {
          String itemName = (String) method.invoke(o);
          if (-1 == commandOutput.indexOf(itemName)) {
            contentsVerified = false;
            break;
          } else {
            contentsVerified = true;
          }
        }
      }
    } catch (Exception e) {
      contentsVerified = false;
    }
    return contentsVerified;
  }

  static private Class GroceryItemClass = getClassByName("GroceryItem");
  static private Class DairyClass = getClassByName("Dairy");
  static private Class CheeseClass = getClassByName("Cheese");
  static private Class CheddarCheeseClass = getClassByName("CheddarCheese");
  static private Class SwissCheeseClass = getClassByName("SwissCheese");
  static private Class MilkClass = getClassByName("Milk");
  static private Class LowfatMilkClass = getClassByName("LowfatMilk");
  static private Class WholeMilkClass = getClassByName("WholeMilk");
  static private Class EggsClass = getClassByName("Eggs");
  static private Class DeliClass = getClassByName("Deli");
  static private Class TurkeyClass = getClassByName("Turkey");
  static private Class HamClass = getClassByName("Ham");
  static private Class ShoppingCartClass = getClassByName("ShoppingCart");

  static private double normalHamPrice = Math.floor(((Math.random() * 10) * 100)) / 100;
  static private double normalTurkeyPrice = Math.floor(((Math.random() * 10) * 100)) / 100;

  static private Object[] testItems = createTestItems();
  static private Object expiredMilkItem = createExpiredMilkTestItem();

  static private Class getClassByName(String className) {
    try {
      return Class.forName(className);
    } catch (ClassNotFoundException e) {
      return null;
    }
  }

  static private Object createExpiredMilkTestItem() {
    try {
      Object newObj = createTestItem(WholeMilkClass, null);
      Field field = DairyClass.getDeclaredField("expired");
      if (null != field) {
        field.setBoolean(newObj, true);
        return newObj;
      }    
    } catch (Exception e) {
      // * //
    }
    return null;
  }

  static private Object[] createTestItems() {
    ArrayList<Object> testItems = new ArrayList<Object>();
    Class[] testItemClasses = new Class[] {
      CheddarCheeseClass,
      SwissCheeseClass,
      WholeMilkClass,
      LowfatMilkClass,
      EggsClass
    };
    for (Class c : testItemClasses) {
      Object o = createTestItem(c, null);
      if (null != o) {
        testItems.add(o);
      }
    }
    {
      Object o = createTestItem(HamClass, normalHamPrice);
      if (null != o) {
        testItems.add(o);
      }
    }
    {
      Object o = createTestItem(TurkeyClass, normalTurkeyPrice);
      if (null != o) {
        testItems.add(o);
      }
    }
    return testItems.toArray();
  }

  static private Object createShoppingCartObject() {
    try {
      if (null != ShoppingCartClass) {
        return ShoppingCartClass.getDeclaredConstructor().newInstance();
      }
    } catch (Exception e) {
      // * //
    }
    return null;
  }

  static private Constructor getTestItemConstructor(Class c) {
    Constructor ctor = null;
    try {
      if (null != c) {
        if ((null != LowfatMilkClass) && (null != WholeMilkClass) && (null != MilkClass)) {
          if (LowfatMilkClass.equals(c) || WholeMilkClass.equals(c) || MilkClass.equals(c)) {
            if (classHasField(MilkClass, "milkVolumeOz", true, double.class)) {
              ctor = c.getConstructor(double.class, String.class, double.class);
            }
          }
        }
        if (null != EggsClass) {
          if (EggsClass.equals(c)) {
            if (classHasField(EggsClass, "eggCount", true, int.class)) {
              ctor = c.getConstructor(double.class, String.class, int.class);
            }
          }
        }
        if (null == ctor) {
          ctor = c.getConstructor(double.class, String.class);
        }
      }
    } catch (Exception e) {
      // * //
    }
    return ctor;
  }

  static private Object createTestItem(Class c, Double itemPrice) {
    double price = Math.floor(((Math.random() * 10) * 100)) / 100;
    if (null != itemPrice) {
      price = itemPrice;
    }
    String randomItemName = c.getName() + getRandomString();
    double milkVolumeOz = Math.floor(((Math.random() * 25) * 100)) / 100;
    int eggCount = (Math.random() > .5 ? (Math.random() > .5 ? 6 : 12) : 18);
    try {
      Constructor ctor = getTestItemConstructor(c);
      if (null != ctor) {
        Object[] ctorParams = { price, randomItemName };
        Class[] paramTypes = ctor.getParameterTypes();
        if (paramTypes.length > 2) {
          if (paramTypes[paramTypes.length-1].equals(int.class)) {
            ctorParams = new Object[] { price, randomItemName, eggCount };
          }
          if (paramTypes[paramTypes.length-1].equals(double.class)) {
            ctorParams = new Object[] { price, randomItemName, milkVolumeOz };
          }
        }
        return ctor.newInstance(ctorParams);
      }
    } catch (Exception e) {
      // * //
    }
    return null;
  }
  
  static private boolean addTestItemsToShoppingCart(Object shoppingCartObject) {
    boolean itemsAdded = false;
    try {
      Method addItemMethod = getMethod(ShoppingCartClass, "addItem", false, GroceryItemClass, boolean.class);
      if ((null != shoppingCartObject) && (null != testItems) && (null != addItemMethod)) {
        itemsAdded = (0 != testItems.length);
        for (Object o : testItems) {
          addItemMethod.invoke(shoppingCartObject, o);
        }
      }
    } catch (Exception e) {
      itemsAdded = false;
    }
    return itemsAdded;
  }

  static String getRandomString() {
    double seed = 98236983267.448;
    Double rand = seed * Math.random();
    return rand.toString().replace('.', '3').substring(0, 10);
  }
}