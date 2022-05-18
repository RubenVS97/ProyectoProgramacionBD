/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p81ruben;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruben
 */
public class LibroDAO implements ILibro{
 
    private Connection con = null;

    public LibroDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<Libro> getAll() throws SQLException {
        List<Libro> lista = new ArrayList<>();

        try ( Statement st = con.createStatement()) {

            ResultSet res = st.executeQuery("select * from Libro");

            while (res.next()) {
                Libro l = new Libro();

                l.setIsbn(res.getInt("isbn"));
                l.setTitulo(res.getString("titulo"));
                l.setGenero(res.getString("genero"));
                l.setNumEditorial(res.getInt("numEditorial"));
                l.setNumAutor(res.getInt("numAutor"));

                lista.add(l);
            }
        }

        return lista;
    }

    @Override
    public Libro findByPk(int pk) throws SQLException {
        ResultSet res = null;
        Libro l = new Libro();

        String sql = "select * from Libro where isbn=?";

        try ( PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, pk);

            res = prest.executeQuery();

            if (res.next()) {

                l.setIsbn(res.getInt("isbn"));
                l.setTitulo(res.getString("titulo"));
                l.setGenero("genero");
                l.setNumEditorial(res.getInt("numEditorial"));
                l.setNumAutor(res.getInt("numAutor"));

                return l;
            }

            return null;
        }
    }

    @Override
    public int insertLibro(Libro libro) throws SQLException {
       int numFilas = 0;
        String sql = "insert into Libro values (?,?,?,?,?)";

        if (findByPk(libro.getIsbn()) != null) {

            return numFilas;
        } else {

            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                prest.setInt(1, libro.getIsbn());
                prest.setString(2, libro.getTitulo());
                prest.setString(3, libro.getGenero());
                prest.setInt(4, libro.getNumEditorial());
                prest.setInt(5, libro.getNumAutor());
                
                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

    @Override
    public int insertLibro(List<Libro> lista) throws SQLException {
        int numFilas = 0;

        for (Libro tmp : lista) {
            numFilas += insertLibro(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteLibro(Libro l) throws SQLException {
        int numFilas = 0;

        String sql = "delete from Libro where isbn = ?";

        try ( PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, l.getIsbn());

            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int deleteLibro() throws SQLException {
       String sql = "delete from Libro";

        int nfilas = 0;

        try ( Statement st = con.createStatement()) {

            nfilas = st.executeUpdate(sql);
        }

        return nfilas;
    }

    @Override
    public int updateLibro(int pk, Libro nuevosDatos) throws SQLException {
        int numFilas = 0;
        String sql = "update Libro set titulo = ?, genero = ?, numEditorial = ?, numAutor = ?, where isbn=?";

        if (findByPk(pk) == null) {

            return numFilas;
        } else {

            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                prest.setInt(1, pk);
                prest.setString(2, nuevosDatos.getTitulo());
                prest.setString(3, nuevosDatos.getGenero());
                prest.setInt(4, nuevosDatos.getNumEditorial());
                prest.setInt(5, nuevosDatos.getNumAutor());
                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }
    
    public int cambiarNombres(String newName, String oldName) throws SQLException {

        int res = 0;

        String sql = "{call cambiar_nombres (?,?)}";

        try ( CallableStatement call = con.prepareCall(sql)) {

            call.setString(1, newName);
            call.setString(2, oldName);

            res = call.executeUpdate();

        }
        return res;
    }
    
}
