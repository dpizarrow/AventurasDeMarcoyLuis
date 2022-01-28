
import com.example.aventurasdemarcoyluis.controller.GameController;
import com.example.aventurasdemarcoyluis.model.enemies.Boo;
import com.example.aventurasdemarcoyluis.model.enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.enemies.Spiny;
import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.items.RedMushroom;
import com.example.aventurasdemarcoyluis.model.players.Luis;
import com.example.aventurasdemarcoyluis.model.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class TestController {

    private GameController controller;

    @BeforeEach
    public void setUp() {
        controller = new GameController();
    }

    @Test
    public void testSetup() {
        // This seed generates 1 Goomba, 1 Boo and 1 Spiny in that order
        controller.setSeed(1);
        controller.setUpGame();
        assertEquals(Marco.class, controller.getPlayers().get(0).getClass());
        assertEquals(Luis.class, controller.getPlayers().get(1).getClass());
        RedMushroom redMushroom = new RedMushroom();
        HoneySyrup honeySyrup = new HoneySyrup();
        assertTrue(controller.getInventory().has(redMushroom));
        assertTrue(controller.getInventory().has(honeySyrup));
        assertEquals(3, controller.getInventory().value(redMushroom));
        assertEquals(3, controller.getInventory().value(honeySyrup));
        assertEquals(1, controller.getRandom().nextInt(4));
        assertEquals(Goomba.class, controller.getEnemies().get(0).getClass());
        assertEquals(Boo.class, controller.getEnemies().get(1).getClass());
        assertEquals(Spiny.class, controller.getEnemies().get(2).getClass());
        assertEquals(Marco.class, controller.getTurnList().get(0).getClass());
        assertEquals(Luis.class, controller.getTurnList().get(1).getClass());
        assertEquals(Goomba.class, controller.getTurnList().get(2).getClass());
        assertEquals(Boo.class, controller.getTurnList().get(3).getClass());
        assertEquals(Spiny.class, controller.getTurnList().get(4).getClass());
        assertEquals(Marco.class, controller.getCurrentTurn().getClass());
    }


    @Test
    public void testNullCharacters() {
        controller.setUpGame();
        assertNull(controller.getCurrentEnemy());
        assertNull(controller.getPlayer(controller.getTurnList().get(3)));
        controller.passTurn();
        controller.passTurn();
        assertNull(controller.getCurrentPlayer());
    }

    @Test
    public void testRoundWin() {
        controller.setSeed(1);
        controller.setUpGame();
        controller.getPlayers().get(0).setSeed(1);
        controller.getPlayers().get(1).setSeed(1);
        controller.getTurnList().get(0).setLVL(100);
        controller.getTurnList().get(1).setLVL(100);
        RedMushroom redMushroom = new RedMushroom();
        HoneySyrup honeySyrup = new HoneySyrup();

        // Round 1

        assertEquals(Marco.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));
        assertEquals(Boo.class, controller.getTurnList().get(2).getClass());
        assertEquals(Luis.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));
        assertEquals(Boo.class, controller.getTurnList().get(2).getClass());
        assertEquals(Boo.class, controller.getCurrentTurn().getClass());
        controller.EnemyAttack();
        assertEquals(9, controller.getTurnList().get(1).getHP());
        assertFalse(controller.checkWin());
        assertFalse(controller.enemiesWin());
        assertEquals(Spiny.class, controller.getCurrentTurn().getClass());
        controller.EnemyAttack();
        assertEquals(9, controller.getTurnList().get(0).getHP());
        assertEquals(Marco.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));
        assertEquals(Luis.class, controller.getCurrentTurn().getClass());
        controller.HammerAttack((IEnemy) controller.getTurnList().get(2));
        assertEquals(Marco.class, controller.getCurrentTurn().getClass());


        assertTrue(controller.checkWin());

        // Round 2

        controller.nextBattle(3);

        assertEquals(11, controller.getPlayers().get(0).getHP());
        assertEquals(11, controller.getPlayers().get(0).getATK());
        assertEquals(11, controller.getPlayers().get(0).getFp());
        assertEquals(11, controller.getPlayers().get(0).getDEF());
        assertEquals(101, controller.getPlayers().get(0).getLVL());
        assertEquals(11, controller.getPlayers().get(1).getHP());
        assertEquals(11, controller.getPlayers().get(1).getATK());
        assertEquals(11, controller.getPlayers().get(1).getFp());
        assertEquals(11, controller.getPlayers().get(1).getDEF());
        assertEquals(101, controller.getPlayers().get(1).getLVL());

        assertEquals(2, controller.getRound());
        assertEquals(4, controller.getInventory().value(redMushroom));
        assertEquals(4, controller.getInventory().value(honeySyrup));
        assertEquals(Marco.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));
        assertEquals(Boo.class, controller.getTurnList().get(2).getClass());
        assertEquals(Luis.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));
        assertEquals(Boo.class, controller.getTurnList().get(2).getClass());
        assertEquals(Boo.class, controller.getCurrentTurn().getClass());
        controller.EnemyAttack();
        assertEquals(10, controller.getTurnList().get(1).getHP());
        assertEquals(Boo.class, controller.getCurrentTurn().getClass());
        controller.EnemyAttack();
        assertEquals(11, controller.getTurnList().get(0).getHP());
        assertEquals(Marco.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));
        assertEquals(Luis.class, controller.getCurrentTurn().getClass());
        controller.passTurn();
        assertEquals(Boo.class, controller.getCurrentTurn().getClass());
        controller.EnemyAttack();
        assertEquals(8, controller.getTurnList().get(1).getHP());
        assertEquals(Marco.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));
        assertEquals(Luis.class, controller.getCurrentTurn().getClass());
        assertFalse(controller.enemiesWin());

        assertTrue(controller.checkWin());


        // Round 3

        controller.nextBattle(5);

        assertEquals(12, controller.getPlayers().get(0).getHP());
        assertEquals(12, controller.getPlayers().get(0).getATK());
        assertEquals(12, controller.getPlayers().get(0).getFp());
        assertEquals(12, controller.getPlayers().get(0).getDEF());
        assertEquals(102, controller.getPlayers().get(0).getLVL());
        assertEquals(12, controller.getPlayers().get(1).getHP());
        assertEquals(12, controller.getPlayers().get(1).getATK());
        assertEquals(12, controller.getPlayers().get(1).getFp());
        assertEquals(12, controller.getPlayers().get(1).getDEF());
        assertEquals(102, controller.getPlayers().get(1).getLVL());

        assertEquals(3, controller.getRound());
        assertEquals(5, controller.getInventory().value(redMushroom));
        assertEquals(5, controller.getInventory().value(honeySyrup));
        controller.getTurnList().get(2).setHP(0);
        controller.getTurnList().get(3).setHP(0);
        controller.getTurnList().get(4).setHP(0);
        controller.getTurnList().get(5).setHP(0);
        controller.setNextTurn();
        assertEquals(Luis.class, controller.getCurrentTurn().getClass());
        controller.HammerAttack((IEnemy) controller.getTurnList().get(2));
        assertEquals(Spiny.class, controller.getCurrentTurn().getClass());
        controller.EnemyAttack();
        assertEquals(11, controller.getTurnList().get(0).getHP());
        assertEquals(Marco.class, controller.getCurrentTurn().getClass());
        controller.HammerAttack((IEnemy) controller.getTurnList().get(2));

        assertTrue(controller.checkWin());

        // Round 4

        controller.nextBattle(5);


        assertEquals(13, controller.getPlayers().get(0).getHP());
        assertEquals(13, controller.getPlayers().get(0).getATK());
        assertEquals(13, controller.getPlayers().get(0).getFp());
        assertEquals(13, controller.getPlayers().get(0).getDEF());
        assertEquals(103, controller.getPlayers().get(0).getLVL());
        assertEquals(13, controller.getPlayers().get(1).getHP());
        assertEquals(13, controller.getPlayers().get(1).getATK());
        assertEquals(13, controller.getPlayers().get(1).getFp());
        assertEquals(13, controller.getPlayers().get(1).getDEF());
        assertEquals(103, controller.getPlayers().get(1).getLVL());


        assertEquals(4, controller.getRound());
        assertEquals(6, controller.getInventory().value(redMushroom));
        assertEquals(6, controller.getInventory().value(honeySyrup));
        controller.getTurnList().get(3).setHP(0);
        controller.getTurnList().get(4).setHP(0);
        controller.getTurnList().get(5).setHP(0);
        controller.getTurnList().get(6).setHP(0);
        controller.setNextTurn();
        assertEquals(Luis.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));

        assertTrue(controller.checkWin());

        // Round 5, final round


        controller.nextBattle(5);


        assertEquals(14, controller.getPlayers().get(0).getHP());
        assertEquals(14, controller.getPlayers().get(0).getATK());
        assertEquals(14, controller.getPlayers().get(0).getFp());
        assertEquals(14, controller.getPlayers().get(0).getDEF());
        assertEquals(104, controller.getPlayers().get(0).getLVL());
        assertEquals(14, controller.getPlayers().get(1).getHP());
        assertEquals(14, controller.getPlayers().get(1).getATK());
        assertEquals(14, controller.getPlayers().get(1).getFp());
        assertEquals(14, controller.getPlayers().get(1).getDEF());
        assertEquals(104, controller.getPlayers().get(1).getLVL());



        assertEquals(5, controller.getRound());
        assertEquals(7, controller.getInventory().value(redMushroom));
        assertEquals(7, controller.getInventory().value(honeySyrup));

        controller.getTurnList().get(3).setHP(0);
        controller.getTurnList().get(4).setHP(0);
        controller.getTurnList().get(5).setHP(0);
        controller.getTurnList().get(6).setHP(0);
        controller.setNextTurn();
        assertEquals(Luis.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));
        controller.EnemyAttack();
        assertEquals(13, controller.getTurnList().get(1).getHP());
        assertEquals(Marco.class, controller.getCurrentTurn().getClass());
        controller.JumpAttack((IEnemy) controller.getTurnList().get(2));
        assertTrue(controller.gameOver(5));
    }

    @Test
    public void enemiesWinTest() {
        controller.setSeed(1);
        controller.setUpGame();
        controller.getTurnList().get(0).setHP(0);
        controller.getTurnList().get(1).setHP(1);
        controller.setNextTurn();
        controller.setNextTurn();
        assertEquals(Goomba.class, controller.getCurrentTurn().getClass());
        controller.EnemyAttack();
        assertTrue(controller.enemiesWin());
        assertTrue(controller.gameOver(5));
    }

    @Test
    public void useItemTest() {
        controller.setSeed(1);
        controller.setUpGame();
        RedMushroom redMushroom = new RedMushroom();
        HoneySyrup honeySyrup = new HoneySyrup();
        controller.getPlayers().get(0).setHP(1);
        controller.getPlayers().get(1).setFp(1);
        controller.useItem(redMushroom);
        controller.useItem(honeySyrup);
        assertEquals(2, controller.getPlayers().get(0).getHP());
        assertEquals(4, controller.getPlayers().get(1).getFp());
    }



}
