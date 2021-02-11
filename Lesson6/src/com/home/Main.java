package com.home;

import com.home.model.*;

import java.util.ArrayList;
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

        MilitaryOffice office = new MilitaryOffice(registry,
                new MilitaryUnit[]{new ArrayMilitaryUnit(1), new ListMilitaryUnit(0)});
        System.out.println(office.getCapacity());
        office.addFitPeopleToTheUnits(new Address("Belarus", "Vitebsk"));
        System.out.println(office.getCapacity());

        try {
            System.out.println(123);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        Speaker s = new Recruit();
        System.out.println(s instanceof Recruit);//true
        Recruit r = (Recruit) s;


//        throwsException();

        try {
            System.out.println("before exception");
            throwsException();
            System.out.println("after exception");
        } catch (RuntimeException e) {
            System.out.println("IO");
//            e.printStackTrace();
        } finally {
            System.out.println("Finally");
        }
    }

    static void throwsException() throws RuntimeException {
        throw new RuntimeException();
    }

    static int method() {
        int a = 1;
        try {
            System.out.println(a);
            return a;
        } finally {
            a = 2;
            System.out.println(a);
        }
    }

}
