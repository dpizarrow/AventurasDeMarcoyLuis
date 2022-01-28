package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.players.IPlayer;

/**
 * Interface that represents a generic item
 */

public interface ItemsInterface {

    /**
     * Modifies the player's stats depending on the item used
     *
     * @param aPlayer the player that uses the item
     */

    void usedBy(IPlayer aPlayer);

}
