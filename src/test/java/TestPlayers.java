
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
        MarcoTest = new Marco("Marco",100, 100, 100, 2, 50, 100, 100);
        LuisTest = new Luis("Luis",50, 50, 20, 6, 10, 12, 110);
        goombaTest = new Goomba("Goomba",2,4,15,8);
        booTest = new Boo("Boo",50, 3, 10, 5);
        spinyTest = new Spiny("Spiny", 30, 10, 10, 5);
        MarcoTest.setSeed(1);
        LuisTest.setSeed(1);
    }

    @Test
    public void getNameTest() {
        assertEquals(MarcoTest.getName(), "Marco");
        assertEquals(LuisTest.getName(), "Luis");
    }

    @Test
    public void setHPTest() {
        MarcoTest.setHP(150);
        assertEquals(MarcoTest.getHP(), 100);
    }

    @Test
    public void setIncorrectFPTest() {
        MarcoTest.setFp(-10);
        LuisTest.setFp(-30);
        assertEquals(0, MarcoTest.getFp());
        assertEquals(0, LuisTest.getFp());
    }

    @Test
    public void getMaxFPTest() {
        assertEquals(MarcoTest.getMaxFP(), 100);
        assertEquals(LuisTest.getMaxFP(), 12);
    }

    @Test
    public void setMaxHPTest() {
        MarcoTest.setMaxHP(150);
        LuisTest.setMaxHP(150);
        assertEquals(150, MarcoTest.getMaxHP());
        assertEquals(150, LuisTest.getMaxHP());
    }

    @Test
    public void setMaxFPTest() {
        MarcoTest.setMaxFP(30);
        LuisTest.setMaxFP(30);
        assertEquals(30, MarcoTest.getMaxFP());
        assertEquals(30, LuisTest.getMaxFP());
    }

    @Test
    public void useRedMushroomTest() {
        RedMushroom redMushroomTest = new RedMushroom();
        MarcoTest.setHP(70);
        LuisTest.setHP(100);
        MarcoTest.useItem(redMushroomTest);
        LuisTest.useItem(redMushroomTest);
        assertEquals(MarcoTest.getHP(), 80);
        assertEquals(LuisTest.getHP(), 110);
    }

    @Test
    public void useHoneySyrupTest() {
        HoneySyrup honeySyrupTest = new HoneySyrup();
        MarcoTest.useItem(honeySyrupTest);
        LuisTest.useItem(honeySyrupTest);
        assertEquals(MarcoTest.getFp(), 53);
        assertEquals(LuisTest.getFp(), 12);
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
    public void failAttackTest() {
        MarcoTest.setHP(0);
        LuisTest.setHP(0);
        MarcoTest.jumpAttack(goombaTest);
        MarcoTest.jumpAttack(spinyTest);
        MarcoTest.jumpAttack(booTest);
        LuisTest.jumpAttack(goombaTest);
        LuisTest.jumpAttack(booTest);
        LuisTest.jumpAttack(spinyTest);
        assertEquals(goombaTest.getHP(), 2);
        assertEquals(booTest.getHP(), 50);
        assertEquals(spinyTest.getHP(), 30);
    }

    @Test
    public void marcoJumpAttackTest() {
        MarcoTest.jumpAttack(goombaTest);
        MarcoTest.jumpAttack(spinyTest);
        MarcoTest.jumpAttack(booTest);
        assertEquals(0, goombaTest.getHP());
        assertEquals(30, spinyTest.getHP());
        assertEquals(95, MarcoTest.getHP());
        assertEquals(30, booTest.getHP());
    }

    @Test
    public void luisJumpAttackTest() {
        LuisTest.jumpAttack(goombaTest);
        LuisTest.jumpAttack(spinyTest);
        LuisTest.jumpAttack(booTest);
        assertEquals(0, goombaTest.getHP());
        assertEquals(50, booTest.getHP());
        assertEquals(30, spinyTest.getHP());
        assertEquals(48, LuisTest.getHP());
    }

    @Test
    public void marcoHammerAttackTest() {
        MarcoTest.hammerAttack(goombaTest);
        MarcoTest.hammerAttack(spinyTest);
        assertEquals(0, goombaTest.getHP());
        assertEquals(30, spinyTest.getHP());
        MarcoTest.hammerAttack(spinyTest);
        assertEquals(0, spinyTest.getHP());
        MarcoTest.hammerAttack(booTest);
        assertEquals(20, booTest.getHP());
        assertEquals(44, MarcoTest.getFp());
    }

    @Test
    public void luisHammerAttackTest() {
        LuisTest.hammerAttack(goombaTest);
        LuisTest.hammerAttack(spinyTest);
        assertEquals(0, goombaTest.getHP());
        assertEquals(30, spinyTest.getHP());
        LuisTest.hammerAttack(booTest);
        assertEquals(50, booTest.getHP());
        LuisTest.hammerAttack(spinyTest);
        assertEquals(0, spinyTest.getHP());
    }


}