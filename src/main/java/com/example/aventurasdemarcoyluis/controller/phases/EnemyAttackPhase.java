package com.example.aventurasdemarcoyluis.controller.phases;

import com.example.aventurasdemarcoyluis.controller.GameController;

/**
 * Phase in which an enemy attacks a random player
 */


public class EnemyAttackPhase extends AbstractPhase{

    /**
     * Constructor for the phase
     * @param controller the controller associated to this phase
     */

    public EnemyAttackPhase(GameController controller) {
        super(controller);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void enemyAttack() {
        this.getController().EnemyAttack();
    }
}
