package universidadgrupo35.vistas;

import universidadgrupo35.accesoaDatos.AlumnoData;

public class MenuView extends javax.swing.JFrame {

    private AlumnoData ad;

    public MenuView() {
        initComponents();
        ad = new AlumnoData(); 
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMalumno = new javax.swing.JMenu();
        jMformAlumno = new javax.swing.JMenuItem();
        jMmateria = new javax.swing.JMenu();
        jMformMateria = new javax.swing.JMenuItem();
        jMadministracion = new javax.swing.JMenu();
        jMformInscripcion = new javax.swing.JMenuItem();
        jMcalificaciones = new javax.swing.JMenuItem();
        jMconsultas = new javax.swing.JMenu();
        jMaluPorMat = new javax.swing.JMenuItem();
        jMsalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        escritorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        escritorio.setForeground(new java.awt.Color(102, 102, 0));
        escritorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1044, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 732, Short.MAX_VALUE)
        );

        getContentPane().add(escritorio);

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMalumno.setText("Alumno");

        jMformAlumno.setText("Form Alumno");
        jMformAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMformAlumnoActionPerformed(evt);
            }
        });
        jMalumno.add(jMformAlumno);

        jMenuBar1.add(jMalumno);

        jMmateria.setText("Materia");
        jMmateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMmateriaActionPerformed(evt);
            }
        });

        jMformMateria.setText("Form Materia");
        jMformMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMformMateriaActionPerformed(evt);
            }
        });
        jMmateria.add(jMformMateria);

        jMenuBar1.add(jMmateria);

        jMadministracion.setText("Administracion");

        jMformInscripcion.setText("Form Inscripcion");
        jMformInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMformInscripcionActionPerformed(evt);
            }
        });
        jMadministracion.add(jMformInscripcion);

        jMcalificaciones.setText("Calificaciones");
        jMcalificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMcalificacionesActionPerformed(evt);
            }
        });
        jMadministracion.add(jMcalificaciones);

        jMenuBar1.add(jMadministracion);

        jMconsultas.setText("Consultas");

        jMaluPorMat.setText("Alumnos por Materia");
        jMaluPorMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaluPorMatActionPerformed(evt);
            }
        });
        jMconsultas.add(jMaluPorMat);

        jMenuBar1.add(jMconsultas);

        jMsalir.setText("Salir");
        jMsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMsalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMsalir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMaluPorMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaluPorMatActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AlumnosPorMateriaView apmv = new AlumnosPorMateriaView();
        apmv.setVisible(true);
        escritorio.add(apmv);
        escritorio.moveToFront(apmv);
    }//GEN-LAST:event_jMaluPorMatActionPerformed

    private void jMcalificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMcalificacionesActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ActualizacionNotasView anv = new ActualizacionNotasView();
        anv.setVisible(true);
        escritorio.add(anv);
        escritorio.moveToFront(anv);

    }//GEN-LAST:event_jMcalificacionesActionPerformed

    private void jMformAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMformAlumnoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AlumnoView avw = new AlumnoView(ad); // instancio objeto de clase AlumnoView
        avw.setVisible(true);
        escritorio.add(avw);
        escritorio.moveToFront(avw);
    }//GEN-LAST:event_jMformAlumnoActionPerformed

    private void jMmateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMmateriaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        MateriaView mvw = new MateriaView();
        mvw.setVisible(true);
        escritorio.add(mvw);
        escritorio.moveToFront(mvw);
    }//GEN-LAST:event_jMmateriaActionPerformed

    private void jMformMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMformMateriaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        MateriaView mvw = new MateriaView();
        mvw.setVisible(true);
        escritorio.add(mvw);
        escritorio.moveToFront(mvw);        // TODO add your handling code here:
    }//GEN-LAST:event_jMformMateriaActionPerformed

    private void jMformInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMformInscripcionActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        InscripcionView ivw
                = new InscripcionView();
        ivw.setVisible(true);
        escritorio.add(ivw);

       
    }//GEN-LAST:event_jMformInscripcionActionPerformed

    private void jMsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMsalirMouseClicked
dispose();
    }//GEN-LAST:event_jMsalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMadministracion;
    private javax.swing.JMenuItem jMaluPorMat;
    private javax.swing.JMenu jMalumno;
    private javax.swing.JMenuItem jMcalificaciones;
    private javax.swing.JMenu jMconsultas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMformAlumno;
    private javax.swing.JMenuItem jMformInscripcion;
    private javax.swing.JMenuItem jMformMateria;
    private javax.swing.JMenu jMmateria;
    private javax.swing.JMenu jMsalir;
    // End of variables declaration//GEN-END:variables
}
