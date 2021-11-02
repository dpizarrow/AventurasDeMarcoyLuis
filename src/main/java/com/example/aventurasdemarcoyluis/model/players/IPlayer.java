package com.example.aventurasdemarcoyluis.model.players;

import com.example.aventurasdemarcoyluis.model.ICharacter;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.items.ItemsInterface;
import com.example.aventurasdemarcoyluis.model.items.RedMushroom;
import com.example.aventurasdemarcoyluis.model.items.Star;

public interface IPlayer extends ICharacter {

    /**
     * Adds an item to the players inventory
     * @param anItem item to be added
     */

    void addAItem(ItemsInterface anItem);

    /**
     * Gets the name of the player
     * @return the players name
     */

    String getName();

    /**
     * Sets the player's health points
     * @param hp the health points to set
     */

    void setHP(int hp);

    /**
     * Gets the maximum health points of a player
     * @return the players maximum health points
     */

    int getMaxHP();

    /**
     * Gets the players fight points
     * @return the players fight points
     */

    int getFp();

    /**
     * Gets the maximum fight points of a player
     * @return the maximum fight points of a player
     */

    int getMaxFP();

    /**
     * Sets the fight points of a player
     * If the value to set is less than the maximum fight points, the value is updated
     * If the value to set is higher than the maximum fight points, the fight points are set to the players maximum fight points
     * In any other case, the fight point value is not set
     * @param fp the fight points to set
     */

    void setFp(int fp);

    /**
     * Use a Red Mushroom item
     * This item heals the player an amount of 10% of the players maximum hp
     * After using the item, it is removed from the players inventory
     * @param aRedMushroom the red mushroom to be used
     */

    void useRedMushroom(RedMushroom aRedMushroom);

    /**
     * Use a Honey Syrup item
     * This item adds 3 to the players current fight point value
     * After using the item, it is removed from the players inventory
     * @param aHoneySyrup the honey syrup to be used
     */

    void useHoneySyrup(HoneySyrup aHoneySyrup);

    /**
     * Use a star item
     * For now, the star sets the current hp to the players maximum hp
     * @param aStar the star item to be used
     */

    void useStar(Star aStar);

    /**
     * Determines a player can attack or not
     * A player can only attack if its HP is greater than 0 and its FP is greater than 1
     * @return true if the player can attack
     */

    boolean canAttack();

    /**
     * Jump attack, costs 1 FP and its damage constant is 1
     * @param anEnemy the enemy that is attacked
     */

    void jumpAttack(IEnemy anEnemy);

    /**
     * Hammer attack, costs 2 FP and is successful 75% of the time. Its damage constant is 1.5
     * @param anEnemy the enemy that is attacked
     */

    void hammerAttack(IEnemy anEnemy);

    /**
     * Method if a player is attacked by a Boo enemy
     * @param anEnemy the Boo enemy that attacks the player
     */

    void attackedByBoo(IEnemy anEnemy);

    /**
     * Method if a player is attacked by a Spiny enemy
     * @param anEnemy the Spiny enemy that attacks the player
     */

    void attackedBySpiny(IEnemy anEnemy);

    /**
     * Method if a player is attacked by a Goomba enemy
     * @param anEnemy the Goomba enemy that attacks the player
     */

    void attackedByGoomba(IEnemy anEnemy);
}
