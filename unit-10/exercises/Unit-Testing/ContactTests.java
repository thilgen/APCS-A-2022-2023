import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ContactTests {

  @Test
  public void ContactNull() {
    Contact contact = new Contact(null);
    assertEquals(null, contact.getAreaCode());
    assertEquals(null, contact.getPhoneNumber());
  }

  @Test
  public void ContactMalformed() {
    Contact contact;
  
    contact = new Contact("");
    assertEquals(null, contact.getAreaCode());
    assertEquals(null, contact.getPhoneNumber());
  
    contact = new Contact("123");
    assertEquals(null, contact.getAreaCode());
    assertEquals(null, contact.getPhoneNumber());
  
    contact = new Contact("123456789-");
    assertEquals(null, contact.getAreaCode());
    assertEquals(null, contact.getPhoneNumber());
  }

  @Test
  public void ContactNominal() {
    Contact contact = new Contact("1234567890");
    assertEquals("123", contact.getAreaCode());
    assertEquals("(123) 456-7890", contact.getPhoneNumber());
  }
}
