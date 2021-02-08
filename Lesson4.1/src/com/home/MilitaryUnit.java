package com.home;

import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;

public class MilitaryUnit {
    private static int unitNumberCounter = 0;
    private final int capacity;
    private final int unitNumber;
    private final Person[] recruitsArray;
    private final List<Person> recruits;
    private int takenPlacesCount = 0;

    public MilitaryUnit(int capacity) {
        this.capacity = capacity;
        unitNumber = unitNumberCounter++;
        recruitsArray = new Person[capacity];
        recruits = new LinkedList<>();
    }

    /**
     * @return true if person was added to the unit, false if unit is full or if person already serves in the unit
     */
    public boolean addRecruitToList(Person person) {
        if (getFreePlacesFromList() == 0) {
            System.out.println("Unit number " + unitNumber + " is full");
            return false;
        }
        boolean recruitExists = doesRecruitAlreadyExists(person, recruits.toArray(new Person[0]));
        if (recruitExists) {
            return false;
        }
        recruits.add(person);
        return true;
    }

    /**
     * @return true if person was added to the unit, false if unit is full or if person already serves in the unit
     */
    public boolean addRecruitToArray(Person person) {
        if (getFreePlacesFromArray() == 0) {
            System.out.println("Unit number " + unitNumber + " is full");
            return false;
        }
        boolean recruitExists = doesRecruitAlreadyExists(person, recruitsArray);
        if (recruitExists) {
            return false;
        }
        recruitsArray[takenPlacesCount++] = person;
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


    public int getFreePlacesFromList() {
        return capacity - recruits.size();
    }

    public int getFreePlacesFromArray() {
        return capacity - takenPlacesCount;
    }

    public void printRecruitsFromArray() {
        for (Person person : recruitsArray) {
            System.out.println(person.getName());
        }
    }

    public void printRecruitsFromList() {
        for (Person person : recruits) {
            System.out.println(person.getName());
        }
    }

    public int getCapacity() {
        return capacity;
    }
}
