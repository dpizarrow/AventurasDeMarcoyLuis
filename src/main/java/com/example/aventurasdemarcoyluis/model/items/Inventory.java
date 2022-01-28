package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.players.IPlayer;

import java.util.HashMap;
import java.util.Map;


/**
 * Represents the player's shared inventory
 * as a HashMap with items as keys and amounts as values
 */

public class Inventory {

    private final Map<ItemsInterface, Integer> inventory;

    /**
     * Initializes the inventory
     */

    public Inventory() {
        inventory = new HashMap<>();
    }

    /**
     * Adds an item to the inventory
     *
     * @param anItem the item to be added
     * @param amount the amount of the item to add
     */

    public void add(ItemsInterface anItem, int amount) {
        if (inventory.containsKey(anItem)) {
            inventory.put(anItem, inventory.get(anItem) + amount);
        } else {
            inventory.put(anItem, amount);
        }
    }

    /**
     * Checks if an item is in the inventory
     *
     * @param anItem the item to be checked
     * @return true if the item is in the inventory
     */

    public boolean has(ItemsInterface anItem) {
        return inventory.containsKey(anItem);
    }

    /**
     * Gets the amount of items in the inventory
     *
     * @param anItem the item to be queried
     * @return the amount of the item in the inventory
     */

    public int value(ItemsInterface anItem) {
        if (this.has(anItem)) {
            return inventory.get(anItem);
        } else {
            return 0;
        }
    }

    /**
     * Takes an item from the inventory
     *
     * @param anItem the item to be taken
     */

    public void takeItem(ItemsInterface anItem) {
        add(anItem, -1);
    }

    public void useItem(IPlayer aPlayer, ItemsInterface anItem) {
        if (this.has(anItem)) {
            this.takeItem(anItem);
            aPlayer.useItem(anItem);
        }
    }


    /**
     * Checks if the inventory is empty
     *
     * @return true if the inventory is empty
     */

    public boolean isEmpty() {
        return inventory.isEmpty();
    }


    /**
     * Checks if the player can use an item. This method returns true if the item is in the inventory,
     * and the amount of the item in the inventory is greater than 0
     * @param anItem the item to be checked
     * @return true if the item can be used
     */

    public boolean canUseItem(ItemsInterface anItem) {
        return this.has(anItem) && this.value(anItem) > 0;
    }


}
