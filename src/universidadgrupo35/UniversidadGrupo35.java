package universidadgrupo35;

import java.sql.Connection;
import java.time.LocalDate;
import universidadgrupo35.accesoaDatos.AlumnoData;
import universidadgrupo35.accesoaDatos.Conexion;
import universidadgrupo35.entidades.Alumno;
import universidadgrupo35.accesoaDatos.Conexion;
import universidadgrupo35.accesoaDatos.InscripcionData;
import universidadgrupo35.accesoaDatos.MateriaData;
import universidadgrupo35.entidades.Inscripcion;
import universidadgrupo35.entidades.Materia;

public class UniversidadGrupo35 {

    public static void main(String[] args) {

        AlumnoData alu = new AlumnoData();
        MateriaData mate = new MateriaData();
        InscripcionData id = new InscripcionData();

        //Alumno aaa;
        //aaa = new Alumno(24558895, "Sanchez","maria",LocalDate.of(2001,12,24),true); 
        //alu.guardarAlumno(aaa);
        //Alumno bbb;
        //aaa = new Alumno(12345678, "Martinez","Jorge",LocalDate.of(2000,02,06),true); 
        //alu.guardarAlumno(bbb);
        //Alumno ccc;
        //ccc = new Alumno(56789123, "Flores","Sandra",LocalDate.of(1990,08,10),true); 
        //alu.guardarAlumno(bbb);
        //alu.buscarAlumno();
        //      System.out.println("");
        //alu.modificarAlumno();   //no se puede probar desde main sin vista
        //alu.eliminarAlumno();
        //alu.buscarAlumno();
        //Buscar alumno por dni
        //alu.buscarAlumnoPorDni(24558895);
        //  if(alumnoEncontrado!=null){
        //      System.out.println(" dni " +alumnoEncontrado.getDni());
        //	System.out.println(" apellido " +alumnoEncontrado.getApellido());
        //}
        //alu.buscarAlumnoPorDni(111111111);
        //alu.listarAlumnos();
        //  for(Alumno alumno:alu.listarAlumnos()){
        //      System.out.println(" dni: " +alumno.getDni() +" nombre: "+alumno.getNombre() +" apellido: "+alumno.getApellido());  
        //}
        //listar alumno            
        //alu.listarAlumnos(alumnos);
        //	for(Alumno alumno:alu.listarAlumnos()){
        //	System.out.println(alumno.getDni());
        //	System.out.println(alumno.getApellido());
        //	System.out.println(alumno.getNombre());
        //	System.out.println(alumno.getFechaNacimiento());
        //}
        //Inscripcion
        //Alumno alum=alu.buscarAlumno(6);
        //Materia mat=mate.buscarMateria(3);
        //Inscripcion insc=new Inscripcion(alum,mat,9);
        //id.guardarInscripcion(insc);
        //Actualizar nota
        //id.actualizarNota(5,4, 7);
        //BorrarInscripcionMateria
        //id.borrarInscripcionMateriaAlumno(5, 4);
        //ObtenerInscripcion
        //ObtenerInscripcionesPorAlumno
        //ObtenerMateriasCursadasPorAlumno
    }

}
