package com.example.aventurasdemarcoyluis.model.enemies;

import java.util.Hashtable;

/**
 * Class that represents a Goomba factory
 * Creates multiple of the same enemy
 */

public class GoombaFactory implements IEnemyFactory {
    /**
     * Creates a hashtable of Goomba enemies
     *
     * @param n the number of enemies to put in the hashtable
     * @return the hashtable with enemies and numbers 1 to n to keys
     */
    @Override
    public Hashtable<Integer, IEnemy> create(int n) {
        n = Math.max(0, n);
        Hashtable<Integer, IEnemy> goombaTable = new Hashtable<>();
        for (int i = 1; i <= n; i++) {
            Goomba aGoomba = new Goomba("Goomba", 20, 20, 20, 1);
            goombaTable.put(i, aGoomba);
        }
        return goombaTable;
    }
}
