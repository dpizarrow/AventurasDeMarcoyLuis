package com.example.aventurasdemarcoyluis.model.enemies;
import com.example.aventurasdemarcoyluis.model.AttackType;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;
import com.example.aventurasdemarcoyluis.model.players.Marco;

/**
 * Class that represents a Spiny enemy
 */

public class Spiny extends Enemies {
    /**
     *
     * @param aName Name of the Spiny
     * @param hp Health points of the Spiny
     * @param atk Attack points of the Spiny
     * @param def Defense points of the Spiny
     * @param lvl level of the Spiny
     */
    public Spiny(String aName, int hp, int atk, int def, int lvl) {
        super(aName, hp, atk, def, lvl);
    }

    /**
     * Receives damage dealt by a Marco Player
     * @param anAttack the attack used
     * @param playerMarco the Marco player
     */
    public void attackedByMarco(AttackType anAttack, Marco playerMarco) {
        switch (anAttack) {
            case SALTO -> playerMarco.attackSpiny(AttackType.SALTO, this);
            case MARTILLO -> playerMarco.attackSpiny(AttackType.MARTILLO, this);
        }
    }

    @Override
    public void attackedJumpMarco(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1, this);
        this.setHP(this.getHP()-dmg);
        aPlayer.setHP((int) (aPlayer.getHP() - (aPlayer.getHP() * 0.05)));
    }

    @Override
    public void attackedHammerMarco(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1.5, this);
        this.setHP(this.getHP() - dmg);
    }

    @Override
    public void attackedJumpLuis(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1, this);
        this.setHP(this.getHP()-dmg);
        aPlayer.setHP((int) (aPlayer.getHP() - (aPlayer.getHP() * 0.05)));
    }

    @Override
    public void attackedHammerLuis(IPlayer aPlayer) {
        int dmg = aPlayer.calculateDamage(1.5, this);
        this.setHP(this.getHP() - dmg);
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
