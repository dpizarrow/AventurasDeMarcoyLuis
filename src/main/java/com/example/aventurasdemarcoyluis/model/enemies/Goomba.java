package com.example.aventurasdemarcoyluis.model.enemies;

import com.example.aventurasdemarcoyluis.model.players.IPlayer;

/**
 * Class that represents a Goomba enemy
 */

public class Goomba extends Enemies {

    /**
     * @param aName the name of the Goomba
     * @param hp    the health points of the Goomba
     * @param atk   the attack points of the Goomba
     * @param def   the defense points of the Goomba
     * @param lvl   the level of the Goomba
     */

    public Goomba(String aName, int hp, int atk, int def, int lvl) {
        super(aName, hp, atk, def, lvl);
    }

    /**
     * Determines if the enemy can attack a player
     *
     * @param aPlayer the player to attack
     * @return true if the enemy can attack the player
     */
    @Override
    public boolean canAttackPlayer(IPlayer aPlayer) {
        return aPlayer.canBeAttackedByGoomba();
    }
}
