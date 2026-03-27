package oop.labor06.labor_gyak.lab6_2;

import java.util.Random;

public class Matrix {
    private double[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    public Matrix(Matrix m){
//        m.data = data;
//        m.rows = rows;
//        m.columns = columns;

        this.rows = m.rows;
        this.columns = m.columns;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(m.data[i], 0, this.data[i], 0, columns);
        }
    }

    public void fillRandom(double min, double max){
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = min + (max - min) * rand.nextDouble();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%.2f ", data[i][j]);
            }
            System.out.println();
        }
    }

    public static Matrix add(Matrix a, Matrix b) {
        if (a.rows != b.rows || a.columns != b.columns) {
            throw new IllegalArgumentException("A méreteknek meg kell egyezniük!");
        }
        Matrix result = new Matrix(a.rows, a.columns);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.columns; j++) {
                result.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.columns != b.rows) {
            throw new IllegalArgumentException("Az első mátrix oszlopainak száma meg kell egyezzen a második sorainak számával!");
        }
        Matrix result = new Matrix(a.rows, b.columns);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.columns; j++) {
                for (int k = 0; k < a.columns; k++) {
                    result.data[i][j] += a.data[i][k] * b.data[k][j];
                }
            }
        }
        return result;
    }

    public static Matrix transpose(Matrix m) {
        Matrix result = new Matrix(m.columns, m.rows);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                result.data[j][i] = m.data[i][j];
            }
        }
        return result;
    }
}
