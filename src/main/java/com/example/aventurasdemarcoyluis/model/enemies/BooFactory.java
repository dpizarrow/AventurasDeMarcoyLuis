package com.example.aventurasdemarcoyluis.model.enemies;

import java.util.Hashtable;

/**
 * Class that represents a boo factory
 * Creates multiple instances of the same enemy
 */

public class BooFactory implements IEnemyFactory {
    /**
     * Creates a hashtable of Boo enemies
     *
     * @param n the number of enemies to put in the hashtable
     * @return the hashtable with enemies and numbers 1 to n to keys
     */
    @Override
    public Hashtable<Integer, IEnemy> create(int n) {
        n = Math.max(0, n);
        Hashtable<Integer, IEnemy> booTable = new Hashtable<>();
        for (int i = 1; i <= n; i++) {
            Boo aBoo = new Boo("Boo", 20, 20, 20, 1);
            booTable.put(i, aBoo);
        }
        return booTable;
    }
}
