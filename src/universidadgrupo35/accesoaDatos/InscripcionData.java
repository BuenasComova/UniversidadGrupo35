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
     
     String sql="insert into inscripcion (idAlumno,idMateria,nota,estado) values (?,?,?,?)";
     
     try {
         PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         
         ps.setInt(1,insc.getAlumno().getIdAlumno());
         
         ps.setInt(2,insc.getMateria().getIdMateria());
         
         ps.setDouble(3,insc.getNota());
         
         ps.setBoolean(4, true);
         
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
         
         String sql="update inscripcion set nota=? "+
                 "where idAlumno=? and idMateria=?  ";
         
         
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

// Hacemos el borrado logico
       public void borrarInscripcionMateriaAlumno (int idAlumno,int idMateria) {
          String sql="UPDATE inscripcion SET estado=0 where idAlumno=? and idMateria=?";
           
//String sql=" update from inscripcion where idAlumno=? and idMateria=?";
           
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
               
               insc.setEstado(rs.getBoolean("estado"));
               
              cursadas.add(insc);
              
              
              
              //agrego el objeto inscripcion a la lista cursadas
            
             
         
         }
         
         ps.close();// cierro la conexion a la base de datos
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error de conexion a tabla inscripcion");
     }
     
     return cursadas;}
     // retorno la lista cursadas
     
     
     public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
     
          ArrayList<Inscripcion> cursadas= new ArrayList <> ();
     
          String sql="SELECT * FROM inscripcion WHERE estado=1 and IdAlumno=?";
          
          
     try {
         PreparedStatement ps= con.prepareStatement(sql);
         ps.setInt(1, idAlumno);
         ResultSet rs= ps.executeQuery();
         
          while (rs.next()){  
             Inscripcion insc = new Inscripcion();
             insc.setIdInscripcion(rs.getInt("idInscripcion"));
             Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
             Materia mat = md.buscarMateria(rs.getInt("idMateria"));
            insc.setAlumno(alu);
            insc.setMateria(mat);
             insc.setNota(rs.getDouble("nota"));
               
              cursadas.add(insc);

          }
          ps.close();
         
     } catch (SQLException ex) {
         
         JOptionPane.showMessageDialog(null, "Error al acceder a tabla inscripcion");
     }
     
        return cursadas;
        
     }
     
     
      //Obtengo las materias cursadas por el alumno
     public List <Materia>obtenerMateriasCursadas (int idAlumno){
         //creo un arrayList para guardar las materias
     ArrayList <Materia> materias= new ArrayList();
     // sentencia para enviar
     
     String sql= "SELECT inscripcion.idMateria,nombre, año, nota From inscripcion, materia "
             
             + " WHERE inscripcion.idMateria= materia.idMateria AND inscripcion.idAlumno= ? And inscripcion.estado= 1 ; ";
     //aca hace producto cartesiano con todas las posibles combinaciones entre inscripción y materia pero que solo devuelva donde coincidan los id 
     try {
          //habilitamos conexion a bd
         PreparedStatement ps=con.prepareStatement(sql);
         //seteamos la incognita con el id que nos pasan por parámetro
         ps.setInt(1, idAlumno);
          //preparamos la sentencia a enviar
         ResultSet rs= ps.executeQuery();
         
        while (rs.next()) {
            //mientras haya filas se recorren con el while
            //se crea un objeto materia con contructor vacio
            Materia materia= new Materia();
            //se rellena 
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnio(rs.getInt("año"));
         
            materias.add(materia);
        }
        //se cierra la conexion
         ps.close();
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripciones");
     }
     return materias;
}
      
      //Obtengo las materias no cursadas por el alumno
     public List <Materia>obtenerMateriasNoCursadas (int idAlumno){
       ArrayList <Materia> materias= new ArrayList();  
         String sql= "SELECT * FROM materia WHERE estado = 1 AND idmateria not in"
                 + "(SELECT idmateria FROM inscripcion WHERE idAlumno =? and inscripcion.estado =1)";          
         
          try {
          //habilitamos conexion a bd
         PreparedStatement ps=con.prepareStatement(sql);
         //seteamos la incognita con el id que nos pasan por parámetro
         ps.setInt(1, idAlumno);
          //preparamos la sentencia a enviar
         ResultSet rs= ps.executeQuery();
         
        while (rs.next()) {
            //mientras haya filas se recorren con el while
            //se crea un objeto materia con contructor vacio
            Materia materia= new Materia();
            //se rellena 
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnio(rs.getInt("año"));
            materias.add(materia);
        }
        //se cierra la conexion
         ps.close();
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripciones");
     }
            return materias;
     }
     
     
     public List<Alumno> obtenerAlumnoPorMateria ( int idMateria) {
         
      ArrayList<Alumno> alus = new ArrayList<> ();
      
       String sql = "select alumno.idalumno,dni,nombre,apellido,fechaDeNacimiento,estado "
               + "from inscripcion,alumno where inscripcion.idAlumno=alumno.idaAlumno and idMateria=?and alumno.estado=1";
               
     try {
         
         PreparedStatement ps=con.prepareStatement(sql);
         
         ps.setInt(1, idMateria);
                 
         ResultSet rs = ps.executeQuery();
         
         while(rs.next()){
             
          Alumno alu=new Alumno ();
           
           
           alu.setIdAlumno(rs.getInt("idAlumno"));
           
           alu.setDni(rs.getInt("dni"));
           
           alu.setNombre(rs.getString ("nombre"));
           
           alu.setApellido(rs.getString("apellido"));
           
           alu.setFechaNacimiento(rs.getDate ("fechaNacimiento").toLocalDate());
       
                   
            alu.setEstado(rs.getBoolean("estado"));
            
            
            alus.add(alu);
            
         }
        
         
         ps.close();
         
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "error de conexion a la tabla ");
     }
                        
                          
       return   alus;
     }
     
     
      
}
     
     

         
         
     
