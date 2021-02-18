/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.model;

/**
 * Un punto que puede hacer parte de un plano.
 * @author hcadavid
 */
public class Point {

    private int x;
    private int y;

    /**
     * Constructor de un punto.
     *
     * @param x Coordenada x
     * @param y Coordenada y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor por defecto.
     */
    public Point() {
    }

    /**
     * Retorna la coordenada en x del punto.
     *
     * @return La coordenada en x.
     */
    public int getX() {
        return x;
    }

    /**
     * Método setter para la coordenada en x del punto.
     *
     * @param x Coordenada en x del punto.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retorna la coordenada en y del punto.
     *
     * @return La coordenada en y.
     */
    public int getY() {
        return y;
    }

    /**
     * Método setter para la coordenada en y del punto.
     *
     * @param y Coordenada en y del punto.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Compara las coordenadas de dos puntos para evaluar si son iguales.
     * @param pp Punto con el que se desea comprar.
     * @return true si los puntos son iguales.
     */
    public boolean compare(Point pp){
        if(this.x == pp.getX() && this.y == pp.getY()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Punto: (" + "x = " + x + ", y = " + y + ')';
    }
}
