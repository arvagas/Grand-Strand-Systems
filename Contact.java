/*
 * Arvin Agas
 * Southern New Hampshire University 
 * CS320: Software Test, Automation QA
 * April 12, 2026
*/

public class Contact {
	// Required fields
	private final String contactId;		// Not null, not updatable, <=10 characters
	private String firstName;			// Not null, <=10 characters
	private String lastName;			// Not null, <=10 characters
	private String phone;				// Not null, == 10 characters
	private String address;				// Not null, <=30 characters
	
	// Constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// Run validity checks on all inputs
		if (contactId == null || contactId.length() > 10 ) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		
		if (firstName == null || firstName.length() > 10 ) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		if (lastName == null || lastName.length() > 10 ) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		if (phone == null || phone.length() != 10 ) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		if (address == null || address.length() > 30 ) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		// Assign inputs to object fields
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getters and setters
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		// Check firstName validity first
		if (firstName == null || firstName.length() > 10 ) {
			throw new IllegalArgumentException("Invalid first name");
		}
		
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		// Check lastName validity first
		if (lastName == null || lastName.length() > 10 ) {
			throw new IllegalArgumentException("Invalid last name");
		}
		
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		// Check phone number validity first
		if (phone == null || phone.length() != 10 ) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		// Check address validity first
		if (address == null || address.length() > 30 ) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.address = address;
	}
}
