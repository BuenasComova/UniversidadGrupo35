/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo35.entidades;

/**
 *
 * @author Hp
 */
public class Inscripcion {

    private int idInscripcion;
    private Alumno alumno;
    private Materia materia;
    private double nota;
    private boolean estado;

    public Inscripcion() {
    }

    public Inscripcion(Alumno alumno, Materia materia, double nota, boolean estado) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.estado = estado;
    }

    public Inscripcion(int idInscripcion, Alumno alumno, Materia materia, double nota, boolean estado) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.estado = estado;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {

        String insc = idInscripcion + " " + alumno.getApellido() + ", " + alumno.getNombre() + ", " + materia.getNombre();

        return insc;
    }

}
