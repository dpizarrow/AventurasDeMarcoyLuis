package com.example.aventurasdemarcoyluis.model.players;

import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;

/**
 * Class that represents a Marco Player
 */

public class Marco extends AbstractPlayers {
    /**
     * @param name  The name of the player
     * @param hp    The health points of the player
     * @param atk   The attack points of the player
     * @param def   The defense points of the player
     * @param lvl   The level of the player
     * @param fp    The fight points of the player
     * @param maxfp The maximum fight points of the player
     * @param maxhp The maximum health points of the player
     */

    public Marco(String name, int hp, int atk, int def, int lvl, int fp, int maxfp, int maxhp) {
        super(name, hp, atk, def, lvl, fp, maxfp, maxhp);
    }


    /**
     * Determines if the player can be attacked by Boo
     * @return false since Boo cannot attack Marco
     */


    @Override
    public boolean canBeAttackedByBoo() {
        return false;
    }

    /**
     * Determines if Marco can attack an enemy
     * @param anEnemy the enemy that the player will try to attack
     * @return true if marco can attack an enemy
     */

    @Override
    public boolean canAttackEnemy(IEnemy anEnemy) {
        return anEnemy.canBeAttackedByMarco();
    }

    /**
     * Checks if the character is a Marco
     *
     * @return true if the character is Marco
     */
    @Override
    public boolean isMarco() {
        return true;
    }
}
