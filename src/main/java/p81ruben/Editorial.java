/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p81ruben;

/**
 *
 * @author ruben
 */
public class Editorial {

    private int numEditorial;
    private String nombre;
    private int numTotalLibros;

    public Editorial() {
    }

    public Editorial(int numEditorial, String nombre, int numTotalLibros) {
        this.numEditorial = numEditorial;
        this.nombre = nombre;
        this.numTotalLibros = numTotalLibros;
    }

    public int getNumEditorial() {
        return numEditorial;
    }

    public void setNumEditorial(int numEditorial) {
        this.numEditorial = numEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumTotalLibros() {
        return numTotalLibros;
    }

    public void setNumTotalLibros(int numTotalLibros) {
        this.numTotalLibros = numTotalLibros;
    }

    @Override
    public String toString() {
        return "Editorial{" + "numEditorial=" + numEditorial + ", nombre=" + nombre + ", numTotalLibros=" + numTotalLibros + '}';
    }

}
