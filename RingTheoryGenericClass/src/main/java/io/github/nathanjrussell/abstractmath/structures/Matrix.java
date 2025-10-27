package io.github.nathanjrussell.abstractmath.structures;

import io.github.nathanjrussell.abstractmath.ring.IRingElement;

import java.util.List;

public class Matrix<T extends IRingElement<T>> implements IRingElement<Matrix<T>> {
    private final List<List<T>> entries;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        // allocate space for entries
        this.entries = new java.util.ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            List<T> row = new java.util.ArrayList<>(cols);
            for (int j = 0; j < cols; j++) {
                row.add(null); // initialize with nulls
            }
            this.entries.add(row);
        }
    }

    public void setEntry(int row, int col, T value) {
        entries.get(row).set(col, value);
    }

    public T getEntry(int row, int col) {
        return entries.get(row).get(col);
    }

    @Override
    public Matrix<T> add(Matrix<T> other) {
        if (this.rows != other.rows) {
            throw new IllegalArgumentException("Matrices must have the same number of rows to add.");
        }
        if (this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same number of columns to add.");
        }
        Matrix<T> result = new Matrix<>(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                T sum = this.getEntry(i, j).add(other.getEntry(i, j));
                result.setEntry(i, j, sum);
            }
        }
        return result;
    }
}
