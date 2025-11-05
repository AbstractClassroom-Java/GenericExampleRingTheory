package io.github.nathanjrussell.abstractmath.structures;

import io.github.nathanjrussell.abstractmath.ring.IRingElement;

import java.util.ArrayList;
import java.util.List;

public class Polynomial<T extends IRingElement<T>> implements IRingElement<Polynomial<T>> {
    private final int deg;
    private final List<T> coefficients;


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
        if (degree > this.deg) { return this.getCoefficient(0).additiveIdentity(); }
        return this.coefficients.get(degree);
    }

    public Polynomial<T> additiveIdentity() {
        Polynomial<T> result  = new Polynomial<>(0);
        T identity = this.coefficients.getFirst().additiveIdentity();
        result.setCoefficient(0, this.coefficients.getFirst());
        return result;
    }

    private void validateDegree(int degree) {
        if (degree < 0) {
            throw new IllegalArgumentException("Degree must be non-negative.");
        }
    }

    public int getDegree() {
        return deg;
    }

    @Override
    public Polynomial<T> add(Polynomial<T> other) {
        int resultDeg = Math.max(this.deg, other.deg);
        List<T> resultCoeffs = new ArrayList<>(resultDeg + 1);
        for (int i = 0; i <= resultDeg; i++) {
            T thisCoeff = (i <= this.deg) ? this.getCoefficient(i) : this.getCoefficient(0).additiveIdentity();
            T otherCoeff = (i <= other.deg) ? other.getCoefficient(i) : other.getCoefficient(0).additiveIdentity();
            resultCoeffs.add(thisCoeff.add(otherCoeff));
        }


    }


}







