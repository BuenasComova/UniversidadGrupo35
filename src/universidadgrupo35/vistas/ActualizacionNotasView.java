package universidadgrupo35.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo35.accesoaDatos.AlumnoData;
import universidadgrupo35.accesoaDatos.InscripcionData;
import universidadgrupo35.accesoaDatos.MateriaData;
import universidadgrupo35.entidades.Alumno;
import universidadgrupo35.entidades.Inscripcion;
import universidadgrupo35.entidades.Materia;


public class ActualizacionNotasView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;

    private AlumnoData ad;

    private InscripcionData id;

    private ArrayList<Alumno> ListaAlumno;

    private ArrayList<Inscripcion> inscripciones;
    private Inscripcion x;

    
    public ActualizacionNotasView() {
        initComponents();

        modelo = ( DefaultTableModel)jTMaterias.getModel();
        ad = new AlumnoData();
        //md= new MateriaData ();
        id = new InscripcionData();
        x = new Inscripcion();
        ListaAlumno = (ArrayList<Alumno>) ad.listarAlumnos();

        inscripciones = (ArrayList<Inscripcion>) id.obtenerInscripciones();
        Alumno a = new Alumno();
        Materia m = new Materia();
        
        cargarAlumnoCombo();
       
    }


    public void cargarAlumnoCombo() {

        for (Alumno a : ListaAlumno) {

            jCBAlumnos.addItem(a);
        }
    }
    public void borrarFilaTabla() {
        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void cargarDatosInscriptas() {

         borrarFilaTabla();
        Alumno a = (Alumno) jCBAlumnos.getSelectedItem();
        inscripciones = (ArrayList) id.obtenerInscripcionesPorAlumno(a.getIdAlumno());
        for (Inscripcion x : inscripciones) {
            modelo.addRow(new Object[]{x.getMateria().getIdMateria(), x.getMateria().getNombre(), x.getMateria().getAnio(), x.getNota()});
        }
    }

    private void guardarNota() {

        int filaSeleccionada = jTMaterias.getSelectedRow();
        if (filaSeleccionada != - 1) {

         Alumno a = (Alumno) jCBAlumnos.getSelectedItem();

         int b = Integer.parseInt( modelo.getValueAt(filaSeleccionada, 0).toString());

         double c = Double.parseDouble( modelo.getValueAt(filaSeleccionada, 3).toString());

          
         id.actualizarNota(a.getIdAlumno(), b, c);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una opción");
        }
       
        borrarFilaTabla();
        cargarDatosInscriptas();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLSeleccioneUnAlumno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMaterias = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLCamgaDeNotas = new javax.swing.JLabel();
        jBLimpiar = new javax.swing.JButton();
        jCBAlumnos = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLSeleccioneUnAlumno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLSeleccioneUnAlumno.setText("Seleccione un alumno");

        jTMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id Materia", "Nombre", "Año", "nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTMaterias);

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLCamgaDeNotas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLCamgaDeNotas.setText("Carga de notas");

        jBLimpiar.setText("Limpiar");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jCBAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAlumnosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLSeleccioneUnAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCBAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jBGuardar)
                .addGap(56, 56, 56)
                .addComponent(jBLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLCamgaDeNotas)
                        .addGap(189, 189, 189))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLCamgaDeNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSeleccioneUnAlumno)
                    .addComponent(jCBAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir)
                    .addComponent(jBLimpiar))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCBAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAlumnosActionPerformed
        cargarDatosInscriptas();  // TODO add your handling code here:
    }//GEN-LAST:event_jCBAlumnosActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        borrarFilaTabla();   // TODO add your handling code here:
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        guardarNota();
    }//GEN-LAST:event_jBGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCBAlumnos;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLCamgaDeNotas;
    private javax.swing.JLabel jLSeleccioneUnAlumno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMaterias;
    // End of variables declaration//GEN-END:variables
}
