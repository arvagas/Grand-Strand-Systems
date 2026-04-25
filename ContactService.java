/*
 * Arvin Agas
 * Southern New Hampshire University 
 * CS320: Software Test, Automation QA
 * April 12, 2026
*/

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	// Generate unique IDs for new contacts
	int idGenerator = 0;
	
	// Hashmap to store Contact objects and retrieve by contactId quickly
	private Map<String, Contact> contacts = new HashMap<String, Contact>();
	
	// Accessible only for testing
	protected Map<String, Contact> getContacts () {
		return contacts;
	}
	
	// Add new contact
	public void addContact(String firstName, String lastName, String phone, String address) {
		Contact contact = new Contact(String.valueOf(idGenerator), firstName, lastName, phone, address);
		
		// Increase generator for next usage
		idGenerator++;
		
		// Add to contacts list
		contacts.put(contact.getContactId(), contact);
	}
	
	// Adds new contact; Accessible only for testing duplicate input IDs
	protected void addContact(Contact contact) {
		// Check to make sure task does not exist
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact with ID already exists");
		}
		
		// Add to tasks list
		contacts.put(contact.getContactId(), contact);
	}
	
	// Delete an existing contact
	public void deleteContact(String contactId) {
		// Check to make sure contact exists
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact does not exist");
		}
		
		contacts.remove(contactId);
	}
	
	// Update an existing contact
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		// Check to make sure contact exists
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact does not exist");
		}
		
		// Grab reference of existing contact
		Contact contact = contacts.get(contactId);
		
		// Update existing contact with new information
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhone(phone);
		contact.setAddress(address);
	}
	
	
}
