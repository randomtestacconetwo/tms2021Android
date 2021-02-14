package com.home.practice;

import jdk.jfr.Event;

public interface CommonHandler extends ClickHandler, FocusHandler {
    void handleEvent(Event event);
}
