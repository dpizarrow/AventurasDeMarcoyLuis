package com.example.aventurasdemarcoyluis.controller.phases;

/**
 * Exception that is thrown when a phase transition is not possible
 */


public class InvalidTransitionException extends Exception{
    public InvalidTransitionException(String message) {
        super(message);
    }
}
