package com.example.aventurasdemarcoyluis.model.players;

import com.example.aventurasdemarcoyluis.model.ICharacter;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.items.ItemsInterface;

/**
 * Interface that represents a player
 */

public interface IPlayer extends ICharacter {

    /**
     * Gets the name of the player
     *
     * @return the players name
     */

    String getName();

    /**
     * Sets the player's health points
     *
     * @param hp the health points to set
     */

    void setHP(int hp);

    /**
     * Gets the maximum health points of a player
     *
     * @return the players maximum health points
     */

    int getMaxHP();

    /**
     * Sets the player's maximum HP
     */

    void setMaxHP(int hp);

    /**
     * Gets the players fight points
     *
     * @return the players fight points
     */

    int getFp();

    /**
     * Sets the fight points of a player
     * If the value to set is less than the maximum fight points, the value is updated
     * If the value to set is higher than the maximum fight points, the fight points are set to the players maximum fight points
     * In any other case, the fight point value is not set
     *
     * @param fp the fight points to set
     */

    void setFp(int fp);

    /**
     * Gets the maximum fight points of a player
     *
     * @return the maximum fight points of a player
     */

    int getMaxFP();

    /**
     * Sets the player's maximum FP points
     */
    void setMaxFP(int fp);

    /**
     * A player uses an item. Depending on the item used, this affects the player in different ways
     *
     * @param anItem the item to be used
     */

    void useItem(ItemsInterface anItem);

    /**
     * Determines a player can attack or not
     * A player can only attack if its HP is greater than 0 and its FP is greater than 1
     *
     * @return true if the player can attack
     */

    boolean canAttack();

    /**
     * Jump attack, costs 1 FP and its damage constant is 1
     *
     * @param anEnemy the enemy that is attacked
     */

    void jumpAttack(IEnemy anEnemy);

    /**
     * Hammer attack, costs 2 FP and is successful 75% of the time. Its damage constant is 1.5
     *
     * @param anEnemy the enemy that is attacked
     */

    void hammerAttack(IEnemy anEnemy);

    /**
     * Sets a seed for the random number generator
     * will be used to test the hammer attack
     *
     * @param seed the seed to be set
     */

    void setSeed(long seed);

    /**
     * Generates a random number and returns true or false depending on whether a hammer attack
     * is successful or not
     *
     * @return true if the hammer attack is successful
     */

    boolean generateRandom();


    /**
     * Updates a player's statistics on leveling up
     * The player's level increases by 1
     * The player's maximum hp increases by 15% and is healed by that amount
     * The player's maximum fp increases by 15% and is set to that amount
     * The player's attack value is increases by 15%
     * The player's defense value is increased by 15%
     */
    void levelUp();


    /**
     * Determines if the player can attack the selected enemy
     * @param anEnemy the enemy that the player will try to attack
     * @return true if the player can attack the selected enemy
     */

    boolean canAttackEnemy(IEnemy anEnemy);

    /**
     * Determines if the player can be attacked by a boo
     * @return true if the player can be attacked by a boo
     */

    boolean canBeAttackedByBoo();


    /**
     * Determines if the player can be attacked by a goomba
     * @return true if the player can be attacked by a goomba
     */

    boolean canBeAttackedByGoomba();

    /**
     * Determines if the player can be attacked by a spiny
     * @return true if the player can be attacked by a spiny
     */

    boolean canBeAttackedBySpiny();

}
