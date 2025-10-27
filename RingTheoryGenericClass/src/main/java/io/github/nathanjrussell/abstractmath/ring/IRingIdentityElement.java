package io.github.nathanjrussell.abstractmath.ring;

public interface IRingIdentityElement<T extends IRingIdentityElement<T>> extends IRingElement<T> {
    T multiplicativeIdentity();
}