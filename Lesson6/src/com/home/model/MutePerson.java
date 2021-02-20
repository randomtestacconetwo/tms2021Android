package com.home.model;

import com.home.exceptions.CantSpeakException;
import com.home.exceptions.InvalidNameSurnameException;

public class MutePerson extends Person {

    public MutePerson(Address address, int age, String name, String surname, String sex) throws InvalidNameSurnameException {
        super(address, age, name, surname, sex);
    }

    @Override
    public void speak() throws CantSpeakException {
        throw new CantSpeakException("Mute Person can't speak");
    }
}
