/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import p81ruben.Autor;
import p81ruben.Libro;
import p81ruben.LibroDAO;

/**
 *
 * @author ruben
 */
public class MainLibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LibroDAO libroDao = new LibroDAO();
        List<Libro> listaLibro = new ArrayList<>();
        listaLibro.add(new Libro(1, "zfdg", "sagd", 1, 1));
        listaLibro.add(new Libro(2, "asfgagh", "dfh", 2, 1));
        listaLibro.add(new Libro(3, "zfdzdfhnzdg", "dfh", 1, 2));
        listaLibro.add(new Libro(4, "dfhd", "vbnv", 3, 1));
        listaLibro.add(new Libro(5, "hkg", "jklj", 3, 2));

        try {

            System.out.println("Nº Libros insertadas " + libroDao.insertLibro(listaLibro));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<Libro> nuevaLista = libroDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Persona con primary key 1: ");
            System.out.println(libroDao.findByPk(1));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la persona con pk 3");
            System.out.println("Nº personas borradas "
                    + libroDao.deleteLibro(new Libro(1, "zfdg", "sagd", 1, 1)));
            System.out.println("-----------------------------------------");
            nuevaLista = libroDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una persona -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la persona con pk 5");
            System.out.println("Nº Personas modificadas "
                    + libroDao.updateLibro(2, new Libro(4, "dfhd", "vbnv", 4, 3)));
            System.out.println("-----------------------------------------");
            nuevaLista = libroDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una persona -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            nuevaLista = libroDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de ejecutar proced. -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        System.out.println();
        listaLibro.forEach(System.out::println);

    }
}
