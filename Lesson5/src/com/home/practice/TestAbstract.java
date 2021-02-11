package com.home.practice;

import com.home.model.Speaker;

public abstract class TestAbstract implements Speaker {

    public TestAbstract() {
        System.out.println("Parent");
    }

    public void realMethod() {
        System.out.println("real logic");
    }

    abstract void abstractMethod();
}
