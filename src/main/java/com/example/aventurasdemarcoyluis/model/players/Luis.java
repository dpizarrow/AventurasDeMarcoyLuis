package com.example.aventurasdemarcoyluis.model.players;
import com.example.aventurasdemarcoyluis.model.*;
import com.example.aventurasdemarcoyluis.model.enemies.Boo;
import com.example.aventurasdemarcoyluis.model.enemies.Goomba;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;
import java.util.Random;

/**
 * Class that represents a Luis player
 */
public class Luis extends AbstractPlayers {
    /**
     *
     * @param name Name of the player
     * @param hp Health points of the player
     * @param atk Attack points of the player
     * @param def Defense points of the player
     * @param lvl Level of the player
     * @param fp Fight points of the player
     * @param maxfp Maximum fight points of the player
     * @param maxhp Maximum health points of the player
     */
    public Luis(String name, int hp, int atk, int def, int lvl, int fp, int maxfp, int maxhp) {
        super(name, hp, atk, def, lvl, fp, maxfp, maxhp);
    }

    /**
     * Attacks a Goomba enemy with a given attack type
     * If the players health is 0, the player deals 0 damage
     * @param anAttack The attack used
     * @param aGoomba The Goomba enemy
     */
    public void attackGoomba(AttackType anAttack, Goomba aGoomba) {
        if (this.isKO()) {
            int damage = 0;
            aGoomba.setHP(aGoomba.getHP() - damage);
        }
    }

    /**
     * Attacks a Boo enemy with a given attack type
     * If the players health is 0, the player deals 0 damage
     * @param anAttack The attack used
     * @param aBoo The Boo enemy
     */
    public void attackBoo(AttackType anAttack, Boo aBoo) {
        if (this.isKO()) {
            int damage = 0;
            aBoo.setHP(aBoo.getHP() - damage);
        }
    }

    @Override
    public void jumpAttack(IEnemy anEnemy) {
        if(this.canAttack()) {
            anEnemy.attackedJumpLuis(this);
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
