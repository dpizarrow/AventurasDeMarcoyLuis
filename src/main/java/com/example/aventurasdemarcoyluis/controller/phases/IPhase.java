package com.example.aventurasdemarcoyluis.controller.phases;


/**
 * Interface that represents a generic phase
 */


public interface IPhase {


    /**
     * Transitions to a player attack phase
     * @throws InvalidTransitionException if the transition is not possible
     */

    void toPlayerAttackPhase() throws InvalidTransitionException;

    /**
     * Transitions to a player phase to use an item
     * @throws InvalidTransitionException if the transition is not possible
     */

    void toPlayerItemPhase() throws InvalidTransitionException;

    /**
     * Undoes the phase transition
     * @throws InvalidTransitionException if this is not possible
     */

    void toPlayerUndo() throws InvalidTransitionException;

    /**
     * Phase to skip a player's turn
     * @throws InvalidTransitionException if this is not possible
     */

    void PlayerSkipTurn() throws InvalidTransitionException;

    /**
     * A player uses an Item
     * @param itemNum the item to be used
     * @throws InvalidUseItemException if the item is not in the inventory
     */

    void useItem(int itemNum) throws InvalidUseItemException;

    /**
     * Jump attack during the PlayerAttackPhase
     * @param enemyNum the enemy to be attacked
     * @throws InvalidAttackableException if the player cannot attack the enemy
     */

    void jumpAttack(int enemyNum) throws InvalidAttackableException;

    /**
     * Hammer attack during the Player Attack Phase
     * @param enemyNum the enemy to be attacked
     * @throws InvalidAttackableException if the player cannot attack the enemy
     */

    void hammerAttack(int enemyNum) throws InvalidAttackableException;

    /**
     * Enemy attacks a player during the EnemyAttackPhase
     * @throws InvalidActionException if the enemy cannot attack the player
     */

    void enemyAttack() throws InvalidActionException;

}
