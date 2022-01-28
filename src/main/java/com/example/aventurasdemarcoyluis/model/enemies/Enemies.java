package com.example.aventurasdemarcoyluis.model.enemies;

import com.example.aventurasdemarcoyluis.model.AbstractCharacter;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;

/**
 * Class that represents a generic enemy
 */

public abstract class Enemies extends AbstractCharacter implements IEnemy {
    private final String name;

    /**
     * Creates a new Enemy
     *
     * @param atk attack points
     * @param def defense points
     * @param hp  heal points
     * @param lvl level of the Unit
     */
    public Enemies(String aName, int hp, int atk, int def, int lvl) {
        super(hp, atk, def, lvl);
        this.name = aName;
    }

    /**
     * Gets the name of the enemy
     *
     * @return the name of the enemy
     */

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Checks if the character is a player
     *
     * @return false since Enemies are not players
     */

    @Override
    public boolean isPlayer() {
        return false;
    }

    /**
     * Checks if the character is an enemy
     *
     * @return true since this class represents enemies
     */
    @Override
    public boolean isEnemy() {
        return true;
    }

    /**
     * The enemy attacks a Player
     * @param aPlayer the player to be attacked
     */

    @Override
    public void attackPlayer(IPlayer aPlayer) {
        if(this.canAttackPlayer(aPlayer) && !this.isKO()) {
            int dmg = this.calculateDamage(0.75, aPlayer);
            aPlayer.setHP(aPlayer.getHP()-dmg);
        }
    }


    /**
     * Checks if Marco can attack this enemy
     * @return true since Marco can attack all enemies
     */

    @Override
    public boolean canBeAttackedByMarco() {
        return true;
    }

    /**
     * Determines if Luis can attack this enemy
     * @return true if Luis can attack this enemy
     */

    @Override
    public boolean canBeAttackedByLuis() {
        return true;
    }


    /**
     * The enemy is attacked by a hammer
     * @param aPlayer the player that attacks the enemy
     */

    @Override
    public void attackedByHammer(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1.5, this);
        this.setHP(this.getHP()-dmg);
    }


    @Override
    public void attackedByJump(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1.0, this);
        this.setHP(this.getHP()-dmg);
    }

}
