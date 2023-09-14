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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import universidadgrupo35.entidades.Inscripcion;

/**
 *
 * @author Hp
 */
public class InscripcionData {
 private Connection con = null;

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
     
     public void actualizaNota(int idAlumno, int idMateria, double nota){
         
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
     } 
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
           
       }}
         
         
     

