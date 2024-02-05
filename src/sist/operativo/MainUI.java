/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sist.operativo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Andrés Castro
 */
public class MainUI extends javax.swing.JFrame {
    
    public String[] parametros;
    public JTextField[] JTextFieldArray;
    public Studio StudioCN;
    public Studio StudioNK;
    /**
     * Creates new form NewJFrame
     */
    public MainUI() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        // Array de cantidades asignadas desde la interfaz mediante cuadros de texto
        this.JTextFieldArray = new JTextField[8];
        this.JTextFieldArray[0] = dayDuration;
        this.JTextFieldArray[1] = shippingDeadline;
        this.JTextFieldArray[2] = screenWriterQtty;
        this.JTextFieldArray[3] = designerQtty;
        this.JTextFieldArray[4] = animatorQtty;
        this.JTextFieldArray[5] = voiceActorsQtty;
        this.JTextFieldArray[6] = plotTwistWritterQtty;
        this.JTextFieldArray[7] = assemblersQtty;
        
        // Lectura del TXT
        String route = "src\\sist\\operativo\\parameters.txt";
        try {
            File archivo = new File(route);
            try (Scanner scanner = new Scanner(archivo)) {
                String linea = scanner.nextLine();
                this.parametros = linea.split(",");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.exit(0);
        }     
        for (int i = 0; i < 8; i++) {
            try {
                if (validNum(parametros[i]) != -1) {
                    this.JTextFieldArray[i].setText(parametros[i]);               
                } else {
                    JOptionPane.showMessageDialog(null, "Error de datos introducidos en TXT.");
                    System.exit(0);
                }
            } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Error de datos introducidos en TXT.");
                    System.exit(0);
                }
        }
        
        this.StudioCN = new Studio(Integer.parseInt(this.parametros[0])*1000, Integer.parseInt(this.parametros[1]), Integer.parseInt(this.parametros[2]), Integer.parseInt(this.parametros[3]), Integer.parseInt(this.parametros[4]), Integer.parseInt(this.parametros[5]), Integer.parseInt(this.parametros[6]), Integer.parseInt(this.parametros[7]), 0);
        this.StudioNK = new Studio(Integer.parseInt(this.parametros[0])*1000, Integer.parseInt(this.parametros[1]), Integer.parseInt(this.parametros[2]), Integer.parseInt(this.parametros[3]), Integer.parseInt(this.parametros[4]), Integer.parseInt(this.parametros[5]), Integer.parseInt(this.parametros[6]), Integer.parseInt(this.parametros[7]), 1);
        
