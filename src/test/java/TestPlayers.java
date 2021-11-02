import com.example.aventurasdemarcoyluis.model.*;
import com.example.aventurasdemarcoyluis.model.enemies.Boo;
import com.example.aventurasdemarcoyluis.model.enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.items.*;
import com.example.aventurasdemarcoyluis.model.players.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayers {
    private Marco MarcoTest;
    private Luis LuisTest;
    private Goomba goombaTest;
    private Boo booTest;
    private Spiny spinyTest;

    @BeforeEach
    public void setUp() {
        MarcoTest = new Marco("Marco",100, 100, 100, 2, 1, 10, 100);
        LuisTest = new Luis("Luis",50, 50, 20, 6, 5, 7, 110);
        goombaTest = new Goomba("Goomba",2,4,15,8);
        booTest = new Boo("Boo",50, 3, 10, 5);
        spinyTest = new Spiny("Spiny", 30, 10, 10, 5);
    }

    @Test
    public void getNameTest() {
        assertEquals(MarcoTest.getName(), "Marco");
        assertEquals(LuisTest.getName(), "Luis");
    }

    @Test
    public void addItemTest() {
        RedMushroom redMushroomTest = new RedMushroom("Red Mushroom");
        HoneySyrup honeySyrupTest = new HoneySyrup("Honey Syrup");
        MarcoTest.addAItem(redMushroomTest);
        MarcoTest.addAItem(honeySyrupTest);
        LuisTest.addAItem(honeySyrupTest);
        assertEquals(MarcoTest.armamento.toArray().length, 2);
        assertEquals(LuisTest.armamento.toArray().length, 1);
    }
    @Test
    public void setHPTest() {
        MarcoTest.setHP(150);
        assertEquals(MarcoTest.getHP(), 100);
    }

    @Test
    public void getMaxFPTest() {
        assertEquals(MarcoTest.getMaxFP(), 10);
        assertEquals(LuisTest.getMaxFP(), 7);
    }

    @Test
    public void useRedMushroomTest() {
        RedMushroom redMushroomTest = new RedMushroom("Red Mushroom");
        MarcoTest.setHP(70);
        LuisTest.setHP(100);
        MarcoTest.addAItem(redMushroomTest);
        LuisTest.addAItem(redMushroomTest);
        MarcoTest.useRedMushroom(redMushroomTest);
        LuisTest.useRedMushroom(redMushroomTest);
        assertEquals(MarcoTest.getHP(), 80);
        assertEquals(LuisTest.getHP(), 110);
        assertEquals(MarcoTest.armamento.toArray().length, 0);
        assertEquals(LuisTest.armamento.toArray().length, 0);
    }

    @Test
    public void useHoneySyrupTest() {
        HoneySyrup honeySyrupTest = new HoneySyrup("Honey Syrup");
        MarcoTest.addAItem(honeySyrupTest);
        LuisTest.addAItem(honeySyrupTest);
        MarcoTest.useHoneySyrup(honeySyrupTest);
        LuisTest.useHoneySyrup(honeySyrupTest);
        assertEquals(MarcoTest.getFp(), 4);
        assertEquals(LuisTest.getFp(), 7);
        assertEquals(MarcoTest.armamento.toArray().length, 0);
        assertEquals(LuisTest.armamento.toArray().length, 0);

    }

    @Test
    public void useStarTest() {
        Star starTest = new Star("Star");
        MarcoTest.addAItem(starTest);
        LuisTest.addAItem(starTest);
        MarcoTest.useStar(starTest);
        LuisTest.useStar(starTest);
        assertEquals(MarcoTest.getMaxHP(), 100);
        assertEquals(LuisTest.getMaxHP(), 110);
    }

    @Test
    public void knockoutTest() {
        MarcoTest.setHP(0);
        assertTrue(MarcoTest.isKO());
        assertFalse(LuisTest.isKO());
    }



    @Test
    public void setDEFTest() {
        MarcoTest.setDEF(40);
        LuisTest.setDEF(50);
        assertEquals(MarcoTest.getDEF(), 40);
        assertNotEquals(LuisTest.getDEF(), 40);
    }

    @Test
    public void setLVLTest() {
        MarcoTest.setLVL(5);
        LuisTest.setLVL(4);
        assertNotEquals(MarcoTest.getLVL(), 7);
        assertEquals(LuisTest.getLVL(), 4);
    }

    @Test
    public void attackSaltoTest() {
        MarcoTest.setHP(0);
        LuisTest.setHP(0);
        MarcoTest.attackGoomba(AttackType.SALTO, goombaTest);
        MarcoTest.attackBoo(AttackType.SALTO, booTest);
        MarcoTest.attackSpiny(AttackType.SALTO, spinyTest);
        LuisTest.attackGoomba(AttackType.SALTO, goombaTest);
        LuisTest.attackBoo(AttackType.SALTO, booTest);
        assertEquals(goombaTest.getHP(), 2);
        assertEquals(booTest.getHP(), 50);
        assertEquals(spinyTest.getHP(), 30);
    }
    @Test
    public void attackMartiloTest() {
        MarcoTest.setHP(0);
        LuisTest.setHP(0);
        MarcoTest.attackGoomba(AttackType.MARTILLO, goombaTest);
        MarcoTest.attackBoo(AttackType.MARTILLO, booTest);
        MarcoTest.attackSpiny(AttackType.MARTILLO, spinyTest);
        LuisTest.attackGoomba(AttackType.MARTILLO, goombaTest);
        LuisTest.attackBoo(AttackType.MARTILLO, booTest);
        assertEquals(goombaTest.getHP(), 2);
        assertEquals(booTest.getHP(), 50);
        assertEquals(spinyTest.getHP(), 30);
    }
}