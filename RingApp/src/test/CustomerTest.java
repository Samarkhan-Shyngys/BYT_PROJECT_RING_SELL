package test;


import junit.framework.TestCase;
import main.Customer;
import org.junit.Test;


public class CustomerTest extends TestCase {
    private final Customer customer = new Customer("Bob", "Craw", "156-111-222", "Warsaw");

    @Test
    public void testTestGetFirstName() {
        assertEquals("Bob", customer.getFirstName());
    }
    @Test
    public void testGetLastname() {
        assertEquals("Craw", customer.getLastName());
    }
    @Test
    public void testGetPhoneNumber() {
        assertEquals("156-111-222", customer.getPhoneNumber());
    }

    @Test
    public void testGetAddress() {
        assertEquals("Warsaw", customer.getAddress().getNameOfAddress());
    }

    @Test
    public void testTestSetFirstName() {
        assertEquals("Bob", customer.getFirstName());
        customer.setFirstName("Ala");
        assertEquals("Ala", customer.getFirstName());
        try {
            customer.setFirstName(null);
            fail();
        } catch (NullPointerException ignored) {
        }
    }
    @Test
    public void testTestSetLastName() {
        assertEquals("Craw", customer.getLastName());
        customer.setLastName("Drud");
        assertEquals("Drud", customer.getLastName());
        try {
            customer.setLastName(null);
            fail();
        } catch (NullPointerException ignored) {
        }
    }
    @Test
    public void testTestSetPhoneNumber() {
        assertEquals("156-111-222", customer.getPhoneNumber());
        customer.setPhoneNumber("156-111-333");
        assertEquals("156-111-333", customer.getPhoneNumber());
        try {
            customer.setPhoneNumber(null);
            fail();
        } catch (NullPointerException ignored) {
        }
    }
}
