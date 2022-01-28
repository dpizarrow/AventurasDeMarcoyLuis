package com.example.aventurasdemarcoyluis.model.enemies;

import java.util.Hashtable;

/**
 * Class that represents a Spiny factory
 * Creates multiple instances of the same enemy
 */

public class SpinyFactory implements IEnemyFactory {
    /**
     * Creates a hashtable of Spiny enemies
     *
     * @param n the number of enemies to put in the hashtable
     * @return the hashtable with enemies and numbers 1 to n to keys
     */
    @Override
    public Hashtable<Integer, IEnemy> create(int n) {
        n = Math.max(0, n);
        Hashtable<Integer, IEnemy> spinyTable = new Hashtable<>();
        for (int i = 1; i <= n; i++) {
            Spiny aSpiny = new Spiny("Spiny", 20, 20, 20, 1);
            spinyTable.put(i, aSpiny);
        }
        return spinyTable;
    }
}
