package com.example.aventurasdemarcoyluis.controller.phases;

import com.example.aventurasdemarcoyluis.controller.GameController;

/**
 * Phase for a player to do an action
 * Here, players can attack an enemy, use an item or skip their turn
 */


public class PlayerDecisionPhase extends AbstractPhase{

    /**
     * Constructor for the phase
     * @param controller the controller associated to the phase
     */

    public PlayerDecisionPhase(GameController controller) {
        super(controller);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void toPlayerAttackPhase(){
        this.getController().setPhase(new PlayerAttackPhase(this.getController()));
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void toPlayerItemPhase(){
        this.getController().setPhase(new UseItemPhase(this.getController()));
    }

    /**
     * {@inheritDoc}
     */


    @Override
    public void PlayerSkipTurn(){
        this.getController().setNextTurn();
    }
}
