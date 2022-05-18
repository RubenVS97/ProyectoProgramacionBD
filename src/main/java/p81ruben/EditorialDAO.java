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
public class EditorialDAO implements IEditorial {

    private Connection con = null;

    public EditorialDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<Editorial> getAll() throws SQLException {
        List<Editorial> lista = new ArrayList<>();

        try ( Statement st = con.createStatement()) {

            ResultSet res = st.executeQuery("select * from Editorial");

            while (res.next()) {
                Editorial e = new Editorial();

                e.setNumEditorial(res.getInt("numEditorial"));
                e.setNombre(res.getString("nombre"));
                e.setNumTotalLibros(res.getInt("numTotalLibros"));

                lista.add(e);
            }
        }

        return lista;
    }

    @Override
    public Editorial findByPk(int pk) throws SQLException {
        ResultSet res = null;
        Editorial e = new Editorial();

        String sql = "select * from Editorial where numEditorial=?";

        try ( PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, pk);

            res = prest.executeQuery();

            if (res.next()) {

                e.setNumEditorial(res.getInt("numEditorial"));
                e.setNombre(res.getString("nombre"));
                e.setNumTotalLibros(res.getInt("numTotalLibros"));

                return e;
            }

            return null;
        }
    }

    @Override
    public int insertEditorial(Editorial editorial) throws SQLException {
        int numFilas = 0;
        String sql = "insert into Editorial values (?,?,?)";

        if (findByPk(editorial.getNumEditorial()) != null) {

            return numFilas;
        } else {

            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                prest.setInt(1, editorial.getNumEditorial());
                prest.setString(2, editorial.getNombre());
                prest.setInt(3, editorial.getNumTotalLibros());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

    @Override
    public int insertEditorial(List<Editorial> lista) throws SQLException {
        int numFilas = 0;

        for (Editorial tmp : lista) {
            numFilas += insertEditorial(tmp);
        }

        return numFilas;
    }

    @Override
    public int deleteEditorial(Editorial e) throws SQLException {
        int numFilas = 0;

        String sql = "delete from Editorial where numEditorial = ?";

        try ( PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setInt(1, e.getNumEditorial());

            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int deleteEditorial() throws SQLException {
        String sql = "delete from Editorial";

        int nfilas = 0;

        try ( Statement st = con.createStatement()) {

            nfilas = st.executeUpdate(sql);
        }

        return nfilas;
    }

    @Override
    public int updateEditorial(int pk, Editorial nuevosDatos) throws SQLException {
        int numFilas = 0;
        String sql = "update Autor set nombre = ?, numTotalLibro = ?, where numAutor=?";

        if (findByPk(pk) == null) {

            return numFilas;
        } else {

            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                prest.setInt(3, pk);
                prest.setString(1, nuevosDatos.getNombre());
                prest.setInt(2, nuevosDatos.getNumTotalLibros());
                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

}
