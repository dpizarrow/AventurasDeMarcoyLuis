import com.example.aventurasdemarcoyluis.model.enemies.*;
import com.example.aventurasdemarcoyluis.model.players.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;


public class TestFactory {
    private GoombaFactory GFactory;
    private SpinyFactory SFactory;
    private BooFactory BFactory;
    private Luis LuisTest;
    private Marco MarcoTest;
    private Hashtable<Integer, IEnemy> enemyTable;

    @BeforeEach
    public void setUp() {
        GFactory = new GoombaFactory();
        SFactory = new SpinyFactory();
        BFactory = new BooFactory();
        LuisTest = new Luis("Luis", 10, 10, 10, 1, 10, 10, 10);
        MarcoTest = new Marco("Marco", 10, 10, 10, 1, 10, 10, 10);
        enemyTable = new Hashtable<>();
    }


    @Test
    public void goombaFactoryTest() {
        enemyTable = GFactory.create(10);
        for(int i = 1; i <= 10; i++) {
            enemyTable.get(i).attackPlayer(LuisTest);
            enemyTable.get(i).attackPlayer(MarcoTest);
            assertEquals(10-i, LuisTest.getHP());
            assertEquals(10-i, MarcoTest.getHP());
        }
    }

    @Test
    public void spinyFactoryTest() {
        enemyTable = SFactory.create(10);
        for(int i = 1; i <= 10; i++) {
            enemyTable.get(i).attackPlayer(LuisTest);
            enemyTable.get(i).attackPlayer(MarcoTest);
            assertEquals(10-i, LuisTest.getHP());
            assertEquals(10-i, MarcoTest.getHP());
        }
    }

    @Test
    public void booFactoryTest() {
        enemyTable = BFactory.create(10);
        for(int i = 1; i <= 10; i++) {
            enemyTable.get(i).attackPlayer(LuisTest);
            enemyTable.get(i).attackPlayer(MarcoTest);
            assertEquals(10-i, LuisTest.getHP());
            assertEquals(10, MarcoTest.getHP());
        }
    }

}
