/*
 * Arvin Agas
 * Southern New Hampshire University 
 * CS320: Software Test, Automation QA
 * April 12, 2026
*/

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	// initialize ContactService
	private ContactService service;
	
	// clear service before each test
	@BeforeEach
	public void setup() {
		service = new ContactService();
	}

	// service is initializing as empty successfully
	@Test
	void testContactServiceEmpty() {
		Map<String, Contact> testService = service.getContacts();
		assertTrue(testService.isEmpty());
	}

	// contact added successfully
	@Test
	void testContactServiceAddContactSuccess() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		Map<String, Contact> testService = service.getContacts();
		assertTrue(testService.containsKey("0"));
		assertTrue(testService.get("0").getContactId().equals("0"));
		assertTrue(testService.get("0").getFirstName().equals("Ghost"));
		assertTrue(testService.get("0").getLastName().equals("Buster"));
		assertTrue(testService.get("0").getPhone().equals("2162452368"));
		assertTrue(testService.get("0").getAddress().equals("14 North Moore St, NYC 10013"));
	}
	
	// singular contact add fails due to using existing id
	@Test
	void testContactServiceAddContactExistingId() {
		// manually assigned id as 0
		Contact dupeContactId = new Contact("0", "Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		// will be loaded with id as 0
		service.addContact("Ghostie", "Buttery", "8632542612", "41 South Leess Ave, CYN 31001");

		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(dupeContactId);
		});

		assertEquals("Contact with ID already exists", exception.getMessage());
	}
	
	// singular contact add fails due to first name > 10 chars
	@Test
	void testContactServiceAddContactFirstNameTooLong() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("Marshmallow", "Buster", "8632542612", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid first name", exception.getMessage());
	}
	
	// singular contact add fails due to last name > 10 chars
	@Test
	void testContactServiceAddContactLastNameTooLong() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("Ghost", "TheGreenGhost", "8632542612", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid last name", exception.getMessage());
	}
	
	// singular contact add fails due to phone > 10 chars
	@Test
	void testContactServiceAddContactPhoneTooLong() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("Ghost", "Buster", "18632542612", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid phone number", exception.getMessage());
	}
	
	// singular contact add fails due to phone < 10 chars
	@Test
	void testContactServiceAddContactPhoneTooShort() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("Ghost", "Buster", "2542612", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid phone number", exception.getMessage());
	}
	
	// singular contact add fails due to address > 30 chars
	@Test
	void testContactServiceAddContactAddressTooLong() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("Ghost", "Buster", "8632542612", "14 North Moore Street, Manhattan, NYC, NY 10013");
		});

		assertEquals("Invalid address", exception.getMessage());
	}
	
	// multiple contacts added successfully
	@Test
	void testContactServiceAddContactMultipleSuccess() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		service.addContact("Ghostie", "Buttery", "8632542612", "41 South Leess Ave, CYN 31001");
		
		Map<String, Contact> testService = service.getContacts();
		assertTrue(testService.containsKey("0"));
		assertTrue(testService.containsKey("1"));
	}
	
	// contact first name is updated successfully
	@Test
	void testContactServiceUpdateFirstNameSuccess() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		service.updateContact("0", "Ghostie", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		Map<String, Contact> testService = service.getContacts();
		assertTrue(testService.containsKey("0"));
		assertTrue(testService.get("0").getContactId().equals("0"));
		assertTrue(testService.get("0").getFirstName().equals("Ghostie"));
		assertTrue(testService.get("0").getLastName().equals("Buster"));
		assertTrue(testService.get("0").getPhone().equals("2162452368"));
		assertTrue(testService.get("0").getAddress().equals("14 North Moore St, NYC 10013"));
	}
	
	// contact update fails due to first name > 10 chars
	@Test
	void testContactServiceUpdateFirstNameTooLong() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("0", "Marshmallow", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid first name", exception.getMessage());
	}
	
	// contact last name is updated successfully
	@Test
	void testContactServiceUpdateLastNameSuccess() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		service.updateContact("0", "Ghost", "Buttery", "2162452368", "14 North Moore St, NYC 10013");
		Map<String, Contact> testService = service.getContacts();
		assertTrue(testService.containsKey("0"));
		assertTrue(testService.get("0").getContactId().equals("0"));
		assertTrue(testService.get("0").getFirstName().equals("Ghost"));
		assertTrue(testService.get("0").getLastName().equals("Buttery"));
		assertTrue(testService.get("0").getPhone().equals("2162452368"));
		assertTrue(testService.get("0").getAddress().equals("14 North Moore St, NYC 10013"));
	}
	
	// contact update fails due to last name > 10 chars
	@Test
	void testContactServiceUpdateLastNameTooLong() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("0", "Ghost", "TheGreenGhost", "2162452368", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid last name", exception.getMessage());
	}
	
	// contact phone is updated successfully
	@Test
	void testContactServiceUpdatePhoneSuccess() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		service.updateContact("0", "Ghost", "Buster", "8632542612", "14 North Moore St, NYC 10013");
		Map<String, Contact> testService = service.getContacts();
		assertTrue(testService.containsKey("0"));
		assertTrue(testService.get("0").getContactId().equals("0"));
		assertTrue(testService.get("0").getFirstName().equals("Ghost"));
		assertTrue(testService.get("0").getLastName().equals("Buster"));
		assertTrue(testService.get("0").getPhone().equals("8632542612"));
		assertTrue(testService.get("0").getAddress().equals("14 North Moore St, NYC 10013"));
	}
	
	// contact update fails due to phone > 10 chars
	@Test
	void testContactServiceUpdatePhoneTooLong() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("0", "Ghost", "Buster", "12162452368", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid phone number", exception.getMessage());
	}
	
	// contact update fails due to phone < 10 chars
	@Test
	void testContactServiceUpdatePhoneTooShort() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("0", "Ghost", "Buster", "2452368", "14 North Moore St, NYC 10013");
		});

		assertEquals("Invalid phone number", exception.getMessage());
	}
	
	// contact address is updated successfully
	@Test
	void testContactServiceUpdateAddressSuccess() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		service.updateContact("0", "Ghost", "Buster", "2162452368", "41 South Leess Ave, CYN 31001");
		Map<String, Contact> testService = service.getContacts();
		assertTrue(testService.containsKey("0"));
		assertTrue(testService.get("0").getContactId().equals("0"));
		assertTrue(testService.get("0").getFirstName().equals("Ghost"));
		assertTrue(testService.get("0").getLastName().equals("Buster"));
		assertTrue(testService.get("0").getPhone().equals("2162452368"));
		assertTrue(testService.get("0").getAddress().equals("41 South Leess Ave, CYN 31001"));
	}
	
	// contact update fails due to address > 30 chars
	@Test
	void testContactServiceUpdateAddressTooLong() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("0", "Ghost", "Buster", "2162452368", "14 North Moore Street, Manhattan, NYC, NY 10013");
		});

		assertEquals("Invalid address", exception.getMessage());
	}
	
	// contact update fails due to no existence
	@Test
	void testAppointmentServiceUpdateNonExisting() {
		// loaded as id with 0
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("2", "Ghostie", "Buttery", "8632542612", "41 South Leess Ave, CYN 31001");
		});
		
		assertEquals("Contact does not exist", exception.getMessage());
	}
	
	// contact is deleted successfully
	@Test
	void testContactServiceDeleteSuccess() {
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		service.deleteContact("0");
		
		Map<String, Contact> testService = service.getContacts();
		assertFalse(testService.containsKey("0"));
	}
	
	// contact deletion fails due to no existence
	@Test
	void testAppointmentServiceDeleteNonExisting() {
		// loaded as id with 0
		service.addContact("Ghost", "Buster", "2162452368", "14 North Moore St, NYC 10013");
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("2");
		});
		
		assertEquals("Contact does not exist", exception.getMessage());
	}

}
