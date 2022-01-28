package com.example.aventurasdemarcoyluis.model;


import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;
import com.example.aventurasdemarcoyluis.model.items.ItemsInterface;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;

import java.util.Random;

/**
 * Class that represent a Player in the game
 *
 * @author SB
 */
public abstract class AbstractPlayers extends AbstractCharacter implements IPlayer {
    protected int fp;
    protected int maxFP;
    protected int maxHP;
    protected final String name;
    protected final Random rand;

    /**
     * Creates a new player
     *
     * @param atk attack points
     * @param def defense points
     * @param hp  heal points
     * @param fp  fight points
     * @param lvl level of the Unit
     */
    protected AbstractPlayers(String name, int hp, int atk, int def, int lvl, int fp, int maxfp, int maxhp) {
        super(hp, atk, def, lvl);
        this.name = name;
        this.fp = fp;
        this.maxFP = maxfp;
        this.maxHP = maxhp;
        rand = new Random();
    }

    /**
     * Gets the name of the player
     *
     * @return the players name
     */

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setHP(int hp) {
        if (hp > 0 && hp < this.maxHP) {
            this.HP = hp;
        }

        if (hp >= this.maxHP) {
            this.HP = this.maxHP;
        }

        if (hp == 0) {
            this.HP = 0;
            this.setATK(0);
        }

    }

    /**
     * Gets the maximum health points of a player
     *
     * @return the players maximum health points
     */

    @Override
    public int getMaxHP() {
        return this.maxHP;
    }

    @Override
    public void setMaxHP(int hp) {
        this.maxHP = hp;
    }

    /**
     * Gets the players fight points
     *
     * @return the players fight points
     */

    @Override
    public int getFp() {
        return this.fp;
    }

    /**
     * Sets the fight points of a player
     * If the value to set is less than the maximum fight points, the value is updated
     * If the value to set is higher than the maximum fight points, the fight points are set to the players maximum fight points
     * In any other case, the fight point value is not set
     *
     * @param fp the fight points to set
     */

    @Override
    public void setFp(int fp) {
        if (fp >= 0 && fp < this.maxFP) {
            this.fp = fp;
        }

        if (fp >= this.maxFP) {
            this.fp = this.maxFP;
        }

        if (fp < 0) {
            this.fp = 0;
        }

    }

    /**
     * Gets the maximum fight points of a player
     *
     * @return the maximum fight points of a player
     */

    @Override
    public int getMaxFP() {
        return this.maxFP;
    }

    @Override
    public void setMaxFP(int fp) {
        this.maxFP = fp;
    }

    /**
     * A player uses an item. Depending on the item used, this affects the player in different ways
     *
     * @param anItem the item to be used
     */

    @Override
    public void useItem(ItemsInterface anItem) {
        anItem.usedBy(this);
    }

    /**
     * Determines if a player can attack or not
     * This means that if a player has an HP higher than 0 and an FP greater than or equal to 1
     * The player can attack
     *
     * @return true if the player can attack
     */

    @Override
    public boolean canAttack() {
        return this.getHP() > 0 && this.getFp() >= 1;
    }


    /**
     * Updates a player's statistics on leveling up
     * The player's level increases by 1
     * The player's maximum hp increases by 15% and is healed by that amount
     * The player's maximum fp increases by 15% and is set to that amount
     * The player's attack value is increases by 15%
     * The player's defense value is increased by 15%
     */

    @Override
    public void levelUp() {
        this.setLVL(this.getLVL() + 1);
        int newfp = (int) (this.getMaxFP() * 1.15);
        int newhp = (int) (this.getMaxHP() * 1.15);
        int newatk = (int) (this.getATK() * 1.15);
        int newdef = (int) (this.getDEF() * 1.15);
        this.setMaxFP(newfp);
        this.setFp(newfp);
        this.setMaxHP(newhp);
        this.setHP(newhp);
        this.setATK(newatk);
        this.setDEF(newdef);
    }


    /**
     * Checks if the character is a player
     *
     * @return true since AbstractPlayer represents a player
     */

    @Override
    public boolean isPlayer() {
        return true;
    }

    /**
     * Checks if the character is an enemy
     *
     * @return false since AbstractPlayer is not an enemy
     */

    @Override
    public boolean isEnemy() {
        return false;
    }

    /**
     * Determines if the player can be attacked by a Goomba
     * @return true since goombas can attack all players
     */

    @Override
    public boolean canBeAttackedByGoomba() {
        return true;
    }


    /**
     * Determines if the player can be attacked by a Spiny
     * @return true since spiny can attack all players
     */

    @Override
    public boolean canBeAttackedBySpiny() {
        return true;
    }

    /**
     * The player jump attacks an enemy
     * @param anEnemy the enemy that is attacked
     */

    @Override
    public void jumpAttack(IEnemy anEnemy) {
        if(this.canAttack() && this.canAttackEnemy(anEnemy)) {
            this.setFp(this.getFp()-1);
            anEnemy.attackedByJump(this);
        }
    }

    /**
     * The player hammer attacks an enemy
     * @param anEnemy the enemy that is attacked
     */

    @Override
    public void hammerAttack(IEnemy anEnemy) {
        if(this.canAttack() && this.canAttackEnemy(anEnemy) && this.generateRandom()) {
            this.setFp(this.getFp()-2);
            anEnemy.attackedByHammer(this);
        }
    }

    /**
     * Sets a seed for the random number generator
     * will be used to test the hammer attack
     *
     * @param seed the seed to be set
     */
    @Override
    public void setSeed(long seed) {
        rand.setSeed(seed);
    }

    /**
     * Generates a random number and returns true or false depending on whether a hammer attack
     * is successful or not
     * @return true if the hammer attack is successful
     */

    @Override
    public boolean generateRandom() {
        int events = rand.nextInt(4);
        return events != 0;
    }

}