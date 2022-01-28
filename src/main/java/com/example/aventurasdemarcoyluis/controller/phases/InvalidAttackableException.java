package com.example.aventurasdemarcoyluis.controller.phases;


/**
 * Exception that is thrown when a player attempts to attack an enemy that it cannot attack
 */

public class InvalidAttackableException extends Exception {
    public InvalidAttackableException(String message) {
        super(message);
    }
}
