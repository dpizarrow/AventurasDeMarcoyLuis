package com.example.aventurasdemarcoyluis.model.items;

/**
 * Class that represents a Honey Syrup item
 */

public class HoneySyrup implements ItemsInterface{
    private final String name;

    /**
     *
     * @param itemName the name of the item
     */
    public HoneySyrup(String itemName) {
        this.name = itemName;
    }

    @Override
    public ItemType getType() {
        return ItemType.HoneySyrup;
    }

    @Override
    public String getName() {
        return this.name;
    }

}


