package com.example.aventurasdemarcoyluis.controller;


import com.example.aventurasdemarcoyluis.controller.phases.IPhase;
import com.example.aventurasdemarcoyluis.model.ICharacter;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.items.Inventory;
import com.example.aventurasdemarcoyluis.model.items.ItemsInterface;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Interface that represents a generic game controller
 */

public interface IController {

    /**
     * If the current turn character is an enemy
     * It randomly chooses a player to attack
     */

    void EnemyAttack();


    /**
     * If the current character is a player, it chooses an enemy to attack with a Jump
     *
     * @param anEnemy the enemy to be attacked
     */

    void JumpAttack(IEnemy anEnemy);

    /**
     * If the current character is a player, it chooses an enemy to attack with a Hammer
     *
     * @param anEnemy the enemy to be attacked
     */

    void HammerAttack(IEnemy anEnemy);


    /**
     * A player uses an item if it exists in the inventory
     * @param anItem  the item to be used
     */

    void useItem(ItemsInterface anItem);

    /**
     * Adds an amount of items to the inventory
     *
     * @param anItem The item to be added
     * @param amount the amount of the item
     */

    void addItem(ItemsInterface anItem, int amount);

    /**
     * Levels up the players on completing a round
     */

    void levelUp();

    /**
     * Creates a list of players and enemies that represents the game turn
     * Also sets the current character to the first player in the turn list
     */

    void createTurns();

    /**
     * Allows the current player to skip their turn
     */

    void passTurn();

    /**
     * Changes the current turn to the next non KO character in the array
     */

    void setNextTurn();

    /**
     * Checks if the players win the game
     * The players win if they defeat all enemies in the turn list
     *
     * @return true if the players win
     */

    boolean checkWin();

    /**
     * Gets the list of players in the game
     *
     * @return the list of players
     */

    ArrayList<IPlayer> getPlayers();

    /**
     * Sets up the list of players
     *
     * @param playerList the list of players in the game
     */

    void setPlayers(ArrayList<IPlayer> playerList);

    /**
     * Gets the list of enemies in the game
     *
     * @return the list of enemies
     */

    ArrayList<IEnemy> getEnemies();

    /**
     * Sets up the list of enemies
     *
     * @param enemyList the list of enemies in the game
     */

    void setEnemies(ArrayList<IEnemy> enemyList);

    /**
     * Gets the player's inventory
     *
     * @return the inventory of the players
     */

    Inventory getInventory();


    /**
     * Gets the list of all players and enemies in the game
     *
     * @return the turn list
     */

    ArrayList<ICharacter> getTurnList();


    /**
     * Gets the current turn's character. Can be an enemy or a player
     *
     * @return the current turns character
     */
    ICharacter getCurrentTurn();

    /**
     * Gets the current round of the game
     *
     * @return the current round
     */

    int getRound();

    /**
     * Sets the game's round
     *
     * @param round the round of the game
     */

    void setRound(int round);

    /**
     * Gets the random number generator for the game
     *
     * @return the random number generator
     */

    Random getRandom();


    /**
     * Sets the seed for the random number generator
     *
     * @param seed the seed to set
     */

    void setSeed(long seed);

    /**
     * Checks if the game is over
     * The game is over if the enemies win or if the players win the required amount of battles
     *
     * @return true if the game is over
     */

    boolean gameOver(int required);

    /**
     * Checks if the enemies win the game
     * This can only happen if there are no players left in the turn list
     *
     * @return true if the enemies win
     */

    boolean enemiesWin();

    /**
     * Changes the game's phase
     */

    void changePhase();

    /**
     * Sets the game's phase
     */

    void setPhase(IPhase phase);

    /**
     * Gets the controller's current phase
     * @return the controller's phase
     */

    IPhase getPhase();

    /**
     * Gets the current character if it is a player
     * @return the player
     */

    IPlayer getCurrentPlayer();


    /**
     * Gets the current character if it is an enemy
     * @return the enemy
     */

    IEnemy getCurrentEnemy();

    /**
     * Gets a character from the turn list if it is a character
     * @param character the character to be searched for
     * @return the player
     */

    IPlayer getPlayer(ICharacter character);

}
