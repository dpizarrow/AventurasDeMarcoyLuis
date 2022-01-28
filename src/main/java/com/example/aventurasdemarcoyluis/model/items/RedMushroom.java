package com.example.aventurasdemarcoyluis.model.items;

import com.example.aventurasdemarcoyluis.model.players.IPlayer;

/**
 * Class that represents a Red Mushroom item
 */
public class RedMushroom extends AbstractItem {

    /**
     * Uses a red mushroom item, this item heals the player for 10% of their maximum HP
     *
     * @param aPlayer the player that uses the item
     */

    @Override
    public void usedBy(IPlayer aPlayer) {
        aPlayer.setHP((int) (aPlayer.getHP() + aPlayer.getMaxHP() * 0.1));
    }
}
