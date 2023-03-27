public class Contact {
  public String phoneNumber;
  public String areaCode;
  public String displayString;

  public Contact(String initPhoneNumber) {
    if ((null != initPhoneNumber) && (initPhoneNumber.matches("[0-9]{10}"))) {
      areaCode = initPhoneNumber.substring(0, 3);
      phoneNumber = initPhoneNumber.substring(3);
      displayString = String.format("(%s) %s-%s", areaCode, phoneNumber.substring(0,3), phoneNumber.substring(3));
    }
  }

  public String getAreaCode() {
    return areaCode;
  }

  public String getPhoneNumber() {
    return displayString;
  }
}
