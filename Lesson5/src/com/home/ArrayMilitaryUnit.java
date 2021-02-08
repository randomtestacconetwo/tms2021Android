package com.home;

import com.home.model.Person;

public class ArrayMilitaryUnit extends MilitaryUnit {
    private final Person[] recruits;
    private int takenPlacesCount = 0;

    public ArrayMilitaryUnit(int capacity) {
        super(capacity);
        recruits = new Person[capacity];
    }

    public ArrayMilitaryUnit() {
        super(10);
        recruits = new Person[10];
    }

    @Override
    public int getFreePlaces() {
        return getCapacity() - takenPlacesCount;
    }

    @Override
    protected Person[] getRecruits() {
        return recruits;
    }

    @Override
    protected void addRecruitToRecruits(Person person) {
        recruits[takenPlacesCount++] = person;
    }
}
