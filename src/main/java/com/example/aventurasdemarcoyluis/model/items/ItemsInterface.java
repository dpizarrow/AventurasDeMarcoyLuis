package com.example.aventurasdemarcoyluis.model.items;

/**
 * Interface that represents a generic item
 */

public interface ItemsInterface {
    /**
     * Gets the type of the item
     * @return the item type
     */
    ItemType getType();

    /**
     * Gets the name of the item
     * @return the name of the item
     */
    String getName();
}
