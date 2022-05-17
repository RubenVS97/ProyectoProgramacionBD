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
    public List<AutorDAO> getAll() throws SQLException {
        List<AutorDAO> lista = new ArrayList<>();
        
        try ( Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from Autor");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                AutorDAO p = new AutorDAO();
                // Recogemos los datos de la persona, guardamos en un objeto
                p.set(res.getInt("pk"));
                p.setNombre(res.getString("nombre"));
                p.setFechaNacimiento(res.getDate("fecha_nac").toLocalDate());

                //Añadimos el objeto a la lista
                lista.add(p);
            }
        }

        return lista;
    }

    @Override
    public PersonaVO findByPk(int pk) throws SQLException {

        ResultSet res = null;
        PersonaVO persona = new PersonaVO();

        String sql = "select * from persona where pk=?";

        try ( PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                persona.setPk(res.getInt("pk"));
                persona.setNombre(res.getString("nombre"));
                persona.setFechaNacimiento(res.getDate("fecha_nac").toLocalDate());
                return persona;
            }

            return null;
        }
    }

    @Override
    public int insertPersona(PersonaVO persona) throws SQLException {

        int numFilas = 0;
        String sql = "insert into persona values (?,?,?)";

        if (findByPk(persona.getPk()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try ( PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, persona.getPk());
                prest.setString(2, persona.getNombre());
                prest.setDate(3, Date.valueOf(persona.getFechaNacimiento()));

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }

    }

    @Override
    public int insertPersona(List<PersonaVO> lista) throws SQLException {
        int numFilas = 0;

        for (PersonaVO tmp : lista) {
            numFilas += insertPersona(tmp);
        }

        return numFilas;
    }

    @Override
    public int deletePersona() throws SQLException {

        String sql = "delete from persona";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try ( Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;

    }

    @Override
    public int deletePersona(PersonaVO persona) throws SQLException {
        int numFilas = 0;

        String sql = "delete from persona where pk = ?";

        // Sentencia parametrizada
        try ( PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, persona.getPk());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int updatePersona(int pk, PersonaVO nuevosDatos) throws SQLException {

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
