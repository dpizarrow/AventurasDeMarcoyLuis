import com.example.aventurasdemarcoyluis.controller.GameController;
import com.example.aventurasdemarcoyluis.controller.phases.*;
import com.example.aventurasdemarcoyluis.model.players.Luis;
import com.example.aventurasdemarcoyluis.model.players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPhases {

    private GameController controller;

    @BeforeEach
    public void setUp() {
        controller = new GameController();
        controller.setSeed(1);
        controller.setUpGame();
    }

    @Test
    public void phaseTransitionTest() {
        assertEquals(PlayerDecisionPhase.class,controller.getPhase().getClass());
        controller.passTurn();

        assertEquals(PlayerDecisionPhase.class,controller.getPhase().getClass());
        controller.passTurn();

        assertEquals(EnemyAttackPhase.class,controller.getPhase().getClass());
        controller.EnemyAttack();

        assertEquals(EnemyAttackPhase.class,controller.getPhase().getClass());
        controller.EnemyAttack();

        assertEquals(EnemyAttackPhase.class,controller.getPhase().getClass());
        controller.EnemyAttack();

        assertEquals(PlayerDecisionPhase.class,controller.getPhase().getClass());

    }

    @Test
    public void testPlayerDecisions() throws InvalidTransitionException {
        controller.getPhase().toPlayerAttackPhase();
        assertEquals(PlayerAttackPhase.class,controller.getPhase().getClass());

        controller.getPhase().toPlayerUndo();
        assertEquals(PlayerDecisionPhase.class,controller.getPhase().getClass());

        controller.getPhase().toPlayerItemPhase();
        assertEquals(UseItemPhase.class,controller.getPhase().getClass());

        controller.getPhase().toPlayerUndo();
        assertEquals(PlayerDecisionPhase.class,controller.getPhase().getClass());

        assertEquals(Marco.class,controller.getCurrentPlayer().getClass());
        controller.getPhase().PlayerSkipTurn();
        assertEquals(Luis.class,controller.getCurrentPlayer().getClass());



        assertThrows(InvalidTransitionException.class,()->controller.getPhase().toPlayerUndo());
        assertThrows(InvalidActionException.class,()->controller.getPhase().enemyAttack());
        assertThrows(InvalidAttackableException.class,()->controller.getPhase().hammerAttack(0));
        assertThrows(InvalidAttackableException.class,()->controller.getPhase().jumpAttack(0));
        assertThrows(InvalidUseItemException.class,()->controller.getPhase().useItem(1));
    }

    @Test
    public void testPhaseAttacks() throws InvalidTransitionException, InvalidAttackableException {
        controller.getPlayers().get(0).setSeed(1);
        controller.getPlayers().get(1).setSeed(1);

        controller.getPhase().toPlayerAttackPhase();
        controller.getPhase().jumpAttack(1);

        controller.getPhase().toPlayerAttackPhase();
        assertThrows(InvalidAttackableException.class,()->controller.getPhase().jumpAttack(2));
        assertThrows(InvalidAttackableException.class,()->controller.getPhase().hammerAttack(2));

        controller.getPhase().hammerAttack(1);

        assertEquals(20,controller.getEnemies().get(0).getHP());
        assertEquals(20,controller.getEnemies().get(1).getHP());

        controller.EnemyAttack();
        controller.EnemyAttack();
        controller.EnemyAttack();

        controller.getPhase().toPlayerAttackPhase();

        assertThrows(InvalidAttackableException.class,()->controller.getPhase().hammerAttack(20));
        assertThrows(InvalidAttackableException.class,()->controller.getPhase().jumpAttack(20));
        assertThrows(InvalidUseItemException.class,()->controller.getPhase().useItem(1));
        assertThrows(InvalidActionException.class,()->controller.getPhase().enemyAttack());
        assertThrows(InvalidTransitionException.class,()->controller.getPhase().toPlayerAttackPhase());
        assertThrows(InvalidTransitionException.class,()->controller.getPhase().toPlayerItemPhase());
        assertThrows(InvalidTransitionException.class,()->controller.getPhase().PlayerSkipTurn());
    }

    @Test
    public void testItemsPhase() throws InvalidTransitionException, InvalidUseItemException {
        controller.getPlayers().get(0).setHP(1);
        controller.getPlayers().get(1).setFp(1);


        controller.getPhase().toPlayerItemPhase();
        controller.getPhase().useItem(1);
        assertEquals(2, controller.getPlayers().get(0).getHP());

        controller.getPhase().toPlayerItemPhase();
        controller.getPhase().useItem(2);
        assertEquals(4, controller.getPlayers().get(1).getFp());

        controller.getPlayers().get(0).setHP(100);
        controller.getPlayers().get(1).setHP(100);

        controller.EnemyAttack();
        controller.EnemyAttack();
        controller.EnemyAttack();

        controller.getPhase().toPlayerItemPhase();
        assertThrows(InvalidUseItemException.class,()->controller.getPhase().useItem(3));

        assertThrows(InvalidAttackableException.class,()->controller.getPhase().hammerAttack(20));
        assertThrows(InvalidAttackableException.class,()->controller.getPhase().jumpAttack(20));
        assertThrows(InvalidActionException.class,()->controller.getPhase().enemyAttack());
        assertThrows(InvalidTransitionException.class,()->controller.getPhase().toPlayerAttackPhase());
        assertThrows(InvalidTransitionException.class,()->controller.getPhase().toPlayerItemPhase());
        assertThrows(InvalidTransitionException.class,()->controller.getPhase().PlayerSkipTurn());
    }

    @Test
    public void testEnemyPhase() throws InvalidTransitionException, InvalidActionException {
        controller.getPhase().PlayerSkipTurn();
        controller.getPhase().PlayerSkipTurn();

        controller.getPhase().enemyAttack();
        assertEquals(10,controller.getPlayers().get(1).getHP());


        assertThrows(InvalidAttackableException.class,()->controller.getPhase().hammerAttack(20));
        assertThrows(InvalidAttackableException.class,()->controller.getPhase().jumpAttack(20));
        assertThrows(InvalidTransitionException.class,()->controller.getPhase().toPlayerAttackPhase());
        assertThrows(InvalidTransitionException.class,()->controller.getPhase().toPlayerItemPhase());
        assertThrows(InvalidTransitionException.class,()->controller.getPhase().PlayerSkipTurn());
    }

}
