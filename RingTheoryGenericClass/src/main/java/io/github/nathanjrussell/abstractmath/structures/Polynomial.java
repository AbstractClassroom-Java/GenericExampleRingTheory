package io.github.nathanjrussell.abstractmath.structures;

import io.github.nathanjrussell.abstractmath.ring.IRingElement;

import java.util.ArrayList;
import java.util.List;

public class Polynomial<T extends IRingElement<T>> implements IRingElement<Polynomial<T>> {
    private final int deg;
    private final List<T> coefficients;


    public Polynomial(int deg) {
        this.deg = deg;
        validateDegree(deg);

        this.coefficients = new ArrayList<>();
        for (int i = 0; i <= deg; i++) {
            this.coefficients.add(null);
        }
    }

    public void setCoefficient(int degree, T coefficient) {
        validateDegree(degree);
        this.coefficients.set(degree, coefficient);
    }

    public T getCoefficient(int degree) {
        validateDegree(degree);
        if (degree > this.deg) { return this.coefficients.getFirst().additiveIdentity(); }
        return this.coefficients.get(degree);
    }

    public Polynomial<T> additiveIdentity() {
        Polynomial<T> result  = new Polynomial<>(0);
        T identity = this.coefficients.getFirst().additiveIdentity();
        result.setCoefficient(0, identity);
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
            resultCoeffs.add(this.getCoefficient(i).add(other.getCoefficient(i)));
        }
        while (resultDeg > 0 && resultCoeffs.get(resultDeg).equals(this.coefficients.getFirst().additiveIdentity())) {
            resultDeg--;
        }
        Polynomial<T> result = new Polynomial<>(resultDeg);
        for (int i = 0; i <= resultDeg; i++) {
            result.setCoefficient(i, resultCoeffs.get(i));
        }
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = deg; i >= 0; i--) {
            T coeff = getCoefficient(i);
            if (!coeff.equals(coeff.additiveIdentity())) {
                if (sb.length() > 0) {
                    sb.append(" + ");
                }
                sb.append("(").append(coeff.toString()).append(")");
                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }
        return sb.toString();
    }


}







