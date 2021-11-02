package com.example.aventurasdemarcoyluis.model;


import com.example.aventurasdemarcoyluis.model.items.*;
import com.example.aventurasdemarcoyluis.model.players.IPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represent a Player in the game
 *
 *  @author SB
 */
public abstract class AbstractPlayers extends AbstractCharacter implements IPlayer {
    protected int fp;
    protected int maxFP;
    protected int maxHP;
    protected String name;
    public List<ItemsInterface> armamento = new ArrayList<>();

    /**
     * Creates a new player
     * @param atk attack points
     * @param def defense points
     * @param hp  heal points
     * @param fp  fight points
     * @param lvl level of the Unit
     *
     */
    protected AbstractPlayers(String name, int hp, int atk, int def, int lvl, int fp, int maxfp, int maxhp) {
        super(hp, atk, def, lvl);
        this.name = name;
        this.fp = fp;
        this.maxFP = maxfp;
        this.maxHP = maxhp;
    }

    /**
     * Adds an item to the players inventory
     * @param anItem item to be added
     */

    @Override
    public void addAItem(ItemsInterface anItem){
        armamento.add(anItem);
    }

    /**
     * Gets the name of the player
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

        if(hp == 0) {
            this.HP = 0;
            this.setATK(0);
        }

    }

    /**
     * Gets the maximum health points of a player
     * @return the players maximum health points
     */

    @Override
    public int getMaxHP() {
        return this.maxHP;
    }

    /**
     * Gets the players fight points
     * @return the players fight points
     */

    @Override
    public int getFp() {
        return this.fp;
    }

    /**
     * Gets the maximum fight points of a player
     * @return the maximum fight points of a player
     */

    @Override
    public int getMaxFP() {
        return this.maxFP;
    }

    /**
     * Sets the fight points of a player
     * If the value to set is less than the maximum fight points, the value is updated
     * If the value to set is higher than the maximum fight points, the fight points are set to the players maximum fight points
     * In any other case, the fight point value is not set
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

    }

    /**
     * Use a Red Mushroom item
     * This item heals the player an amount of 10% of the players maximum hp
     * After using the item, it is removed from the players inventory
     * @param aRedMushroom the red mushroom to be used
     */

    @Override
    public void useRedMushroom(RedMushroom aRedMushroom) {
        if(armamento.contains(aRedMushroom)) {
            int newhp = (int) (getHP() + this.maxHP * 0.1);
            setHP(newhp);
            armamento.remove(aRedMushroom);
        }
    }

    /**
     * Use a Honey Syrup item
     * This item adds 3 to the players current fight point value
     * After using the item, it is removed from the players inventory
     * @param aHoneySyrup the honey syrup to be used
     */

    @Override
    public void useHoneySyrup(HoneySyrup aHoneySyrup) {
        if(armamento.contains(aHoneySyrup)) {
            int newfp = getFp() + 3;
            setFp(newfp);
            armamento.remove(aHoneySyrup);
        }
    }

    /**
     * Use a star item
     * For now, the star sets the current hp to the players maximum hp
     * @param aStar the star item to be used
     */

    @Override
    public void useStar(Star aStar) {
        if(armamento.contains(aStar)) {
            setHP(this.maxHP);
        }
    }

    @Override
    public boolean canAttack() {
        return this.getHP() > 0 && this.getFp() >= 1;
    }

}