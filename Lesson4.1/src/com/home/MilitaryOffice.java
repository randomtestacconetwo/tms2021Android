package com.home;

import com.home.model.Address;
import com.home.model.Person;

import java.util.LinkedList;
import java.util.List;

import static com.home.model.Person.MALE;

public class MilitaryOffice {
    private final PersonRegistry registry;

    public MilitaryOffice(PersonRegistry registry) {
        this.registry = registry;
    }

    public List<Person> getFitPeople(Address address) {
        List<Person> peopleByAddress = registry.getPeople(address);
        List<Person> fitPeople = new LinkedList<>();
        for (Person person : peopleByAddress) {
            if (isPersonFit(person)) {
                System.out.printf("%s is fit!\n", person.getName()); // this is equal to System.out.println(person.getName() + " is fit!");
                fitPeople.add(person);
            }
        }
        return fitPeople;
    }

    private boolean isPersonFit(Person person) {
        return MALE.equals(person.getSex())
                && person.getAge() > 17
                && person.getAge() < 28;
    }
}
