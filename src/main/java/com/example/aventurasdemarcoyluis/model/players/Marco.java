package com.example.aventurasdemarcoyluis.model.players;

import com.example.aventurasdemarcoyluis.model.AbstractPlayers;
import com.example.aventurasdemarcoyluis.model.AttackType;
import com.example.aventurasdemarcoyluis.model.enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.enemies.Boo;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.enemies.Spiny;
import java.util.Random;

/**
 * Class that represents a Marco Player
 */

public class Marco extends AbstractPlayers {
    /**
     *
     * @param name The name of the player
     * @param hp The health points of the player
     * @param atk The attack points of the player
     * @param def The defense points of the player
     * @param lvl The level of the player
     * @param fp The fight points of the player
     * @param maxfp The maximum fight points of the player
     * @param maxhp The maximum health points of the player
     */

    public Marco(String name, int hp, int atk, int def, int lvl, int fp, int maxfp, int maxhp) {
        super(name, hp, atk, def, lvl, fp, maxfp, maxhp);
    }


    /**
     * Attacks a Goomba enemy with the given attack type
     * If the players health is 0, the player deals no damage
     * @param anAttack The attack used
     * @param aGoomba The goomba enemy
     */

    public void attackGoomba(AttackType anAttack, Goomba aGoomba) {
        if (this.isKO()) {
            int damage = 0;
            aGoomba.setHP(aGoomba.getHP() - damage);
        }
    }

    /**
     * Attacks a Boo enemy with the given attack type
     * If the players health is 0, the player deals no damage
     * @param anAttack The attack used
     * @param aBoo The boo enemy
     */

    public void attackBoo(AttackType anAttack, Boo aBoo) {
        if (this.isKO()) {
            int damage = 0;
            aBoo.setHP(aBoo.getHP() - damage);
        }
    }

    /**
     * Attacks a Spiny enemy with the given attack type
     * If the player's health is 0, the player deals no damage
     * @param anAttack The attack used
     * @param aSpiny The spiny enemy
     */

    public void attackSpiny(AttackType anAttack, Spiny aSpiny) {
        if (this.isKO()) {
            int damage = 0;
            aSpiny.setHP(aSpiny.getHP() - damage);
        }
    }

    @Override
    public void jumpAttack(IEnemy anEnemy) {
        if (this.canAttack()) {
            anEnemy.attackedJumpMarco(this);
            this.setFp(this.getFp()-1);
        }
    }

    @Override
    public void hammerAttack(IEnemy anEnemy) {
        Random rand = new Random();
        if (this.canAttack()) {
            int chance = rand.nextInt(4);
            if(chance == 0) {
                anEnemy.attackedHammerMarco(this);
                this.setFp(this.getFp()-2);
            }
        }
    }

    /**
     * Method if a player is attacked by a Boo enemy
     *
     * @param anEnemy the Boo enemy that attacks the player
     */
    @Override
    public void attackedByBoo(IEnemy anEnemy) {

    }

    /**
     * Method if a player is attacked by a Spiny enemy
     *
     * @param anEnemy the Spiny enemy that attacks the player
     */
    @Override
    public void attackedBySpiny(IEnemy anEnemy) {

    }

    /**
     * Method if a player is attacked by a Goomba enemy
     *
     * @param anEnemy the Goomba enemy that attacks the player
     */
    @Override
    public void attackedByGoomba(IEnemy anEnemy) {

    }
}
