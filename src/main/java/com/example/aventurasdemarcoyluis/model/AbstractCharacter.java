package com.example.aventurasdemarcoyluis.model;

/**
 * Abstract class for players and enemies
 */

public abstract class AbstractCharacter implements ICharacter {
    protected int HP;
    protected int ATK;
    protected int DEF;
    protected int LVL;

    /**
     *
     * @param hp the health points of the player or enemy
     * @param atk the attack points of the player or enemy
     * @param def the defense points of the player or enemy
     * @param lvl the level of the player or enemy
     */
    protected AbstractCharacter(int hp, int atk, int def, int lvl) {
        this.HP = hp;
        this.ATK = atk;
        this.DEF = def;
        this.LVL = lvl;
    }

    @Override
    public int getHP() {
        return this.HP;
    }

    @Override
    public void setHP(int hp) {
        this.HP = hp;
    }


    @Override
    public int getATK() {
        return this.ATK;
    }

    @Override
    public void setATK(int atk) {
        this.ATK = atk;
    }

    @Override
    public int getDEF() {
        return this.DEF;
    }

    @Override
    public void setDEF(int def) {
        this.DEF = def;
    }

    @Override
    public int getLVL() {
        return this.LVL;
    }

    @Override
    public void setLVL(int lvl) {
        this.LVL = lvl;
    }

    @Override
    public int calculateDamage(double k, ICharacter attacked) {
        return (int) (k * this.getATK() * (this.getLVL()) / attacked.getDEF());
    }

    @Override
    public boolean isKO() {
        return this.getHP() <= 0;
    }

}
