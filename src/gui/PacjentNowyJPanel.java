/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import encje.Pacjent;
import encje.Upowaznienie;
import inne.OnlyNumberFormatter;
import inne.EdytowanieJPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.Collection;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import zarzadzanie.Main;


/**
 *
 * @author Monika
 */
public class PacjentNowyJPanel extends EdytowanieJPanel {
    
    Pacjent pacjent;
    /**
     * Creates new form Wizyta
     */
    public PacjentNowyJPanel() {
        initComponents();
        peselText.setDocument(new OnlyNumberFormatter(11));
        telefonText.setDocument(new OnlyNumberFormatter(11));
        
        modelUpowaznieniaTable = (DefaultTableModel)upowaznieniaTable.getModel();
        cardLayout = (CardLayout)this.getLayout();
    }
    
    private void setTabelaUpowaznien() {
        modelUpowaznieniaTable.setRowCount(0);
        
        Collection<Upowaznienie> listaUpowaznien = pacjent.getUpowaznienieCollection();
//        System.out.println(pacjent.getIdPacjenta());

        for (Upowaznienie u : listaUpowaznien) {
            modelUpowaznieniaTable.addRow(new Object[]
            {u.getIdUpowaznienia(), u.getStopienPokrewiensta(), u.getImie(), 
                u.getNazwisko(), u.getNumerTelefonu()});
        }
        
        edytujUpowaznienieButton.setEnabled(false);
        usunUpowaznienieButton.setEnabled(false);
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
        imieText = new javax.swing.JTextField();
        wyczyscButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        upowaznieniaTable = new javax.swing.JTable();
        peselText = new javax.swing.JTextField();
        rodoweLabel = new javax.swing.JLabel();
        adresLabel = new javax.swing.JLabel();
        plecLabel = new javax.swing.JLabel();
        miejsceText = new javax.swing.JTextField();
        rodoweText = new javax.swing.JTextField();
        imieLabel = new javax.swing.JLabel();
        telefonLabel = new javax.swing.JLabel();
        nazwiskoText = new javax.swing.JTextField();
        upowaznienieButton = new javax.swing.JButton();
        upowaznieniaLabel = new javax.swing.JLabel();
        dodajPacjentaButton = new javax.swing.JButton();
        drugieLabel = new javax.swing.JLabel();
        drugieText = new javax.swing.JTextField();
        stanLabel = new javax.swing.JLabel();
        adresText = new javax.swing.JTextField();
        nazwiskoLabel = new javax.swing.JLabel();
        miejsceLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        peselLabel = new javax.swing.JLabel();
        plecComboBox = new javax.swing.JComboBox<>();
        telefonText = new javax.swing.JTextField();
        edytujUpowaznienieButton = new javax.swing.JButton();
        usunUpowaznienieButton = new javax.swing.JButton();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.CardLayout());

        imieText.setBackground(new java.awt.Color(204, 255, 204));
        imieText.setName(""); // NOI18N

