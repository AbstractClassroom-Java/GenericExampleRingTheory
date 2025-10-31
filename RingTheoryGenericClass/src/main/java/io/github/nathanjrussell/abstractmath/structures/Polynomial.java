package io.github.nathanjrussell.abstractmath.structures;

import io.github.nathanjrussell.abstractmath.ring.IRingElement;

public class Polynomial<T extends IRingElement<T>> implements IRingElement<Polynomial<T>> {
    int deg;

}
