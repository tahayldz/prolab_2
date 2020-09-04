
package prolab3;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class KayitSayfa extends javax.swing.JFrame {


    public KayitSayfa() {
        
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_email = new javax.swing.JTextField();
        jTextField_isim = new javax.swing.JTextField();
        jButton_kayit = new javax.swing.JButton();
        jButton_Giris = new javax.swing.JButton();
        jPasswordField_parola = new javax.swing.JPasswordField();
        jTextField_dogumTarihi = new javax.swing.JTextField();
        aksiyon = new javax.swing.JCheckBox();
        bilimKurgu = new javax.swing.JCheckBox();
        anime = new javax.swing.JCheckBox();
        belgesel = new javax.swing.JCheckBox();
        bililmDoga = new javax.swing.JCheckBox();
        cocukAile = new javax.swing.JCheckBox();
        drama = new javax.swing.JCheckBox();
        fantastik = new javax.swing.JCheckBox();
        macera = new javax.swing.JCheckBox();
        korku = new javax.swing.JCheckBox();
        komedi = new javax.swing.JCheckBox();
        gerilim = new javax.swing.JCheckBox();
        romantik = new javax.swing.JCheckBox();
        reality = new javax.swing.JCheckBox();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_hepsi = new javax.swing.JTable();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_emailActionPerformed(evt);
            }
        });

        jButton_kayit.setText("Kayit Ol");
        jButton_kayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_kayitActionPerformed(evt);
            }
        });

        jButton_Giris.setText("Giris Yap");
        jButton_Giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GirisActionPerformed(evt);
            }
        });

        jPasswordField_parola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_parolaActionPerformed(evt);
            }
        });

        aksiyon.setText("Aksiyon");

        bilimKurgu.setText("Bilim Kurgu");

        anime.setText("Anime");

        belgesel.setText("Belgesel");

        bililmDoga.setText("Bilim ve Doğa");

        cocukAile.setText("Çocuk ve Aile");

        drama.setText("Drama");

        fantastik.setText("Fantastik Yapımlar");

        macera.setText("Macera");

        korku.setText("Korku");

        komedi.setText("Komedi");

        gerilim.setText("Gerilim");

        romantik.setText("Romantik");

        reality.setText("Reality Program");

        jTable_hepsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Program ID", "Program Adi", "Dizi/Film", "Türü", "Sezon/Süre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane2.setViewportView(jTable_hepsi);
        if (jTable_hepsi.getColumnModel().getColumnCount() > 0) {
            jTable_hepsi.getColumnModel().getColumn(0).setMinWidth(70);
            jTable_hepsi.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable_hepsi.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable_hepsi.getColumnModel().getColumn(1).setMinWidth(170);
            jTable_hepsi.getColumnModel().getColumn(1).setMaxWidth(170);
            jTable_hepsi.getColumnModel().getColumn(2).setMinWidth(80);
            jTable_hepsi.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTable_hepsi.getColumnModel().getColumn(2).setMaxWidth(80);
            jTable_hepsi.getColumnModel().getColumn(3).setMinWidth(330);
            jTable_hepsi.getColumnModel().getColumn(3).setPreferredWidth(110);
            jTable_hepsi.getColumnModel().getColumn(3).setMaxWidth(330);
        }

        label5.setText("ONERILENLER");

        label6.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        label6.setText("NOT: Film/dizi ' lerin sahip oldukları tür miktarından dolayı aynı film/dizi birkaç kere yazıyor.");

        jLayeredPane1.setVisible(false);

        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(label5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(label6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        label1.setText("isim:");

        label2.setText("email:");

        label3.setText("parola");

        label4.setText("dogum tarihi:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_isim, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField_parola, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_dogumTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(belgesel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anime, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bilimKurgu, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aksiyon, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drama, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cocukAile, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fantastik, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bililmDoga, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(korku, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(macera, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(komedi, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gerilim, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(romantik, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reality, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_kayit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Giris, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 440, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aksiyon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(anime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(belgesel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(bilimKurgu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_isim, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_email, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordField_parola, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bililmDoga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cocukAile, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(drama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fantastik, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gerilim, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reality, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(komedi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(romantik, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(korku, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(macera, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_dogumTarihi, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton_kayit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Giris, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(400, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void oner(){
        ArrayList<JCheckBox> checkBoxList = new ArrayList();
        checkBoxList.add(aksiyon);
        checkBoxList.add(anime);
        checkBoxList.add(belgesel);
        checkBoxList.add(bililmDoga);
        checkBoxList.add(bilimKurgu);
        checkBoxList.add(cocukAile);
        checkBoxList.add(drama);
        checkBoxList.add(fantastik);
        checkBoxList.add(gerilim);
        checkBoxList.add(komedi);
        checkBoxList.add(korku);
        checkBoxList.add(macera);
        checkBoxList.add(reality);
        checkBoxList.add(romantik);
        
        int sayac = 0;
        int t = 0,T=0;
        String [] tur = new String[3];
        for (int i=0; i< checkBoxList.size(); i++){
            if(checkBoxList.get(i).isSelected()){
                sayac++;
                tur[t] = checkBoxList.get(i).getText();
                t++;
                if(sayac == 3){
                    break;
                }
            }
        }
          
        jLayeredPane1.setVisible(true);
            PreparedStatement as;
            ResultSet ras;
            int programID;
            String turler = null;
            String tip = null;
            String [] programAdi = new String[2];

            String progName = null;
            
            DefaultTableModel model = (DefaultTableModel)jTable_hepsi.getModel();     
        try {
            for(int i=0;i<3;i++){
                String sorgu = "select program.adi from program,tur,programtur where program.id = programtur.programId and tur.id = programtur.turId and tur.adi = ? LIMIT 2";
                as = Baglanti.bagla().prepareStatement(sorgu);
                as.setString(1,tur[i]);
                ras = as.executeQuery();
                T=0;
                while(ras.next()){
                    
                   programAdi[T] = ras.getString("program.adi");
                   T++;
                }
             as.close();
                sorgu = "SELECT program.id,program.adi,tur.adi,program.tipi,program.uzunluk FROM program,tur,programtur WHERE (((programtur.programID)=[program].[id]) AND ((programtur.turID)=[tur].[id]) AND (program.adi = ? or program.adi = ?))";
                as = Baglanti.bagla().prepareStatement(sorgu);
                as.setString(1,programAdi[0]);
                as.setString(2,programAdi[1]);
                ras = as.executeQuery();
                while(ras.next()){
                   programID = ras.getInt("program.id");
                   progName = ras.getString("program.adi");
                   turler = ras.getString("tur.adi");
                   tip = ras.getString("program.tipi");
                   
                   if("dizi".equals(tip) || "TV Show".equals(tip)){
                       int uzunluk;
                       uzunluk = (int)ras.getFloat("program.uzunluk");
                       
                       model.addRow(new Object[]{programID,progName,tip,turler,uzunluk});
                   }
                   else{
                       float uzunluk;
                       uzunluk = ras.getFloat("program.uzunluk");
                       model.addRow(new Object[]{programID,progName,tip,turler,uzunluk});
                   }
                   
                }
            }
            
                
        }
        catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        
        //JOptionPane.showMessageDialog(rootPane,tur[0]+" "+tur[1]+" "+tur[2]);
    }
    private void jButton_kayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_kayitActionPerformed
  
            try {
            String isim = jTextField_isim.getText();
            String email = jTextField_email.getText();
            String parola = String.valueOf(jPasswordField_parola.getPassword());
            String dogumTarihi = jTextField_dogumTarihi.getText();
            
            if(isim.hashCode() == 0 || email.hashCode() == 0 || parola.hashCode() == 0 || dogumTarihi.hashCode() == 0){
                JOptionPane.showMessageDialog(rootPane,"LUTFEN TUM ALANLARI DOLDURUNUZ!");
            }
            else if(!email.contains("@")){
                JOptionPane.showMessageDialog(rootPane,"LUTFEN GECERLI BIR EMAIL ADRESI GIRIN!");
            }
            else{
                PreparedStatement ps;
            ResultSet rs;
            
            String sorgu = "SELECT email FROM kullanici WHERE email = ?";
            
            ps = Baglanti.bagla().prepareStatement(sorgu);
            
           
            ps.setString(1,email);
            rs = ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(rootPane,"BU EMAIL ADRESI ZATEN KAYITLI!");
            }
            else{
            PreparedStatement ps1;
            String sorgu1 = "INSERT INTO kullanici(isim,email,parola,dogumTarihi)VALUES(?,?,?,?)";
            
            ps1 = Baglanti.bagla().prepareStatement(sorgu1);
            
            ps1.setString(1,isim);
            ps1.setString(2,email);
            ps1.setString(3,parola);
            ps1.setString(4,dogumTarihi);
            
            if(ps1.executeUpdate() >0){
                JOptionPane.showMessageDialog(rootPane,"Kayit basarili");
            }
    
            }
            oner();
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(KayitSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton_kayitActionPerformed

    private void jButton_GirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GirisActionPerformed
        GirisSayfa mf = new GirisSayfa();
        mf.setVisible(true);
        mf.pack();
        mf.setLocationRelativeTo(null);
        mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.dispose();
    }//GEN-LAST:event_jButton_GirisActionPerformed

    private void jPasswordField_parolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_parolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField_parolaActionPerformed

    private void jTextField_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_emailActionPerformed

    /**
     * @param args the command line arguments
     */
    private void calis() {
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
            java.util.logging.Logger.getLogger(KayitSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KayitSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KayitSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KayitSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KayitSayfa().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox aksiyon;
    private javax.swing.JCheckBox anime;
    private javax.swing.JCheckBox belgesel;
    private javax.swing.JCheckBox bililmDoga;
    private javax.swing.JCheckBox bilimKurgu;
    private javax.swing.JCheckBox cocukAile;
    private javax.swing.JCheckBox drama;
    private javax.swing.JCheckBox fantastik;
    private javax.swing.JCheckBox gerilim;
    private javax.swing.JButton jButton_Giris;
    private javax.swing.JButton jButton_kayit;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPasswordField jPasswordField_parola;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_hepsi;
    private javax.swing.JTextField jTextField_dogumTarihi;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_isim;
    private javax.swing.JCheckBox komedi;
    private javax.swing.JCheckBox korku;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private javax.swing.JCheckBox macera;
    private javax.swing.JCheckBox reality;
    private javax.swing.JCheckBox romantik;
    // End of variables declaration//GEN-END:variables

    
}
