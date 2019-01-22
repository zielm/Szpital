/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import inne.EdytowanieJPanel;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.util.ArrayList;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JButton;
import zarzadzanie.Main;

/**
 *
 * @author Monika
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        initExtra();
        
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        dodajWizyteButton = new javax.swing.JButton();
        przegladajWizytyButton = new javax.swing.JButton();
        przegladajPacjentowButton = new javax.swing.JButton();
        dodajPacjentaButton = new javax.swing.JButton();
        rozpoznaniaButton = new javax.swing.JButton();
        proceduryButton = new javax.swing.JButton();
        panelObsluga = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wizyty w szpitalu");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dodajWizyteButton.setText("Dodaj wizytę");
        dodajWizyteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajWizyteButtonActionPerformed(evt);
            }
        });

        przegladajWizytyButton.setText("Przeglądaj wizyty");
        przegladajWizytyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przegladajWizytyButtonActionPerformed(evt);
            }
        });

        przegladajPacjentowButton.setText("Przeglądaj pacjentów");
        przegladajPacjentowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przegladajPacjentowButtonActionPerformed(evt);
            }
        });

        dodajPacjentaButton.setText("Dodaj pacjenta");
        dodajPacjentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajPacjentaButtonActionPerformed(evt);
            }
        });

        rozpoznaniaButton.setText("Rozpoznania");
        rozpoznaniaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rozpoznaniaButtonActionPerformed(evt);
            }
        });

        proceduryButton.setText("Procedury");
        proceduryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceduryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(przegladajWizytyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dodajWizyteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(przegladajPacjentowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dodajPacjentaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rozpoznaniaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(proceduryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(dodajPacjentaButton)
                .addGap(18, 18, 18)
                .addComponent(przegladajPacjentowButton)
                .addGap(18, 18, 18)
                .addComponent(dodajWizyteButton)
                .addGap(18, 18, 18)
                .addComponent(przegladajWizytyButton)
                .addGap(48, 48, 48)
                .addComponent(rozpoznaniaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(proceduryButton)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        getContentPane().add(panelMenu);
        panelMenu.getAccessibleContext().setAccessibleName("");

        panelObsluga.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        panelObsluga.add(jPanel1, "card2");

        getContentPane().add(panelObsluga);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void initExtra() {
        cardsObsluga = (CardLayout) panelObsluga.getLayout();
        
        panelNowyPacjent = new PacjentNowyJPanel();
        panelObsluga.add(panelNowyPacjent);
        cardsObsluga.addLayoutComponent(panelNowyPacjent, "panelNowyPacjent");
        
        panelNowaWizyta = new WizytaNowaJPanel();
        panelObsluga.add(panelNowaWizyta);
        cardsObsluga.addLayoutComponent(panelNowaWizyta, "panelNowaWizyta");
        
        panelPacjenci = new PacjenciJPanel();
        panelObsluga.add(panelPacjenci);
        cardsObsluga.addLayoutComponent(panelPacjenci, "panelPacjenci");
        
        panelWizyty = new WizytyJPanel();
        panelObsluga.add(panelWizyty);
        cardsObsluga.addLayoutComponent(panelWizyty, "panelWizyty");
        
        panelProcedury = new ProceduryJPanel();
        panelObsluga.add(panelProcedury);
        cardsObsluga.addLayoutComponent(panelProcedury, "panelProcedury");
        
        panelRozpoznania = new RozpoznaniaJPanel();
        panelObsluga.add(panelRozpoznania);
        cardsObsluga.addLayoutComponent(panelRozpoznania, "panelRozpoznania");
    }
    
    private void dodajWizyteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajWizyteButtonActionPerformed
        cardsObsluga.show(panelObsluga, "panelNowaWizyta");
    }//GEN-LAST:event_dodajWizyteButtonActionPerformed

    private void przegladajWizytyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przegladajWizytyButtonActionPerformed
        cardsObsluga.show(panelObsluga, "panelWizyty");
    }//GEN-LAST:event_przegladajWizytyButtonActionPerformed

    private void dodajPacjentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajPacjentaButtonActionPerformed
        cardsObsluga.show(panelObsluga, "panelNowyPacjent");
    }//GEN-LAST:event_dodajPacjentaButtonActionPerformed

    private void przegladajPacjentowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przegladajPacjentowButtonActionPerformed
        cardsObsluga.show(panelObsluga, "panelPacjenci");
    }//GEN-LAST:event_przegladajPacjentowButtonActionPerformed

    private void proceduryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceduryButtonActionPerformed
        cardsObsluga.show(panelObsluga, "panelProcedury");
    }//GEN-LAST:event_proceduryButtonActionPerformed

    private void rozpoznaniaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rozpoznaniaButtonActionPerformed
        cardsObsluga.show(panelObsluga, "panelRozpoznania");
    }//GEN-LAST:event_rozpoznaniaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton dodajPacjentaButton;
    public javax.swing.JButton dodajWizyteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelObsluga;
    private javax.swing.JButton proceduryButton;
    public javax.swing.JButton przegladajPacjentowButton;
    public javax.swing.JButton przegladajWizytyButton;
    private javax.swing.JButton rozpoznaniaButton;
    // End of variables declaration//GEN-END:variables
    
    private CardLayout cardsObsluga;
    private WizytaNowaJPanel panelNowaWizyta;
    private PacjentNowyJPanel panelNowyPacjent;
    private PacjenciJPanel panelPacjenci;
    private WizytyJPanel panelWizyty;
    private EdytowanieJPanel panelRozpoznania;
    private EdytowanieJPanel panelProcedury;

    public ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttonsList = new ArrayList<>();
        buttonsList.add(dodajPacjentaButton);
        buttonsList.add(przegladajPacjentowButton);
        buttonsList.add(dodajWizyteButton);
        buttonsList.add(przegladajWizytyButton);
        buttonsList.add(rozpoznaniaButton);
        buttonsList.add(proceduryButton);
        return buttonsList;
    }
}