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

    List<Autor> getAll() throws SQLException;

    Autor findByPk(int pk) throws SQLException;

    int insertAutor(Autor persona) throws SQLException;

    int insertAutor(List<Autor> lista) throws SQLException;

    int deleteAutor(Autor a) throws SQLException;

    int deleteAutor() throws SQLException;

    int updateAutor(int pk, Autor nuevosDatos) throws SQLException;

}
