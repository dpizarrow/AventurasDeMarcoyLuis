package com.example.aventurasdemarcoyluis.controller.phases;

import com.example.aventurasdemarcoyluis.controller.GameController;
import com.example.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.example.aventurasdemarcoyluis.model.items.RedMushroom;


/**
 * Phase in which a player can use an item
 */


public class UseItemPhase extends AbstractPhase{

    /**
     * Constructor for this phase
     * @param controller the controller associated to this phase
     */

    public UseItemPhase(GameController controller) {
        super(controller);
    }

    /**
     * {@inheritDoc}
     * @param itemNum
     * @throws InvalidUseItemException
     */

    @Override
    public void useItem(int itemNum) throws InvalidUseItemException {
        if((itemNum==1) && this.getController().getInventory().canUseItem(new RedMushroom())) {
            this.getController().useItem(new RedMushroom());
        }
        else if((itemNum==2) && this.getController().getInventory().canUseItem(new HoneySyrup())) {
            this.getController().useItem(new HoneySyrup());
        }
        else {
            throw new InvalidUseItemException("There is none of this item in the Inventory.");
        }
    }


    /**
     * {@inheritDoc}
     */

    @Override
    public void toPlayerUndo() {
        this.getController().setPhase(new PlayerDecisionPhase(this.getController()));
    }
}
