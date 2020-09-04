/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author taha
 */
public class Menu extends javax.swing.JFrame {
    int kullaniciID;
    
    public Menu(int id) {
        this.kullaniciID = id;
        int nerdenGeldin = 1;
        initComponents();
        Sor(nerdenGeldin);
        
    }
    public Menu(){
        
    }
    

    
    private void Sor(int nerdenGeldin){
        

        
            PreparedStatement ps;
            ResultSet rs;
            int programID;
            String programAdi = null;
            String turler = null;
            String tip = null;
            
            
            DefaultTableModel model = (DefaultTableModel)jTable_hepsi.getModel();
            DefaultTableModel model1 = (DefaultTableModel)jTable_izlenen.getModel();
            
            
        try {
            String sorgu = "SELECT program.id,program.adi,tur.adi,program.tipi,program.uzunluk FROM program,tur,programtur WHERE (((programtur.programID)=[program].[id]) AND ((programtur.turID)=[tur].[id]))";
                ps = Baglanti.bagla().prepareStatement(sorgu);
                rs = ps.executeQuery();
                model.setRowCount(0);
                while(rs.next()){
                   programID = rs.getInt("program.id");
                   programAdi = rs.getString("program.adi");
                   turler = rs.getString("tur.adi");
                   tip = rs.getString("program.tipi");
                   
                   if("dizi".equals(tip) || "TV Show".equals(tip)){
                       int uzunluk;
                       uzunluk = (int)rs.getFloat("program.uzunluk");
                       
                       model.addRow(new Object[]{programID,programAdi,tip,turler,uzunluk});
                   }
                   else{
                       float uzunluk;
                       uzunluk = rs.getFloat("program.uzunluk");
                       model.addRow(new Object[]{programID,programAdi,tip,turler,uzunluk});
                   }
                   
                }
             ps.close();
             
            sorgu = "SELECT kullaniciprogram.puan, kullaniciprogram.programID, program.adi, kullaniciprogram.tarih,kullaniciprogram.bolum FROM kullaniciprogram,program WHERE kullaniciprogram.kullaniciID = ? AND kullaniciprogram.programID = program.id ORDER BY kullaniciprogram.puan DESC ";
            ps = Baglanti.bagla().prepareStatement(sorgu);   
            ps.setInt(1, this.kullaniciID);
            rs = ps.executeQuery();
            model1.setRowCount(0);
                while(rs.next()){
                  int puan = rs.getInt("kullaniciprogram.puan");
                  int progID = rs.getInt("kullaniciprogram.programID");
                   String programAdi2 = rs.getString("program.adi");
                   String tarih = rs.getString("kullaniciprogram.tarih");
                   int bolum = rs.getInt("kullaniciprogram.bolum");
                   
                   model1.addRow(new Object[]{puan,progID,programAdi2,tarih,bolum});
                }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                if(nerdenGeldin == 1){
            JOptionPane.showMessageDialog(rootPane,"NOT: Film / diziler sahip oldukları tür miktarından dolayı\n"+
                    "ekranda birden fazla kez yazıyor.\n"+
                    "Izlemek istenilen film/dizinin oldugu herhangi bir satıra\n"+
                    "tıklanarak izlenebilir.");
        }
            
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_izlenen = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_hepsi = new javax.swing.JTable();
        jButton_puan = new javax.swing.JButton();
        jTextField_programId = new javax.swing.JTextField();
        jTextField_ara = new javax.swing.JTextField();
        jButton_diziAra = new javax.swing.JButton();
        jButton_türAra = new javax.swing.JButton();
        jButton_yenile = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_izlenen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Puan", "ID", "Program Adi", "İzlenme Tarihi", "Son İzlenen Bölüm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jTable_izlenen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_izlenenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_izlenen);
        if (jTable_izlenen.getColumnModel().getColumnCount() > 0) {
            jTable_izlenen.getColumnModel().getColumn(0).setMinWidth(80);
            jTable_izlenen.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable_izlenen.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable_izlenen.getColumnModel().getColumn(1).setMinWidth(70);
            jTable_izlenen.getColumnModel().getColumn(1).setPreferredWidth(1);
            jTable_izlenen.getColumnModel().getColumn(1).setMaxWidth(70);
            jTable_izlenen.getColumnModel().getColumn(2).setMinWidth(170);
            jTable_izlenen.getColumnModel().getColumn(2).setMaxWidth(170);
            jTable_izlenen.getColumnModel().getColumn(3).setMinWidth(100);
            jTable_izlenen.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable_izlenen.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jTable_hepsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Program Adi", "Dizi/Film", "Türü", "Sezon/Süre"
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
        jTable_hepsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_hepsiMouseClicked(evt);
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
            jTable_hepsi.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable_hepsi.getColumnModel().getColumn(3).setMaxWidth(330);
        }

        jButton_puan.setText("PUANLA!");
        jButton_puan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_puanActionPerformed(evt);
            }
        });

        jButton_diziAra.setText("DİZİ/FİLM ARA!");
        jButton_diziAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_diziAraActionPerformed(evt);
            }
        });

        jButton_türAra.setText("TÜR ARA!");
        jButton_türAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_türAraActionPerformed(evt);
            }
        });

        jButton_yenile.setText("YENİLE!");
        jButton_yenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_yenileActionPerformed(evt);
            }
        });

        label1.setText("PROGRAM ID:");

        label2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label2.setText("IZLENEN / IZLENMEYE DEVAM EDEN ICERIKLER");

        label3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label3.setText("TUM ICERIKLER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(696, 696, 696)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_puan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_programId, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(468, 468, 468)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton_diziAra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_türAra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(218, 218, 218))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(402, 402, 402)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1407, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jTextField_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_diziAra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_türAra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton_yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_programId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_puan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(875, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_hepsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_hepsiMouseClicked
        String secilenRow = jTable_hepsi.getValueAt(jTable_hepsi.getSelectedRow(), 0).toString();
        int programID = Integer.parseInt(secilenRow);
        String tarih = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
       PreparedStatement ps,ps1;
       ResultSet rs;    
       try {     
            String varMi = "SELECT  program.bolum,kullaniciprogram.tarih,kullaniciprogram.bolum FROM kullaniciprogram,program WHERE kullaniciprogram.kullaniciID = ? AND kullaniciprogram.programID = ? and program.id = ?";
            ps = Baglanti.bagla().prepareStatement(varMi);
            ps.setInt(1,this.kullaniciID);
            ps.setInt(2, programID);
            ps.setInt(3,programID);
            rs = ps.executeQuery();
            if(rs.next()){
                int toplamBolum = rs.getInt("program.bolum");
                int bolum = rs.getInt("kullaniciprogram.bolum");
                if(bolum < toplamBolum){
                    
                bolum += 1;
                ps.close();
                          
                String guncelle = "UPDATE kullaniciprogram SET kullaniciprogram.bolum = ? WHERE kullaniciprogram.kullaniciID = ? AND kullaniciprogram.programID = ?";
                ps1 = Baglanti.bagla().prepareStatement(guncelle);
                
                
                ps1.setInt(1,bolum);
                ps1.setInt(2,this.kullaniciID);
                ps1.setInt(3, programID);
                if(ps1.executeUpdate() > 0){
                  JOptionPane.showMessageDialog(rootPane,bolum+". BÖLÜMÜ İZLEDİNİZ!");
               } 
                ps1.close();
                }                else
                    JOptionPane.showMessageDialog(rootPane,"TÜM BÖLÜMLERİ İZLEDİNİZ!\n ASAGIDAKI KUTUCUGA PUANLAMAK ISTEDIGINIZ\n PROGRAMIN ID NUMARASINI GIREREK PUANLAYABILIRSINIZ.");
            
}
            else{
                float sure=0;
                String sorgu= "SELECT program.bolum,program.uzunluk FROM program WHERE program.id = ?";
                ps = Baglanti.bagla().prepareStatement(sorgu);
                ps.setInt(1, programID);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    sure = rs.getFloat("program.uzunluk");
                    
                }
                sorgu ="INSERT INTO kullaniciprogram (`tarih`,`sure`,`bolum`,`puan`,`kullaniciID`,`programID`)VALUES(?,?,1,0,?,?)";
                ps = Baglanti.bagla().prepareStatement(sorgu);
                ps.setString(1, tarih);
                ps.setFloat(2,sure);
                ps.setInt(3,this.kullaniciID);
                ps.setInt(4, programID);
               if(ps.executeUpdate() > 0){
                  JOptionPane.showMessageDialog(rootPane,"KEYIFLI SEYIRLER!");
               } 
            }
               
            
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Sor(0);
    }//GEN-LAST:event_jTable_hepsiMouseClicked

    private void jButton_puanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_puanActionPerformed
        try {
            
            int programID = Integer.parseInt(jTextField_programId.getText());
            PreparedStatement sa,ps1;
            ResultSet sonuc;
            String tarih = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
         
            String varMi = "SELECT  kullaniciprogram.tarih,kullaniciprogram.bolum FROM kullaniciprogram WHERE kullaniciprogram.kullaniciID = ? AND kullaniciprogram.programID = ?";
            sa = Baglanti.bagla().prepareStatement(varMi);
            sa.setInt(1,this.kullaniciID);
            sa.setInt(2, programID);
            sonuc = sa.executeQuery();
            if(sonuc.next()){
                String date = sonuc.getString("kullaniciprogram.tarih");
                int currentBolum = sonuc.getInt("kullaniciprogram.bolum");
                int puan = Integer.parseInt(JOptionPane.showInputDialog(rootPane, date+" TARIHINDE "+currentBolum+" BOLUM IZLEDINIZ.\nPUANLAMAK ICIN 0-10 ARASINDA BIR DEGER GIREBILIRSINIZ!", "PUANLA!", JOptionPane.QUESTION_MESSAGE));
                
                String puanla = "UPDATE kullaniciprogram SET kullaniciprogram.puan = ?  WHERE kullaniciprogram.kullaniciID = ? AND kullaniciprogram.programID = ?";
                ps1 = Baglanti.bagla().prepareStatement(puanla);
                
                ps1.setInt(1,puan);
                ps1.setInt(2,this.kullaniciID);
                ps1.setInt(3, programID);
                if(ps1.executeUpdate() > 0){
                  JOptionPane.showMessageDialog(rootPane,puan+" PUAN VERDINIZ!");
               } 
                ps1.close();
                }             
        }
        catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sor(0);
        
    }//GEN-LAST:event_jButton_puanActionPerformed

    private void jButton_yenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_yenileActionPerformed
       Sor(0);
    }//GEN-LAST:event_jButton_yenileActionPerformed

    private void jButton_diziAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_diziAraActionPerformed

        try {
                    String programAdi = jTextField_ara.getText();
            if(programAdi.hashCode() == 0){
                JOptionPane.showMessageDialog(rootPane," LUTFEN ARAMAK ISTEDIGINIZ TURU GIRIN");
            }
            PreparedStatement ps;
            ResultSet rs;
            int programID;
            String turler = null;
            String tip = null;
            String progName = null;
            DefaultTableModel model = (DefaultTableModel)jTable_hepsi.getModel();
            model.setRowCount(0);

            String sorgu2 = "SELECT program.id,program.adi,tur.adi,program.tipi,program.uzunluk FROM program,tur,programtur WHERE (((programtur.programID)=[program].[id]) AND ((programtur.turID)=[tur].[id])) and program.adi = ?";
            ps = Baglanti.bagla().prepareStatement(sorgu2);
            ps.setString(1,programAdi);
            rs = ps.executeQuery();
            while(rs.next()){
                programID = rs.getInt("program.id");
                progName = rs.getString("program.adi");
                turler = rs.getString("tur.adi");
                tip = rs.getString("program.tipi");
                
                if("dizi".equals(tip) || "TV Show".equals(tip)){
                    int uzunluk;
                    uzunluk = (int)rs.getFloat("program.uzunluk");
                    
                    model.addRow(new Object[]{programID,progName,tip,turler,uzunluk});
                }
                else{
                    float uzunluk;
                    uzunluk = rs.getFloat("program.uzunluk");
                    model.addRow(new Object[]{programID,progName,tip,turler,uzunluk});
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_diziAraActionPerformed
    private void TurAra(String programAdi){
        try {
            PreparedStatement ps;
            ResultSet rs;
            int programID;
            String turler = null;
            String tip = null;
            String progName = null;
            DefaultTableModel model = (DefaultTableModel)jTable_hepsi.getModel();

            String sorgu2 = "SELECT program.id,program.adi,tur.adi,program.tipi,program.uzunluk FROM program,tur,programtur WHERE (((programtur.programID)=[program].[id]) AND ((programtur.turID)=[tur].[id])) and program.adi = ?";
            ps = Baglanti.bagla().prepareStatement(sorgu2);
            ps.setString(1,programAdi);
            rs = ps.executeQuery();
            while(rs.next()){
                programID = rs.getInt("program.id");
                progName = rs.getString("program.adi");
                turler = rs.getString("tur.adi");
                tip = rs.getString("program.tipi");
                
                if("dizi".equals(tip) || "TV Show".equals(tip)){
                    int uzunluk;
                    uzunluk = (int)rs.getFloat("program.uzunluk");
                    
                    model.addRow(new Object[]{programID,progName,tip,turler,uzunluk});
                }
                else{
                    float uzunluk;
                    uzunluk = rs.getFloat("program.uzunluk");
                    model.addRow(new Object[]{programID,progName,tip,turler,uzunluk});
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton_türAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_türAraActionPerformed

            String turAdi = jTextField_ara.getText();
            if(turAdi.hashCode() == 0){
                JOptionPane.showMessageDialog(rootPane," LUTFEN ARAMAK ISTEDIGINIZ TURU GIRIN");
            }
            PreparedStatement as;
            ResultSet ras;
            String programAdi = null;          
            DefaultTableModel model = (DefaultTableModel)jTable_hepsi.getModel();
            model.setRowCount(0);
        try {
                String sorgu = "select program.adi from program,tur,programtur where program.id = programtur.programId and tur.id = programtur.turId and tur.adi = ?";
                as = Baglanti.bagla().prepareStatement(sorgu);
                as.setString(1,turAdi);
                ras = as.executeQuery();
                while(ras.next()){
                    
                    programAdi = ras.getString("program.adi");
                    TurAra(programAdi);

                }       
        }
        catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_türAraActionPerformed

    private void jTable_izlenenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_izlenenMouseClicked
         String secilenRow = jTable_izlenen.getValueAt(jTable_izlenen.getSelectedRow(), 1).toString();
         int programID = Integer.parseInt(secilenRow);
        String tarih = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
       PreparedStatement ps,ps1;
       ResultSet rs;    
       try {     
            String varMi = "SELECT  program.bolum,kullaniciprogram.tarih,kullaniciprogram.bolum FROM kullaniciprogram,program WHERE kullaniciprogram.kullaniciID = ? AND kullaniciprogram.programID = ? and program.id = ?";
            ps = Baglanti.bagla().prepareStatement(varMi);
            ps.setInt(1,this.kullaniciID);
            ps.setInt(2, programID);
            ps.setInt(3,programID);
            rs = ps.executeQuery();
            if(rs.next()){
                int toplamBolum = rs.getInt("program.bolum");
                int bolum = rs.getInt("kullaniciprogram.bolum");
                if(bolum < toplamBolum){
                    
                bolum += 1;
                ps.close();
                          
                String guncelle = "UPDATE kullaniciprogram SET kullaniciprogram.bolum = ? WHERE kullaniciprogram.kullaniciID = ? AND kullaniciprogram.programID = ?";
                ps1 = Baglanti.bagla().prepareStatement(guncelle);
                
                
                ps1.setInt(1,bolum);
                ps1.setInt(2,this.kullaniciID);
                ps1.setInt(3, programID);
                if(ps1.executeUpdate() > 0){
                  JOptionPane.showMessageDialog(rootPane,bolum+". BÖLÜMÜ İZLEDİNİZ!");
               } 
                ps1.close();
                }
                else
                    JOptionPane.showMessageDialog(rootPane,"TÜM BÖLÜMLERİ İZLEDİNİZ!\n ASAGIDAKI KUTUCUGA PUANLAMAK ISTEDIGINIZ\nPROGRAMIN ID NUMARASINI GIREREK PUANLAYABILIRSINIZ.");
            
            }
            else{
                float sure=0;
                String sorgu= "SELECT program.bolum,program.uzunluk FROM program WHERE program.id = ?";
                ps = Baglanti.bagla().prepareStatement(sorgu);
                ps.setInt(1, programID);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    sure = rs.getFloat("program.uzunluk");
                    
                }
                sorgu ="INSERT INTO kullaniciprogram (`tarih`,`sure`,`bolum`,`puan`,`kullaniciID`,`programID`)VALUES(?,?,1,0,?,?)";
                ps = Baglanti.bagla().prepareStatement(sorgu);
                ps.setString(1, tarih);
                ps.setFloat(2,sure);
                ps.setInt(3,this.kullaniciID);
                ps.setInt(4, programID);
               if(ps.executeUpdate() > 0){
                  JOptionPane.showMessageDialog(rootPane,"KEYIFLI SEYIRLER!");
               } 
            }
               
            
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       Sor(0);
         
    }//GEN-LAST:event_jTable_izlenenMouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_diziAra;
    private javax.swing.JButton jButton_puan;
    private javax.swing.JButton jButton_türAra;
    private javax.swing.JButton jButton_yenile;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_hepsi;
    private javax.swing.JTable jTable_izlenen;
    private javax.swing.JTextField jTextField_ara;
    private javax.swing.JTextField jTextField_programId;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    // End of variables declaration//GEN-END:variables
}
