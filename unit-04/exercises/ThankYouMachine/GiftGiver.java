//
// This class represents a person who has given you a gift, and requires
// a thank you note. Instances of this class should be created when reading
// the mailing_list.csv file in MailingList.java
//
public class GiftGiver {
  private String name;
  private String gift;
  private String address1;
  private String address2;

  public GiftGiver(String name, String gift, String address1, String address2) {
    this.name = name;
    this.gift = gift;
    this.address1 = address1;
    this.address2 = address2;
  }

  public String getName() { return name; }
  public String getGift() { return gift; }
  public String getAddress1() { return address1; }
  public String getAddress2() { return address2; }
}