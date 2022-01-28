package com.example.aventurasdemarcoyluis.model.items;

/**
 * Represents a generic item
 */

public abstract class AbstractItem implements ItemsInterface {

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return this.hashCode() == obj.hashCode();
    }
}
