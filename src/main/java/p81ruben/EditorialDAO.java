/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p81ruben;

import java.sql.Connection;

/**
 *
 * @author ruben
 */
public class EditorialDAO implements IEditorial{
    
    private Connection con = null;

    public EditorialDAO() {
        con = Conexion.getInstance();
    }
    
}
