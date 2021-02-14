package com.home.model;

public class Recruit extends Person {
    private String title;

    public Recruit() {
    }

    public Recruit(Address address, int age, String name, String sex, String title) {
        super(address, age, name, sex);
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
