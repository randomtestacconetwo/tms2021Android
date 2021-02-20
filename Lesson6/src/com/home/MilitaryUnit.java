package com.home;

import com.home.model.Person;

import java.util.Arrays;

public abstract class MilitaryUnit {
    private static int unitNumberCounter = 0;
    private final int capacity;
    private final int unitNumber;

    public MilitaryUnit(int capacity) {
        this.capacity = capacity;
        unitNumber = unitNumberCounter++;
    }

    /**
     * @return true if person was added to the unit, false if unit is full or if person already serves in the unit
     */
    public boolean addRecruit(Person person) {
        if (getFreePlaces() == 0) {
            System.out.println("Unit number " + unitNumber + " is full");
            return false;
        }
        boolean recruitExists = doesRecruitAlreadyExists(person, getRecruits());
        if (recruitExists) {
            return false;
        }
        addRecruitToRecruits(person);
        return true;
    }

    private boolean doesRecruitAlreadyExists(Person person, Person[] recruits) {
        for (Person recruit : recruits) {
            if (recruit != null && recruit.getName().equals(person.getName())
                    && recruit.getAge() == person.getAge()) {
                System.out.println("person " + person.getName() + "already serves here");
                return true;
            }
        }
        return false;
    }

    public void printRecruits() {
        if (getRecruits().length == 0) {
            System.out.println("Military Unit number " + unitNumber + " is empty");
            return;
        }
        System.out.println("Military Unit number " + unitNumber + " recruits:");
        int i = 1;
        for (String nameSurname : getSortedRecruitsNames()) {
            System.out.printf("%s. %s\n", i++, nameSurname);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    private String[] getSortedRecruitsNames() {
        String[] names = new String[getRecruits().length];
        int i = 0;
        for (Person p : getRecruits()) {
            names[i++] = p.getSurname() + " " + p.getName();
        }
        Arrays.sort(names);
        return names;
    }

    public abstract int getFreePlaces();

    protected abstract Person[] getRecruits();

    protected abstract void addRecruitToRecruits(Person person);
}
