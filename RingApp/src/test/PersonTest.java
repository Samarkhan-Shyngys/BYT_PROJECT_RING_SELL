package test;

import junit.framework.TestCase;
import main.Customer;
import main.Person;
import org.junit.Test;

public class PersonTest extends TestCase {
    private final Person person = new Customer("Bob", "Craw", "516-111-222", "Warsaw");
    @Test
    public void testTestGetFirstName() {
        assertEquals("Bob", person.getFirstName());
    }
    @Test
    public void testGetLastname() {
        assertEquals("Craw", person.getLastName());
    }
    @Test
    public void testGetAddress() {
        assertEquals("Warsaw", person.getAddress().getNameOfAddress());
    }

    @Test
    public void testTestSetFirstName() {
        assertEquals("Bob", person.getFirstName());
        person.setFirstName("Ala");
        assertEquals("Ala", person.getFirstName());
        try {
            person.setFirstName(null);
            fail();
        } catch (NullPointerException ignored) {
        }
    }

}
