package com.example.aventurasdemarcoyluis.controller;


import com.example.aventurasdemarcoyluis.controller.phases.EnemyAttackPhase;
import com.example.aventurasdemarcoyluis.controller.phases.PlayerDecisionPhase;
import com.example.aventurasdemarcoyluis.model.enemies.BooFactory;
import com.example.aventurasdemarcoyluis.model.enemies.GoombaFactory;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.enemies.SpinyFactory;
import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.items.RedMushroom;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;
import com.example.aventurasdemarcoyluis.model.players.Luis;
import com.example.aventurasdemarcoyluis.model.players.Marco;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Game controller for the game
 */

public class GameController extends AbstractController {

    final int rounds;

    /**
     * Constructor for this class, inherits the Abstract Controller
     */

    public GameController() {
        super();
        rounds = 5;
    }

    /**
     * Creates an arraylist of n random enemies
     *
     * @param n the amount of enemies to create
     */

    public void createEnemies(int n) {
        ArrayList<IEnemy> enemyList = new ArrayList<>();
        int nboos = n - getRandom().nextInt(n + 1);
        int ngoombas = n - nboos - getRandom().nextInt(n - nboos + 1);
        int nspinys = n - nboos - ngoombas;

        GoombaFactory goombaFactory = new GoombaFactory();
        BooFactory booFactory = new BooFactory();
        SpinyFactory spinyFactory = new SpinyFactory();

        Hashtable<Integer, IEnemy> goombaTable;
        Hashtable<Integer, IEnemy> booTable;
        Hashtable<Integer, IEnemy> spinyTable;

        goombaTable = goombaFactory.create(ngoombas);
        booTable = booFactory.create(nboos);
        spinyTable = spinyFactory.create(nspinys);
        enemyList.addAll(goombaTable.values());
        enemyList.addAll(booTable.values());
        enemyList.addAll(spinyTable.values());
        this.setEnemies(enemyList);
    }

    /**
     * Sets up the game
     * Creates the two players, the inventory, the items
     * The player list and the enemy list
     * For the first round, 3 random enemies are created and 3 Red Mushroom and 3 Honey Syrup
     * Are added to the inventory
     */

    public void setUpGame() {
        Marco marco = new Marco("Marco", 10, 10, 10, 1, 10, 10, 10);
        Luis luis = new Luis("Luis", 10, 10, 10, 1, 10, 10, 10);

        RedMushroom redMushroom = new RedMushroom();
        HoneySyrup honeySyrup = new HoneySyrup();

        ArrayList<IPlayer> playerList = this.getPlayers();
        playerList.add(marco);
        playerList.add(luis);
        this.setPlayers(playerList);
        this.createEnemies(3);
        this.addItem(redMushroom, 3);
        this.addItem(honeySyrup, 3);
        this.createTurns();
    }

    /**
     * Creates the next battle if the game is not over and the players have won the round
     * On a new round, 1 Red Mushroom and 1 Honey Syrup are added to the inventory
     * The players level up
     * And new enemies are created
     *
     * @param enemies the amount of enemies to create
     */

    public void nextBattle(int enemies) {
        if (!this.gameOver(rounds)) {
            RedMushroom redMushroom = new RedMushroom();
            HoneySyrup honeySyrup = new HoneySyrup();
            this.addItem(redMushroom, 1);
            this.addItem(honeySyrup, 1);
            this.getEnemies().clear();
            this.getTurnList().clear();
            this.levelUp();
            this.createEnemies(enemies);
            this.createTurns();
            this.setRound(this.getRound() + 1);
        }
    }


    /**
     * Changes the game's phase
     */

    @Override
    public void changePhase() {
        if(this.getCurrentTurn().isPlayer()) {
            this.setPhase(new PlayerDecisionPhase(this));
        } else if(this.getCurrentTurn().isEnemy()){
            this.setPhase(new EnemyAttackPhase(this));
        }
    }


    /**
     * Changes the current turn to the next non KO character in the array
     */

    @Override
    public void setNextTurn() {
        super.setNextTurn();
        this.changePhase();
    }
}
