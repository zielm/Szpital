/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import encje.Pacjent;
import encje.Wizyta;
import inne.EdytowanieJPanel;
import inne.OnlyNumberFormatter;
import java.awt.Color;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import zarzadzanie.Main;

/**
 *
 * @author Monika
 */
public class WizytaNowaJPanel extends EdytowanieJPanel {
    
    private Pacjent pacjent;
    private boolean dlaKonkretnegoPacjenta = false;
    /**
     * Creates new form Wizyta
     */
    public WizytaNowaJPanel() {
        initComponents();
        pacjent = null;
        peselText.setDocument(new OnlyNumberFormatter(11));
        wrocButton.setVisible(false);
    }
    
    
    public WizytaNowaJPanel(Pacjent p) {
        initComponents();
        pacjent = p;
        peselButton.setVisible(false);
        nnButton.setVisible(false);
        dlaKonkretnegoPacjenta = true;
        uzupelnijDanePacjenta();
    }
    
    private void uzupelnijDanePacjenta() {
        if(pacjent.getPesel() != null) {
            peselText.setText(pacjent.getPesel());
        }

        if (pacjent.getPlec() == 'K') {
            plecComboBox.setSelectedIndex(1);
        }
        else plecComboBox.setSelectedIndex(2);

        imieText.setText(pacjent.getImie());
        drugieText.setText(pacjent.getDrugieImie());
        nazwiskoText.setText(pacjent.getNazwisko());
        rodoweText.setText(pacjent.getNazwiskoRodowe());
        adresText.setText(pacjent.getAdres());
        miejsceText.setText(pacjent.getMiejsceUrodzenia());
        if (pacjent.getNumerTelefonu() != null) {
            telefonText.setText(pacjent.getNumerTelefonu().toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        peselLabel = new javax.swing.JLabel();
        peselText = new javax.swing.JTextField();
        peselButton = new javax.swing.JButton();
        dataLabel = new javax.swing.JLabel();
        pacjentPanel = new javax.swing.JPanel();
        plecLabel = new javax.swing.JLabel();
        imieLabel = new javax.swing.JLabel();
        nazwiskoLabel = new javax.swing.JLabel();
        adresLabel = new javax.swing.JLabel();
        miejsceLabel = new javax.swing.JLabel();
        miejsceText = new javax.swing.JTextField();
        adresText = new javax.swing.JTextField();
        nazwiskoText = new javax.swing.JTextField();
        imieText = new javax.swing.JTextField();
        drugieLabel = new javax.swing.JLabel();
        rodoweLabel = new javax.swing.JLabel();
        telefonLabel = new javax.swing.JLabel();
        telefonText = new javax.swing.JTextField();
        rodoweText = new javax.swing.JTextField();
        drugieText = new javax.swing.JTextField();
        plecComboBox = new javax.swing.JComboBox<>();
        nnButton = new javax.swing.JButton();
        lekarzLabel = new javax.swing.JLabel();
        lekarzText = new javax.swing.JTextField();
        opisLabel = new javax.swing.JLabel();
        opisTextArea = new javax.swing.JTextArea();
        stanLabel = new javax.swing.JLabel();
        dataText = new javax.swing.JFormattedTextField();
        zapiszButton = new javax.swing.JButton();
        stanWizytyLabel = new javax.swing.JLabel();
        wrocButton = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        peselLabel.setText("Pesel:");

        peselText.setName(""); // NOI18N

        peselButton.setText("OK");
        peselButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peselButtonActionPerformed(evt);
            }
        });

        dataLabel.setText("Data przyjęcia:");

        plecLabel.setText("Płeć:");

        imieLabel.setText("Imię:");

        nazwiskoLabel.setText("Nazwisko:");

        adresLabel.setText("Adres:");

        miejsceLabel.setText("Miejsce ur.:");

        miejsceText.setEnabled(false);
        miejsceText.setName(""); // NOI18N

        adresText.setEnabled(false);
        adresText.setName(""); // NOI18N

        nazwiskoText.setEnabled(false);
        nazwiskoText.setName(""); // NOI18N

        imieText.setEnabled(false);
        imieText.setName(""); // NOI18N

        drugieLabel.setText("Drugie imię:");

        rodoweLabel.setText("Nazw. rodowe:");

        telefonLabel.setText("Telefon:");

