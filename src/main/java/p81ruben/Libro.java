/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p81ruben;

/**
 *
 * @author ruben
 */
public class Libro {
    
    private int isbn;
    private String titulo;
    private String genero;
    private int numEditorial;
    private int numAutor;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumEditorial() {
        return numEditorial;
    }

    public void setNumEditorial(int numEditorial) {
        this.numEditorial = numEditorial;
    }

    public int getNumAutor() {
        return numAutor;
    }

    public void setNumAutor(int numAutor) {
        this.numAutor = numAutor;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", genero=" + genero + ", numEditorial=" + numEditorial + ", numAutor=" + numAutor + '}';
    }
    
    
    
}
