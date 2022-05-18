/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import p81ruben.Editorial;
import p81ruben.EditorialDAO;

/**
 *
 * @author ruben
 */
public class MainEditorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EditorialDAO editorialDao = new EditorialDAO();
        List<Editorial> listaEditorial = new ArrayList<>();
        listaEditorial.add(new Editorial(1, "Editorial1", 4));
        listaEditorial.add(new Editorial(2, "Editorial2", 2));
        listaEditorial.add(new Editorial(3, "Editorial3", 0));
        listaEditorial.add(new Editorial(4, "Editorial4", 5));
        listaEditorial.add(new Editorial(5, "Editorial5", 10));

        try {

            System.out.println("Nº editoriales insertadas " + editorialDao.insertEditorial(listaEditorial));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<Editorial> nuevaLista = editorialDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Persona con primary key 1: ");
            System.out.println(editorialDao.findByPk(1));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la persona con pk 3");
            System.out.println("Nº personas borradas "
                    + editorialDao.deleteEditorial(new Editorial(4, "Editorial4", 5)));
            System.out.println("-----------------------------------------");
            nuevaLista = editorialDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una persona -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la persona con pk 5");
            System.out.println("Nº Personas modificadas "
                    + editorialDao.updateEditorial(1, new Editorial(7, "Planeta", 7)));
            System.out.println("-----------------------------------------");
            nuevaLista = editorialDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una persona -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            nuevaLista = editorialDao.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de ejecutar proced. -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        System.out.println();
        listaEditorial.forEach(System.out::println);

    }
}
