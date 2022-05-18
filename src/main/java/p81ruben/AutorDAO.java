/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p81ruben;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
public class AutorDAO implements IAutor {

    private Connection con = null;

    public AutorDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<Autor> getAll() throws SQLException {
        List<Autor> lista = new ArrayList<>();

        try ( Statement st = con.createStatement()) {

            ResultSet res = st.executeQuery("select * from Autor");

            while (res.next()) {
                Autor a = new Autor();

                a.setNumAutor(res.getInt("numAutor"));
                a.setNombre(res.getString("nombre"));
                a.setApe1(res.getString("ape1"));
                a.setApe2(res.getString("ape2"));
                a.setNumLibros(res.getInt("numLibros"));

                lista.add(a);
            }
        }

        return lista;
    }

    @Override
    public Autor findByPk(int pk) throws SQLException {

        ResultSet res = null;
        Autor a = new Autor();

        String sql = "select * from Autor where numAutor=?";

        try ( PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, pk);

            res = prest.executeQuery();

            if (res.next()) {

                a.setNumAutor(res.getInt("numAutor"));
                a.setNombre(res.getString("nombre"));
                a.setApe1(res.getString("ape1"));
                a.setApe2(res.getString("ape2"));
                a.setNumLibros(res.getInt("numLibros"));
                return a;
            }

            return null;
        }
    }

    @Override
    public int insertAutor(Autor a) throws SQLException {

        int numFilas = 0;
        String sql = "insert into Autor values (?,?,?,?,?)";

        if (findByPk(a.getNumAutor()) != null) {

            return numFilas;
        } else {

            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                prest.setInt(1, a.getNumAutor());
                prest.setString(2, a.getNombre());
                prest.setString(3, a.getApe1());
                prest.setString(4, a.getApe2());
                prest.setInt(5, a.getNumLibros());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    }

    @Override
    public int insertAutor(List<Autor> lista) throws SQLException {
        int numFilas = 0;

        for (Autor tmp : lista) {
            numFilas += insertAutor(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteAutor() throws SQLException {

        String sql = "delete from Autor";

        int nfilas = 0;

        try ( Statement st = con.createStatement()) {

            nfilas = st.executeUpdate(sql);
        }

        return nfilas;

    }

    @Override
    public int deleteAutor(Autor persona) throws SQLException {
        int numFilas = 0;

        String sql = "delete from Autor where numAutor = ?";

        try ( PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, persona.getNumAutor());

            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int updateAutor(int pk, Autor nuevosDatos) throws SQLException {

        int numFilas = 0;
        String sql = "update Autor set nombre = ?, ape1 = ?, ape2 = ?, numLibros = ?, where numAutor=?";

        if (findByPk(pk) == null) {

            return numFilas;
        } else {

            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                prest.setString(1, nuevosDatos.getNombre());
                prest.setString(2, nuevosDatos.getApe1());
                prest.setString(3, nuevosDatos.getApe2());
                prest.setInt(4, nuevosDatos.getNumLibros());
                prest.setInt(5, pk);
                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

}
