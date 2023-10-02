package com.java8features;

/**
 *  Functional interfaces are a new concept introduced in Java 8.
 *  An interface with exactly one abstract method becomes a Functional Interface.
 *  We don’t need to use @FunctionalInterface annotation to mark an interface as a Functional Interface.
 *
 * @FunctionalInterface annotation is a facility to avoid the accidental addition
 * of abstract methods in the functional interfaces.
 */
@java.lang.FunctionalInterface
public interface FunctionalInterface {
    void method1(String str);

    default void log(String str){
        System.out.println("I1 logging::"+str);
    }

    static void print(String str){
        System.out.println("Printing "+str);
    }
}
