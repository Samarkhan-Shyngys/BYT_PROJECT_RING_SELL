package test;

import junit.framework.TestCase;
import main.Address;
import main.Jeweler;
import org.junit.Test;

public class JewelerTest extends TestCase {
    private final Jeweler jeweler = new Jeweler("David", "Luis", "516-456-456", "Warsaw", 50.0);

    @Test
    public void testTestGetFirstName() {
        assertEquals("David", jeweler.getFirstName());
    }
    @Test
    public void testGetLastname() {
        assertEquals("Luis", jeweler.getLastName());
    }
    @Test
    public void testGetPhoneNumber() {
        assertEquals("516-456-456", jeweler.getPhoneNumber());
    }

    @Test
    public void testGetAddress() {
        assertEquals("Warsaw", jeweler.getAddress().getNameOfAddress());
    }

    @Test
    public void testTestSetFirstName() {
        assertEquals("David", jeweler.getFirstName());
        jeweler.setFirstName("Ban");
        assertEquals("Ban", jeweler.getFirstName());
        try {
            jeweler.setFirstName(null);
            fail();
        } catch (NullPointerException ignored) {
        }
    }
    @Test
    public void testTestSetLastName() {
        assertEquals("Luis", jeweler.getLastName());
        jeweler.setLastName("Zhan");
        assertEquals("Zhan", jeweler.getLastName());
        try {
            jeweler.setLastName(null);
            fail();
        } catch (NullPointerException ignored) {
        }
    }
    @Test
    public void testTestSetAddress() {
        assertEquals("Warsaw", jeweler.getAddress().getNameOfAddress());
        Address address = new Address("Krakow");
        jeweler.setAddress(address);
        assertEquals("Krakow", jeweler.getAddress().getNameOfAddress());

    }
}
