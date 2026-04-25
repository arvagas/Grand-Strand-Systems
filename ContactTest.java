/*
 * Arvin Agas
 * Southern New Hampshire University 
 * CS320: Software Test, Automation QA
 * April 12, 2026
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	// contact object created successfully
	@Test
	void testContactObjectSuccess() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		assertTrue(contact.getContactId().equals("1"));
		assertTrue(contact.getFirstName().equals("Ghost"));
		assertTrue(contact.getLastName().equals("Buster"));
		assertTrue(contact.getPhone().equals("2162452368"));
		assertTrue(contact.getAddress().equals("14 North Moore St, NYC 10013"));
	}

	// contact object fails to create due to id length > 10
	@Test
	void testContactIdTooLong() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("NEWYORKECTO-1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid contact ID", exception.getMessage());
	}

	// contact object fails to create due to first name length > 10
	@Test
	void testContactFirstNameTooLong() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Marshmallow", "Man", "2162452368", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid first name", exception.getMessage());
	}

	// contact object fails to create due to last name length > 10
	@Test
	void testContactLastNameTooLong() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Slimer", "TheGreenGhost", "2162452368", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid last name", exception.getMessage());
	}
	
	// contact object fails to create due to phone length > 10
	@Test
	void testContactPhoneNumberTooMany() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Ghost", "Buster", "0002162452368", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid phone number", exception.getMessage());
	}
	
	// contact object fails to create due to phone length < 10
	@Test
	void testContactPhoneNumberNotEnough() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Ghost", "Buster", "2452368", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid phone number", exception.getMessage());
	}

	// contact object fails to create due to address length > 30
	@Test
	void testContactAddressTooLong() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore Street, Manhattan, NYC, NY 10013");
		});
		
		assertEquals("Invalid address", exception.getMessage());
	}
	
	// contact object updates first name successfully
	@Test
	void testContactFirstNameUpdateSuccess() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		contact.setFirstName("Ghostie");
		assertTrue(contact.getContactId().equals("1"));
		assertTrue(contact.getFirstName().equals("Ghostie"));
		assertTrue(contact.getLastName().equals("Buster"));
		assertTrue(contact.getPhone().equals("2162452368"));
		assertTrue(contact.getAddress().equals("14 North Moore St, NYC 10013"));
	}
	
	// contact object fails to update due to first name length > 10
	@Test
	void testContactUpdateFirstNameTooLong() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("Marshmallow");
		});

		assertEquals("Invalid first name", exception.getMessage());
	}
	
	// contact object updates last name successfully
	@Test
	void testContactLastNameUpdateSuccess() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		contact.setLastName("Buttery");
		assertTrue(contact.getContactId().equals("1"));
		assertTrue(contact.getFirstName().equals("Ghost"));
		assertTrue(contact.getLastName().equals("Buttery"));
		assertTrue(contact.getPhone().equals("2162452368"));
		assertTrue(contact.getAddress().equals("14 North Moore St, NYC 10013"));
	}
	
	// contact object fails to update due to last name length > 10
	@Test
	void testContactUpdateLastNameTooLong() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("TheGreenGhost");
		});

		assertEquals("Invalid last name", exception.getMessage());
	}
	
	// contact object updates phone number successfully
	@Test
	void testContactPhoneUpdateSuccess() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		contact.setPhone("8632542612");
		assertTrue(contact.getContactId().equals("1"));
		assertTrue(contact.getFirstName().equals("Ghost"));
		assertTrue(contact.getLastName().equals("Buster"));
		assertTrue(contact.getPhone().equals("8632542612"));
		assertTrue(contact.getAddress().equals("14 North Moore St, NYC 10013"));
	}
	
	// contact object fails to update due to phone number length > 10
	@Test
	void testContactUpdatePhoneTooLong() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("12162452368");
		});

		assertEquals("Invalid phone number", exception.getMessage());
	}
	
	// contact object fails to update due to phone number < 10
	@Test
	void testContactUpdatePhoneNotEnough() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("2452368");
		});

		assertEquals("Invalid phone number", exception.getMessage());
	}
	
	// contact object updates address successfully
	@Test
	void testContactAddressSuccess() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		contact.setAddress("41 South Leess Ave, CYN 31001");
		assertTrue(contact.getContactId().equals("1"));
		assertTrue(contact.getFirstName().equals("Ghost"));
		assertTrue(contact.getLastName().equals("Buster"));
		assertTrue(contact.getPhone().equals("2162452368"));
		assertTrue(contact.getAddress().equals("41 South Leess Ave, CYN 31001"));
	}
	
	// contact object fails to update due to address length > 30
	@Test
	void testContactUpdateAddressTooLong() {
		Contact contact = new Contact("1", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("14 North Moore Street, Manhattan, NYC, NY 10013");
		});

		assertEquals("Invalid address", exception.getMessage());
	}

}
