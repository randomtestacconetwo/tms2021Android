package com.home.practice;

import jdk.jfr.Event;

@FunctionalInterface
public interface ClickHandler {
    void handle(Event event);

    default String defaultMessage() {
        return "Another default message";
    }
}