        telefonText.setEnabled(false);
        telefonText.setName(""); // NOI18N

        rodoweText.setEnabled(false);
        rodoweText.setName(""); // NOI18N

        drugieText.setEnabled(false);
        drugieText.setName(""); // NOI18N

        plecComboBox.setBackground(new java.awt.Color(255, 255, 204));
        plecComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "K", "M" }));
        plecComboBox.setEnabled(false);

        javax.swing.GroupLayout pacjentPanelLayout = new javax.swing.GroupLayout(pacjentPanel);
        pacjentPanel.setLayout(pacjentPanelLayout);
        pacjentPanelLayout.setHorizontalGroup(
            pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pacjentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pacjentPanelLayout.createSequentialGroup()
                        .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(miejsceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(miejsceText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pacjentPanelLayout.createSequentialGroup()
                        .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pacjentPanelLayout.createSequentialGroup()
                                .addComponent(nazwiskoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pacjentPanelLayout.createSequentialGroup()
                                .addComponent(imieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imieText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pacjentPanelLayout.createSequentialGroup()
                                .addComponent(plecLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(plecComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)))
                        .addGap(18, 18, 18)
                        .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pacjentPanelLayout.createSequentialGroup()
                                .addComponent(drugieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(drugieText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pacjentPanelLayout.createSequentialGroup()
                                .addComponent(rodoweLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rodoweText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pacjentPanelLayout.createSequentialGroup()
                        .addComponent(adresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adresText, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pacjentPanelLayout.setVerticalGroup(
            pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pacjentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plecLabel)
                    .addComponent(plecComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imieLabel)
                    .addComponent(imieText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drugieText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drugieLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rodoweLabel)
                        .addComponent(rodoweText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nazwiskoLabel)
                        .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresLabel)
                    .addComponent(adresText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miejsceLabel)
                    .addComponent(miejsceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pacjentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonLabel)
                    .addComponent(telefonText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        nnButton.setText("N/N");
        nnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nnButtonActionPerformed(evt);
            }
        });

        lekarzLabel.setText("Lekarz prowadzący:");

        lekarzText.setBackground(new java.awt.Color(204, 255, 204));
        lekarzText.setName(""); // NOI18N

        opisLabel.setText("Opis dolegliwości:");

        opisTextArea.setColumns(20);
        opisTextArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        opisTextArea.setRows(5);
        opisTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        stanLabel.setText(" ");

        dataText.setBackground(new java.awt.Color(204, 255, 204));
        dataText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        zapiszButton.setText("Stwórz wizytę");
        zapiszButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapiszButtonActionPerformed(evt);
            }
        });

        stanWizytyLabel.setText(" ");

        wrocButton.setText("Wróć");
        wrocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wrocButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dataLabel)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(opisLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(opisTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(stanWizytyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(lekarzLabel)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dataText)
                                            .addComponent(lekarzText, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pacjentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(peselLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(peselButton)
                                .addGap(68, 68, 68)
                                .addComponent(nnButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wrocButton)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(zapiszButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(peselLabel)
                            .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peselButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(wrocButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stanLabel)
                .addGap(8, 8, 8)
                .addComponent(pacjentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel)
                    .addComponent(dataText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lekarzLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lekarzText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opisLabel)
                    .addComponent(opisTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zapiszButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stanWizytyLabel)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        stanLabel.getAccessibleContext().setAccessibleName("stanLabel");

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void peselButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peselButtonActionPerformed
                
        if (peselText.getText().isEmpty() || peselText.getText().length() != 11) {
            stanLabel.setText("Błędny pesel");
            stanLabel.setForeground(Color.red);
            return;
        }
        
        pacjent = Main.getEntityManager().createNamedQuery("Pacjent.findByPesel", Pacjent.class).
                setParameter("pesel", peselText.getText()).getSingleResult();
        
        if (pacjent != null) {
            stanLabel.setText("Znaleziono pacjenta");
            stanLabel.setForeground(Color.blue);
            
            uzupelnijDanePacjenta();
        }
        
        nnButton.setEnabled(false);
        peselButton.setEnabled(false);
        
        
        
    }//GEN-LAST:event_peselButtonActionPerformed

    private void nnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nnButtonActionPerformed
        plecComboBox.setEnabled(true);
        pacjent = null;
    }//GEN-LAST:event_nnButtonActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        if(!dlaKonkretnegoPacjenta) {
            zerujWszystko();
            pacjent = null;
            nnButton.setEnabled(true);
            peselText.setEnabled(true);
            peselButton.setEnabled(true);
            zapiszButton.setEnabled(true);
        }
        String stringData = dateFormat.format(new Date());
        dataText.setText(stringData);
    }//GEN-LAST:event_formComponentShown

    private void zapiszButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszButtonActionPerformed
        if(plecComboBox.getSelectedIndex() == 0) {
            odrzuc();
            return;
        }
        
        Wizyta wizyta = new Wizyta();
        Date dataPrzyjecia;
        try {
            dataPrzyjecia = dateFormat.parse(dataText.getText());
        } catch (ParseException ex) {
            Logger.getLogger(WizytaNowaJPanel.class.getName()).log(Level.SEVERE, null, ex);
            odrzuc();
            return;
        }
        
        wizyta.setDataPrzyjecia(dataPrzyjecia);
        wizyta.setLekarzProwadzacy(lekarzText.getText());
        wizyta.setOpisDolegliwosci(opisTextArea.getText());
        

        if (pacjent == null) {
            pacjent = new Pacjent();
            pacjent.setNazwisko("N/N");
            pacjent.setPlec(plecComboBox.getSelectedItem().toString().charAt(0));
            Main.getEntityManager().getTransaction().begin();
            Main.getEntityManager().persist(pacjent);
            Main.getEntityManager().getTransaction().commit();
            
            List<Pacjent> lista = Main.getEntityManager().createNamedQuery("Pacjent.findAll").getResultList();
            pacjent = lista.get(lista.size()-1);            
            blockButtonsOnMainPanel();
            peselText.setEnabled(false);
            peselButton.setEnabled(false);
            stanLabel.setText("Dodano N/N");
            stanLabel.setForeground(Color.blue);
        }
        
        
        
        try {
            
            Main.getEntityManager().getTransaction().begin();
                       
            wizyta.setIdPacjenta(pacjent);
            Main.getEntityManager().persist(wizyta);           

            Main.getEntityManager().getTransaction().commit();
            stanLabel.setText("Dodano wizytę");
            stanLabel.setForeground(Color.BLUE);
            zapiszButton.setEnabled(false);
            
            if(!dlaKonkretnegoPacjenta) {
                unblockButtonsOnMainPanel();
            }
            
        } catch (Exception SQLException) {
            odrzuc();
        }    
        
        
    }//GEN-LAST:event_zapiszButtonActionPerformed

    private void wrocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wrocButtonActionPerformed
        wroc();
    }//GEN-LAST:event_wrocButtonActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adresLabel;
    private javax.swing.JTextField adresText;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JFormattedTextField dataText;
    private javax.swing.JLabel drugieLabel;
    private javax.swing.JTextField drugieText;
    private javax.swing.JLabel imieLabel;
    private javax.swing.JTextField imieText;
    private javax.swing.JLabel lekarzLabel;
    private javax.swing.JTextField lekarzText;
    private javax.swing.JLabel miejsceLabel;
    private javax.swing.JTextField miejsceText;
    private javax.swing.JLabel nazwiskoLabel;
    private javax.swing.JTextField nazwiskoText;
    private javax.swing.JButton nnButton;
    private javax.swing.JLabel opisLabel;
    private javax.swing.JTextArea opisTextArea;
    private javax.swing.JPanel pacjentPanel;
    private javax.swing.JButton peselButton;
    private javax.swing.JLabel peselLabel;
    private javax.swing.JTextField peselText;
    private javax.swing.JComboBox<String> plecComboBox;
    private javax.swing.JLabel plecLabel;
    private javax.swing.JLabel rodoweLabel;
    private javax.swing.JTextField rodoweText;
    private javax.swing.JLabel stanLabel;
    private javax.swing.JLabel stanWizytyLabel;
    private javax.swing.JLabel telefonLabel;
    private javax.swing.JTextField telefonText;
    private javax.swing.JButton wrocButton;
    private javax.swing.JButton zapiszButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void odrzuc() {
        stanLabel.setText("Odrzucono wizytę");
        stanLabel.setForeground(Color.red);    
    }
}
