package io.github.nathanjrussell.abstractmath.structures;

import io.github.nathanjrussell.abstractmath.ring.IRingElement;

import java.util.ArrayList;
import java.util.List;

public class Polynomial<T extends IRingElement<T>> implements IRingElement<Polynomial<T>> {
    int deg;
    List<T> coefficients;


    Polynomial(int deg) {
        this.deg = deg;
        validateDegree(deg);

        this.coefficients = new ArrayList<>(deg + 1);
    }

    public void setCoefficient(int degree, T coefficient) {
        validateDegree(degree);
        this.coefficients.set(degree, coefficient);
    }

    public T getCoefficient(int degree) {
        validateDegree(degree);
        return this.coefficients.get(degree);
    }

    private void validateDegree(int degree) {
        if (degree < 0) {
            throw new IllegalArgumentException("Degree must be non-negative.");
        }
        if (degree > this.deg) {
            throw new IllegalArgumentException("Degree exceeds polynomial degree.");

        }
    }

}







