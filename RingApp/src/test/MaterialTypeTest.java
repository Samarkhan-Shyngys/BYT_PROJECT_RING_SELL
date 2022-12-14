package test;

import junit.framework.TestCase;
import main.MaterialType;
import org.junit.Test;

public class MaterialTypeTest extends TestCase {
    private final MaterialType materialType = new MaterialType("Gold", "It is a dense, " +
            "lustrous, yellow, malleable precious metal", 100.0);

    @Test
    public void testTestGetMaterialName() {
        assertEquals("Gold", materialType.getName());
    }
    @Test
    public void testGetPriceForGram() {
        assertEquals(100.0, materialType.getPriceForOneGram());
    }

    @Test
    public void testTestSetPriceForGram() {
        assertEquals(100.0, materialType.getPriceForOneGram());
        materialType.setPriceForOneGram(200.0);
        assertEquals(200.0, materialType.getPriceForOneGram());
        try {
            materialType.setPriceForOneGram(null);
            fail();
        } catch (NullPointerException ignored) {
        }
    }
}
