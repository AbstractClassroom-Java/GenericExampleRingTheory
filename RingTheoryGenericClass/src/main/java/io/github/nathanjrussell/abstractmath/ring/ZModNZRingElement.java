package io.github.nathanjrussell.abstractmath.ring;

/**
 * Represents an element of the ring of integers modulo n (Z/nZ).
 */
public class ZModNZRingElement implements IRingElement<ZModNZRingElement> {
    private final int value;
    private final int modulus;

    public ZModNZRingElement(int value, int modulus) {
        if (modulus <= 0) {
            throw new IllegalArgumentException("Modulus must be a positive integer.");
        }
        if (value < 0 || value >= modulus) {
            throw new IllegalArgumentException("Value must be in the range [0, modulus).");
        }
        this.value = value;
        this.modulus = modulus;
    }

    public ZModNZRingElement add(ZModNZRingElement other) {
        if (this.modulus != other.modulus) {
            throw new IllegalArgumentException("Cannot add elements with different moduli.");
        }
        return new ZModNZRingElement((this.value + other.value) % this.modulus, this.modulus);
    }

    public ZModNZRingElement multiply(ZModNZRingElement other) {
        if (this.modulus != other.modulus) {
            throw new IllegalArgumentException("Cannot multiply elements with different moduli.");
        }
        return new ZModNZRingElement((this.value * other.value) % this.modulus, this.modulus);
    }

    public ZModNZRingElement negate() {
        return new ZModNZRingElement((modulus - value) % modulus, modulus);
    }

    public ZModNZRingElement additiveIdentity() {
        return new ZModNZRingElement(0, modulus);
    }

    public ZModNZRingElement multiplicativeIdentity() {
        return new ZModNZRingElement(1, modulus);
    }

    public int getValue() {
        return value;
    }

    public int getModulus() {
        return modulus;
    }

    @Override
    public String toString() {
        return String.format("%d (mod %d)", value, modulus);
    }
}
