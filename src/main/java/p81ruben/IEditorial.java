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
    
    List<Editorial> getAll() throws SQLException;

    Editorial findByPk(int pk) throws SQLException;

    int insertEditorial(Editorial editorial) throws SQLException;

    int insertEditorial(List<Editorial> lista) throws SQLException;

    int deleteEditorial(Editorial e) throws SQLException;

    int deleteEditorial() throws SQLException;

    int updateEditorial(int pk, Editorial nuevosDatos) throws SQLException;
    
}
