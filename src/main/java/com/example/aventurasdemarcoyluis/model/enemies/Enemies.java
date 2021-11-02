package com.example.aventurasdemarcoyluis.model.enemies;

import com.example.aventurasdemarcoyluis.model.AbstractCharacter;

/**
 * Class that represents a generic enemy
 */

public abstract class Enemies extends AbstractCharacter implements IEnemy{
    private final String name;
    /**
     * Creates a new Enemy
     * @param atk attack points
     * @param def defense points
     * @param hp heal points
     * @param lvl level of the Unit
     *
     */
    public Enemies(String aName, int hp, int atk, int def, int lvl){
        super(hp, atk, def, lvl);
        this.name = aName;
    }

    /**
     * Gets the name of the enemy
     * @return the name of the enemy
     */

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enemies enemies)) return false;
        return ATK == enemies.ATK && DEF == enemies.DEF && HP == enemies.HP && LVL == enemies.LVL;
    }


}
