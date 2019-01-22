/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import encje.Procedura;
import encje.Rozpoznanie;
import inne.Java2sAutoTextField;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JTextField;
import zarzadzanie.Main;
/**
 *
 * @author Monika
 */
public class WizytaEdycjaDodatkowyPanel extends javax.swing.JPanel {

    private List<Procedura> proceduryLista;
    private List<Rozpoznanie> rozpoznaniaLista;
    /**
     * Creates new form WizytaEdycjaDodatkowyPanel
     */
    public WizytaEdycjaDodatkowyPanel() {
        initComponents();
    }
    
    public void setDane(String idRozpoznania, String idProcedury) {
        rozpoznanieText.setText(idRozpoznania);
        proceduraText.setText(idProcedury);
        
        if(!idProcedury.isEmpty()) 
        {
            Procedura procedura = Main.getEntityManager().find(Procedura.class, idProcedury);
            proceduraOpisText.setText(procedura.getNazwaProcedury());
        }
        
        if(!idRozpoznania.isEmpty()) 
        {
            Rozpoznanie rozpoznanie = Main.getEntityManager().find(Rozpoznanie.class, idRozpoznania);
            rozpoznanieOpisText.setText(rozpoznanie.getNazwaChoroby());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="Init">                          
    private void initComponents() {
        
        
        proceduryLista = Main.getEntityManager().
                createNamedQuery("Procedura.findAll").getResultList();
        
        rozpoznaniaLista = Main.getEntityManager().
                createNamedQuery("Rozpoznanie.findAll").getResultList();
        
        
        
        rozpoznanieLabel = new javax.swing.JLabel();
        rozpoznanieOpisText = new javax.swing.JTextField();
        rozpoznanieText = new Java2sAutoTextField(rozpoznaniaLista);
        
        proceduraLabel = new javax.swing.JLabel();
        proceduraText = new Java2sAutoTextField(proceduryLista);
        proceduraOpisText = new javax.swing.JTextField();
        
        proceduraText.setText("");
        rozpoznanieText.setText("");

        rozpoznanieLabel.setText("Rozpoznanie:");

        proceduraLabel.setText("Procedura:");

        proceduraText.setName(""); // NOI18N

        rozpoznanieText.setName(""); // NOI18N
        rozpoznanieText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rozpoznanieTextKeyReleased(evt);
            }
        });
        
        proceduraText.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                proceduraTextKeyReleased(evt);
            }
        });
        
        rozpoznanieOpisText.setEditable(false);
        rozpoznanieOpisText.setPreferredSize(new Dimension(200, 20));
        rozpoznanieOpisText.setMaximumSize(new Dimension(200, 20));
        rozpoznanieOpisText.setMinimumSize(new Dimension(200, 20));
        
        proceduraOpisText.setEditable(false);
        proceduraOpisText.setPreferredSize(new Dimension(200, 20));
        proceduraOpisText.setMaximumSize(new Dimension(200, 20));
        proceduraOpisText.setMinimumSize(new Dimension(200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proceduraLabel)
                    .addComponent(rozpoznanieLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(proceduraText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rozpoznanieText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rozpoznanieOpisText)
                            .addComponent(proceduraOpisText))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rozpoznanieLabel)
                    .addComponent(rozpoznanieText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rozpoznanieOpisText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceduraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proceduraText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proceduraOpisText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void rozpoznanieTextKeyReleased(java.awt.event.KeyEvent evt) {
        String idRozpoznania = rozpoznanieText.getText();
        if(idRozpoznania.isEmpty()) 
        {
            rozpoznanieOpisText.setText("");
            return;
        }
        Rozpoznanie rozpoznanie = Main.getEntityManager().find(Rozpoznanie.class, idRozpoznania);
        
        if(rozpoznanie == null) {
            proceduraOpisText.setText("");
            return;
        }
        rozpoznanieOpisText.setText(rozpoznanie.getNazwaChoroby());
    }                                 
    
    private void proceduraTextKeyReleased(java.awt.event.KeyEvent evt) {
        String idProcedury = proceduraText.getText();
        if(idProcedury.isEmpty()) 
        {
            proceduraOpisText.setText("");
            return;
        }
        Procedura procedura = Main.getEntityManager().find(Procedura.class, idProcedury);
        
        if(procedura == null) {
            proceduraOpisText.setText("");
            return;
        }
        proceduraOpisText.setText(procedura.getNazwaProcedury());
    }          



    // Variables declaration - do not modify                         
    
    
    
    private javax.swing.JLabel proceduraLabel;
    private javax.swing.JTextField proceduraOpisText;
    private Java2sAutoTextField proceduraText;
    
    private javax.swing.JTextField rozpoznanieOpisText;
    private javax.swing.JLabel rozpoznanieLabel;
    private Java2sAutoTextField rozpoznanieText;
//    private Java2sAutoTextField rozpoznanieText;
 
    // End of variables declaration         

    public Procedura getProcedure() {
        if (proceduraText.getText().isEmpty() || proceduraText.getText().equals(" ")) {
            return null;
        }
        
        return Main.getEntityManager().find(Procedura.class, proceduraText.getText());
    }

    public Rozpoznanie getRozpoznanie() {
        if (rozpoznanieText.getText().isEmpty() || rozpoznanieText.getText().equals(" ")) {
            return null;
        }
        
        return Main.getEntityManager().find(Rozpoznanie.class, rozpoznanieText.getText());
    }
    
    public void aktualizujListy() {                                    
        proceduryLista = Main.getEntityManager().
                createNamedQuery("Procedura.findAll").getResultList();
        
        rozpoznaniaLista = Main.getEntityManager().
                createNamedQuery("Rozpoznanie.findAll").getResultList();
        
        rozpoznanieText.setDataList(rozpoznaniaLista);
        proceduraText.setDataList(proceduryLista);
        
    }                
    
    
}
