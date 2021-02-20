package com.home;

import com.home.exceptions.InvalidNameSurnameException;
import com.home.model.*;

public class Main {
    public static void main(String[] args) throws InvalidNameSurnameException {
        Address konstantinsAddress = new Address("Belarus", "Vitebsk");
        Person konstantin = new Person(konstantinsAddress, 20, "Konstantin", "Konstantinovich", Person.MALE);

        Address glebsAddress = new Address("Belarus", "Vitebsk");
        Person gleb = new Person(glebsAddress, 25, "gleb", "GLEBOVICH", Person.MALE);

        Address olegsAddress = new Address("Belarus", "Braslav");
        Person oleg = new Person(olegsAddress, 38, "Oleg", "Olegovich\t", Person.MALE);

        Address vadimsAddress = new Address("Belarus", "Vitebsk");
        Person vadim = new Person(vadimsAddress, 26, "\tVadim", "Vadimovich", Person.MALE);

        Address olgasAddress = new Address("Belarus", "Vitebsk");
        Person olga = new Person(olgasAddress, 20, "Olga", "Olgaovich", Person.FEMALE);

        PersonRegistry registry = new PersonRegistry(new Person[]{gleb, konstantin, oleg, vadim, olga});

        MilitaryOffice office = new MilitaryOffice(registry,
                new MilitaryUnit[]{new ArrayMilitaryUnit(2), new ListMilitaryUnit(2)});
        System.out.println(office.getCapacity());
        office.addFitPeopleToTheUnits(new Address("Belarus", "Vitebsk"));
        office.printRecruits();

    }

}
