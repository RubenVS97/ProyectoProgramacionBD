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
public interface IAutor {

    List<AutorDAO> getAll() throws SQLException;

    AutorDAO findByPk(int pk) throws SQLException;

    int insertAutor(AutorDAO persona) throws SQLException;

    int insertAutor(List<AutorDAO> lista) throws SQLException;

    int deleteAutor(AutorDAO a) throws SQLException;

    int deleteAutor() throws SQLException;

    int updateAutor(int pk, AutorDAO nuevosDatos) throws SQLException;

}
