/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sist.operativo;

/**
 *
 * @author Andrés Castro
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public MainUI() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dayDuration = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        shippingDeadline = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        screenWriterQtty = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        designerQtty = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        animatorQtty = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        voiceActorsQtty = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        plotTwistWritterQtty = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        assemblersQtty = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Cantidades iniciales");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 220, -1));

        dayDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayDurationActionPerformed(evt);
            }
        });
        jPanel1.add(dayDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        jLabel3.setText("días");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, 40));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel4.setText("Duración de un día:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        shippingDeadline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shippingDeadlineActionPerformed(evt);
            }
        });
        jPanel1.add(shippingDeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel5.setText("segundos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, 40));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        jLabel6.setText("Configuración de Simulación");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 480, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel7.setText("Deadline de entrega:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        screenWriterQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenWriterQttyActionPerformed(evt);
            }
        });
        jPanel1.add(screenWriterQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel8.setText("Guionistas:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        designerQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                designerQttyActionPerformed(evt);
            }
        });
        jPanel1.add(designerQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel9.setText("Diseñador de escenarios:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        animatorQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animatorQttyActionPerformed(evt);
            }
        });
        jPanel1.add(animatorQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel10.setText("Animador de personajes:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        voiceActorsQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceActorsQttyActionPerformed(evt);
            }
        });
        jPanel1.add(voiceActorsQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel11.setText("Actores de doblaje:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        plotTwistWritterQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistWritterQttyActionPerformed(evt);
            }
        });
        jPanel1.add(plotTwistWritterQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel12.setText("Guionista de PlotTwist:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        assemblersQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblersQttyActionPerformed(evt);
            }
        });
        jPanel1.add(assemblersQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel13.setText("Ensambladores:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, -1, -1));

        jTabbedPane1.addTab("Menú", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cartoon Network", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Nickelodeon", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dayDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayDurationActionPerformed

    private void shippingDeadlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shippingDeadlineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shippingDeadlineActionPerformed

    private void screenWriterQttyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenWriterQttyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_screenWriterQttyActionPerformed

    private void designerQttyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_designerQttyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_designerQttyActionPerformed

    private void animatorQttyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animatorQttyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animatorQttyActionPerformed

    private void voiceActorsQttyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voiceActorsQttyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_voiceActorsQttyActionPerformed

    private void plotTwistWritterQttyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotTwistWritterQttyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plotTwistWritterQttyActionPerformed

    private void assemblersQttyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assemblersQttyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assemblersQttyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField animatorQtty;
    private javax.swing.JTextField assemblersQtty;
    private javax.swing.JTextField dayDuration;
    private javax.swing.JTextField designerQtty;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField plotTwistWritterQtty;
    private javax.swing.JTextField screenWriterQtty;
    private javax.swing.JTextField shippingDeadline;
    private javax.swing.JTextField voiceActorsQtty;
    // End of variables declaration//GEN-END:variables
}
