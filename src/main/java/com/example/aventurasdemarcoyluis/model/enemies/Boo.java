package com.example.aventurasdemarcoyluis.model.enemies;

import com.example.aventurasdemarcoyluis.model.AttackType;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;
import com.example.aventurasdemarcoyluis.model.players.Luis;
import com.example.aventurasdemarcoyluis.model.players.Marco;

/**
 * Class that represents a Boo enemy
 */

public class Boo extends Enemies {

    /**
     *
     * @param aName the name of the Boo
     * @param hp the health points of the Boo
     * @param atk the attack points of the Boo
     * @param def the defense points of the Boo
     * @param lvl the level of the Boo
     */
    public Boo(String aName, int hp, int atk, int def, int lvl) {
        super(aName, hp, atk, def, lvl);
    }


    /**
     * Receives damage to the Boo when attack by a Marcos player
     * @param anAttack the type of attack received
     * @param playerMarco the Player that attacks
     */
    public void attackedByMarco(AttackType anAttack, Marco playerMarco) {
        switch (anAttack) {
            case SALTO -> playerMarco.attackBoo(AttackType.SALTO, this);
            case MARTILLO -> playerMarco.attackBoo(AttackType.MARTILLO, this);
        }
    }

    /**
     * Deals damage to the Boo when attack by a Luis player
     * @param anAttack the type of attack received
     * @param playerLuis the Player that attacks
     */
    public void attackedByLuis(AttackType anAttack, Luis playerLuis) {
        switch (anAttack) {
            case SALTO -> playerLuis.attackBoo(AttackType.SALTO, this);
            case MARTILLO -> playerLuis.attackBoo(AttackType.MARTILLO, this);
        }
    }

    @Override
    public void attackedJumpMarco(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1, this);
        this.setHP(this.getHP()-dmg);
    }

    @Override
    public void attackedHammerMarco(IPlayer aPlayer) {

    }

    @Override
    public void attackedJumpLuis(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1, this);
        this.setHP(this.getHP()-dmg);
    }

    @Override
    public void attackedHammerLuis(IPlayer aPlayer) {

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
