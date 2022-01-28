import com.example.aventurasdemarcoyluis.model.items.*;
import com.example.aventurasdemarcoyluis.model.players.Luis;
import com.example.aventurasdemarcoyluis.model.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestInventory {
    private Inventory InventoryTest;
    private RedMushroom RMushroom;
    private RedMushroom RMushroom2;
    private HoneySyrup HSyrup;
    private HoneySyrup HSyrup2;

    @BeforeEach
    public void setUp() {
        RMushroom = new RedMushroom();
        RMushroom2 = new RedMushroom();
        HSyrup = new HoneySyrup();
        HSyrup2 = new HoneySyrup();
        InventoryTest = new Inventory();
    }

    @Test
    public void emptyTest() {
        assertTrue(InventoryTest.isEmpty());
        assertEquals(0, InventoryTest.value(RMushroom));
        assertEquals(0, InventoryTest.value(HSyrup));
    }

    @Test
    public void addTest() {
        assertTrue(InventoryTest.isEmpty());
        InventoryTest.add(RMushroom, 1);
        InventoryTest.add(RMushroom2, 1);
        InventoryTest.add(HSyrup, 1);
        InventoryTest.add(HSyrup2, 1);
        assertTrue(InventoryTest.has(RMushroom));
        assertTrue(InventoryTest.has(RMushroom2));
        assertTrue(InventoryTest.has(HSyrup));
        assertTrue(InventoryTest.has(HSyrup2));
    }

    @Test
    public void takeTest() {
        assertTrue(InventoryTest.isEmpty());
        InventoryTest.add(RMushroom, 5);
        InventoryTest.add(HSyrup, 3);
        InventoryTest.takeItem(RMushroom);
        InventoryTest.takeItem(HSyrup);
        assertEquals(4, InventoryTest.value(RMushroom2));
        assertEquals(2, InventoryTest.value(HSyrup));
    }

    @Test
    public void useRedMushroomTest() {
        Marco MarcoTest = new Marco("Marco", 10, 10, 10, 10, 10, 10, 20);
        Luis LuisTest = new Luis("Luis", 10, 10, 10, 10, 10, 10, 20);
        InventoryTest.useItem(MarcoTest, RMushroom);
        InventoryTest.useItem(LuisTest, RMushroom);
        assertEquals(10, MarcoTest.getHP());
        assertEquals(10, LuisTest.getHP());

        RedMushroom redMushroom = new RedMushroom();
        InventoryTest.add(redMushroom, 2);
        InventoryTest.useItem(MarcoTest, redMushroom);
        InventoryTest.useItem(LuisTest, redMushroom);
        assertEquals(12, MarcoTest.getHP());
        assertEquals(12, LuisTest.getHP());
    }

    @Test
    public void useHoneySyrupTest() {
        Marco MarcoTest = new Marco("Marco", 10, 10, 10, 10, 10, 15, 20);
        Luis LuisTest = new Luis("Luis", 10, 10, 10, 10, 10, 15, 20);
        InventoryTest.useItem(MarcoTest, HSyrup);
        InventoryTest.useItem(LuisTest, HSyrup);
        assertEquals(10, MarcoTest.getFp());
        assertEquals(10, LuisTest.getFp());

        HoneySyrup honeySyrup = new HoneySyrup();
        InventoryTest.add(honeySyrup, 2);
        InventoryTest.useItem(MarcoTest, honeySyrup);
        InventoryTest.useItem(LuisTest, honeySyrup);
        assertEquals(13, MarcoTest.getFp());
        assertEquals(13, LuisTest.getFp());
    }
}
