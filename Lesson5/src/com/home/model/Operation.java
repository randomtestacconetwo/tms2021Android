package com.home.model;

public enum Operation {
    SUM {
        @Override
        int operate(int a, int b) {
            return a + b;
        }
    }, MULTIPLY {
        @Override
        int operate(int a, int b) {
            return a * b;
        }
    };

    abstract int operate(int a, int b);
}
