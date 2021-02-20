package com.home.model;

import com.home.exceptions.InvalidNameSurnameException;

public class Recruit extends Person {
    private String title;

    public Recruit(Address address, int age, String name, String surname, String sex, String title) throws InvalidNameSurnameException {
        super(address, age, name, surname, sex);
        this.title = title;
    }

    @Override
    public final void speak() {
        System.out.println("Здравия желаю");
    }

    public String getTitle() {
        return title;
    }

    public static void personTest() {
        System.out.println("I am Recruit");
    }
}
