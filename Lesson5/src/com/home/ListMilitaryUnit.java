package com.home;

import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;

public class ListMilitaryUnit extends MilitaryUnit {
    private List<Person> recruits;

    public ListMilitaryUnit(int capacity) {
        super(capacity);
        recruits = new LinkedList<>();
    }

    @Override
    public int getFreePlaces() {
        return getCapacity() - recruits.size();
    }

    @Override
    protected Person[] getRecruits() {
        return recruits.toArray(new Person[0]);
    }

    @Override
    protected void addRecruitToRecruits(Person person) {
        recruits.add(person);
    }
}
