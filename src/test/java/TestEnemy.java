
import com.example.aventurasdemarcoyluis.model.enemies.Boo;
import com.example.aventurasdemarcoyluis.model.enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.players.Luis;
import com.example.aventurasdemarcoyluis.model.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEnemy {

    private Goomba goombaTest;
    private Boo booTest;
    private Spiny spinyTest;
    private Marco MarcoTest;
    private Luis LuisTest;

    @BeforeEach
    public void setUp() {
        MarcoTest = new Marco("Marco",100, 100, 10, 2, 1, 10, 100);
        LuisTest = new Luis("Luis",30, 50, 20, 6, 5, 7, 110);
        goombaTest = new Goomba("Goomba",2,4,15,8);
        booTest = new Boo("Boo",50, 3, 10, 5);
        spinyTest = new Spiny("Spiny", 30, 10, 10, 5);
    }


    @Test
    public void equalsNameTest() {
        assertNotEquals(goombaTest.getName(), booTest.getName());
        assertNotEquals(spinyTest.getName(), goombaTest.getName());
    }

    @Test
    public void equalsDEF() {assertEquals(goombaTest.getDEF(), 15); assertEquals(booTest.getDEF(), 10);}

    @Test
    public void getHPTest() {
        goombaTest.setHP(20);
        booTest.setHP(50);
        assertEquals(goombaTest.getHP(), 20);
        assertNotEquals(booTest.getHP(), 70);
    }

    @Test
    public void setATKTest() {
        goombaTest.setATK(40);
        booTest.setATK(40);
        assertEquals(goombaTest.getATK(), 40);
        assertNotEquals(booTest.getATK(), 50);
    }

    @Test
    public void isKOTest() {
        assertFalse(goombaTest.isKO());
        assertFalse(booTest.isKO());
        assertFalse(spinyTest.isKO());
    }

    @Test
    public void attackFailTest() {
        goombaTest.setHP(0);
        spinyTest.setHP(0);
        booTest.setHP(0);
        goombaTest.attackPlayer(LuisTest);
        goombaTest.attackPlayer(MarcoTest);
        assertEquals(100, MarcoTest.getHP());
        assertEquals(30, LuisTest.getHP());
        assertEquals(100, MarcoTest.getHP());
        assertEquals(30, LuisTest.getHP());
        assertEquals(100, MarcoTest.getHP());
        assertEquals(30, LuisTest.getHP());
    }

    @Test
    public void goombaAttackTest() {
        goombaTest.attackPlayer(MarcoTest);
        goombaTest.attackPlayer(LuisTest);
        assertEquals(98, MarcoTest.getHP());
        assertEquals(29, LuisTest.getHP());
    }

    @Test
    public void spinyAttackTest() {
        spinyTest.attackPlayer(MarcoTest);
        spinyTest.attackPlayer(LuisTest);
        assertEquals(97, MarcoTest.getHP());
        assertEquals(29, LuisTest.getHP());
    }

    @Test
    public void booAttackTest() {
        booTest.attackPlayer(MarcoTest);
        booTest.attackPlayer(LuisTest);
        assertEquals(100, MarcoTest.getHP());
        assertEquals(30, LuisTest.getHP());
    }

    @Test
    public void isEnemyTest() {
        assertTrue(booTest.isEnemy());
        assertTrue(goombaTest.isEnemy());
        assertTrue(spinyTest.isEnemy());
    }

}



