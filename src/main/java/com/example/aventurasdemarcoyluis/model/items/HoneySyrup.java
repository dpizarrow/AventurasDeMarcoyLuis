package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.players.IPlayer;

/**
 * Class that represents a Honey Syrup item
 */

public class HoneySyrup extends AbstractItem {

    /**
     * A player uses a Honey Syrup item
     * This item gives 3 FP to the player
     *
     * @param aPlayer the player that uses the item
     */

    @Override
    public void usedBy(IPlayer aPlayer) {
        aPlayer.setFp(aPlayer.getFp() + 3);
    }
}


