package com.beingmate.learn.hyperloglog;

@SuppressWarnings("serial")
public abstract class CardinalityMergeException extends Exception {

    public CardinalityMergeException(String message) {
        super(message);
    }
}