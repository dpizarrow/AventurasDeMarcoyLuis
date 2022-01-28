package com.example.aventurasdemarcoyluis.controller.phases;


/**
 * Exception that is thrown when an enemy tries to attack a player that it cannot
 */

public class InvalidActionException extends Exception{
    public InvalidActionException(String message) {
        super(message);
    }
}
