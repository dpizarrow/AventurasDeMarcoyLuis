package com.example.aventurasdemarcoyluis.controller.phases;

import com.example.aventurasdemarcoyluis.controller.GameController;
import com.example.aventurasdemarcoyluis.model.enemies.IEnemy;


/**
 * Phase for a player to attack a chosen enemy
 */

public class PlayerAttackPhase extends AbstractPhase{

    /**
     * Constructor for this phase
     * @param controller the controller associated to this phase
     */

    public PlayerAttackPhase(GameController controller) {
        super(controller);
    }

    /**
     * {@inheritDoc}
     * @param enemyNum
     * @throws InvalidAttackableException
     */


    @Override
    public void jumpAttack(int enemyNum) throws InvalidAttackableException {
        int enemyIndex = enemyNum - 1;
        if( (0 <= enemyIndex) && (enemyIndex <= this.getController().getEnemies().size()-1)){
            IEnemy enemy = this.getController().getEnemies().get(enemyIndex);
            if(this.getController().getCurrentPlayer().canAttackEnemy(enemy)){
                this.getController().JumpAttack(enemy);
            }
            else {
                throw new InvalidAttackableException("Cannot attack this kind of Enemy.");
            }
        }
        else {
            throw new InvalidAttackableException("Cannot attack this kind of Enemy.");
        }
    }

    /**
     * {@inheritDoc}
     * @param enemyNum
     * @throws InvalidAttackableException
     */

    @Override
    public void hammerAttack(int enemyNum) throws InvalidAttackableException {
        int enemyIndex = enemyNum - 1;
        if( (0 <= enemyIndex) && (enemyIndex <= this.getController().getEnemies().size()-1)){
            IEnemy enemy = this.getController().getEnemies().get(enemyIndex);
            if(this.getController().getCurrentPlayer().canAttackEnemy(enemy)){
                this.getController().HammerAttack(enemy);
            }
            else {
                throw new InvalidAttackableException("Cannot attack this kind of Enemy.");
            }
        }
        else {
            throw new InvalidAttackableException("Cannot attack this kind of Enemy.");
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
