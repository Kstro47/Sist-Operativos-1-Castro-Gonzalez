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
            int maxWorkers = 0;
            try (Scanner scanner = new Scanner(archivo)) {
                String linea = scanner.nextLine();
                this.parametros = linea.split(",");
                for (int i = 2; i < this.parametros.length; i++) {
                    maxWorkers += Integer.parseInt(this.parametros[i]);
                }
                if (maxWorkers > 21){
                    JOptionPane.showMessageDialog(null, "Error de datos introducidos en TXT. La cantidad de trabajadores debe ser menor o igual a 21");
                    System.exit(0);
                }                
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
            utilidadTotal2.setText(Integer.toString(this.StudioNK.totalEarnings));
            costos1.setText(Integer.toString(this.StudioNK.operativeCosts));
            
            numScripters.setText(Integer.toString(this.StudioCN.screenWriters.length));
            numDesigners.setText(Integer.toString(this.StudioCN.designers.length));
            numAnimators.setText(Integer.toString(this.StudioCN.animators.length));
            numDubbers.setText(Integer.toString(this.StudioCN.dubsActor.length));
            numPlotTwisters.setText(Integer.toString(this.StudioCN.plotTwistsWriters.length));
            numAssemblers.setText(Integer.toString(this.StudioCN.assemblers.length));
            
            numScripters1.setText(Integer.toString(this.StudioNK.screenWriters.length));
            numDesigners1.setText(Integer.toString(this.StudioNK.designers.length));
            numAnimators1.setText(Integer.toString(this.StudioNK.animators.length));
            numDubbers1.setText(Integer.toString(this.StudioNK.dubsActor.length));
            numPlotTwisters1.setText(Integer.toString(this.StudioNK.plotTwistsWriters.length));
            numAssemblers1.setText(Integer.toString(this.StudioNK.assemblers.length));
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
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
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
        jButton13 = new javax.swing.JButton();
        deleteScripts = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        numScripters = new javax.swing.JLabel();
        pmFaultsLabel1 = new javax.swing.JLabel();
        pmFaultsLabel4 = new javax.swing.JLabel();
        pmFaultsLabel3 = new javax.swing.JLabel();
        pmFaultsLabel2 = new javax.swing.JLabel();
        numDesigners = new javax.swing.JLabel();
        numAnimators = new javax.swing.JLabel();
        numDubbers = new javax.swing.JLabel();
        numPlotTwisters = new javax.swing.JLabel();
        numAssemblers = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        sumScripts = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        completeEpisodes1NK = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        daysLeftLabelNK = new javax.swing.JLabel();
        totalEarningsLabelNK = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
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
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
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
        utilidadTotal2 = new javax.swing.JLabel();
        pmMoneyLost1NK3 = new javax.swing.JLabel();
        numDesigners1 = new javax.swing.JLabel();
        numDubbers1 = new javax.swing.JLabel();
        numPlotTwisters1 = new javax.swing.JLabel();
        numAssemblers1 = new javax.swing.JLabel();
        pmMoneyLost1NK2 = new javax.swing.JLabel();
        numScripters1 = new javax.swing.JLabel();
        pmMoneyLost1NK1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        numAnimators1 = new javax.swing.JLabel();
        nickFondo = new javax.swing.JLabel();

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/descarga (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 280, 310));

        jTabbedPane1.addTab("Menú", jPanel1);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        completePTEpisodes1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        completePTEpisodes1.setForeground(new java.awt.Color(0, 0, 0));
        completePTEpisodes1.setText("0");
        jPanel2.add(completePTEpisodes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 40, 40));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Máximo");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 80, 40));

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Plotwisters");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 80, 40));

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
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 110, 40));

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Diseñadores");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 80, 40));

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Animadores");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 80, 40));

        jLabel38.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Dobladores");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 80, 40));

        jLabel39.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Guionistas");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 80, 40));

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
        jPanel2.add(utilidadTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 210, 50));

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
        jPanel2.add(totalEarningsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 190, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("COSTOS = ");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 100, 50));

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
        pmFaultsLabel.setText("$");
        jPanel2.add(pmFaultsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 20, 20));

        pmMoneyLost1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmMoneyLost1.setForeground(new java.awt.Color(0, 0, 0));
        pmMoneyLost1.setText("0");
        jPanel2.add(pmMoneyLost1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 160, 60));

        jLabel42.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("UTILIDAD TOTAL = ");
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 200, 50));

        costos.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        costos.setForeground(new java.awt.Color(0, 0, 0));
        costos.setText("0");
        jPanel2.add(costos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 230, 50));

        jButton13.setText("-");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, -1, 20));

        deleteScripts.setText("-");
        deleteScripts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteScriptsActionPerformed(evt);
            }
        });
        jPanel2.add(deleteScripts, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, -1, -1));

        jButton15.setText("-");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, -1, 20));

        jButton16.setText("-");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, -1, 20));

        jButton17.setText("-");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, -1, 20));

        jButton18.setText("-");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, -1, 20));

        numScripters.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numScripters.setForeground(new java.awt.Color(0, 0, 0));
        numScripters.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numScripters.setText("0");
        jPanel2.add(numScripters, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 50, 60));

        pmFaultsLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmFaultsLabel1.setForeground(new java.awt.Color(0, 0, 0));
        pmFaultsLabel1.setText("0");
        jPanel2.add(pmFaultsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 40, 60));

        pmFaultsLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmFaultsLabel4.setForeground(new java.awt.Color(0, 0, 0));
        pmFaultsLabel4.setText("$");
        jPanel2.add(pmFaultsLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 20, 20));

        pmFaultsLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmFaultsLabel3.setForeground(new java.awt.Color(0, 0, 0));
        pmFaultsLabel3.setText("$");
        jPanel2.add(pmFaultsLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 20, 60));

        pmFaultsLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmFaultsLabel2.setForeground(new java.awt.Color(0, 0, 0));
        pmFaultsLabel2.setText("$");
        jPanel2.add(pmFaultsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 20, 60));

        numDesigners.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numDesigners.setForeground(new java.awt.Color(0, 0, 0));
        numDesigners.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numDesigners.setText("0");
        jPanel2.add(numDesigners, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 50, 60));

        numAnimators.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numAnimators.setForeground(new java.awt.Color(0, 0, 0));
        numAnimators.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numAnimators.setText("0");
        jPanel2.add(numAnimators, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 50, 60));

        numDubbers.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numDubbers.setForeground(new java.awt.Color(0, 0, 0));
        numDubbers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numDubbers.setText("0");
        jPanel2.add(numDubbers, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 50, 60));

        numPlotTwisters.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numPlotTwisters.setForeground(new java.awt.Color(0, 0, 0));
        numPlotTwisters.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPlotTwisters.setText("0");
        jPanel2.add(numPlotTwisters, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 50, 60));

        numAssemblers.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numAssemblers.setForeground(new java.awt.Color(0, 0, 0));
        numAssemblers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numAssemblers.setText("0");
        jPanel2.add(numAssemblers, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 50, 60));

        jButton19.setText("+");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, 20));

        jButton20.setText("+");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, -1, 20));

        jButton21.setText("+");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, -1, 20));

        jButton22.setText("+");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, -1, 20));

        jButton23.setText("+");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, -1, 20));

        sumScripts.setText("+");
        sumScripts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumScriptsActionPerformed(evt);
            }
        });
        jPanel2.add(sumScripts, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, -1, 20));

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
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 310, 40));

        completeEpisodes1NK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        completeEpisodes1NK.setForeground(new java.awt.Color(0, 0, 0));
        completeEpisodes1NK.setText("0");
        jPanel3.add(completeEpisodes1NK, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 160, 40));

        jLabel43.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("DÍAS PARA LA ENTREGA:");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 240, 50));

        daysLeftLabelNK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        daysLeftLabelNK.setForeground(new java.awt.Color(0, 0, 0));
        daysLeftLabelNK.setText("0");
        jPanel3.add(daysLeftLabelNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 60, 50));

        totalEarningsLabelNK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        totalEarningsLabelNK.setForeground(new java.awt.Color(0, 0, 0));
        totalEarningsLabelNK.setText("0");
        jPanel3.add(totalEarningsLabelNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 170, 50));

        jLabel44.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("GANANCIA EN BRUTO= ");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 230, 50));

        jLabel45.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("UTILIDAD TOTAL = ");
        jPanel3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 200, 50));

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("CAPÍTULOS LISTOS PLOTWIST =");
        jPanel3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 310, 40));

        completePTEpisodes1NK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        completePTEpisodes1NK.setForeground(new java.awt.Color(0, 0, 0));
        completePTEpisodes1NK.setText("0");
        jPanel3.add(completePTEpisodes1NK, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 40, 40));

        jLabel47.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("PARTES y TRABAJADORES");
        jPanel3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 310, 40));

        jLabel48.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Drive");
        jPanel3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 80, 50));

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
        jPanel3.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 110, 40));

        jLabel57.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Plotwisters");
        jPanel3.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 80, 40));

        jLabel58.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Dobladores");
        jPanel3.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 80, 40));

        jLabel59.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setText("Animadores");
        jPanel3.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 80, 40));

        jLabel60.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Diseñadores");
        jPanel3.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 80, 40));

        jLabel61.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Guionistas");
        jPanel3.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 80, 40));

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

        pmFaultsLabelNK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmFaultsLabelNK.setForeground(new java.awt.Color(0, 0, 0));
        pmFaultsLabelNK.setText("0");
        jPanel3.add(pmFaultsLabelNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 406, 60, 30));

        pmMoneyLost1NK.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmMoneyLost1NK.setForeground(new java.awt.Color(0, 0, 0));
        pmMoneyLost1NK.setText("$");
        jPanel3.add(pmMoneyLost1NK, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 20, 40));

        jLabel66.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("COSTOS = ");
        jPanel3.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 100, 50));

        costos1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        costos1.setForeground(new java.awt.Color(0, 0, 0));
        costos1.setText("0");
        jPanel3.add(costos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 230, 50));

        utilidadTotal2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        utilidadTotal2.setForeground(new java.awt.Color(0, 0, 0));
        utilidadTotal2.setText("0");
        jPanel3.add(utilidadTotal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 190, 50));

        pmMoneyLost1NK3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmMoneyLost1NK3.setForeground(new java.awt.Color(0, 0, 0));
        pmMoneyLost1NK3.setText("$");
        jPanel3.add(pmMoneyLost1NK3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 20, 40));

        numDesigners1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numDesigners1.setForeground(new java.awt.Color(0, 0, 0));
        numDesigners1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numDesigners1.setText("0");
        jPanel3.add(numDesigners1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 50, 60));

        numDubbers1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numDubbers1.setForeground(new java.awt.Color(0, 0, 0));
        numDubbers1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numDubbers1.setText("0");
        jPanel3.add(numDubbers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 50, 60));

        numPlotTwisters1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numPlotTwisters1.setForeground(new java.awt.Color(0, 0, 0));
        numPlotTwisters1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPlotTwisters1.setText("0");
        jPanel3.add(numPlotTwisters1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 50, 60));

        numAssemblers1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numAssemblers1.setForeground(new java.awt.Color(0, 0, 0));
        numAssemblers1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numAssemblers1.setText("0");
        jPanel3.add(numAssemblers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 50, 60));

        pmMoneyLost1NK2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmMoneyLost1NK2.setForeground(new java.awt.Color(0, 0, 0));
        pmMoneyLost1NK2.setText("$");
        jPanel3.add(pmMoneyLost1NK2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 20, 40));

        numScripters1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numScripters1.setForeground(new java.awt.Color(0, 0, 0));
        numScripters1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numScripters1.setText("0");
        jPanel3.add(numScripters1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 50, 60));

        pmMoneyLost1NK1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        pmMoneyLost1NK1.setForeground(new java.awt.Color(0, 0, 0));
        pmMoneyLost1NK1.setText("0");
        jPanel3.add(pmMoneyLost1NK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 110, 40));

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, -1, 20));

        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, -1, 20));

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, -1, 20));

        jButton4.setText("-");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, -1, 20));

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, 20));

        jButton6.setText("-");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, -1, 20));

        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, -1, 20));

        jButton8.setText("-");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, -1, 20));

        jButton9.setText("+");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, -1, 20));

        jButton10.setText("-");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, -1, 20));

        jButton11.setText("+");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, -1, 20));

        jButton12.setText("-");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, -1, 20));

        numAnimators1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        numAnimators1.setForeground(new java.awt.Color(0, 0, 0));
        numAnimators1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numAnimators1.setText("0");
        jPanel3.add(numAnimators1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 50, 60));

        nickFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/NickStudioFondo.png"))); // NOI18N
        nickFondo.setText("jLabel15");
        jPanel3.add(nickFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 470));

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
        int maxWorkers = 0-Integer.parseInt(this.JTextFieldArray[0].getText())-Integer.parseInt(this.JTextFieldArray[1].getText());
        for (int i = 0; i < 8; i++) {
            if (validNum(this.JTextFieldArray[i].getText()) != -1 ) {
                if (i == 7) {
                    texto += this.JTextFieldArray[i].getText();
                } else {
                    texto += this.JTextFieldArray[i].getText() + ",";                
                }  
                maxWorkers += Integer.parseInt(this.JTextFieldArray[i].getText());
            } else {
                break;
            }
        }
        if (maxWorkers <= 21) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(route))) {
            bw.write(texto);
            JOptionPane.showMessageDialog(null, "Guardado exitoso.");
            } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar: La máxima cantidad de trabajadores es 21.");
        }
        
        
        
    }//GEN-LAST:event_saveChangesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.addWorker(5);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.deleteWorker(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.addWorker(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.deleteWorker(1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.addWorker(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.deleteWorker(2);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.addWorker(2);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.deleteWorker(3);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.addWorker(3);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.deleteWorker(4);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.addWorker(4);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        this.StudioNK.deleteWorker(5);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        this.StudioCN.deleteWorker(5);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void deleteScriptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteScriptsActionPerformed
        this.StudioCN.deleteWorker(0);
    }//GEN-LAST:event_deleteScriptsActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        this.StudioCN.deleteWorker(1);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        this.StudioCN.deleteWorker(2);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        this.StudioCN.deleteWorker(3);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        this.StudioCN.deleteWorker(4);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        this.StudioCN.addWorker(1);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        this.StudioCN.addWorker(2);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        this.StudioCN.addWorker(3);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        this.StudioCN.addWorker(4);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        this.StudioCN.addWorker(5);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void sumScriptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumScriptsActionPerformed
        this.StudioCN.addWorker(0);
    }//GEN-LAST:event_sumScriptsActionPerformed

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
    private javax.swing.JButton deleteScripts;
    private javax.swing.JTextField designerQtty;
    private javax.swing.JLabel directorStateLabel;
    private javax.swing.JLabel directorStateLabelNK;
    private javax.swing.JLabel doblajesDisp;
    private javax.swing.JLabel doblajesDispNK;
    private javax.swing.JLabel doblajesMax;
    private javax.swing.JLabel doblajesMax1;
    private javax.swing.JLabel escenariosDisp;
    private javax.swing.JLabel escenariosDispNK;
    private javax.swing.JLabel escenariosMax;
    private javax.swing.JLabel escenariosMax1;
    private javax.swing.JLabel guionesDisp;
    private javax.swing.JLabel guionesDispNK;
    private javax.swing.JLabel guionesMax;
    private javax.swing.JLabel guionesMax1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel numAnimators;
    private javax.swing.JLabel numAnimators1;
    private javax.swing.JLabel numAssemblers;
    private javax.swing.JLabel numAssemblers1;
    private javax.swing.JLabel numDesigners;
    private javax.swing.JLabel numDesigners1;
    private javax.swing.JLabel numDubbers;
    private javax.swing.JLabel numDubbers1;
    private javax.swing.JLabel numPlotTwisters;
    private javax.swing.JLabel numPlotTwisters1;
    private javax.swing.JLabel numScripters;
    private javax.swing.JLabel numScripters1;
    private javax.swing.JTextField plotTwistWritterQtty;
    private javax.swing.JLabel plotwistsDisp;
    private javax.swing.JLabel plotwistsDispNK;
    private javax.swing.JLabel plotwistsMax;
    private javax.swing.JLabel plotwistsMax1;
    private javax.swing.JLabel pmFaultsLabel;
    private javax.swing.JLabel pmFaultsLabel1;
    private javax.swing.JLabel pmFaultsLabel2;
    private javax.swing.JLabel pmFaultsLabel3;
    private javax.swing.JLabel pmFaultsLabel4;
    private javax.swing.JLabel pmFaultsLabelNK;
    private javax.swing.JLabel pmMoneyLost1;
    private javax.swing.JLabel pmMoneyLost1NK;
    private javax.swing.JLabel pmMoneyLost1NK1;
    private javax.swing.JLabel pmMoneyLost1NK2;
    private javax.swing.JLabel pmMoneyLost1NK3;
    private javax.swing.JLabel pmStateLabel;
    private javax.swing.JLabel pmStateLabelNK;
    private javax.swing.JButton saveChanges;
    private javax.swing.JTextField screenWriterQtty;
    private javax.swing.JTextField shippingDeadline;
    private javax.swing.JButton sumScripts;
    private javax.swing.JLabel totalEarningsLabel;
    private javax.swing.JLabel totalEarningsLabelNK;
    private javax.swing.JLabel utilidadTotal;
    private javax.swing.JLabel utilidadTotal2;
    private javax.swing.JTextField voiceActorsQtty;
    // End of variables declaration//GEN-END:variables
}
