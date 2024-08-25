// Felicia Mirabel
// CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContactSuccess() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        Contact contact = contactService.getContactById("1234567890");
        assertNotNull(contact);
        assertEquals("Proto", contact.getFirstName());
        assertEquals("Man", contact.getLastName());
        assertEquals("2129092995", contact.getPhone());
        assertEquals("100 Williams St.", contact.getAddress());
    }

    @Test
    public void testAddContactDuplicateId() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact("1234567890", "Jane", "Smith", "0987654321", "456 Elm St");
        });
        assertEquals("Contact ID must be unique.", exception.getMessage());
    }

    @Test
    public void testDeleteContactSuccess() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        contactService.deleteContact("1234567890");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContactById("1234567890");
        });
        assertEquals("Contact with given ID does not exist.", exception.getMessage());
    }

    @Test
    public void testDeleteContactNonExistentId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("1234567890");
        });
        assertEquals("Contact with given ID does not exist.", exception.getMessage());
    }

    @Test
    public void testUpdateFirstNameSuccess() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        contactService.updateFirstName("1234567890", "Wood");
        assertEquals("Wood", contactService.getContactById("1234567890").getFirstName());
    }

    @Test
    public void testUpdateFirstNameTooLong() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("1234567890", "Hockey");
        });
        assertEquals("First name must not be empty and not be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testUpdateLastNameSuccess() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        contactService.updateLastName("1234567890", "Woman");
        assertEquals("Woman", contactService.getContactById("1234567890").getLastName());
    }

    @Test
    public void testUpdateLastNameTooLong() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("1234567890", "ManManManManManManManManManManMan");
        });
        assertEquals("Last name must not be empty and not be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testUpdatePhoneSuccess() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        contactService.updatePhone("1234567890", "2125551212");
        assertEquals("2125551212", contactService.getContactById("1234567890").getPhone());
    }

    @Test
    public void testUpdatePhoneNotTenDigits() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("1234567890", "15556664444");
        });
        assertEquals("Phone must not be empty and must be 10 characters.", exception.getMessage());
    }

    @Test
    public void testUpdateAddressSuccess() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        contactService.updateAddress("1234567890", "465 Jefferson Ave.");
        assertEquals("465 Jefferson Ave.", contactService.getContactById("1234567890").getAddress());
    }

    @Test
    public void testUpdateAddressTooLong() {
        contactService.addContact("1234567890", "Proto", "Man", "2129092995", "100 Williams St.");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("1234567890", "465 Jefferson Ave., Staten Island, New York, 10306");
        });
        assertEquals("Address must not be empty and not be longer than 30 characters.", exception.getMessage());
    }
}
