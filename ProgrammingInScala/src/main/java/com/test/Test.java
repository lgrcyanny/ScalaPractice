package com.test;

/**
 * Created by lgrcyanny on 16/1/27.
 */

public class Test {
    private String a = "hello";
    public void go() {
        final int b = 0;
        class Inner {
            public String printName() {
                System.out.println("Hi this " + this.getClass().getName());
                return this.getClass().getName();
            }
        }
        Inner s = new Inner();
        s.printName();
    }

    public static void main(String[] args) {
        new Test().go();
    }

}