        while (true){
            guionesDisp.setText(Integer.toString(this.StudioCN.drive.scripts));
            escenariosDisp.setText(Integer.toString(this.StudioCN.drive.scenarios));
            animacionesDisp.setText(Integer.toString(this.StudioCN.drive.animations));
            doblajesDisp.setText(Integer.toString(this.StudioCN.drive.dubs));
            plotwistsDisp.setText(Integer.toString(this.StudioCN.drive.plotTwists));
            pmStateLabel.setText(this.StudioCN.pm.state);
            directorStateLabel.setText(this.StudioCN.director.state);
            daysLeftLabel.setText(Integer.toString(this.StudioCN.counter.daysLeft));
            pmFaultsLabel.setText(Integer.toString(this.StudioCN.pm.faults));
            completeEpisodes1.setText(Integer.toString(this.StudioCN.drive.episodes));
            completePTEpisodes1.setText(Integer.toString(this.StudioCN.drive.episodesPT));
            totalEarningsLabel.setText(Integer.toString(this.StudioCN.episodeEarnings));
            pmMoneyLost1.setText(Integer.toString(this.StudioCN.pm.pocketLost));
            utilidadTotal.setText(Integer.toString(this.StudioCN.totalEarnings));
            costos.setText(Integer.toString(this.StudioCN.operativeCosts));
            guionesDispNK.setText(Integer.toString(this.StudioNK.drive.scripts));
            escenariosDispNK.setText(Integer.toString(this.StudioNK.drive.scenarios));
            animacionesDispNK.setText(Integer.toString(this.StudioNK.drive.animations));
            doblajesDispNK.setText(Integer.toString(this.StudioNK.drive.dubs));
            plotwistsDispNK.setText(Integer.toString(this.StudioNK.drive.plotTwists));
            pmStateLabelNK.setText(this.StudioNK.pm.state);
            directorStateLabelNK.setText(this.StudioNK.director.state);
            daysLeftLabelNK.setText(Integer.toString(this.StudioNK.counter.daysLeft));
            pmFaultsLabelNK.setText(Integer.toString(this.StudioNK.pm.faults));
            completeEpisodes1NK.setText(Integer.toString(this.StudioNK.drive.episodes));
            completePTEpisodes1NK.setText(Integer.toString(this.StudioNK.drive.episodesPT));
            totalEarningsLabelNK.setText(Integer.toString(this.StudioNK.episodeEarnings));
            pmMoneyLost1NK.setText(Integer.toString(this.StudioNK.pm.pocketLost));
            utilidadTotal1.setText(Integer.toString(this.StudioNK.totalEarnings));
            costos1.setText(Integer.toString(this.StudioNK.operativeCosts));
        }
        

        
    }
    
    // Validador de numeros
    public static int validNum(String numString) {
        int num;
        try {
            num = Integer.parseInt(numString);
            return num;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input Inválido: " + e.getMessage());
        }
        return -1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
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
        saveChanges = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        completePTEpisodes1 = new javax.swing.JLabel();
        ensambladoresCont = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        guionesDisp = new javax.swing.JLabel();
        animacionesMax = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        escenariosDisp = new javax.swing.JLabel();
        doblajesMax = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        animacionesDisp = new javax.swing.JLabel();
        plotwistsMax = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        doblajesDisp = new javax.swing.JLabel();
        plotwistsDisp = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        guionCont1 = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        diseñadorEsceCont1 = new javax.swing.JSpinner();
        jLabel37 = new javax.swing.JLabel();
        animadoresCont1 = new javax.swing.JSpinner();
        jLabel38 = new javax.swing.JLabel();
        dobladoresCont1 = new javax.swing.JSpinner();
        jLabel39 = new javax.swing.JLabel();
        plotwistersCont1 = new javax.swing.JSpinner();
        jLabel40 = new javax.swing.JLabel();
        pmStateLabel = new javax.swing.JLabel();
        directorStateLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        guionesMax = new javax.swing.JLabel();
        completeEpisodes1 = new javax.swing.JLabel();
        utilidadTotal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        totalEarningsLabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        escenariosMax = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        daysLeftLabel = new javax.swing.JLabel();
        pmFaultsLabel = new javax.swing.JLabel();
        pmMoneyLost1 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        costos = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        completeEpisodes1NK = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        daysLeftLabelNK = new javax.swing.JLabel();
        totalEarningsLabelNK = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        utilidadTotal1 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        completePTEpisodes1NK = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        plotwistsDispNK = new javax.swing.JLabel();
        doblajesDispNK = new javax.swing.JLabel();
        animacionesDispNK = new javax.swing.JLabel();
        escenariosDispNK = new javax.swing.JLabel();
        guionesDispNK = new javax.swing.JLabel();
        guionesMax1 = new javax.swing.JLabel();
        escenariosMax1 = new javax.swing.JLabel();
        animacionesMax1 = new javax.swing.JLabel();
        doblajesMax1 = new javax.swing.JLabel();
        plotwistsMax1 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        ensambladoresCont1 = new javax.swing.JSpinner();
        jLabel57 = new javax.swing.JLabel();
        plotwistersCont2 = new javax.swing.JSpinner();
        dobladoresCont2 = new javax.swing.JSpinner();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        animadoresCont2 = new javax.swing.JSpinner();
        diseñadorEsceCont2 = new javax.swing.JSpinner();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        guionCont2 = new javax.swing.JSpinner();
        jLabel62 = new javax.swing.JLabel();
        directorStateLabelNK = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        pmStateLabelNK = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        pmFaultsLabelNK = new javax.swing.JLabel();
        pmMoneyLost1NK = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        costos1 = new javax.swing.JLabel();
        nickFondo = new javax.swing.JLabel();
        doblajesMax2 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Cantidades iniciales");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 220, -1));

        dayDuration.setColumns(4);
        dayDuration.setName(""); // NOI18N
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

        shippingDeadline.setColumns(4);
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

        screenWriterQtty.setColumns(4);
        screenWriterQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenWriterQttyActionPerformed(evt);
            }
        });
        jPanel1.add(screenWriterQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel8.setText("Guionistas:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        designerQtty.setColumns(4);
        designerQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                designerQttyActionPerformed(evt);
            }
        });
        jPanel1.add(designerQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel9.setText("Diseñador de escenarios:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        animatorQtty.setColumns(4);
        animatorQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animatorQttyActionPerformed(evt);
            }
        });
        jPanel1.add(animatorQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel10.setText("Animador de personajes:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        voiceActorsQtty.setColumns(4);
        voiceActorsQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceActorsQttyActionPerformed(evt);
            }
        });
        jPanel1.add(voiceActorsQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel11.setText("Actores de doblaje:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        plotTwistWritterQtty.setColumns(4);
        plotTwistWritterQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotTwistWritterQttyActionPerformed(evt);
            }
        });
        jPanel1.add(plotTwistWritterQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel12.setText("Guionista de PlotTwist:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        assemblersQtty.setColumns(4);
        assemblersQtty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblersQttyActionPerformed(evt);
            }
        });
        jPanel1.add(assemblersQtty, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jLabel13.setText("Ensambladores:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        saveChanges.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        saveChanges.setText("Guardar");
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesActionPerformed(evt);
            }
        });
        jPanel1.add(saveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sist/operativo/purple.PNG"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 270, 190));

        jTabbedPane1.addTab("Menú", jPanel1);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        completePTEpisodes1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        completePTEpisodes1.setForeground(new java.awt.Color(0, 0, 0));
        completePTEpisodes1.setText("0");
        jPanel2.add(completePTEpisodes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 40, 40));

        ensambladoresCont.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        ensambladoresCont.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ensambladoresContStateChanged(evt);
            }
        });
        jPanel2.add(ensambladoresCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 40, 20));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Máximo");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 80, 40));

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Plotwisters");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 80, 40));

        guionesDisp.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        guionesDisp.setForeground(new java.awt.Color(0, 0, 0));
        guionesDisp.setText("0");
        jPanel2.add(guionesDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 30, 40));

        animacionesMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        animacionesMax.setForeground(new java.awt.Color(0, 0, 0));
        animacionesMax.setText("55");
        jPanel2.add(animacionesMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 20, 40));

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Escenarios");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 80, 40));

        escenariosDisp.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        escenariosDisp.setForeground(new java.awt.Color(0, 0, 0));
        escenariosDisp.setText("0");
        jPanel2.add(escenariosDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 30, 40));

        doblajesMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        doblajesMax.setForeground(new java.awt.Color(0, 0, 0));
        doblajesMax.setText("35");
        jPanel2.add(doblajesMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 20, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Animaciones");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, 40));

        animacionesDisp.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        animacionesDisp.setForeground(new java.awt.Color(0, 0, 0));
        animacionesDisp.setText("0");
        jPanel2.add(animacionesDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 30, 40));

        plotwistsMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        plotwistsMax.setForeground(new java.awt.Color(0, 0, 0));
        plotwistsMax.setText("10");
        jPanel2.add(plotwistsMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 20, 40));

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Doblajes");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 90, 40));

        doblajesDisp.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        doblajesDisp.setForeground(new java.awt.Color(0, 0, 0));
        doblajesDisp.setText("0");
        jPanel2.add(doblajesDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 30, 40));

        plotwistsDisp.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        plotwistsDisp.setForeground(new java.awt.Color(0, 0, 0));
        plotwistsDisp.setText("0");
        jPanel2.add(plotwistsDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 30, 40));

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Guiones");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 40));

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Ensambladores");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 110, 40));

        guionCont1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        guionCont1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                guionCont1StateChanged(evt);
            }
        });
        jPanel2.add(guionCont1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 40, 20));

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Diseñadores");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 80, 40));

        diseñadorEsceCont1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        diseñadorEsceCont1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                diseñadorEsceCont1StateChanged(evt);
            }
        });
        jPanel2.add(diseñadorEsceCont1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 40, 20));

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Animadores");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 80, 40));

        animadoresCont1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        animadoresCont1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                animadoresCont1StateChanged(evt);
            }
        });
        jPanel2.add(animadoresCont1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 40, 20));

        jLabel38.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Dobladores");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 80, 40));

        dobladoresCont1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        dobladoresCont1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dobladoresCont1StateChanged(evt);
            }
        });
        jPanel2.add(dobladoresCont1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 40, 20));

        jLabel39.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Guionistas");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 80, 40));

        plotwistersCont1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        plotwistersCont1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                plotwistersCont1StateChanged(evt);
            }
        });
        jPanel2.add(plotwistersCont1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 40, 20));

        jLabel40.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("GANANCIA EN BRUTO = ");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 240, 50));

        pmStateLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        pmStateLabel.setForeground(new java.awt.Color(0, 0, 0));
        pmStateLabel.setText("Trabajando/Viendo anime");
        jPanel2.add(pmStateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, 40));

        directorStateLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        directorStateLabel.setForeground(new java.awt.Color(0, 0, 0));
        directorStateLabel.setText("Trabajando/Vigilando al PM");
        jPanel2.add(directorStateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("ESTADO DEL PM:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 110, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("DINERO PM TOTAL DESCONTADO =");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 240, 40));

        guionesMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        guionesMax.setForeground(new java.awt.Color(0, 0, 0));
        guionesMax.setText("25");
        jPanel2.add(guionesMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 20, 40));

        completeEpisodes1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        completeEpisodes1.setForeground(new java.awt.Color(0, 0, 0));
        completeEpisodes1.setText("0");
        jPanel2.add(completeEpisodes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 50, 40));

        utilidadTotal.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        utilidadTotal.setForeground(new java.awt.Color(0, 0, 0));
        utilidadTotal.setText("0");
        jPanel2.add(utilidadTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 230, 50));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("PARTES y TRABAJADORES ");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 310, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("CAPÍTULOS LISTOS ESTÁNDAR =");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 310, 40));

        totalEarningsLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        totalEarningsLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalEarningsLabel.setText("0");
        jPanel2.add(totalEarningsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 190, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("COSTOS = ");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 200, 50));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("DÍAS PARA LA ENTREGA:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 240, 50));

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("CAPÍTULOS LISTOS PLOTWIST =");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 310, 40));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Drive");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 80, 50));

        escenariosMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        escenariosMax.setForeground(new java.awt.Color(0, 0, 0));
        escenariosMax.setText("20");
        jPanel2.add(escenariosMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 20, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("ESTADO DEL DIRECTOR:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 160, 40));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Plotwists");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 90, 40));

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Disponibles");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 80, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("FALTAS AL PM=");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 110, 40));

        daysLeftLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        daysLeftLabel.setForeground(new java.awt.Color(0, 0, 0));
        daysLeftLabel.setText("0");
        jPanel2.add(daysLeftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 40, 50));

        pmFaultsLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmFaultsLabel.setForeground(new java.awt.Color(0, 0, 0));
        pmFaultsLabel.setText("0");
        jPanel2.add(pmFaultsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 40, 60));

        pmMoneyLost1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmMoneyLost1.setForeground(new java.awt.Color(0, 0, 0));
        pmMoneyLost1.setText("0");
        jPanel2.add(pmMoneyLost1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 160, 60));

        jLabel42.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("UTILIDAD TOTAL = ");
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 200, 50));

        costos.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        costos.setForeground(new java.awt.Color(0, 0, 0));
        costos.setText("0");
        jPanel2.add(costos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 230, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/CNSTUDIOfONDO33 (1).jpg"))); // NOI18N
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setOpaque(true);
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 470));

        jTabbedPane1.addTab("Cartoon Network", jPanel2);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("CAPÍTULOS LISTOS ESTÁNDAR =");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 40));

        completeEpisodes1NK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        completeEpisodes1NK.setForeground(new java.awt.Color(0, 0, 0));
        completeEpisodes1NK.setText("0");
        jPanel3.add(completeEpisodes1NK, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 160, 40));

        jLabel43.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("DÍAS PARA LA ENTREGA:");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 240, 50));

        daysLeftLabelNK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        daysLeftLabelNK.setForeground(new java.awt.Color(0, 0, 0));
        daysLeftLabelNK.setText("0");
        jPanel3.add(daysLeftLabelNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 60, 50));

        totalEarningsLabelNK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        totalEarningsLabelNK.setForeground(new java.awt.Color(0, 0, 0));
        totalEarningsLabelNK.setText("0");
        jPanel3.add(totalEarningsLabelNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 170, 50));

        jLabel44.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("GANANCIA EN BRUTO= ");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 230, 50));

        jLabel45.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("UTILIDAD TOTAL = ");
        jPanel3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 200, 50));

        utilidadTotal1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        utilidadTotal1.setForeground(new java.awt.Color(0, 0, 0));
        utilidadTotal1.setText("0");
        jPanel3.add(utilidadTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 190, 50));

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("CAPÍTULOS LISTOS PLOTWIST =");
        jPanel3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 310, 40));

        completePTEpisodes1NK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        completePTEpisodes1NK.setForeground(new java.awt.Color(0, 0, 0));
        completePTEpisodes1NK.setText("0");
        jPanel3.add(completePTEpisodes1NK, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 40, 40));

        jLabel47.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("TRABAJADORES y PARTES");
        jPanel3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 310, 40));

        jLabel48.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Drive");
        jPanel3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 80, 40));

        jLabel49.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("Disponibles");
        jPanel3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 80, 40));

        jLabel50.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("Máximo");
        jPanel3.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 80, 40));

        jLabel51.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Guiones");
        jPanel3.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 40));

        jLabel52.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("Escenarios");
        jPanel3.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 80, 40));

        jLabel53.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("Animaciones");
        jPanel3.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, 40));

        jLabel54.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setText("Doblajes");
        jPanel3.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 90, 40));

        jLabel55.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Plotwists");
        jPanel3.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 90, 40));

        plotwistsDispNK.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        plotwistsDispNK.setForeground(new java.awt.Color(0, 0, 0));
        plotwistsDispNK.setText("0");
        jPanel3.add(plotwistsDispNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 30, 40));

        doblajesDispNK.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        doblajesDispNK.setForeground(new java.awt.Color(0, 0, 0));
        doblajesDispNK.setText("0");
        jPanel3.add(doblajesDispNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 30, 40));

        animacionesDispNK.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        animacionesDispNK.setForeground(new java.awt.Color(0, 0, 0));
        animacionesDispNK.setText("0");
        jPanel3.add(animacionesDispNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 30, 40));

        escenariosDispNK.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        escenariosDispNK.setForeground(new java.awt.Color(0, 0, 0));
        escenariosDispNK.setText("0");
        jPanel3.add(escenariosDispNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 30, 40));

        guionesDispNK.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        guionesDispNK.setForeground(new java.awt.Color(0, 0, 0));
        guionesDispNK.setText("0");
        jPanel3.add(guionesDispNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 30, 40));

        guionesMax1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        guionesMax1.setForeground(new java.awt.Color(0, 0, 0));
        guionesMax1.setText("25");
        jPanel3.add(guionesMax1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 20, 40));

        escenariosMax1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        escenariosMax1.setForeground(new java.awt.Color(0, 0, 0));
        escenariosMax1.setText("20");
        jPanel3.add(escenariosMax1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 20, 40));

        animacionesMax1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        animacionesMax1.setForeground(new java.awt.Color(0, 0, 0));
        animacionesMax1.setText("55");
        jPanel3.add(animacionesMax1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 20, 40));

        doblajesMax1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        doblajesMax1.setForeground(new java.awt.Color(0, 0, 0));
        doblajesMax1.setText("35");
        jPanel3.add(doblajesMax1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 20, 40));

        plotwistsMax1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        plotwistsMax1.setForeground(new java.awt.Color(0, 0, 0));
        plotwistsMax1.setText("10");
        jPanel3.add(plotwistsMax1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 20, 40));

        jLabel56.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Ensambladores");
        jPanel3.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 110, 40));

        ensambladoresCont1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        ensambladoresCont1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ensambladoresCont1StateChanged(evt);
            }
        });
        jPanel3.add(ensambladoresCont1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 40, 20));

        jLabel57.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Plotwisters");
        jPanel3.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 80, 40));

        plotwistersCont2.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        plotwistersCont2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                plotwistersCont2StateChanged(evt);
            }
        });
        jPanel3.add(plotwistersCont2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 40, 20));

        dobladoresCont2.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        dobladoresCont2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dobladoresCont2StateChanged(evt);
            }
        });
        jPanel3.add(dobladoresCont2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 40, 20));

        jLabel58.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Dobladores");
        jPanel3.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 80, 40));

        jLabel59.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setText("Animadores");
        jPanel3.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 80, 40));

        animadoresCont2.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        animadoresCont2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                animadoresCont2StateChanged(evt);
            }
        });
        jPanel3.add(animadoresCont2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 40, 20));

        diseñadorEsceCont2.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        diseñadorEsceCont2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                diseñadorEsceCont2StateChanged(evt);
            }
        });
        jPanel3.add(diseñadorEsceCont2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 40, 20));

        jLabel60.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Diseñadores");
        jPanel3.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 80, 40));

        jLabel61.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Guionistas");
        jPanel3.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 80, 40));

        guionCont2.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        guionCont2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                guionCont2StateChanged(evt);
            }
        });
        jPanel3.add(guionCont2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 40, 20));

        jLabel62.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("ESTADO DEL DIRECTOR:");
        jPanel3.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 160, 40));

        directorStateLabelNK.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        directorStateLabelNK.setForeground(new java.awt.Color(0, 0, 0));
        directorStateLabelNK.setText("Trabajando/Vigilando al PM");
        jPanel3.add(directorStateLabelNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, 40));

        jLabel63.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("ESTADO DEL PM:");
        jPanel3.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 110, 40));

        pmStateLabelNK.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        pmStateLabelNK.setForeground(new java.awt.Color(0, 0, 0));
        pmStateLabelNK.setText("Trabajando/Viendo anime");
        jPanel3.add(pmStateLabelNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, 40));

        jLabel64.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("FALTAS AL PM=");
        jPanel3.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 110, 40));

        jLabel65.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("DINERO PM TOTAL DESCONTADO =");
        jPanel3.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 240, 40));

        pmFaultsLabelNK.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        pmFaultsLabelNK.setForeground(new java.awt.Color(0, 0, 0));
        pmFaultsLabelNK.setText("0");
        jPanel3.add(pmFaultsLabelNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 60, -1));

        pmMoneyLost1NK.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        pmMoneyLost1NK.setForeground(new java.awt.Color(0, 0, 0));
        pmMoneyLost1NK.setText("0");
        jPanel3.add(pmMoneyLost1NK, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 110, -1));

        jLabel66.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("COSTOS = ");
        jPanel3.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 200, 50));

        costos1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        costos1.setForeground(new java.awt.Color(0, 0, 0));
        costos1.setText("0");
        jPanel3.add(costos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 230, 50));

        nickFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/NickStudioFondo.png"))); // NOI18N
        nickFondo.setText("jLabel15");
        jPanel3.add(nickFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 470));

        doblajesMax2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        doblajesMax2.setForeground(new java.awt.Color(0, 0, 0));
        doblajesMax2.setText("0");
        jPanel3.add(doblajesMax2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 10, 40));

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
    
    
    // Guarda cambios en TXT
    private void saveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesActionPerformed
        String texto = "";
        String route = "src\\sist\\operativo\\parameters.txt";
        for (int i = 0; i < 8; i++) {
            if (validNum(this.JTextFieldArray[i].getText()) != -1 ) {
                if (i == 7) {
                    texto += this.JTextFieldArray[i].getText();
                } else {
                    texto += this.JTextFieldArray[i].getText() + ",";                
                }               
            } else {
                break;
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(route))) {
            bw.write(texto);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar: " + e.getMessage());
        }
        
        
    }//GEN-LAST:event_saveChangesActionPerformed

    private void ensambladoresContStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ensambladoresContStateChanged
        
    }//GEN-LAST:event_ensambladoresContStateChanged

    private void guionCont1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_guionCont1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_guionCont1StateChanged

    private void diseñadorEsceCont1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_diseñadorEsceCont1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_diseñadorEsceCont1StateChanged

    private void animadoresCont1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_animadoresCont1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_animadoresCont1StateChanged

    private void dobladoresCont1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dobladoresCont1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dobladoresCont1StateChanged

    private void plotwistersCont1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_plotwistersCont1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_plotwistersCont1StateChanged

    private void ensambladoresCont1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ensambladoresCont1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ensambladoresCont1StateChanged

    private void plotwistersCont2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_plotwistersCont2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_plotwistersCont2StateChanged

    private void dobladoresCont2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dobladoresCont2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dobladoresCont2StateChanged

    private void animadoresCont2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_animadoresCont2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_animadoresCont2StateChanged

    private void diseñadorEsceCont2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_diseñadorEsceCont2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_diseñadorEsceCont2StateChanged

    private void guionCont2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_guionCont2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_guionCont2StateChanged

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
    private javax.swing.JLabel animacionesDisp;
    private javax.swing.JLabel animacionesDispNK;
    private javax.swing.JLabel animacionesMax;
    private javax.swing.JLabel animacionesMax1;
    private javax.swing.JSpinner animadoresCont1;
    private javax.swing.JSpinner animadoresCont2;
    private javax.swing.JTextField animatorQtty;
    private javax.swing.JTextField assemblersQtty;
    private javax.swing.JLabel completeEpisodes1;
    private javax.swing.JLabel completeEpisodes1NK;
    private javax.swing.JLabel completePTEpisodes1;
    private javax.swing.JLabel completePTEpisodes1NK;
    private javax.swing.JLabel costos;
    private javax.swing.JLabel costos1;
    private javax.swing.JTextField dayDuration;
    private javax.swing.JLabel daysLeftLabel;
    private javax.swing.JLabel daysLeftLabelNK;
    private javax.swing.JTextField designerQtty;
    private javax.swing.JLabel directorStateLabel;
    private javax.swing.JLabel directorStateLabelNK;
    private javax.swing.JSpinner diseñadorEsceCont1;
    private javax.swing.JSpinner diseñadorEsceCont2;
    private javax.swing.JSpinner dobladoresCont1;
    private javax.swing.JSpinner dobladoresCont2;
    private javax.swing.JLabel doblajesDisp;
    private javax.swing.JLabel doblajesDispNK;
    private javax.swing.JLabel doblajesMax;
    private javax.swing.JLabel doblajesMax1;
    private javax.swing.JLabel doblajesMax2;
    private javax.swing.JSpinner ensambladoresCont;
    private javax.swing.JSpinner ensambladoresCont1;
    private javax.swing.JLabel escenariosDisp;
    private javax.swing.JLabel escenariosDispNK;
    private javax.swing.JLabel escenariosMax;
    private javax.swing.JLabel escenariosMax1;
    private javax.swing.JSpinner guionCont1;
    private javax.swing.JSpinner guionCont2;
    private javax.swing.JLabel guionesDisp;
    private javax.swing.JLabel guionesDispNK;
    private javax.swing.JLabel guionesMax;
    private javax.swing.JLabel guionesMax1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel nickFondo;
    private javax.swing.JTextField plotTwistWritterQtty;
    private javax.swing.JSpinner plotwistersCont1;
    private javax.swing.JSpinner plotwistersCont2;
    private javax.swing.JLabel plotwistsDisp;
    private javax.swing.JLabel plotwistsDispNK;
    private javax.swing.JLabel plotwistsMax;
    private javax.swing.JLabel plotwistsMax1;
    private javax.swing.JLabel pmFaultsLabel;
    private javax.swing.JLabel pmFaultsLabelNK;
    private javax.swing.JLabel pmMoneyLost1;
    private javax.swing.JLabel pmMoneyLost1NK;
    private javax.swing.JLabel pmStateLabel;
    private javax.swing.JLabel pmStateLabelNK;
    private javax.swing.JButton saveChanges;
    private javax.swing.JTextField screenWriterQtty;
    private javax.swing.JTextField shippingDeadline;
    private javax.swing.JLabel totalEarningsLabel;
    private javax.swing.JLabel totalEarningsLabelNK;
    private javax.swing.JLabel utilidadTotal;
    private javax.swing.JLabel utilidadTotal1;
    private javax.swing.JTextField voiceActorsQtty;
    // End of variables declaration//GEN-END:variables
}
