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
        
        Studio StudioCN = new Studio(Integer.parseInt(this.parametros[2]), Integer.parseInt(this.parametros[3]), Integer.parseInt(this.parametros[4]), Integer.parseInt(this.parametros[5]), Integer.parseInt(this.parametros[6]), 3000);
        System.out.println(StudioCN.animators.length);
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
        capitulosPlotListos = new javax.swing.JLabel();
        dineroDescTotalPM = new javax.swing.JTextField();
        cantFaltasPM = new javax.swing.JTextField();
        ensambladoresCont = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        guionesDisp = new javax.swing.JLabel();
        animacionesMax = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        escenariosDisp = new javax.swing.JLabel();
        doblajesMax = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        animacionesDisp1 = new javax.swing.JLabel();
        plotwistsMax = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        doblajesDisp1 = new javax.swing.JLabel();
        plotwistsDisp1 = new javax.swing.JLabel();
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
        diasFaltantes1 = new javax.swing.JLabel();
        pmStateLabel = new javax.swing.JLabel();
        directorStateLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        guionesMax = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        utilidadTotal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ganaciasTotal = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        escenariosMax = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

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

        capitulosPlotListos.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        capitulosPlotListos.setForeground(new java.awt.Color(0, 0, 0));
        capitulosPlotListos.setText("0");
        jPanel2.add(capitulosPlotListos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 40, 40));
        jPanel2.add(dineroDescTotalPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 30, -1));

        cantFaltasPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantFaltasPMActionPerformed(evt);
            }
        });
        jPanel2.add(cantFaltasPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 30, -1));

        ensambladoresCont.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        ensambladoresCont.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ensambladoresContStateChanged(evt);
            }
        });
        jPanel2.add(ensambladoresCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 40, 20));

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
        jPanel2.add(guionesDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 10, 40));

        animacionesMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        animacionesMax.setForeground(new java.awt.Color(0, 0, 0));
        animacionesMax.setText("0");
        jPanel2.add(animacionesMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 10, 40));

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Escenarios");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 80, 40));

        escenariosDisp.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        escenariosDisp.setForeground(new java.awt.Color(0, 0, 0));
        escenariosDisp.setText("0");
        jPanel2.add(escenariosDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 10, 40));

        doblajesMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        doblajesMax.setForeground(new java.awt.Color(0, 0, 0));
        doblajesMax.setText("0");
        jPanel2.add(doblajesMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 10, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Animaciones");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, 40));

        animacionesDisp1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        animacionesDisp1.setForeground(new java.awt.Color(0, 0, 0));
        animacionesDisp1.setText("0");
        jPanel2.add(animacionesDisp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 10, 40));

        plotwistsMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        plotwistsMax.setForeground(new java.awt.Color(0, 0, 0));
        plotwistsMax.setText("0");
        jPanel2.add(plotwistsMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 10, 40));

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Doblajes");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 90, 40));

        doblajesDisp1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        doblajesDisp1.setForeground(new java.awt.Color(0, 0, 0));
        doblajesDisp1.setText("0");
        jPanel2.add(doblajesDisp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 10, 40));

        plotwistsDisp1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        plotwistsDisp1.setForeground(new java.awt.Color(0, 0, 0));
        plotwistsDisp1.setText("0");
        jPanel2.add(plotwistsDisp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 10, 40));

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Guiones");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 40));

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Ensambladores");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 110, 40));

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
        jLabel40.setText("GANANCIA TOTAL = ");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 200, 50));

        diasFaltantes1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        diasFaltantes1.setForeground(new java.awt.Color(0, 0, 0));
        diasFaltantes1.setText("0");
        jPanel2.add(diasFaltantes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 60, 50));

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
        guionesMax.setText("0");
        jPanel2.add(guionesMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 20, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("0");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 160, 40));

        utilidadTotal.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        utilidadTotal.setForeground(new java.awt.Color(0, 0, 0));
        utilidadTotal.setText("0");
        jPanel2.add(utilidadTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 30, 50));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("TRABAJADORES y PARTES");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 310, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("CAPÍTULOS LISTOS ESTÁNDAR =");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 40));

        ganaciasTotal.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        ganaciasTotal.setForeground(new java.awt.Color(0, 0, 0));
        ganaciasTotal.setText("0");
        jPanel2.add(ganaciasTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 40, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("UTILIDAD TOTAL = ");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 200, 50));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("DÍAS PARA LA ENTREGA:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 240, 50));

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("CAPÍTULOS LISTOS PLOTWIST =");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 310, 40));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Drive");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 80, 40));

        escenariosMax.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        escenariosMax.setForeground(new java.awt.Color(0, 0, 0));
        escenariosMax.setText("0");
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

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/CNStudioFondo (1).png"))); // NOI18N
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setOpaque(true);
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 470));

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

    private void cantFaltasPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantFaltasPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantFaltasPMActionPerformed

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
    private javax.swing.JLabel animacionesDisp1;
    private javax.swing.JLabel animacionesMax;
    private javax.swing.JSpinner animadoresCont1;
    private javax.swing.JTextField animatorQtty;
    private javax.swing.JTextField assemblersQtty;
    private javax.swing.JTextField cantFaltasPM;
    private javax.swing.JLabel capitulosPlotListos;
    private javax.swing.JTextField dayDuration;
    private javax.swing.JTextField designerQtty;
    private javax.swing.JLabel diasFaltantes1;
    private javax.swing.JTextField dineroDescTotalPM;
    private javax.swing.JLabel directorStateLabel;
    private javax.swing.JSpinner diseñadorEsceCont1;
    private javax.swing.JSpinner dobladoresCont1;
    private javax.swing.JLabel doblajesDisp1;
    private javax.swing.JLabel doblajesMax;
    private javax.swing.JSpinner ensambladoresCont;
    private javax.swing.JLabel escenariosDisp;
    private javax.swing.JLabel escenariosMax;
    private javax.swing.JLabel ganaciasTotal;
    private javax.swing.JSpinner guionCont1;
    private javax.swing.JLabel guionesDisp;
    private javax.swing.JLabel guionesMax;
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
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField plotTwistWritterQtty;
    private javax.swing.JSpinner plotwistersCont1;
    private javax.swing.JLabel plotwistsDisp1;
    private javax.swing.JLabel plotwistsMax;
    private javax.swing.JLabel pmStateLabel;
    private javax.swing.JButton saveChanges;
    private javax.swing.JTextField screenWriterQtty;
    private javax.swing.JTextField shippingDeadline;
    private javax.swing.JLabel utilidadTotal;
    private javax.swing.JTextField voiceActorsQtty;
    // End of variables declaration//GEN-END:variables
}
