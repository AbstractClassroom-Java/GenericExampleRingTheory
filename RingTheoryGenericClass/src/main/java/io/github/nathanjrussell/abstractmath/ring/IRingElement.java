package io.github.nathanjrussell.abstractmath.ring;

public interface IRingElement<T extends IRingElement<T>> {
    T add(T other);
    T multiply(T other);
    T negate();
    T additiveIdentity();
}
