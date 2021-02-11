package com.home.model;

import com.home.exceptions.CantSpeakException;

public interface Speaker {
    void speak() throws CantSpeakException;
}
