package com.example.aventurasdemarcoyluis.model.players;

import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;

/**
 * Class that represents a Luis player
 */
public class Luis extends AbstractPlayers {
    /**
     * @param name  Name of the player
     * @param hp    Health points of the player
     * @param atk   Attack points of the player
     * @param def   Defense points of the player
     * @param lvl   Level of the player
     * @param fp    Fight points of the player
     * @param maxfp Maximum fight points of the player
     * @param maxhp Maximum health points of the player
     */
    public Luis(String name, int hp, int atk, int def, int lvl, int fp, int maxfp, int maxhp) {
        super(name, hp, atk, def, lvl, fp, maxfp, maxhp);
    }

    /**
     * Determines if the player can be attacked by Boo
     * @return true since Boo can Attack Luis
     */

    @Override
    public boolean canBeAttackedByBoo() {
        return true;
    }


    /**
     * Determines if Luis can attack an enemy
     * @param anEnemy the enemy that the player will try to attack
     * @return true if Luis can attack the enemy
     */

    @Override
    public boolean canAttackEnemy(IEnemy anEnemy) {
        return anEnemy.canBeAttackedByLuis();
    }

    /**
     * Checks if the character is a Luis
     *
     * @return true if the character is Luis
     */
    @Override
    public boolean isLuis() {
        return true;
    }
}
