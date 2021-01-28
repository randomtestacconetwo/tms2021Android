package com.home.model;

import java.util.Random;

public class Person {
    private Address address;
    private int age;
    private String name;
    private int height;

    public Person() {
    }

    public Person(int age, String name, int height) {
        this(age, name);
        this.height = height;
    }

    public Person(int age, String name) {
        this();
        this.height = 180;
        this.age = age;
        this.name = name;
    }

    public void info() {
        Random random = new Random();
        if (random.nextInt(40) < 20) {
            System.out.println("Hello, my name is " + name);
        } else {
            secureInfo();
        }
        System.out.println("I am living in " + address.toString());
    }

    private void secureInfo() {
        System.out.println("Hello, my name is " + name + " and I'm " + age + " years old");
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = Math.max(age, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
