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

        String sql = "select * from persona where pk=?";

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
    public int insertPersona(Autor a) throws SQLException {

        int numFilas = 0;
        String sql = "insert into Autor values (?,?,?,?,?)";

        if (findByPk(a.getNumAutor()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
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
    public int insertPersona(List<Autor> lista) throws SQLException {
        int numFilas = 0;

        for (Autor tmp : lista) {
            numFilas += insertPersona(tmp);
        }

        return numFilas;
    }

    @Override
    public int deletePersona() throws SQLException {

        String sql = "delete from Autor";

        int nfilas = 0;

        try ( Statement st = con.createStatement()) {

            nfilas = st.executeUpdate(sql);
        }

        return nfilas;

    }

    @Override
    public int deletePersona(Autor persona) throws SQLException {
        int numFilas = 0;

        String sql = "delete from persona where pk = ?";

        // Sentencia parametrizada
        try ( PreparedStatement prest = con.prepareStatement(sql)) {


            prest.setInt(1, persona.getNumAutor());

            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int updatePersona(int pk, Autor nuevosDatos) throws SQLException {

        int numFilas = 0;
        String sql = "update persona set nombre = ?, fecha_nac = ? where pk=?";

        if (findByPk(pk) == null) {
            // La persona a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1, nuevosDatos.getNombre());
                prest.setDate(2, Date.valueOf(nuevosDatos.getFechaNacimiento()));
                prest.setInt(3, pk);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

    public int cambiarNombres(String newName, String oldName) throws SQLException {

        int res = 0;
        // Dos ?, uno para newName y otro para oldName

        String sql = "{call cambiar_nombres (?,?)}";

        // Preparamos la llamada al procedimiento almacenado
        try ( CallableStatement call = con.prepareCall(sql)) {
            // Establecemos parámetros a pasar al procedimiento
            call.setString(1, newName);
            call.setString(2, oldName);
            // Ejecutamos el procedimiento
            res = call.executeUpdate();

        }
        return res;
    }

}
