package com.example.aventurasdemarcoyluis.model.enemies;

import com.example.aventurasdemarcoyluis.model.ICharacter;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;

/**
 * Interface that represents an enemy
 */

public interface IEnemy extends ICharacter {

    /**
     * Gets the name of the enemy
     *
     * @return the name of the enemy
     */

    String getName();


    /**
     * The enemy gets hit with a hammer attack
     * @param aPlayer the player that attacks the enemy
     */

    void attackedByHammer(IPlayer aPlayer);

    /**
     * The enemy gets hit with a jump attack
     * @param aPlayer the player that attacks the enemy
     */

    void attackedByJump(IPlayer aPlayer);

    /**
     * Attacks a player
     * Depending on the enemy type this behavior will change
     *
     * @param aPlayer the player to be attacked
     */

    void attackPlayer(IPlayer aPlayer);

    /**
     * Determines if the enemy can attack a player
     * @param aPlayer the player to attack
     * @return true if the enemy can attack the player
     */

    boolean canAttackPlayer(IPlayer aPlayer);

    /**
     * Determines if the enemy can be attacked by Marco
     * @return true if the enemy can be attacked by Marco
     */

    boolean canBeAttackedByMarco();


    /**
     * Determines if the enemy can be attacked by Luis
     * @return true if the enemy can be attacked by Luis
     */

    boolean canBeAttackedByLuis();

}
