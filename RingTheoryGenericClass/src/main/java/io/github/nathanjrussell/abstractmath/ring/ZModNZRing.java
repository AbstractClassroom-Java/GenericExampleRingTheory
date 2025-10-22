package io.github.nathanjrussell.abstractmath.ring;

import io.github.nathanjrussell.abstractmath.utility;

/**
 * Represents the ring of integers modulo n (Z/nZ).
 */
public class ZModNZRing {
    int modulus;
    ZModNZRingElement[] elements;


    public ZModNZRing(int modulus) {
        if (modulus <= 0) {
            throw new IllegalArgumentException("Modulus must be a positive integer.");
        }
        this.modulus = modulus;
        this.elements = new ZModNZRingElement[modulus];
        for (int i = 0; i < modulus; i++) {
            elements[i] = new ZModNZRingElement(i, modulus);
        }
    }

    public int getModulus() {
        return modulus;
    }

    public ZModNZRingElement[] getElements() {
        return elements;
    }

    public ZModNZRingElement getElement(int value) {
        if (value < 0 || value >= modulus) {
            throw new IllegalArgumentException("Value must be in the range [0, modulus).");
        }
        return elements[value];
    }

    /**
     * Prints the addition operation table for the Ring in tabular format.
     */
    public void printAdditionOpTable() {
        ZModNZRingElement [] headers = getElements();
        ZModNZRingElement [][] body = new ZModNZRingElement[modulus][modulus];
        for (int i = 0; i < modulus; i++) {
            for (int j = 0; j < modulus; j++) {
                body[i][j] = headers[i].add(headers[j]);
            }
        }
        utility.printOpTable(java.util.Arrays.asList(headers), body);
    }

    public void printMultiplicationOpTable() {
        ZModNZRingElement [] headers = getElements();
        ZModNZRingElement [][] body = new ZModNZRingElement[modulus][modulus];
        for (int i = 0; i < modulus; i++) {
            for (int j = 0; j < modulus; j++) {
                body[i][j] = headers[i].multiply(headers[j]);
            }
        }
        utility.printOpTable(java.util.Arrays.asList(headers), body);
    }



}
