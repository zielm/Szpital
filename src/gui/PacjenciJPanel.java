/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import encje.Pacjent;
import inne.EdytowanieJPanel;
import inne.OnlyNumberFormatter;
import java.awt.CardLayout;
import java.util.List;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.PlainDocument;
import zarzadzanie.Main;

/**
 *
 * @author Monika
 */
public class PacjenciJPanel extends EdytowanieJPanel {

    /**
     * Creates new form PacjenciPanel
     */
    public PacjenciJPanel() {
        initComponents();
        modelPacjenciTable = (DefaultTableModel)pacjenciTable.getModel();
        peselText.setDocument(new OnlyNumberFormatter(11));
        cardLayout = (CardLayout)this.getLayout();
    }
    
    private void setPacjenciTable() {
        modelPacjenciTable.setRowCount(0);
        
        String nazwisko, pesel;
        
        nazwisko = nazwiskoText.getText();
        pesel = peselText.getText();
        
        Query query = null;
        List<Pacjent> listaPacjentow;
        
        
//    , @NamedQuery(name = "Pacjent.findByNazwiskoLike", query = "SELECT p FROM Pacjent p WHERE p.nazwisko LIKE CONCAT('%',:nazwisko,'%')")})
        // szukaj po nazwisku
        if(!nazwisko.isEmpty()) {
            query = Main.getEntityManager().createNamedQuery("Pacjent.findByNazwiskoLike").setParameter("nazwisko", nazwisko);
        }
        
//    , @NamedQuery(name = "Pacjent.findByPeselLike", query = "SELECT p FROM Pacjent p WHERE p.pesel LIKE CONCAT(:pesel,'%')")
        // szukaj po peselu
        else if(!pesel.isEmpty()) {
            query = Main.getEntityManager().createNamedQuery("Pacjent.findByPeselLike").setParameter("pesel", pesel);
        }
        
        else {
            query = Main.getEntityManager().createNamedQuery("Pacjent.findAll");
        }

        if(query != null) {
            listaPacjentow = query.getResultList();
            for (Pacjent p : listaPacjentow) {
                modelPacjenciTable.addRow(new Object[]
                {p.getIdPacjenta(), p.getPesel(), p.getImie(), p.getNazwisko()});
            }
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

        wyszukiwaniePanel = new javax.swing.JPanel();
        nazwiskoText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        peselText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pacjenciTable = new javax.swing.JTable();
        wyszukajButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        edytujPacjentaButton = new javax.swing.JButton();
        dodajWizyteButton = new javax.swing.JButton();

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

        nazwiskoText.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel2.setText("Pesel:");

        peselText.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel5.setText("Nazwisko:");

        pacjenciTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "pesel", "imie", "nazwisko"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pacjenciTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pacjenciTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pacjenciTable);

        wyszukajButton.setText("Wyszukaj");
        wyszukajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyszukajButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Wyszukaj pacjentów:");

        edytujPacjentaButton.setText("Edytuj pacjenta");
        edytujPacjentaButton.setEnabled(false);
        edytujPacjentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edytujPacjentaButtonActionPerformed(evt);
            }
        });

        dodajWizyteButton.setText("Dodaj wizytę");
        dodajWizyteButton.setEnabled(false);
        dodajWizyteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajWizyteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wyszukiwaniePanelLayout = new javax.swing.GroupLayout(wyszukiwaniePanel);
        wyszukiwaniePanel.setLayout(wyszukiwaniePanelLayout);
        wyszukiwaniePanelLayout.setHorizontalGroup(
            wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wyszukiwaniePanelLayout.createSequentialGroup()
                .addGroup(wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wyszukiwaniePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(wyszukiwaniePanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(32, 32, 32)
                                .addGroup(wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(86, 86, 86)
                                .addComponent(wyszukajButton))))
                    .addGroup(wyszukiwaniePanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(edytujPacjentaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(dodajWizyteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wyszukiwaniePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        wyszukiwaniePanelLayout.setVerticalGroup(
            wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wyszukiwaniePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wyszukiwaniePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(wyszukiwaniePanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(wyszukajButton)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(wyszukiwaniePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edytujPacjentaButton)
                    .addComponent(dodajWizyteButton))
                .addGap(33, 33, 33))
        );

        dodajWizyteButton.getAccessibleContext().setAccessibleName("");

        add(wyszukiwaniePanel, "wyszukiwania");
        wyszukiwaniePanel.getAccessibleContext().setAccessibleName("wyszukiwaniePanel");
    }// </editor-fold>//GEN-END:initComponents

    private void wyszukajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyszukajButtonActionPerformed
        setPacjenciTable();
        edytujPacjentaButton.setEnabled(false);
        dodajWizyteButton.setEnabled(false);
    }//GEN-LAST:event_wyszukajButtonActionPerformed

    private void pacjenciTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pacjenciTableMouseClicked
        edytujPacjentaButton.setEnabled(true);
        dodajWizyteButton.setEnabled(true);
    }//GEN-LAST:event_pacjenciTableMouseClicked

    private void edytujPacjentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edytujPacjentaButtonActionPerformed
        if (pacjenciTable.getSelectedRow() == -1 ) return;
        long idPacjenta = (long)pacjenciTable.getValueAt(pacjenciTable.getSelectedRow(), 0);
        Pacjent pacjent = Main.getEntityManager().find(Pacjent.class, idPacjenta);
        
        PacjentEdytujJPanel edycjaPacjenta = new PacjentEdytujJPanel(pacjent);
        this.add(edycjaPacjenta);
        cardLayout.addLayoutComponent(edycjaPacjenta, "edycja");
        cardLayout.show(this, "edycja");
        
        super.blockButtonsOnMainPanel();
    }//GEN-LAST:event_edytujPacjentaButtonActionPerformed

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
        setPacjenciTable();
        edytujPacjentaButton.setEnabled(false);
        dodajWizyteButton.setEnabled(false);
    }//GEN-LAST:event_formComponentRemoved

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        zerujWszystko();
    }//GEN-LAST:event_formComponentShown

    private void dodajWizyteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajWizyteButtonActionPerformed
        if (pacjenciTable.getSelectedRow() == -1 ) return;
        long idPacjenta = (long)pacjenciTable.getValueAt(pacjenciTable.getSelectedRow(), 0);
        Pacjent pacjent = Main.getEntityManager().find(Pacjent.class, idPacjenta);
        
        WizytaNowaJPanel dodajWizyte = new WizytaNowaJPanel(pacjent);
        this.add(dodajWizyte);
        cardLayout.addLayoutComponent(dodajWizyte, "wizyta");
        cardLayout.show(this, "wizyta");
        
        super.blockButtonsOnMainPanel();
    }//GEN-LAST:event_dodajWizyteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dodajWizyteButton;
    private javax.swing.JButton edytujPacjentaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nazwiskoText;
    private javax.swing.JTable pacjenciTable;
    private javax.swing.JTextField peselText;
    private javax.swing.JButton wyszukajButton;
    private javax.swing.JPanel wyszukiwaniePanel;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelPacjenciTable;
    private CardLayout cardLayout;

    @Override
    public void odrzuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
