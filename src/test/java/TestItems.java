import com.example.aventurasdemarcoyluis.model.items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestItems {
    private RedMushroom RedMushroomTest;
    private HoneySyrup HoneySyrupTest;
    private Star starTest;

    @BeforeEach
    public void setUp() {
        RedMushroomTest = new RedMushroom("Red Mushroom");
        HoneySyrupTest = new HoneySyrup("Honey Syrup");
        starTest = new Star("Star");
    }

    @Test
    public void getNameTest() {
        assertEquals(RedMushroomTest.getName(), "Red Mushroom");
        assertEquals(HoneySyrupTest.getName(), "Honey Syrup");
        assertEquals(starTest.getName(), "Star");
    }

    @Test
    public void getTypeTest() {
        assertEquals(RedMushroomTest.getType(), ItemType.RedMushroom);
        assertEquals(HoneySyrupTest.getType(), ItemType.HoneySyrup);
        assertEquals(starTest.getType(), ItemType.STAR);
    }

}
