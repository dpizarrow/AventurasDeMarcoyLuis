package com.example.aventurasdemarcoyluis.controller;


import com.example.aventurasdemarcoyluis.controller.phases.IPhase;
import com.example.aventurasdemarcoyluis.controller.phases.PlayerDecisionPhase;
import com.example.aventurasdemarcoyluis.model.ICharacter;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.items.Inventory;
import com.example.aventurasdemarcoyluis.model.items.ItemsInterface;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Abstract class that represents an abstract game controller
 */

public abstract class AbstractController implements IController {
    private ArrayList<IPlayer> playerList;
    private ArrayList<IEnemy> enemyList;
    private final Inventory inventory;
    private final Random random;
    private int round;
    private final ArrayList<ICharacter> turnList;
    private ICharacter currentTurn;
    private IPhase phase;

    /**
     * Controller for the abstract game
     * Initializes the inventory, lists for players and enemies
     * The turn list, the random number generator and the count of rounds
     */

    public AbstractController() {
        playerList = new ArrayList<>();
        enemyList = new ArrayList<>();
        inventory = new Inventory();
        random = new Random();
        turnList = new ArrayList<>();
        round = 1;
        phase = new PlayerDecisionPhase((GameController) this);
    }

    /**
     * If the current turn character is an enemy
     * It randomly chooses a player to attack
     */

    @Override
    public void EnemyAttack() {
        if(currentTurn.isEnemy()){
            IEnemy currentEnemy = this.getCurrentEnemy();
            ArrayList<IPlayer> alivePlayers = new ArrayList<>();
            int numberOfPlayer = 0;
            for (ICharacter character : turnList) {
                if (character.isPlayer()) {
                    if (currentEnemy.canAttackPlayer(this.getPlayer(character))) {
                        alivePlayers.add(this.getPlayer(character));
                        numberOfPlayer++;
                    }

                }
            }

            int playerToAttack = random.nextInt(numberOfPlayer);
            currentEnemy.attackPlayer(alivePlayers.get(playerToAttack));
            this.setNextTurn();
        }
    }

    /**
     * If the current character is a player, it chooses an enemy to attack with a Jump
     *
     * @param anEnemy the enemy to be attacked
     */

    @Override
    public void JumpAttack(IEnemy anEnemy) {
        if (currentTurn.isPlayer()) {
            IPlayer current = this.getCurrentPlayer();
            current.jumpAttack(anEnemy);
            this.setNextTurn();
        }
    }

    /**
     * If the current character is a player, it chooses an enemy to attack with a Hammer
     *
     * @param anEnemy the enemy to be attacked
     */

    @Override
    public void HammerAttack(IEnemy anEnemy) {
        if (currentTurn.isPlayer()) {
            IPlayer current = this.getCurrentPlayer();
            current.hammerAttack(anEnemy);
            this.setNextTurn();
        }
    }

    /**
     * A player uses an item if it exists in the inventory
     * @param anItem  the item to be used
     */

    @Override
    public void useItem(ItemsInterface anItem) {
        if(currentTurn.isPlayer()) {
            IPlayer current = this.getCurrentPlayer();
            inventory.useItem(current, anItem);
            this.setNextTurn();
        }
    }

    /**
     * Adds an amount of items to the inventory
     *
     * @param anItem The item to be added
     * @param amount the amount of the item
     */

    @Override
    public void addItem(ItemsInterface anItem, int amount) {
        inventory.add(anItem, amount);
    }

    /**
     * Levels up the players on completing a round
     */

    @Override
    public void levelUp() {
        for (IPlayer player : playerList) {
            player.levelUp();
        }
    }

    /**
     * Creates a list of players and enemies that represents the game turn
     * Also sets the current character to the first player in the turn list
     */

    @Override
    public void createTurns() {
        turnList.addAll(playerList);
        turnList.addAll(enemyList);
        currentTurn = turnList.get(0);
    }

    /**
     * Allows the current player to skip their turn
     */

    @Override
    public void passTurn() {
        if (currentTurn.isPlayer()) {
            this.setNextTurn();
        }
    }

    /**
     * Changes the current turn to the next non KO character in the array
     */

    @Override
    public void setNextTurn() {
        int i = 0;
        while (i < this.turnList.size()) {
            if (this.turnList.get(i).isKO()) {
                this.turnList.remove(i);
                i--;
            }
            i++;
        }
        int currentIndex = this.turnList.indexOf(this.currentTurn);
        this.currentTurn = this.turnList.get((currentIndex + 1) % this.turnList.size());
    }

