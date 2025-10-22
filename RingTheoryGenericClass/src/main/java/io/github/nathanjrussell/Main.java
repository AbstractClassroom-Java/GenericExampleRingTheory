package io.github.nathanjrussell;

import io.github.nathanjrussell.abstractmath.ring.ZModNZRing;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ZModNZRing zMod5Ring = new ZModNZRing(5);
        //print elements of Z/5Z
        System.out.println("Elements of Z/5Z:");
        for (var element : zMod5Ring.getElements()) {
            System.out.println(element);
        }

//        // Addition Operation Table for Z/5Z
//        System.out.println("\nAddition Table for Z/5Z:");
//        for (var a : zMod5Ring.getElements()) {
//            for (var b : zMod5Ring.getElements()) {
//                var result = a.add(b);
//                System.out.printf("%s + %s = %s%n", a, b, result);
//            }
//        }
//
//        // Multiplication Operation Table for Z/5Z
//        System.out.println("\nMultiplication Table for Z/5Z:");
//        for (var a : zMod5Ring.getElements()) {
//            for (var b : zMod5Ring.getElements()) {
//                var result = a.multiply(b);
//                System.out.printf("%s * %s = %s%n", a, b, result);
//            }
//        }

        System.out.println("\nAddition Operation Table for Z/5Z:");
        zMod5Ring.printAdditionOpTable();
        System.out.println("\nMultiplication Operation Table for Z/5Z:");
        zMod5Ring.printMultiplicationOpTable();
    }
}