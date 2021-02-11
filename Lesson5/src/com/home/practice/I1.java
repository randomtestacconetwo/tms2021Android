package com.home.practice;

public interface I1 {
    void method();

    static void shout() {
        System.out.println("SHOUT");
    }

    default String defaultMessage() {
        return getMessage();
    }

    private String getMessage() {
        return "Default message";
    }
}
