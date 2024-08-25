import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
        Contact contact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with given ID does not exist.");
        }
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContactById(contactId);
        contact.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContactById(contactId);
        contact.setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        Contact contact = getContactById(contactId);
        contact.setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        Contact contact = getContactById(contactId);
        contact.setAddress(address);
    }

    public Contact getContactById(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with given ID does not exist.");
        }
        return contact;
    }
}
