/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo35.accesoaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo35.entidades.Materia;

/**
 *
 * @author Hp
 */
public class MateriaData {

    private Connection con = null; //objeto Connection usa metodos de clase Data (guardar,eliminar consultar de BD)

    //constructor para inicializar variable de Connection con - constructor no recibe nada
    public MateriaData() {
        con = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {

        String sql = "INSERT INTO materia (nombre, año)"
                + "VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //devuelve lista claves generadas
            //setear valores:
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());

            ps.setBoolean(3, materia.isEstado());

            ps.executeUpdate(); // hasta aca para INSERT de datos

            ResultSet rs = ps.getGeneratedKeys(); //guardo resultado en resultSet
            //devuelve tabla con la fila que inserte

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1)); //paso numero de columna "idMateria"
                JOptionPane.showMessageDialog(null, "Materia guardada");
            }

            ps.close(); //cierro objeto ps

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia");
        }

    }//Modificar Materia

    public void modificarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre=?, año=?"
                + "WHERE idMateria= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //seteo valores--- son 3 parametros
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3, materia.getIdMateria());

            ps.executeUpdate();            //devuelve int con cant filas afectadas. lo guardo en variable:
            int modif = ps.executeUpdate();
            if (modif == 1) {
                JOptionPane.showMessageDialog(null, "Datos de la Materia actualizados");

            } else {
                JOptionPane.showMessageDialog(null, " Materia inexistente");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Materia");
        }

    }

    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado=0 WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id); //1 xq es el unico parametro
            int elim = ps.executeUpdate();
            if (elim == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error alacceder a la tabla materia");

        }

    }

    public Materia buscarMateria(int idMateria) {

        String sql = "SELECT nombre, año FROM materia WHERE idMateria=? and Estado = 1";

        Materia mat = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                mat = new Materia();

                mat.setIdMateria(idMateria);
                mat.setNombre(rs.getString("nombre"));
               
               
                mat.setAnio(rs.getInt("año"));
                mat.setEstado(true);
            } else {

                JOptionPane.showMessageDialog(null, "No existe la materia");

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Materia");
        }

        return mat;

    }

    

      
    public List<Materia> listarMaterias() {
        List<Materia> materias = new ArrayList<>();

        String sql = "SELECT * FROM Materia where estado=1";

        Materia mat = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                mat = new Materia();

                mat.setIdMateria(rs.getInt("idMateria"));
                
                mat.setNombre(rs.getString("nombre"));
               
                mat.setAnio(rs.getInt("año"));
                mat.setEstado(true);
                materias.add(mat);

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Materias");
        }

        return materias;

    }
}

