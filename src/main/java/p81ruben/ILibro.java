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
    
    List<LibroDAO> getAll() throws SQLException;

    LibroDAO findByPk(int pk) throws SQLException;

    int insertLibro(LibroDAO libro) throws SQLException;

    int insertLibro(List<LibroDAO> lista) throws SQLException;

    int deleteLibro(LibroDAO l) throws SQLException;

    int deleteLibro() throws SQLException;

    int updateLibro(int pk, LibroDAO nuevosDatos) throws SQLException;
    
}
