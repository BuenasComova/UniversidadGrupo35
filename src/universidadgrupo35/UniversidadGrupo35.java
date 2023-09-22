
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
        // TODO code application logic here
        
       //Alumno juan;
        //juan = new Alumno(24558895, "Sanchez","maria",LocalDate.of(2009,12,24),true);
       //AlumnoData alu=new AlumnoData(); 
        //Alumno alumnoEncontrado=alu.buscarAlumno(1);
        //System.out.println("dni " +alumnoEncontrado.getDni() +"nombre "+alumnoEncontrado.getNombre() +"apellido "+alumnoEncontrado.getApellido());
        //alu.guardarAlumno(juan);
        //alu.listarAlumnos(maria);
        //alu.buscarAlumno(1);
        //alu.eliminarAlumno(0);
        //System.out.println("dni, apellido, nombre, "+Alumno);
//        alu.eliminarAlumno(1);
//        for(Alumno alumno:alu.listarAlumnos()){
//           System.out.println(" dni " +alumno.getDni() +" nombre "+alumno.getNombre() +" apellido "+alumno.getApellido());  
//        }
	//Buscar alumno por dni
//        Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(24558895);
//	if(alumnoEncontrado!=null){
//		System.out.println(" dni " +alumnoEncontrado.getDni());
//		System.out.println(" apellido " +alumnoEncontrado.getApellido());
//	}

	//listar alumno
//	AlumnoData alu=new AlumnoData();
//        //alu.listarAlumnos(alumnos);
//	for(Alumno alumno:alu.listarAlumnos()){
////		System.out.println(alumno.getDni());
//		System.out.println(alumno.getApellido());
//		System.out.println(alumno.getNombre());
//		System.out.println(alumno.getFechaNacimiento());
//	}
	
	//Inscripcion
	AlumnoData alu=new AlumnoData();
        MateriaData mate=new MateriaData();
        InscripcionData id=new InscripcionData();
	
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

    private static Iterable<Alumno> listarAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }
  
    
