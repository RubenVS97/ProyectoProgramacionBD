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
public interface IEditorial {
    
    List<EditorialDAO> getAll() throws SQLException;

    EditorialDAO findByPk(int pk) throws SQLException;

    int insertEditorial(EditorialDAO editorial) throws SQLException;

    int insertEditorial(List<EditorialDAO> lista) throws SQLException;

    int deleteEditorial(EditorialDAO e) throws SQLException;

    int deleteEditorial() throws SQLException;

    int updateEditorial(int pk, EditorialDAO nuevosDatos) throws SQLException;
    
}
