/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package p81ruben;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ruben
 */
public interface ILibro {
    
    List<Libro> getAll() throws SQLException;

    Libro findByPk(int pk) throws SQLException;

    int insertLibro(Libro libro) throws SQLException;

    int insertLibro(List<Libro> lista) throws SQLException;

    int deleteLibro(Libro l) throws SQLException;

    int deleteLibro() throws SQLException;

    int updateLibro(int pk, Libro nuevosDatos) throws SQLException;
    
}
