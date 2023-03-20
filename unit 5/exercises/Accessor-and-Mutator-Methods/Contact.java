public class Contact
{
  public String phoneNumber;
  public String areaCode;
  
  public Contact(String initPhoneNumber) {
    phoneNumber = initPhoneNumber.substring(0,3);
    phoneNumber += "-" + initPhoneNumber.substring(3, 6);
    phoneNumber += "-" + initPhoneNumber.substring(6);    
    areaCode = phoneNumber.substring(0,3);
  }
}
