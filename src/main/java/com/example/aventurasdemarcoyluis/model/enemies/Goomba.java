package com.example.aventurasdemarcoyluis.model.enemies;
import com.example.aventurasdemarcoyluis.model.AttackType;
import com.example.aventurasdemarcoyluis.model.players.*;

/**
 * Class that represents a Goomba enemy
 */

public class Goomba extends Enemies {

    /**
     * @param aName the name of the Goomba
     * @param hp the health points of the Goomba
     * @param atk the attack points of the Goomba
     * @param def the defense points of the Goomba
     * @param lvl the level of the Goomba
     */

    public Goomba(String aName, int hp, int atk, int def, int lvl) {
        super(aName, hp, atk, def, lvl);
    }

    /**
     * Receives damage when attacked by a Marco player
     * @param anAttack the attack used
     * @param playerMarco the Marco player
     */
    public void attackedByMarco(AttackType anAttack, Marco playerMarco) {
        switch (anAttack) {
            case SALTO -> playerMarco.attackGoomba(AttackType.SALTO, this);
            case MARTILLO -> playerMarco.attackGoomba(AttackType.MARTILLO, this);
        }
    }

    /**
     * Deals damage when attacked by a Luis player
     * @param anAttack the attack used
     * @param playerLuis the Marco player
     */
    public void attackedByLuis(AttackType anAttack, Luis playerLuis) {
        switch (anAttack) {
            case SALTO -> playerLuis.attackGoomba(AttackType.SALTO, this);
            case MARTILLO -> playerLuis.attackGoomba(AttackType.MARTILLO, this);
        }
    }


    @Override
    public void attackedJumpMarco(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1, this);
        this.setHP(this.getHP()-dmg);
    }

    @Override
    public void attackedHammerMarco(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1.5, this);
        this.setHP(this.getHP()-dmg);
    }

    @Override
    public void attackedJumpLuis(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1, this);
        this.setHP(this.getHP()-dmg);
    }

    @Override
    public void attackedHammerLuis(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1.5, this);
        this.setHP(this.getHP()-dmg);
    }

    /**
     * Attacks a Marco player
     *
     * @param aPlayer the player that is attacked
     */
    @Override
    public void attackMarco(IPlayer aPlayer) {

    }

    /**
     * Attacks a Luis playuer
     *
     * @param aPlayer the player that is attacked
     */
    @Override
    public void attackLuis(IPlayer aPlayer) {

    }
}
