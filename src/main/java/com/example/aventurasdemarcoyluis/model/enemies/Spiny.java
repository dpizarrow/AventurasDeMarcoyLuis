package com.example.aventurasdemarcoyluis.model.enemies;

import com.example.aventurasdemarcoyluis.model.players.IPlayer;

/**
 * Class that represents a Spiny enemy
 */

public class Spiny extends Enemies {
    /**
     * @param aName Name of the Spiny
     * @param hp    Health points of the Spiny
     * @param atk   Attack points of the Spiny
     * @param def   Defense points of the Spiny
     * @param lvl   level of the Spiny
     */
    public Spiny(String aName, int hp, int atk, int def, int lvl) {
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
        return aPlayer.canBeAttackedBySpiny();
    }


    @Override
    public void attackedByJump(IPlayer aPlayer) {
        int spike = (int) (aPlayer.getHP() * 0.05);
        aPlayer.setHP((int) (aPlayer.getHP()-Math.max(1.0, spike)));
    }
}
