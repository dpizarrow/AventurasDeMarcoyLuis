package com.example.aventurasdemarcoyluis.model.items;

/**
 * Class that represents a Red Mushroom item
 */
public class RedMushroom implements ItemsInterface{

    private final String name;

    /**
     *
     * @param itemName the name of the item
     */
    public RedMushroom(String itemName) {
        this.name = itemName;
    }

    @Override
    public ItemType getType() {
        return ItemType.RedMushroom;
    }

    @Override
    public String getName() {
        return this.name;
    }


}
