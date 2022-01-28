package com.example.aventurasdemarcoyluis.model.enemies;

import com.example.aventurasdemarcoyluis.model.players.IPlayer;

/**
 * Class that represents a Boo enemy
 */

public class Boo extends Enemies {

    /**
     * @param aName the name of the Boo
     * @param hp    the health points of the Boo
     * @param atk   the attack points of the Boo
     * @param def   the defense points of the Boo
     * @param lvl   the level of the Boo
     */
    public Boo(String aName, int hp, int atk, int def, int lvl) {
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
        return aPlayer.canBeAttackedByBoo();
    }


    /**
     * Determines if Luis can attack this enemy
     * @return false since Luis cannot attack Boo
     */

    @Override
    public boolean canBeAttackedByLuis() {
        return false;
    }

    /**
     * Checks if the character is a Boo
     *
     * @return true if the character is a Boo
     */
    @Override
    public boolean isBoo() {
        return true;
    }
}
