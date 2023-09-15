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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import universidadgrupo35.entidades.Alumno;
import universidadgrupo35.entidades.Inscripcion;
import universidadgrupo35.entidades.Materia;

/**
 *
 * @author Hp
 */
public class InscripcionData {
 private Connection con = null;
 
 private MateriaData md = new MateriaData ();
 
 private AlumnoData ad = new AlumnoData ();
 
    public InscripcionData() {
        this.con= Conexion.getConexion();
        
    }
 public void guardarInscripcion ( Inscripcion insc){
     
     String sql="insert into inscripcion (idAlumno,idMateria,nota) values (?,?,?)";
     
     try {
         PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         
         ps.setInt(1,insc.getAlumno().getIdAlumno());
         
         ps.setInt(2,insc.getMateria().getIdMateria());
         
         ps.setDouble(3,insc.getNota());
         
         ps.executeUpdate();
         
         ResultSet rs=ps.getGeneratedKeys();
         
         if (rs.next()){
             
             insc.setIdInscripcion(rs.getInt(1));
             
             JOptionPane.showMessageDialog(null, "Inscripcion registrada");
             
             ps.close();
         }
         
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Error al acceder a la tabla inscripcion");
         
     }
     
 }
     
     public void actualizarNota(int idAlumno, int idMateria, double nota){
         
         String sql="update inscripcion set nota= ? where idAlumno=? and idMateria=?";
         
     try {
         PreparedStatement ps=con.prepareStatement(sql);
         
         ps.setDouble(1,nota);
         
         ps.setInt(2, idAlumno);
         
         ps.setInt(3,idMateria);
         
         int filas= ps.executeUpdate();
         
         if (filas>0) {
             
             JOptionPane.showMessageDialog(null, "Nota actualizada");
             
         
         }
         
         ps.close();
         
         
     } catch (SQLException ex) {
         
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de inscripcion");
         
        
         
         
         
     }
     } // Hacemos el borrado logico o el fisico????
       public void borrarInscripcionMateriaAlumno (int idAlumno,int idMateria) {
           
           String sql=" Delete from inscripcion where idAlumno=? and idMateria=?";
           
           PreparedStatement ps;
     try {
         ps = con.prepareStatement(sql);
   
     
           
           ps.setInt(1,idAlumno);
           
           ps.setInt(2, idMateria);
           
           
           int filas=ps.executeUpdate();
           
           if (filas>0){
             
               JOptionPane.showMessageDialog(null, "Inscripcion borrada");
             
               
           }
                   
             ps.close();
                   
            } catch (SQLException ex) {   
                
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
            }     
           
       }
     public List<Inscripcion> obtenerInscripciones(){
     ArrayList<Inscripcion> cursadas= new ArrayList <> ();
     
     String sql="select * from inscripcion ";
     try {
         //habilitamos conexion a bd
         PreparedStatement ps= con.prepareStatement(sql);
         //preparamos la sentencia a enviar
         ResultSet rs=ps.executeQuery();
         //ResulSet contiene los resultados de la consulta a bd
         //guardamos el resultado de nuestra consulta enviada a traves de la ejecucion de la sentecia sql
         //en la variable rs.
         
         while (rs.next()){ // mientras haya filas en rs  ejecuto el while  
             Inscripcion insc = new Inscripcion ();
             // creo un objeto inscripcion
             insc.setIdInscripcion(rs.getInt("idInscripcion"));
            // relleno el objeto inscripcion con los campos que me suministra la variable rs
             Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
             
             Materia mat = md.buscarMateria(rs.getInt("idMateria"));
             
             
               insc.setAlumno(alu);
               
               insc.setMateria(mat);
               
               insc.setNota(rs.getDouble("nota"));
               
              cursadas.add(insc);
              
              //agrego el objeto inscripcion a la lista cursadas
            
             
         
         }
         
         ps.close();// cierro la conexion a la base de datos
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error de conexion a tabla inscripcion");
     }
     
     return cursadas;}
     // retorno la lista cursadas
}
     

         
         
     

