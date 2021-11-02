package com.example.aventurasdemarcoyluis.model.enemies;

import com.example.aventurasdemarcoyluis.model.ICharacter;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;

public interface IEnemy extends ICharacter {

    /**
     * Gets the name of the enemy
     * @return the name of the enemy
     */

    String getName();

    /**
     * Method when an enemy is attacked by Marco with a jump
     * @param aPlayer the player that attacked, is only called by Marci
     */

    void attackedJumpMarco(IPlayer aPlayer);

    /**
     * Method when an enemy is attacked by Marco with a Hammer
     * @param aPlayer the player that attacked, only called by Marco
     */

    void attackedHammerMarco(IPlayer aPlayer);

    /**
     * Method when an enemy is attacked by Luis with a jump
     * @param aPlayer the player that attacked, only called by Luis
     */

    void attackedJumpLuis(IPlayer aPlayer);

    /**
     * Method when an enemy is attacked by Luis with a Hammer
     * @param aPlayer the player that attacked, can only be called by Luis
     */

    void attackedHammerLuis(IPlayer aPlayer);

    /**
     * Attacks a Marco player
     * @param aPlayer the player that is attacked
     */

    void attackMarco(IPlayer aPlayer);

    /**
     * Attacks a Luis playuer
     * @param aPlayer the player that is attacked
     */

    void attackLuis(IPlayer aPlayer);

}