        wyczyscButton.setText("Wyczyść dane");
        wyczyscButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyczyscButtonActionPerformed(evt);
            }
        });

        upowaznieniaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "st. pokr.", "imie", "nazwisko", "numer telefonu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        upowaznieniaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upowaznieniaTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(upowaznieniaTable);

        peselText.setBackground(new java.awt.Color(255, 255, 204));

        rodoweLabel.setText("Nazw. rodowe:");

        adresLabel.setText("Adres:");

        plecLabel.setText("Płeć:");

        miejsceText.setName(""); // NOI18N

        rodoweText.setName(""); // NOI18N

        imieLabel.setText("Imię:");

        telefonLabel.setText("Telefon:");

        nazwiskoText.setBackground(new java.awt.Color(204, 255, 204));
        nazwiskoText.setName(""); // NOI18N

        upowaznienieButton.setText("Dodaj upoważnienie");
        upowaznienieButton.setEnabled(false);
        upowaznienieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upowaznienieButtonActionPerformed(evt);
            }
        });

        upowaznieniaLabel.setText("Upoważnienia:");

        dodajPacjentaButton.setText("Dodaj pacjenta");
        dodajPacjentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajPacjentaButtonActionPerformed(evt);
            }
        });

        drugieLabel.setText("Drugie imię:");

        drugieText.setName(""); // NOI18N

        stanLabel.setText("stan");

        adresText.setName(""); // NOI18N

        nazwiskoLabel.setText("Nazwisko:");

        miejsceLabel.setText("Miejsce ur.:");

        jLabel1.setText("Dodaj pacjenta:");

        peselLabel.setText("Pesel:");

        plecComboBox.setBackground(new java.awt.Color(255, 255, 204));
        plecComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "K", "M" }));

        telefonText.setName(""); // NOI18N

        edytujUpowaznienieButton.setText("Edytuj wybrane upoważnienie");
        edytujUpowaznienieButton.setEnabled(false);
        edytujUpowaznienieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edytujUpowaznienieButtonActionPerformed(evt);
            }
        });

        usunUpowaznienieButton.setText("Usuń wybrane upoważnienie");
        usunUpowaznienieButton.setEnabled(false);
        usunUpowaznienieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunUpowaznienieButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(upowaznieniaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(270, 270, 270)
                                .addComponent(upowaznienieButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(miejsceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(telefonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(miejsceText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(telefonText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(adresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(adresText, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(peselLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(nazwiskoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(imieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(imieText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(plecLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(plecComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(drugieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(drugieText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rodoweLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rodoweText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(stanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dodajPacjentaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(98, 98, 98)
                                    .addComponent(wyczyscButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(400, 400, 400)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(edytujUpowaznienieButton)
                .addGap(18, 18, 18)
                .addComponent(usunUpowaznienieButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(peselLabel)
                    .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plecLabel)
                    .addComponent(plecComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imieLabel)
                    .addComponent(imieText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drugieText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drugieLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rodoweLabel)
                        .addComponent(rodoweText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nazwiskoLabel)
                        .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresLabel)
                    .addComponent(adresText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miejsceLabel)
                    .addComponent(miejsceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonLabel)
                    .addComponent(telefonText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dodajPacjentaButton)
                    .addComponent(wyczyscButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stanLabel)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upowaznieniaLabel)
                    .addComponent(upowaznienieButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edytujUpowaznienieButton)
                    .addComponent(usunUpowaznienieButton))
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void upowaznienieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upowaznienieButtonActionPerformed
        UpowaznienieJPanel upowaznienieJPanel = new UpowaznienieJPanel(pacjent);
        this.add(upowaznienieJPanel);
        cardLayout.addLayoutComponent(upowaznienieJPanel, "upowaznienie");
        cardLayout.show(this, "upowaznienie");
        super.blockButtonsOnMainPanel();
    }//GEN-LAST:event_upowaznienieButtonActionPerformed

    private void dodajPacjentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajPacjentaButtonActionPerformed
        Pacjent nowyPacjent = new Pacjent();
        
        if((peselText.getText().length() != 11 && plecComboBox.getSelectedIndex() == 0) ||
                imieText.getText().isEmpty() || nazwiskoText.getText().isEmpty()) {
            odrzuc();
            return;
        }
        
        
        if (!peselText.getText().isEmpty()) {
            nowyPacjent.setPesel(peselText.getText());                    
        }
        
        if(plecComboBox.getSelectedIndex() != 0) {
            nowyPacjent.setPlec(plecComboBox.getSelectedItem().toString().charAt(0));
        }
        nowyPacjent.setImie(imieText.getText());
        nowyPacjent.setDrugieImie(drugieText.getText());
        nowyPacjent.setNazwisko(nazwiskoText.getText());
        nowyPacjent.setNazwiskoRodowe(rodoweText.getText());
        nowyPacjent.setAdres(adresText.getText());
        nowyPacjent.setMiejsceUrodzenia(miejsceText.getText());

        if (!telefonText.getText().isEmpty()) {
            nowyPacjent.setNumerTelefonu(Long.parseLong(telefonText.getText()));
        }
        
        
        try {
            Main.getEntityManager().getTransaction().begin();
            Main.getEntityManager().persist(nowyPacjent);
            Main.getEntityManager().getTransaction().commit();
            stanLabel.setText("Dodano pacjenta");
            stanLabel.setForeground(Color.BLUE);
            dodajPacjentaButton.setEnabled(false);
            upowaznienieButton.setEnabled(true);
            System.out.println("dodano");
            List<Pacjent> pacjenci = Main.getEntityManager().
                    createNamedQuery("Pacjent.findAll").getResultList();
            pacjent = pacjenci.get(pacjenci.size()-1);

        } catch (Exception SQLException) {
            odrzuc();
            return;
        }      
        
        try {
            if(pacjent.getPesel() != null) {
                Main.getEntityManager().getTransaction().begin();
                StoredProcedureQuery query = Main.getEntityManager()
                    .createStoredProcedureQuery("okreslPlec")
                    .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                    .setParameter(1, pacjent.getPesel());
                query.executeUpdate();
                Main.getEntityManager().getTransaction().commit();
                Main.getEntityManager().refresh(pacjent);
            }
        } catch (Exception SQLException) {
            return;
        }      
        
    }//GEN-LAST:event_dodajPacjentaButtonActionPerformed

    private void wyczyscButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyczyscButtonActionPerformed
        super.zerujWszystko();
        stanLabel.setText("");
        upowaznienieButton.setEnabled(false);
        edytujUpowaznienieButton.setEnabled(false);
        dodajPacjentaButton.setEnabled(true);
        modelUpowaznieniaTable.setRowCount(0);
        upowaznienieButton.setEnabled(false);
        edytujUpowaznienieButton.setEnabled(false);
        usunUpowaznienieButton.setEnabled(false);
    }//GEN-LAST:event_wyczyscButtonActionPerformed

    private void edytujUpowaznienieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edytujUpowaznienieButtonActionPerformed
        long idUpowaznienia = (long)upowaznieniaTable.getValueAt(upowaznieniaTable.getSelectedRow(), 0);
        Upowaznienie upowaznienie = Main.getEntityManager().find(Upowaznienie.class, idUpowaznienia);
        UpowaznienieJPanel edycjaUpowaznienia = new UpowaznienieJPanel(upowaznienie);
        this.add(edycjaUpowaznienia);
        cardLayout.addLayoutComponent(edycjaUpowaznienia, "upowaznienie");
        cardLayout.show(this, "upowaznienie");

        super.blockButtonsOnMainPanel();
    }//GEN-LAST:event_edytujUpowaznienieButtonActionPerformed

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
        setTabelaUpowaznien();
    }//GEN-LAST:event_formComponentRemoved

    private void usunUpowaznienieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunUpowaznienieButtonActionPerformed
        int odpowiedz = JOptionPane.showConfirmDialog(null,
            "Czy na pewno chcesz usunąć to upoważnienie?",
            "Usuń upoważnienie",
            JOptionPane.YES_NO_OPTION);
        
        if(odpowiedz == JOptionPane.YES_OPTION) {
            long idUpowaznienia = (long)upowaznieniaTable.getValueAt(upowaznieniaTable.getSelectedRow(), 0);
            Upowaznienie upowaznienie = Main.getEntityManager().find(Upowaznienie.class, idUpowaznienia);
            
            Main.getEntityManager().getTransaction().begin();
            Main.getEntityManager().remove(upowaznienie);
            Main.getEntityManager().getTransaction().commit();
            
            setTabelaUpowaznien();

        }
    }//GEN-LAST:event_usunUpowaznienieButtonActionPerformed

    private void upowaznieniaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upowaznieniaTableMouseClicked
        usunUpowaznienieButton.setEnabled(true);
        edytujUpowaznienieButton.setEnabled(true);
    }//GEN-LAST:event_upowaznieniaTableMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        zerujWszystko();
        pacjent = null;
        dodajPacjentaButton.setEnabled(true);
    }//GEN-LAST:event_formComponentShown
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adresLabel;
    private javax.swing.JTextField adresText;
    private javax.swing.JButton dodajPacjentaButton;
    private javax.swing.JLabel drugieLabel;
    private javax.swing.JTextField drugieText;
    private javax.swing.JButton edytujUpowaznienieButton;
    private javax.swing.JLabel imieLabel;
    private javax.swing.JTextField imieText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel miejsceLabel;
    private javax.swing.JTextField miejsceText;
    private javax.swing.JLabel nazwiskoLabel;
    private javax.swing.JTextField nazwiskoText;
    private javax.swing.JLabel peselLabel;
    private javax.swing.JTextField peselText;
    private javax.swing.JComboBox<String> plecComboBox;
    private javax.swing.JLabel plecLabel;
    private javax.swing.JLabel rodoweLabel;
    private javax.swing.JTextField rodoweText;
    private javax.swing.JLabel stanLabel;
    private javax.swing.JLabel telefonLabel;
    private javax.swing.JTextField telefonText;
    private javax.swing.JLabel upowaznieniaLabel;
    private javax.swing.JTable upowaznieniaTable;
    private javax.swing.JButton upowaznienieButton;
    private javax.swing.JButton usunUpowaznienieButton;
    private javax.swing.JButton wyczyscButton;
    // End of variables declaration//GEN-END:variables
    CardLayout cardLayout;
    private DefaultTableModel modelUpowaznieniaTable;

    @Override
    public void odrzuc() {
        stanLabel.setText("Odrzucono pacjenta");
        stanLabel.setForeground(Color.red);
    }
}