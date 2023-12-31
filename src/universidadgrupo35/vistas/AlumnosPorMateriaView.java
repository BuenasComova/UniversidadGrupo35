/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo35.vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import universidadgrupo35.accesoaDatos.AlumnoData;
import universidadgrupo35.accesoaDatos.InscripcionData;
import universidadgrupo35.accesoaDatos.MateriaData;
import universidadgrupo35.entidades.Alumno;
import universidadgrupo35.entidades.Materia;

/**
 *
 * @author usuario
 */
public class AlumnosPorMateriaView extends javax.swing.JInternalFrame {

    private ArrayList<Materia> listaM;
    private ArrayList<Alumno> listaA;
    private AlumnoData ad;
    private MateriaData md;

    private InscripcionData inscd;
    private DefaultTableModel modelo;

    public AlumnosPorMateriaView() {
        initComponents();
        modelo = new DefaultTableModel();
        ad = new AlumnoData();
        md = new MateriaData();
        inscd = new InscripcionData();
        listaA = (ArrayList<Alumno>) ad.listarAlumnos();
        listaM = (ArrayList<Materia>) md.listarMaterias();
        armarCabeceraTabla();
        cargarMaterias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCmateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTalumnos = new javax.swing.JTable();
        jBsalir = new javax.swing.JButton();

        jLabel1.setText("LISTADO DE ALUMNOS POR MATERIA");

        jLabel2.setText("Seleccione una materia:");

        jCmateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmateriaActionPerformed(evt);
            }
        });

        jTalumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTalumnos);

        jBsalir.setText("Salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jCmateria, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBsalir)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCmateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jBsalir)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCmateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmateriaActionPerformed
        cargarAlumnosPorMateria();
    }//GEN-LAST:event_jCmateriaActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBsalir;
    private javax.swing.JComboBox<Materia> jCmateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTalumnos;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceraTabla() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        //nombres columnas
        filaCabecera.add("id");
        filaCabecera.add("dni");
        filaCabecera.add("apellido");
        filaCabecera.add("nombre");

        for (Object object : filaCabecera) {

            modelo.addColumn(object);
        }

        jTalumnos.setModel(modelo); //seteo campos a la tabla

    }

    private void cargarMaterias() {

        for (Materia materia : listaM) {  //propiedades - code - type parameters

            jCmateria.addItem(materia);

        }
    }

    private void borrarFilasTabla() {

        int indice = modelo.getRowCount() - 1; //cuenta las filas desde la ultima
        for (int i = indice; i >= 0; i--) {  //itera desde indice, recorre descendente
            modelo.removeRow(i);            //borra filas que tengan ese indice
        }
    }

    private void cargarAlumnosPorMateria() {

        borrarFilasTabla();
        Materia mat = (Materia) jCmateria.getSelectedItem(); //castea a Materia
        listaA = (ArrayList<Alumno>) inscd.obtenerAlumnoPorMateria(mat.getIdMateria()); //  se castea a ArrayList
        for (Alumno a : listaA) {
            modelo.addRow(new Object[]{a.getIdAlumno(), a.getDni(), a.getApellido(), a.getNombre()});

        }

    }

}
