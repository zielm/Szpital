/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import encje.Pacjent;
import encje.Upowaznienie;
import inne.EdytowanieJPanel;
import inne.OnlyNumberFormatter;
import java.awt.CardLayout;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import zarzadzanie.Main;


/**
 *
 * @author Monika
 */
public class PacjentEdytujJPanel extends EdytowanieJPanel {
    
    Pacjent pacjent;
    
    /**
     * Creates new form Wizyta
     */
    public PacjentEdytujJPanel(Pacjent nowyPacjent) {
        pacjent = nowyPacjent;
        initComponents();
        setDanePacjenta();
        
        modelUpowaznieniaTable = (DefaultTableModel)upowaznieniaTable.getModel();
        cardLayout = (CardLayout)this.getLayout();
        
        setTabelaUpowaznien();
    }

    private void setDanePacjenta() {
        peselText.setDocument(new OnlyNumberFormatter(11));
        telefonText.setDocument(new OnlyNumberFormatter(11));
        
        idText.setText(pacjent.getIdPacjenta().toString());
        if(pacjent.getPesel() != null) {
            peselText.setText(pacjent.getPesel());
            String wiek = Main.getEntityManager()
                    .createNativeQuery("SELECT getWiek( ?1 ) FROM DUAL")
                    .setParameter(1, pacjent.getPesel())
                    .getSingleResult().toString();
            wiekText.setText(wiek);
        }
        if(pacjent.getPlec() != null) {
            if (pacjent.getPlec() == 'K') {
                plecComboBox.setSelectedIndex(1);
            }
            else plecComboBox.setSelectedIndex(2);
        }
        
        imieText.setText(pacjent.getImie());
        drugieText.setText(pacjent.getDrugieImie());
        nazwiskoText.setText(pacjent.getNazwisko());
        rodoweText.setText(pacjent.getNazwiskoRodowe());
        adresText.setText(pacjent.getAdres());
        miejsceText.setText(pacjent.getMiejsceUrodzenia());
        if (pacjent.getNumerTelefonu() != null) {
            telefonText.setText(pacjent.getNumerTelefonu().toString());
        }
        
        stanLabel.setText("");
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
        edytujUpowaznienieButton = new javax.swing.JButton();
        miejsceLabel = new javax.swing.JLabel();
        miejsceText = new javax.swing.JTextField();
        imieLabel = new javax.swing.JLabel();
        drugieText = new javax.swing.JTextField();
        rodoweText = new javax.swing.JTextField();
        telefonLabel = new javax.swing.JLabel();
        peselText = new javax.swing.JTextField();
        plecLabel = new javax.swing.JLabel();
        drugieLabel = new javax.swing.JLabel();
        telefonText = new javax.swing.JTextField();
        zapiszPacjentaButton = new javax.swing.JButton();
        wiekText = new javax.swing.JFormattedTextField();
        rodoweLabel = new javax.swing.JLabel();
        adresText = new javax.swing.JTextField();
        wyjdzButton = new javax.swing.JButton();
        peselLabel = new javax.swing.JLabel();
        wiekLabel = new javax.swing.JLabel();
        stanLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        upowaznieniaTable = new javax.swing.JTable();
        upowaznieniaLabel = new javax.swing.JLabel();
        plecComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        przywrocButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        upowaznienieButton = new javax.swing.JButton();
        nazwiskoText = new javax.swing.JTextField();
        adresLabel = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        imieText = new javax.swing.JTextField();
        nazwiskoLabel = new javax.swing.JLabel();
        usunUpowaznienieButton = new javax.swing.JButton();
        usunPacjentaButton = new javax.swing.JButton();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        setLayout(new java.awt.CardLayout());

        edytujUpowaznienieButton.setText("Edytuj wybrane upoważnienie");
        edytujUpowaznienieButton.setEnabled(false);
        edytujUpowaznienieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edytujUpowaznienieButtonActionPerformed(evt);
            }
        });

        miejsceLabel.setText("Miejsce ur.:");

        miejsceText.setName(""); // NOI18N

        imieLabel.setText("Imię:");

        drugieText.setName(""); // NOI18N

        rodoweText.setName(""); // NOI18N

        telefonLabel.setText("Telefon:");

        plecLabel.setText("Płeć:");

        drugieLabel.setText("Drugie imię:");

        telefonText.setName(""); // NOI18N

        zapiszPacjentaButton.setText("Zapisz zmiany");
        zapiszPacjentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapiszPacjentaButtonActionPerformed(evt);
            }
        });

        wiekText.setEditable(false);
        wiekText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        rodoweLabel.setText("Nazw. rodowe:");

        adresText.setName(""); // NOI18N

        wyjdzButton.setText("Wróć");
        wyjdzButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyjdzButtonActionPerformed(evt);
            }
        });

        peselLabel.setText("Pesel:");

        wiekLabel.setText("Wiek:");

        stanLabel.setText("Stan: aktualny");

        upowaznieniaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "st. pokr.", "imie", "nazwisko", "numer telefonu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
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

        upowaznieniaLabel.setText("Upoważnienia:");

        plecComboBox.setBackground(new java.awt.Color(255, 255, 204));
        plecComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "K", "M" }));
        plecComboBox.setEnabled(false);

        jLabel2.setText("Id:");

        przywrocButton.setText("Przywróć dane");
        przywrocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przywrocButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Edytuj pacjenta:");

        upowaznienieButton.setText("Dodaj nowe upoważnienie");
        upowaznienieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upowaznienieButtonActionPerformed(evt);
            }
        });

        nazwiskoText.setName(""); // NOI18N

        adresLabel.setText("Adres:");

        idText.setEnabled(false);

        imieText.setName(""); // NOI18N

        nazwiskoLabel.setText("Nazwisko:");

        usunUpowaznienieButton.setText("Usuń wybrane upoważnienie");
        usunUpowaznienieButton.setEnabled(false);
        usunUpowaznienieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunUpowaznienieButtonActionPerformed(evt);
            }
        });

        usunPacjentaButton.setText("Usuń pacjenta");
        usunPacjentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunPacjentaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                            .addComponent(przywrocButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(stanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(159, 159, 159))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(297, 297, 297)
                                                    .addComponent(wiekText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
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
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(peselLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(idText)
                                                    .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)
                                                .addComponent(wiekLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(80, 80, 80)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(edytujUpowaznienieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(usunUpowaznienieButton))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(upowaznieniaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(239, 239, 239))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(zapiszPacjentaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(usunPacjentaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(upowaznienieButton)))
                            .addGap(39, 39, 39)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(wyjdzButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(wyjdzButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(przywrocButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(peselLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(wiekLabel)
                        .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wiekText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(zapiszPacjentaButton)
                    .addComponent(usunPacjentaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(stanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upowaznieniaLabel)
                    .addComponent(upowaznienieButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void zapiszPacjentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszPacjentaButtonActionPerformed
        if(pacjent.getPesel() != null && peselText.getText().length() != 11) {
            odrzuc();
            return;
        }
        
        if (!peselText.getText().isEmpty()) {
            pacjent.setPesel(peselText.getText());
        }

        pacjent.setImie(imieText.getText());
        pacjent.setDrugieImie(drugieText.getText());
        pacjent.setNazwisko(nazwiskoText.getText());
        pacjent.setNazwiskoRodowe(rodoweText.getText());
        pacjent.setAdres(adresText.getText());
        pacjent.setMiejsceUrodzenia(miejsceText.getText());

        if (!telefonText.getText().isEmpty()) {
            pacjent.setNumerTelefonu(Long.parseLong(telefonText.getText()));
        }
        else pacjent.setNumerTelefonu(null);
        
        
        try {
            Main.getEntityManager().getTransaction().begin();
            Main.getEntityManager().persist(pacjent);
            Main.getEntityManager().getTransaction().commit();
            stanLabel.setText("Uaktualniono pacjenta");
            stanLabel.setForeground(Color.BLUE);
            upowaznienieButton.setEnabled(true);
            
        } catch (Exception SQLException) {
            odrzuc();
        }      
        
        
    }//GEN-LAST:event_zapiszPacjentaButtonActionPerformed

    private void przywrocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przywrocButtonActionPerformed
        setDanePacjenta();
        stanLabel.setText("");
    }//GEN-LAST:event_przywrocButtonActionPerformed

    private void upowaznieniaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upowaznieniaTableMouseClicked
        edytujUpowaznienieButton.setEnabled(true);
        usunUpowaznienieButton.setEnabled(true);
    }//GEN-LAST:event_upowaznieniaTableMouseClicked

    private void wyjdzButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyjdzButtonActionPerformed
        wroc();
    }//GEN-LAST:event_wyjdzButtonActionPerformed

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

    private void usunPacjentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunPacjentaButtonActionPerformed
        int odpowiedz = JOptionPane.showConfirmDialog(null,
            "Czy na pewno chcesz usunąć tego pacjenta?",
            "Usuń pacjenta",
            JOptionPane.YES_NO_OPTION);
        
        if(odpowiedz == JOptionPane.YES_OPTION) {
            Main.getEntityManager().getTransaction().begin();
            Main.getEntityManager().remove(pacjent);
            Main.getEntityManager().getTransaction().commit();
            
            super.wroc();          
        }
    }//GEN-LAST:event_usunPacjentaButtonActionPerformed
    
  
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adresLabel;
    private javax.swing.JTextField adresText;
    private javax.swing.JLabel drugieLabel;
    private javax.swing.JTextField drugieText;
    private javax.swing.JButton edytujUpowaznienieButton;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel imieLabel;
    private javax.swing.JTextField imieText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JButton przywrocButton;
    private javax.swing.JLabel rodoweLabel;
    private javax.swing.JTextField rodoweText;
    private javax.swing.JLabel stanLabel;
    private javax.swing.JLabel telefonLabel;
    private javax.swing.JTextField telefonText;
    private javax.swing.JLabel upowaznieniaLabel;
    private javax.swing.JTable upowaznieniaTable;
    private javax.swing.JButton upowaznienieButton;
    private javax.swing.JButton usunPacjentaButton;
    private javax.swing.JButton usunUpowaznienieButton;
    private javax.swing.JLabel wiekLabel;
    private javax.swing.JFormattedTextField wiekText;
    private javax.swing.JButton wyjdzButton;
    private javax.swing.JButton zapiszPacjentaButton;
    // End of variables declaration//GEN-END:variables
    CardLayout cardLayout;
    private DefaultTableModel modelUpowaznieniaTable;

    @Override
    public void odrzuc() {
        stanLabel.setText("Odrzucono pacjenta");
        stanLabel.setForeground(Color.red);    
    }
}
