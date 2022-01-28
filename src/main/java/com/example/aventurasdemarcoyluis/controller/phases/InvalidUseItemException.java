package com.example.aventurasdemarcoyluis.controller.phases;


/**
 * Exception that is thrown when a player attempts to use an item that is not in the inventory
 */

public class InvalidUseItemException extends Exception{
    public InvalidUseItemException(String message) {
        super(message);
    }
}
