// Felicia Mirabel
// CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Mega", contact.getFirstName());
        assertEquals("Man", contact.getLastName());
        assertEquals("7186984294", contact.getPhone());
        assertEquals("148 Rice Ave.", contact.getAddress());
    }

    // ContactID
    @Test
    public void testContactIdTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Mega", "Man", "7186984294", "148 Rice Ave.");
        });
        assertEquals("Contact ID must not be empty and not be longer than 10 characters.", exception.getMessage());
    }

    @Test 
    public void testContactIdNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Mega", "Man", "7186984294", "148 Rice Ave.");
        });
        assertEquals("Contact ID must not be empty and not be longer than 10 characters.", exception.getMessage());
    }

    // First Name
    @Test
    public void testFirstNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "MegaManFirstNameIsTooLong", "Man", "7186984294", "148 Rice Ave.");
        });
        assertEquals("First name must not be empty and not be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testFirstNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Man", "7186984294", "148 Rice Ave.");
        });
        assertEquals("First name must not be empty and not be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testSetFirstNameSuccess() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        contact.setFirstName("Proto");
        assertEquals("Proto", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameTooLong() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ProtoProtoProtoProto");
        });
        assertEquals("First name must be non-null and no longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testSetFirstNameNull() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        assertEquals("First name must be non-null and no longer than 10 characters.", exception.getMessage());
    }

    // Last Name
    @Test
    public void testLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mega", "ManLastNameTooLong", "7186984294", "148 Rice Ave.");
        });
        assertEquals("Last name must not be empty and not be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testLastNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mega", null, "7186984294", "148 Rice Ave.");
        });
        assertEquals("Last name must not be empty and not be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testSetLastNameSuccess() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        contact.setLastName("Hero");
        assertEquals("Hero", contact.getLastName());
    }

    @Test
    public void testSetLastNameTooLong() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("ManManManManMan");
        });
        assertEquals("Last name must be non-null and no longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testSetLastNameNull() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        assertEquals("Last name must be non-null and no longer than 10 characters.", exception.getMessage());
    }

    // Phone
    @Test
    public void testPhoneNotTenDigits() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mega", "Man", "123456789", "148 Rice Ave.");
        });
        assertEquals("Phone must not be empty and must be 10 characters.", exception.getMessage());
    }

    @Test
    public void testPhoneNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mega", "Man", null, "148 Rice Ave.");
        });
        assertEquals("Phone must not be empty and must be 10 characters.", exception.getMessage());
    }

    @Test
    public void testSetPhoneSuccess() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        contact.setPhone("6039332264");
        assertEquals("6039332264", contact.getPhone());
    }

    @Test
    public void testSetPhoneNotTenDigits() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("17186984294");
        });
        assertEquals("Phone must be non-null and exactly 10 digits.", exception.getMessage());
    }

    @Test
    public void testSetPhoneNull() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
        assertEquals("Phone must be non-null and exactly 10 digits.", exception.getMessage());
    }

    // Address
    @Test
    public void testAddressTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mega", "Man", "7186984294", "Much too long address that exceeds the length limit");
        });
        assertEquals("Address must not be empty and not be longer than 30 characters.", exception.getMessage());
    }

    @Test
    public void testAddressNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mega", "Man", "7186984294", null);
        });
        assertEquals("Address must not be empty and not be longer than 30 characters.", exception.getMessage());
    }

    @Test
    public void testSetAddressSuccess() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        contact.setAddress("606 Richmond Hill Rd.");
        assertEquals("606 Richmond Hill Rd.", contact.getAddress());
    }

    @Test
    public void testSetAddressTooLong() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("An address that is way too long and does not fit");
        });
        assertEquals("Address must be non-null and no longer than 30 characters.", exception.getMessage());
    }

    @Test
    public void testSetAddressNull() {
        Contact contact = new Contact("1234567890", "Mega", "Man", "7186984294", "148 Rice Ave.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
        assertEquals("Address must be non-null and no longer than 30 characters.", exception.getMessage());
    }
}
