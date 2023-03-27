import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.Field;

class Verify {
  static public void validateClassesAreDefined() {
    System.out.println("\n1. Validating Required Classes Are Defined");
    boolean classesAreDefined = true;
    for (String className : requiredClassNames) {
      try {
        Class c = Class.forName(className);
        System.out.println("  " + className + ": " + true);
      } catch (ClassNotFoundException e) {
        System.out.println("  " + className + ": " + false);
        classesAreDefined = false;
      }      
    }
    System.out.println(String.format("** %s **", classesAreDefined ? "SUCCESS" : "FAILURE"));
  }
  
  static private boolean validateInheritance(Class subclass, Class superclass) {
    if ((null != subclass) && (null != superclass)) {
      Class parentClass = subclass.getSuperclass();
      for ( ; null != parentClass ; parentClass = parentClass.getSuperclass()) {
        if (parentClass.getTypeName().equals(superclass.getTypeName())) {
          return true;
        }
      }
    }
    return false;
  }
  
  static public void validateInheritanceHierarchy() {
    System.out.println("\n2. Validating Class Hierarchies");
    
    boolean inheritanceHierarchyValid = true;
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(GroceryItemClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  GroceryItem: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(DairyClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(DairyClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  Dairy: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(CheeseClass, DairyClass));
      isValid = (isValid && validateInheritance(CheeseClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(CheeseClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  Cheese: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(CheddarCheeseClass, CheeseClass));
      isValid = (isValid && validateInheritance(CheddarCheeseClass, DairyClass));
      isValid = (isValid && validateInheritance(CheddarCheeseClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(CheddarCheeseClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  CheddarCheese: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(SwissCheeseClass, CheeseClass));
      isValid = (isValid && validateInheritance(SwissCheeseClass, DairyClass));
      isValid = (isValid && validateInheritance(SwissCheeseClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(SwissCheeseClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  SwissCheese: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(MilkClass, DairyClass));
      isValid = (isValid && validateInheritance(MilkClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(MilkClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  Milk: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(LowfatMilkClass, MilkClass));
      isValid = (isValid && validateInheritance(LowfatMilkClass, DairyClass));
      isValid = (isValid && validateInheritance(LowfatMilkClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(LowfatMilkClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  LowfatMilk: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(WholeMilkClass, MilkClass));
      isValid = (isValid && validateInheritance(WholeMilkClass, DairyClass));
      isValid = (isValid && validateInheritance(WholeMilkClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(WholeMilkClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  WholeMilk: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(EggsClass, DairyClass));
      isValid = (isValid && validateInheritance(EggsClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(EggsClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  Eggs: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(DeliClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(DeliClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  Deli: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(TurkeyClass, DeliClass));
      isValid = (isValid && validateInheritance(TurkeyClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(TurkeyClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  Turkey: " + isValid);
    }
    {
      boolean isValid = true;
      isValid = (isValid && validateInheritance(HamClass, DeliClass));
      isValid = (isValid && validateInheritance(HamClass, GroceryItemClass));
      isValid = (isValid && validateInheritance(HamClass, Object.class));
      inheritanceHierarchyValid = inheritanceHierarchyValid && isValid;
      System.out.println("  Ham: " + isValid);
    }
    System.out.println(String.format("** %s **", inheritanceHierarchyValid ? "SUCCESS" : "FAILURE"));
  }

  static private boolean validateSimpleConstructor(Class c) {
    if (null != c) {
      Constructor[] ctors = c.getConstructors();
      for (int idx = 0 ; idx < ctors.length ; idx++) {
        Type[] paramTypes = ctors[idx].getGenericParameterTypes();
        if (2 == paramTypes.length) {
          if (paramTypes[0].getTypeName().equals("double")) {
            if (paramTypes[1].getTypeName().equals("java.lang.String")) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  static private boolean validatePublicGetter(Class c, String getterName, Type returnType) {
    if (null != c) {
      Method[] methods = c.getDeclaredMethods();
      for (int idx = 0 ; idx < methods.length ; idx++) {
        Method method = methods[idx];
        if (method.getName().equals(getterName)) {
          if (Modifier.isPublic(method.getModifiers())) {
            if (0 == method.getGenericParameterTypes().length) {
              if (returnType == method.getReturnType()) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }

  static private boolean classHasField(Class c, String fieldName) {
    if (null != c) {
      Field[] fields = c.getDeclaredFields();
      for (int idx = 0 ; idx < fields.length ; idx++) {
        Field field = fields[idx];
        if (field.getName().equals(fieldName)) {
          return true;
        }
      }
    }
    return false;
  }

  static public void validateConstructors() {
    System.out.println("\n3. Validating Constructors");
    boolean constructorsValid = true;
    {
      boolean isValid = validateSimpleConstructor(GroceryItemClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  GroceryItem: " + isValid);
    }
    {
      boolean isValid = validatePublicGetter(GroceryItemClass, "getItemName", String.class);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  GroceryItem (getter): " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(DairyClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Dairy: " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(CheeseClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Cheese: " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(CheddarCheeseClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  CheddarCheese: " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(SwissCheeseClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  SwissCheese: " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(MilkClass);
      if (classHasField(MilkClass, "milkVolumeOz")) {
        isValid = validateExtendedConstructor(MilkClass, double.class);
      }
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Milk: " + isValid);        
    }
    {
      boolean isValid = validateSimpleConstructor(LowfatMilkClass);
      if (classHasField(MilkClass, "milkVolumeOz")) {
        isValid = validateExtendedConstructor(LowfatMilkClass, double.class);
      }
      constructorsValid = constructorsValid && isValid;
      System.out.println("  LowfatMilk: " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(WholeMilkClass);
      if (classHasField(MilkClass, "milkVolumeOz")) {
        isValid = validateExtendedConstructor(WholeMilkClass, double.class);
      }
      constructorsValid = constructorsValid && isValid;
      System.out.println("  WholeMilk: " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(EggsClass);
      if (classHasField(EggsClass, "eggCount")) {
        isValid = validateExtendedConstructor(EggsClass, int.class);
      }
      constructorsValid = constructorsValid && isValid;     
      System.out.println("  Eggs: " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(DeliClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Deli: " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(TurkeyClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Turkey: " + isValid);
    }
    {
      boolean isValid = validateSimpleConstructor(HamClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Ham: " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(GroceryItemClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  GroceryItem (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(DairyClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Dairy (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(CheeseClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Cheese (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(CheddarCheeseClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  CheddarCheese (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(SwissCheeseClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  SwissCheese (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(MilkClass);
      if (classHasField(MilkClass, "milkVolumeOz")) {
        isValid = validateItemNameViaExtendedConstructionDouble(MilkClass);
      }      
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Milk (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(LowfatMilkClass);
      if (classHasField(MilkClass, "milkVolumeOz")) {
        isValid = validateItemNameViaExtendedConstructionDouble(LowfatMilkClass);
      }      
      constructorsValid = constructorsValid && isValid;
      System.out.println("  LowfatMilk (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(WholeMilkClass);
      if (classHasField(MilkClass, "milkVolumeOz")) {
        isValid = validateItemNameViaExtendedConstructionDouble(WholeMilkClass);
      }      
      constructorsValid = constructorsValid && isValid;
      System.out.println("  WholeMilk (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(EggsClass);
      if (classHasField(EggsClass, "eggCount")) {
        isValid = validateItemNameViaExtendedConstructionInt(EggsClass);
      }
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Eggs (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(DeliClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Deli (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(TurkeyClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Turkey (itemName): " + isValid);
    }
    {
      boolean isValid = validateItemNameViaConstruction(HamClass);
      constructorsValid = constructorsValid && isValid;
      System.out.println("  Ham (itemName): " + isValid);
    }    
    System.out.println(String.format("** %s **", constructorsValid ? "SUCCESS" : "FAILURE"));
  }

  static boolean validateItemNameViaConstruction(Class c) {
    if (null != c) {
      try {
        String randomItemName = getRandomString();
        Constructor ctor = c.getConstructor(double.class, String.class);  
        Object groceryObject = ctor.newInstance(5.0, randomItemName);
        Method method = c.getMethod("getItemName");
        return randomItemName.equals((String) method.invoke(groceryObject));
      } catch (Exception e) {
        // * //
      }      
    }
    return false;
  }

  static boolean validateItemNameViaExtendedConstructionDouble(Class c) {
    if (null != c) {
      try {
        String randomItemName = getRandomString();
        Constructor ctor = c.getConstructor(double.class, String.class, double.class);  
        Object groceryObject = ctor.newInstance(5.0, randomItemName, 1.1);
        Method method = c.getMethod("getItemName");
        return randomItemName.equals((String) method.invoke(groceryObject));        
      } catch (Exception e) {
        // * //
      }      
    }
    return false;
  } 
  
  static boolean validateItemNameViaExtendedConstructionInt(Class c) {
    if (null != c) {
      try {
        String randomItemName = getRandomString();
        Constructor ctor = c.getConstructor(double.class, String.class, int.class);  
        Object groceryObject = ctor.newInstance(5.0, randomItemName, 999);
        Method method = c.getMethod("getItemName");
        return randomItemName.equals((String) method.invoke(groceryObject));          
      } catch (Exception e) {
        // * //
      }      
    }
    return false;
  } 

  static String getRandomString() {
    double seed = 98236983267.448;
    Double rand = seed * Math.random();
    return rand.toString().replace('.','3').substring(0,10);
  }

  static public void validateEggs() {
    System.out.println("\n4. Validating Eggs");
    boolean eggsValidated = true;
    {
      boolean isValid = validatePublicGetter(EggsClass, "getEggCount", int.class);
      eggsValidated = eggsValidated && isValid;
      System.out.println("  Eggs (getter): " + isValid);
    }
    {
      boolean isValid = validateExtendedConstructor(EggsClass, int.class);
      eggsValidated = eggsValidated && isValid;
      System.out.println("  Eggs (ctor): " + isValid);
    }
    System.out.println(String.format("** %s **", eggsValidated ? "SUCCESS" : "FAILURE"));
  }

  static private boolean validateExtendedConstructor(Class c, Type extraParamType) {
    if (null != c) {
      Constructor[] ctors = c.getConstructors();
      for (int idx = 0 ; idx < ctors.length ; idx++) {
        Type[] paramTypes = ctors[idx].getGenericParameterTypes();
        if (3 == paramTypes.length) {
          if (paramTypes[0].getTypeName().equals("double")) {
            if (paramTypes[1].getTypeName().equals("java.lang.String")) {
              return (paramTypes[2] == extraParamType);
            }
          }
        }
      }
    }
    return false;
  }
  
  static public void validateMilk() {
    System.out.println("\n5. Validating Milk");
    boolean milkValidated = true;
    {
      boolean isValid = validatePublicGetter(MilkClass, "getMilkVolumeOz", double.class);
      milkValidated = milkValidated && isValid;
      System.out.println("  Milk (getter): " + isValid);
    }
    {
      boolean isValid = validateExtendedConstructor(MilkClass, double.class);
      milkValidated = milkValidated && isValid;
      System.out.println("  Milk (ctor): " + isValid);
    }
    {
      boolean isValid = validateExtendedConstructor(LowfatMilkClass, double.class);
      milkValidated = milkValidated && isValid;
      System.out.println("  LowfatMilk (ctor): " + isValid);
    }
    {
      boolean isValid = validateExtendedConstructor(WholeMilkClass, double.class);
      milkValidated = milkValidated && isValid;
      System.out.println("  WholeMilk (ctor): " + isValid);
    }
    {
      boolean isValid = validateVolumeOzViaConstruction(MilkClass);
      milkValidated = milkValidated && isValid;
      System.out.println("  Milk (milkVolumeOz): " + isValid);
    }
    {
      boolean isValid = validateVolumeOzViaConstruction(LowfatMilkClass);
      milkValidated = milkValidated && isValid;
      System.out.println("  LowfatMilk (milkVolumeOz): " + isValid);
    }
    {
      boolean isValid = validateVolumeOzViaConstruction(WholeMilkClass);
      milkValidated = milkValidated && isValid;
      System.out.println("  WholeMilk (milkVolumeOz): " + isValid);
    }
    System.out.println(String.format("** %s **", milkValidated ? "SUCCESS" : "FAILURE"));
  }  

  static private boolean validateVolumeOzViaConstruction(Class c) {
    if (null != c) {
      if (classHasField(MilkClass, "milkVolumeOz")) {
        try {
          String randomItemName = getRandomString();
          double randomMilkSize = Math.random();
          Constructor ctor = c.getConstructor(double.class, String.class, double.class);  
          Object milkObject = ctor.newInstance(5.0, randomItemName, randomMilkSize);
          Method method = c.getMethod("getMilkVolumeOz");
          return (randomMilkSize == (Double) method.invoke(milkObject));
        } catch (Exception e) {
          // * //
        }    
      }
    }
    return false;
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

  static private Class getClassByName(String className) {
    try {
      return Class.forName(className);
    } catch (ClassNotFoundException e) {
      return null;
    }    
  }

  static String[] requiredClassNames = new String[] {
    "GroceryItem",
    "Dairy",
    "Cheese",
    "CheddarCheese",
    "SwissCheese",
    "Milk",
    "LowfatMilk",
    "WholeMilk",
    "Eggs",
    "Deli",
    "Turkey",
    "Ham"
  };
}