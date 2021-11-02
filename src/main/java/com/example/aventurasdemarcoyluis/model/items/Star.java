package com.example.aventurasdemarcoyluis.model.items;

/**
 * Represents a Star item
 */
public class Star implements ItemsInterface{
    private final String name;

    /**
     *
     * @param itemName the name of the item
     */
    public Star(String itemName) {
        this.name = itemName;
    }

    @Override
    public ItemType getType() {
        return ItemType.STAR;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
