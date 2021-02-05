package com.home;

import com.home.model.Address;
import com.home.model.Person;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Address konstantinsAddress = new Address("Belarus", "Vitebsk");
        Person konstantin = new Person(konstantinsAddress, 20, "Konstantin", Person.MALE);

        Address glebsAddress = new Address("Belarus", "Vitebsk");
        Person gleb = new Person(glebsAddress, 25, "Gleb", Person.MALE);

        Address olegsAddress = new Address("Belarus", "Braslav");
        Person oleg = new Person(olegsAddress, 38, "Oleg", Person.MALE);

        Address vadimsAddress = new Address("Belarus", "Smorgon'");
        Person vadim = new Person(vadimsAddress, 27, "Vadim", Person.MALE);

        Address olgasAddress = new Address("Belarus", "Vitebsk'");
        Person olga = new Person(olgasAddress, 20, "Olga", Person.FEMALE);

        PersonRegistry registry = new PersonRegistry(new Person[]{gleb, konstantin, oleg, vadim, olga});

        System.out.println(registry.countPeople(new Address("Belarus", "Vitebsk")));
        System.out.println(registry.countPeople(new Address("Belarus", "Krarow")));
        System.out.println(registry.countPeople("Belarus"));

        MilitaryOffice office = new MilitaryOffice(registry);
        List<Person> fitPeople = office.getFitPeople(new Address("Belarus", "Vitebsk")); }

}
