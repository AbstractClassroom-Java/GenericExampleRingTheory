package io.github.nathanjrussell;

import io.github.nathanjrussell.abstractmath.ring.ZModNZRing;
import io.github.nathanjrussell.abstractmath.ring.ZModNZRingElement;
import io.github.nathanjrussell.abstractmath.structures.Polynomial;

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

        Polynomial<ZModNZRingElement> poly1 = new Polynomial<>(2);
        poly1.setCoefficient(0, zMod5Ring.getElement(3));
        poly1.setCoefficient(1, zMod5Ring.getElement(0));
        poly1.setCoefficient(2, zMod5Ring.getElement(4));

        Polynomial<ZModNZRingElement> poly2 = new Polynomial<>(4);
        poly2.setCoefficient(0, zMod5Ring.getElement(2));
        poly2.setCoefficient(1, zMod5Ring.getElement(3));
        poly2.setCoefficient(2, zMod5Ring.getElement(4));
        poly2.setCoefficient(3, zMod5Ring.getElement(3));
        poly2.setCoefficient(4, zMod5Ring.getElement(1));
        Polynomial<ZModNZRingElement> polySum = poly1.add(poly2);
        System.out.println("\nPolynomial 1: " + poly1);
        System.out.println("Polynomial 2: " + poly2);
        System.out.println("Polynomial 1 + Polynomial 2: " + polySum);
Polynomial<Polynomial<ZModNZRingElement>> polyOfPoly = new Polynomial<>(1);
        polyOfPoly.setCoefficient(0, poly1);
        polyOfPoly.setCoefficient(1, poly2);
        System.out.println("\nPolynomial of Polynomials: " + polyOfPoly);
    }
}