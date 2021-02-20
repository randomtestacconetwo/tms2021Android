package com.home.model;

import com.home.exceptions.CantSpeakException;
import com.home.exceptions.InvalidNameSurnameException;

import java.util.Random;

public class Person implements Speaker, Cloneable {
    public static final String MALE = "male";
    public static final String FEMALE = "female";

    private Address address;
    private int age;
    private final String name;
    private final String surname;
    //enum is definitely the better option here
    private String sex = FEMALE;

    public Person(Address address, int age, String name, String surname, String sex) throws InvalidNameSurnameException {
        this.address = address;
        this.age = age;
        this.name = beautifyNameSurname(name);
        this.surname = beautifyNameSurname(surname);
        validateNameSurname(name);
        validateNameSurname(surname);
        if (MALE.equals(sex) || FEMALE.equals(sex)) {
            this.sex = sex;
        }
    }

    public void speak() throws CantSpeakException {
        Random random = new Random();
        if (random.nextInt(40) < 20) {
            System.out.println("Hello, my name is " + name);
        } else {
            secureInfo();
        }
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

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        clone.address = address.clone();
        return clone;
    }

    private String beautifyNameSurname(String name) {
        name = name.trim().toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private void validateNameSurname(String name) throws InvalidNameSurnameException {
        if (name.contains(" ")) {
            throw new InvalidNameSurnameException();
        }
    }
}
