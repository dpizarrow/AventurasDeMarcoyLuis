package com.example.aventurasdemarcoyluis.model;

public interface ICharacter {
    /**
     * Gets the attack points of a player or an enemy
     * @return the attack points
     */
    int getATK();

    /**
     * Sets the attack points of a player or an enemy
     * @param atk The attack points to set
     */
    void setATK(int atk);

    /**
     * Gets the defense points of a player or an enemy
     * @return the defense points
     */
    int getDEF();

    /**
     * Sets the defense points of a player or an enemy
     * @param def the defense points to set
     */
    void setDEF(int def);

    /**
     * Gets the health points of a player or an enemy
     * @return the health points
     */
    int getHP();

    /**
     * Sets the health points of a player or an enemy
     * @param hp the health points to set
     */
    void setHP(int hp);

    /**
     * Gets the level of a player or an enemy
     * @return the level
     */
    int getLVL();

    /**
     * Sets the level of a player or an enemy
     * @param lvl The level to set
     */
    void setLVL(int lvl);

    /**
     * Calculates the damage done to a character
     * @param k the attack type constant
     * @param attacked the character that is attacked
     * @return the damage that a player does to the attacked character
     */
    int calculateDamage(double k, ICharacter attacked);

    /**
     * Checks if a character is defeated. That is, if the character's Hp is less than
     * or equal to 0
     * @return true if the character is defeated
     */

    boolean isKO();
}
