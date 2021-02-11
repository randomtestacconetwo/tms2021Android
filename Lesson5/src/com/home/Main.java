package com.home;

import com.home.model.*;
import com.home.practice.*;
import jdk.jfr.Event;

import static com.home.model.DayOfWeekEnum.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address konstantinsAddress = new Address("Belarus", "Vitebsk");
        Person konstantin = new Person(konstantinsAddress, 20, "Konstantin", Person.MALE);
        Person konstantinClone = (Person) konstantin.clone();

        konstantinClone.setAge(21);
        konstantinClone.getAddress().setCity("Minsk");
        System.out.println(konstantin.getAge());
        System.out.println(konstantinClone.getAge());
        System.out.println(konstantin.getAddress().getCity());
        System.out.println(konstantinClone.getAddress().getCity());
//
//        Address glebsAddress = new Address("Belarus", "Vitebsk");
//        Person gleb = new Person(glebsAddress, 25, "Gleb", Person.MALE);
//
//        Address olegsAddress = new Address("Belarus", "Braslav");
//        Person oleg = new Person(olegsAddress, 38, "Oleg", Person.MALE);
//
//        Address vadimsAddress = new Address("Belarus", "Smorgon'");
//        Person vadim = new Person(vadimsAddress, 27, "Vadim", Person.MALE);
//
//        Address olgasAddress = new Address("Belarus", "Vitebsk'");
//        Person olga = new Person(olgasAddress, 20, "Olga", Person.FEMALE);
//
//        MilitaryUnit unit = new ArrayMilitaryUnit(10);
//        Speaker speaker = new Person();
//        speaker = new Recruit();
//        Recruit recruit = new Recruit(new Address("Brl", "Vtb"), 25, "Gleb", Person.MALE, "private");
//
//        PersonRegistry registry = new PersonRegistry(new Person[]{vadim, recruit});
//        Recruit.personTest();
//        Person.personTest();
//
//        Person p = new Recruit();
//        p.personTest();
        Speaker speaker1 = new Speaker() {
            @Override
            public void speak() {
                System.out.println("Custom speak");
            }
        };
        Person person = new Person() {
            @Override
            public void speak() {
                System.out.println("Super speak");
            }
        };
        MilitaryUnit unit = new MilitaryUnit(2) {
            @Override
            public int getFreePlaces() {
                return 0;
            }

            @Override
            protected Person[] getRecruits() {
                return new Person[0];
            }

            @Override
            protected void addRecruitToRecruits(Person person) {

            }
        };
//        Person regular = new Person();
////        speaker1.speak();
//        regular.speak();
//        person.speak();
//
//        SuperHandler handler = new SuperHandler();
//        Button button = new Button();
//        button.handleClick(handler);
//        button.handleFocus(handler);

//        ((TestImpl2)testAbstract).customCalculation();
        printAllDays();
        CommonHandler handler = new CommonHandler() {
            @Override
            public void handleEvent(Event event) {

            }

            @Override
            public void handle(Event event) {

            }

            @Override
            public void handleFocus() {

            }
        };
        System.out.println(konstantinsAddress.toString());
        System.out.println(konstantinsAddress);

    }

    public static void printAllDays() {

        for (DayOfWeekEnum dayOfWeekEnum : DayOfWeekEnum.values()) {
            System.out.println(dayOfWeekEnum.getLocalization());
        }
    }

    public static String localizedFromString(String s) {
        for (DayOfWeekEnum dayOfWeekEnum : DayOfWeekEnum.values()) {
            if (dayOfWeekEnum.name().equalsIgnoreCase(s)) {
                return dayOfWeekEnum.getLocalization();
            }
        }
        return MONDAY.getLocalization();
    }

    public static void test(TestAbstract testAbstract) {
        System.out.println("info");
        if (testAbstract instanceof TestImpl2) {
            System.out.println("additional");
        }
        if (testAbstract.getClass().equals(TestImpl.class)) {
            System.out.println("additional");
        }
    }

    static class Button {

        void handleFocus(FocusHandler handler) {

        }

        void handleClick(ClickHandler handler) {

        }
    }


}
