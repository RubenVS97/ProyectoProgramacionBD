/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import p81ruben.Autor;
import p81ruben.AutorDAO;

/**
 *
 * @author ruben
 */
public class MainAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AutorDAO autorDao = new AutorDAO();
        List<Autor> listaAutor = new ArrayList<>();
        listaAutor.add(new Autor(1, "Autor1", "ad", "asf", 2));
        listaAutor.add(new Autor(2, "Autor2", "", "", 1));
        listaAutor.add(new Autor(3, "Autor3", "", "", 3));
        listaAutor.add(new Autor(4, "Autor4", "", "", 0));
        listaAutor.add(new Autor(5, "Autor5", "", "", 5));

        try {

            System.out.println("Nº Autor insertadas " + autorDao.insertAutor(listaAutor));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<Autor> nuevaLista = autorDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Persona con primary key 1: ");
            System.out.println(autorDao.findByPk(1));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la persona con pk 3");
            System.out.println("Nº personas borradas "
                    + autorDao.deleteAutor(new Autor(3, "Autor3", "", "", 3)));
            System.out.println("-----------------------------------------");
            nuevaLista = autorDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una persona -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la persona con pk 5");
            System.out.println("Nº Personas modificadas "
                    + autorDao.updateAutor(5, new Autor(7, "NuevoNombre", "", "", 2)));
            System.out.println("-----------------------------------------");
            nuevaLista = autorDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una persona -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Ejecución del procedimiento almacenado");
            System.out.println("Se cambia María Weston por Felipe Román");
            System.out.println("Nombres cambiados " + autorDao.cambiarNombres("Autor1", "Maria Weston"));
            System.out.println("-----------------------------------------");
            nuevaLista = autorDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de ejecutar proced. -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        System.out.println();
        listaAutor.forEach(System.out::println);

    }
}

