package io.github.nathanjrussell;

import io.github.nathanjrussell.abstractmath.ring.ZModNZRing;
import io.github.nathanjrussell.abstractmath.ring.ZModNZRingElement;
import io.github.nathanjrussell.abstractmath.structures.Matrix;

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

//        System.out.println("\nAddition Operation Table for Z/5Z:");
//        zMod5Ring.printAdditionOpTable();
//        System.out.println("\nMultiplication Operation Table for Z/5Z:");
//        zMod5Ring.printMultiplicationOpTable();
        Matrix<ZModNZRingElement> matrixA = new Matrix<>(2, 2);
        matrixA.setEntry(0,0, zMod5Ring.getElement(1));
        matrixA.setEntry(0,1, zMod5Ring.getElement(2));
        matrixA.setEntry(1,0, zMod5Ring.getElement(3));
        matrixA.setEntry(1,1, zMod5Ring.getElement(4));
        Matrix<ZModNZRingElement> matrixB = new Matrix<>(2, 2);
        matrixB.setEntry(0,0, zMod5Ring.getElement(4));
        matrixB.setEntry(0,1, zMod5Ring.getElement(3));
        matrixB.setEntry(1,0, zMod5Ring.getElement(2));
        matrixB.setEntry(1,1, zMod5Ring.getElement(1));
        Matrix<ZModNZRingElement> matrixC = matrixA.add(matrixB);
        System.out.println("\nMatrix A + Matrix B:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrixC.getEntry(i, j) + " ");
            }
            System.out.println();
        }
    }
}