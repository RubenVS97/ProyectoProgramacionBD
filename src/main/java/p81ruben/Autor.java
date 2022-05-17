/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p81ruben;

/**
 *
 * @author ruben
 */
public class Autor {
    
    private int numAutor;
    private String nombre;
    private String ape1;
    private String ape2;
    private int numLibros;

    public int getNumAutor() {
        return numAutor;
    }

    public void setNumAutor(int numAutor) {
        this.numAutor = numAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    @Override
    public String toString() {
        return "Autor{" + "numAutor=" + numAutor + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", numLibros=" + numLibros + '}';
    }
    
    
    
}