    /**
     * Checks if the players win the game
     * The players win if they defeat all enemies in the turn list
     *
     * @return true if the players win
     */

    @Override
    public boolean checkWin() {
        boolean allEnemiesDefeated = true;
        boolean possibleWin = true;
        for (ICharacter i:turnList){
            if(i.isEnemy()){
                allEnemiesDefeated = false;
            }

            if(!(i.isMarco()||i.isBoo())){
                possibleWin = false;
            }
        }

        return allEnemiesDefeated||possibleWin;
    }


    /**
     * Checks if the enemies win the game
     * This can only happen if there are no players left in the turn list
     *
     * @return true if the enemies win
     */

    @Override
    public boolean enemiesWin() {
        boolean allPlayersDefeated = true;
        boolean possibleWin = true;
        for (ICharacter i : turnList){
            if(i.isPlayer()){
                allPlayersDefeated = false;
            }

            if(!(i.isLuis()||i.isBoo())){
                possibleWin = false;
            }
        }

        return allPlayersDefeated||possibleWin;
    }


    /**
     * Gets the list of players in the game
     *
     * @return the list of players
     */

    @Override
    public ArrayList<IPlayer> getPlayers() {
        return playerList;
    }

    /**
     * Sets up the list of players
     *
     * @param playerList the list of players in the game
     */

    @Override
    public void setPlayers(ArrayList<IPlayer> playerList) {
        this.playerList = playerList;
    }

    /**
     * Gets the list of enemies in the game
     *
     * @return the list of enemies
     */

    @Override
    public ArrayList<IEnemy> getEnemies() {
        return enemyList;
    }

    /**
     * Sets up the list of enemies
     *
     * @param enemyList the list of enemies in the game
     */

    @Override
    public void setEnemies(ArrayList<IEnemy> enemyList) {
        this.enemyList = enemyList;
    }

    /**
     * Gets the player's inventory
     *
     * @return the inventory of the players
     */

    @Override
    public Inventory getInventory() {
        return inventory;
    }


    /**
     * Gets the list of all players and enemies in the game
     *
     * @return the turn list
     */

    @Override
    public ArrayList<ICharacter> getTurnList() {
        return turnList;
    }


    /**
     * Gets the current turn's character. Can be an enemy or a player
     *
     * @return the current turns character
     */

    @Override
    public ICharacter getCurrentTurn() {
        return currentTurn;
    }

    /**
     * Gets the current round of the game
     *
     * @return the current round
     */

    @Override
    public int getRound() {
        return round;
    }

    /**
     * Sets the game's round
     *
     * @param round the round of the game
     */

    @Override
    public void setRound(int round) {
        this.round = round;
    }

    /**
     * Gets the random number generator for the game
     *
     * @return the random number generator
     */

    @Override
    public Random getRandom() {
        return random;
    }


    /**
     * Sets the seed for the random number generator
     *
     * @param seed the seed to set
     */

    @Override
    public void setSeed(long seed) {
        random.setSeed(seed);
    }


    /**
     * Checks if the game is over
     * The game is over if the enemies win or if the players win the required amount of battles
     *
     * @return true if the game is over
     */

    @Override
    public boolean gameOver(int required) {
        return this.enemiesWin() || required == round;
    }


    /**
     * Sets the game's phase
     */

    @Override
    public void setPhase(IPhase phase) {
        this.phase = phase;
    }


    /**
     * Gets the controller's current phase
     *
     * @return the controller's phase
     */

    @Override
    public IPhase getPhase() {
        return phase;
    }

    /**
     * {@inheritDoc}
     * @return
     */

    @Override
    public IPlayer getCurrentPlayer() {
        if(currentTurn.isPlayer()) {
            for(IPlayer player : playerList) {
                if(player.equals(currentTurn)) {
                    return player;
                }
            }
        }
        return null;
    }

    /**
     * Gets the current character if it is an enemy
     *
     * @return the enemy
     */

    @Override
    public IEnemy getCurrentEnemy() {
        if(currentTurn.isEnemy()) {
            for(IEnemy enemy : enemyList) {
                if(enemy.equals(currentTurn)) {
                    return enemy;
                }
            }
        }
        return null;
    }

    /**
     * Gets a character from the turn list if it is a character
     *
     * @param character the character to be searched for
     * @return the player
     */

    @Override
    public IPlayer getPlayer(ICharacter character) {
        if(character.isPlayer()) {
            for(IPlayer player:playerList) {
                if(player.equals(character)) {
                    return player;
                }
            }
        }
        return null;
    }
}
