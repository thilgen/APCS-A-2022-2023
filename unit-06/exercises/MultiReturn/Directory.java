class Directory {
  private String name1 = "Susan Berry";
  private String name2 = "Carol Le";
  private String name3 = "Sharon Cardenas";
  private String name4 = "Linda Walton";
  private String name5 = "Sandra Andersen";
  
  public String getName1() {
    return name1;
  }
  
  public String getName2() {
    return name2;
  }
  
  public String getName3() {
    return name3;
  }
  
  public String getName4() {
    return name4;
  }

  public String getName5() {
    return name5;
  }

  public String[] getNames() {
    String[] names = { name1, name2, name3, name4, name5 };
    return names;
  }
}