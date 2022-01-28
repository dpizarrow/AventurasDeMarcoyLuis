package com.example.aventurasdemarcoyluis.model.enemies;

import java.util.Hashtable;

/**
 * Interface to handle the creation of different enemy factories
 */

public interface IEnemyFactory {

    /**
     * Creates a hashtable of enemies of the same type
     *
     * @param n the number of enemies to put in the hashtable
     * @return the hashtable with enemies and numbers 1 to n to keys
     */

    Hashtable<Integer, IEnemy> create(int n);
}
