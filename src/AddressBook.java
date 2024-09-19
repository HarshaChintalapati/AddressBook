import java.util.*;

public class AddressBook {
    List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public Contact findContactByName(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public boolean editContact(String firstName, String lastName, Contact updatedContact) {
        Contact contact = findContactByName(firstName, lastName);
        if
        (contact != null) {
            contact.setFirstName(updatedContact.getFirstName());
            contact.setLastName(updatedContact.getLastName());
            contact.setAddress(updatedContact.getAddress());
            contact.setCity(updatedContact.getCity());
            contact.setState(updatedContact.getState());
            contact.setZip(updatedContact.getZip());
            contact.setPhoneNumber(updatedContact.getPhoneNumber());
            contact.setEmail(updatedContact.getEmail());
            return true;

        }
        return false;
    }
    public boolean deleteContact(String firstName,String lastName) {
        Contact contact = findContactByName(firstName, lastName);
        if (contact != null) {
            contacts.remove(contact);
            return true;
        }
        return false;

    }
}



