
import com.example.aventurasdemarcoyluis.model.*;
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
        MarcoTest = new Marco("Marco",0, 100, 100, 2, 1, 10, 100);
        LuisTest = new Luis("Luis",0, 50, 20, 6, 5, 7, 110);
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
    public void MarcoHammerAttackTest() {
        goombaTest.attackedByMarco(AttackType.MARTILLO, MarcoTest);
        booTest.attackedByMarco(AttackType.MARTILLO, MarcoTest);
        spinyTest.attackedByMarco(AttackType.MARTILLO, MarcoTest);
        assertEquals(goombaTest.getHP(), 2);
        assertEquals(booTest.getHP(), 50);
        assertEquals(spinyTest.getHP(), 30);
    }

    @Test
    public void MarcoJumpAttackTest() {
        goombaTest.attackedByMarco(AttackType.SALTO, MarcoTest);
        booTest.attackedByMarco(AttackType.SALTO, MarcoTest);
        spinyTest.attackedByMarco(AttackType.SALTO, MarcoTest);
        assertEquals(goombaTest.getHP(), 2);
        assertEquals(booTest.getHP(), 50);
        assertEquals(spinyTest.getHP(), 30);
    }

    @Test
    public void LuisHammerAttackTest() {
        goombaTest.attackedByLuis(AttackType.MARTILLO, LuisTest);
        booTest.attackedByLuis(AttackType.MARTILLO, LuisTest);
        assertEquals(goombaTest.getHP(), 2);
        assertEquals(booTest.getHP(), 50);
    }

    @Test
    public void LuisJumpAttackTest() {
        goombaTest.attackedByLuis(AttackType.SALTO, LuisTest);
        booTest.attackedByLuis(AttackType.SALTO, LuisTest);
        assertEquals(goombaTest.getHP(), 2);
        assertEquals(booTest.getHP(), 50);
    }

    @Test
    public void equalsTest() {
        assertFalse(goombaTest.equals(spinyTest));
        assertFalse(booTest.equals(goombaTest));
    }

}



