package com.home.model;

import com.home.exceptions.CantSpeakException;

public class MutePerson extends Person {

    public MutePerson() {
    }

    public MutePerson(Address address, int age, String name, String sex) {
        super(address, age, name, sex);
    }

    @Override
    public void speak() throws CantSpeakException {
        throw new CantSpeakException("Mute Person can't speak");
    }
}
