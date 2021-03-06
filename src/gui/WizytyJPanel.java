/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import encje.Pacjent;
import encje.Wizyta;
import encje.WizytaPacjenta;
import inne.EdytowanieJPanel;
import java.awt.CardLayout;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import zarzadzanie.Main;

/**
 *
 * @author Monika
 */
public class WizytyJPanel extends EdytowanieJPanel {

    /**
     * Creates new form PacjenciPanel
     */
    public WizytyJPanel() {
        initComponents();
        cardLayout = (CardLayout)this.getLayout();
        modelWizytyTable = (DefaultTableModel)wizytyTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        wyszukajButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        wizytyTable = new javax.swing.JTable();
        edytujWizyteButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        wizytyTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        peselText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nazwiskoText = new javax.swing.JTextField();
        dataPrzyjeciaText = new javax.swing.JFormattedTextField();

        setLayout(new java.awt.CardLayout());

        jLabel1.setText("Wyszukaj wizyty:");

        wyszukajButton.setText("Wyszukaj");
        wyszukajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyszukajButtonActionPerformed(evt);
            }
        });

        wizytyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "data przyjęcia", "data wypisu", "imie", "nazwisko", "pesel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        wizytyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wizytyTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(wizytyTable);

        edytujWizyteButton.setText("Edytuj wizytę");
        edytujWizyteButton.setEnabled(false);
        edytujWizyteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edytujWizyteButtonActionPerformed(evt);
            }
        });

        wizytyTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "data przyjęcia", "data wypisu", "imie", "nazwisko", "pesel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        wizytyTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wizytyTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(wizytyTable1);

        jLabel3.setText("Przyjęcie:");

        jLabel4.setText("Pesel:");

        peselText.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel2.setText("Nazwisko:");

        dataPrzyjeciaText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(edytujWizyteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(peselText, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(nazwiskoText)
                            .addComponent(dataPrzyjeciaText))
                        .addGap(111, 111, 111)
                        .addComponent(wyszukajButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(dataPrzyjeciaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edytujWizyteButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(wyszukajButton)))
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents
    
    private void setWizytyTable() {
        modelWizytyTable.setRowCount(0);
        
        String pesel, nazwisko;
        Date data;
        
        nazwisko = nazwiskoText.getText();
        pesel = peselText.getText();
        
        if(!dataPrzyjeciaText.getText().isEmpty()) {
            try {
                data = dateFormat.parse(dataPrzyjeciaText.getText());
            } catch (ParseException ex) {
                Logger.getLogger(WizytyJPanel.class.getName()).log(Level.SEVERE, null, ex);
                data = null;
            }
        }
        else data = null;
        
        Query query = null;
        List<WizytaPacjenta> listaWizyt;

        // szukaj po nazwisku
        if(!nazwisko.isEmpty()) {
            query = Main.getEntityManager().createNamedQuery("WizytaPacjenta.findByNazwiskoLike").setParameter("nazwisko", nazwisko);
        }
        
        // szukaj po peselu
        else if(!pesel.isEmpty()) {
            query = Main.getEntityManager().createNamedQuery("WizytaPacjenta.findByPeselLike").setParameter("pesel", pesel);
        }
        
        else if(data != null) {
            query = Main.getEntityManager().createNamedQuery("WizytaPacjenta.findByDataPrzyjecia").setParameter("dataPrzyjecia", data);
        }
        
        
        else {
            query = Main.getEntityManager().createNamedQuery("WizytaPacjenta.findAll");
        }

        if(query != null) {
            listaWizyt = query.getResultList();
            for (WizytaPacjenta w : listaWizyt) {
                Date dataWypisu = w.getDataWypisu();
                String strDataWypisu = "";
                if(dataWypisu != null) {
                    strDataWypisu = dateFormat.format(w.getDataWypisu());
                }
                
                
                modelWizytyTable.addRow(new Object[]
                    {w.getIdWizyty(), 
                    dateFormat.format(w.getDataPrzyjecia()), 
                    strDataWypisu,
                    w.getImie(),
                    w.getNazwisko(), 
                    w.getPesel()});
            }
        }
    }
    
    private void wyszukajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyszukajButtonActionPerformed
        setWizytyTable();
        edytujWizyteButton.setEnabled(false);
    }//GEN-LAST:event_wyszukajButtonActionPerformed

    private void wizytyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wizytyTableMouseClicked
        edytujWizyteButton.setEnabled(true);
    }//GEN-LAST:event_wizytyTableMouseClicked

    private void edytujWizyteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edytujWizyteButtonActionPerformed
        if (wizytyTable.getSelectedRow() == -1 ) return;
        long idWizyty = (long)wizytyTable.getValueAt(wizytyTable.getSelectedRow(), 0);
        WizytaPacjenta wizyta = (WizytaPacjenta)
                Main.getEntityManager().createNamedQuery("WizytaPacjenta.findByIdWizyty").
                        setParameter("idWizyty", idWizyty).getSingleResult();

        WizytaEdycjaJPanel edycjaWizyta = new WizytaEdycjaJPanel(wizyta);
        this.add(edycjaWizyta);
        cardLayout.addLayoutComponent(edycjaWizyta, "edycja");
        cardLayout.show(this, "edycja");

        super.blockButtonsOnMainPanel();
    }//GEN-LAST:event_edytujWizyteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dataPrzyjeciaText;
    private javax.swing.JButton edytujWizyteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField nazwiskoText;
    private javax.swing.JTextField peselText;
    private javax.swing.JTable wizytyTable;
    private javax.swing.JTable wizytyTable1;
    private javax.swing.JButton wyszukajButton;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelWizytyTable;
    private CardLayout cardLayout;
    
    @Override
    public void odrzuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
