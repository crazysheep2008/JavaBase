package com.beingmate.learn.hyperloglog;

public interface IBuilder<T> {

    T build();

    int sizeof();
}