
package universidadgrupo35.accesoaDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo35.entidades.Alumno;

public class AlumnoData {

    private Connection con = null; //objeto Connection usa metodos de clase Data (guardar,eliminar consultar de BD)

    //constructor para inicializar variable de Connection con - constructor no recibe nada
    public AlumnoData() {
        con = Conexion.getConexion();

    }

    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumno (dni,apellido, nombre, fechaNacimiento, estado )"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //devuelve lista claves generadas
            //setear valores:
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento())); // fechaN devuelve LocalDate :hay q transformar a Date con metodo ValueOf
            // y paso x parametro fechaN del alumno          Date de paquete sql
            ps.setBoolean(5, alumno.isEstado());

            ps.executeUpdate(); // hasta aca para INSERT de datos

            ResultSet rs = ps.getGeneratedKeys(); //guardo resultado en resultSet
            //devuelve tabla con la fila que inserte

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1)); //paso numero de columna "idAlumno"
                JOptionPane.showMessageDialog(null, "Alumno guardado");
            }

            ps.close(); //cierro objeto ps

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla alumno");
        }

    }
    // buscarAlumno

    public void modificarAlumno(Alumno alumno) {

        String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=?"
                + "WHERE idAlumno= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //seteo valores--- son 5 parametros
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            ps.executeUpdate();            //devuelve int con cant filas afectadas. lo guardo en variable:
            int modif = ps.executeUpdate();
            if (modif == 1) {
                JOptionPane.showMessageDialog(null, "Datos de alumno actualizados");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla alumno");
        }

    }

    public void eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET estado=0 WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id); //1 xq es el unico parametro
            int elim = ps.executeUpdate();
            if (elim == 1) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado");

            }

        } catch (SQLException ex) {

        }

    }
    
    public Alumno buscarAlumno(int idAlumno){
        
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno=? AND estado=1";
             
            Alumno alu = null;
            
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idAlumno);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
            
                 alu = new Alumno();
                
                alu.setIdAlumno(idAlumno);
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimiento(rs.getDate ("fechaNacimiento").toLocalDate());
                alu.setEstado(true);
            } else{
                
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            
            }
            
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla alumno");
        }
            
        return alu;
      
    }
    
public Alumno buscarAlumnoPorDni(int dni) {

        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni=? AND estado=1";

        Alumno alu = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                alu = new Alumno();

                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setEstado(true);
            } else {

                JOptionPane.showMessageDialog(null, "No existe el alumno");

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla alumno");
        }

        return alu;

    }

    public List <Alumno>listarAlumnos() {
        List<Alumno>alumnos=new ArrayList<>();
    

        String sql = "SELECT * FROM alumno where estado=1";

        Alumno alu = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                alu = new Alumno();

                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setEstado(true);
                alumnos.add(alu);
                
            }  

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla alumno");
        }

        return alumnos;

    }
}

