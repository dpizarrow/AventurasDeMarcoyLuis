package com.example.aventurasdemarcoyluis.controller.phases;

import com.example.aventurasdemarcoyluis.controller.GameController;



/**
 * Implementation of an abstract phase
 */

public abstract class AbstractPhase implements IPhase {
    private final GameController controller;

    /**
     * Constructor for the abstract phase
     * @param controller the controller associated to the phase
     */

    public AbstractPhase(GameController controller) {
        this.controller = controller;
    }

    /**
     * Gets the phase's game controller
     * @return the phase's game controller
     */

    public GameController getController() {
        return controller;
    }


    /**
     * {@inheritDoc}
     * @throws InvalidTransitionException
     */

    @Override
    public void toPlayerAttackPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Cannot make this transition");
    }


    /**
     * {@inheritDoc}
     * @throws InvalidTransitionException
     */

    @Override
    public void toPlayerItemPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Cannot make this transition");
    }


    /**
     * {@inheritDoc}
     * @throws InvalidTransitionException
     */

    @Override
    public void toPlayerUndo() throws InvalidTransitionException {
        throw new InvalidTransitionException("Cannot make this transition");
    }


    /**
     * {@inheritDoc}
     * @throws InvalidTransitionException
     */

    @Override
    public void PlayerSkipTurn() throws InvalidTransitionException {
        throw new InvalidTransitionException("Cannot make this transition");
    }


    /**
     * {@inheritDoc}
     * @param itemNum
     * @throws InvalidUseItemException
     */

    @Override
    public void useItem(int itemNum) throws InvalidUseItemException {
        throw new InvalidUseItemException("Cannot do this action in the current phase");
    }


    /**
     * {@inheritDoc}
     * @param enemyNum the enemy to be attacked
     * @throws InvalidAttackableException
     */

    @Override
    public void jumpAttack(int enemyNum) throws InvalidAttackableException {
        throw new InvalidAttackableException("Cannot do this action in the current phase");
    }


    /**
     * {@inheritDoc}
     * @param enemyNum enemy to be attacked
     * @throws InvalidAttackableException
     */

    @Override
    public void hammerAttack(int enemyNum) throws InvalidAttackableException {
        throw new InvalidAttackableException("Cannot do this action in the current phase");
    }


    /**
     * {@inheritDoc}
     * @throws InvalidActionException
     */

    @Override
    public void enemyAttack() throws InvalidActionException {
        throw new InvalidActionException("Cannot do this action in the current phase");
    }
}
