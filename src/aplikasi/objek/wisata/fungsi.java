/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.objek.wisata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Asus
 */
public class fungsi {
    
    
    private static Connection kon;
    public static Connection koneksidb() throws SQLException {
        try {
            String URL ="jdbc:mysql://localhost/objekwisata";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            kon = (Connection) DriverManager.getConnection(URL,user,pass);
            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Tidak ada koneksi","Error",
            JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
         return kon;
    }
    

   
    public String getIsiTabel(String[] IsiTabel){
       String hasil="";
       int DeteksiIndex=IsiTabel.length-1;
       try {
            for (int i = 0; i < IsiTabel.length; i++){
                 if (i==DeteksiIndex){
                         hasil=hasil+"'"+IsiTabel[i]+"'";
                     } else {
                         hasil=hasil+"'"+IsiTabel[i]+"',";
                     }
            }
       }catch (Exception e){
           System.out.println(e.toString());
}
    return "("+hasil+")";
    }
            
    public String getfield(String[] FieldTabel){
        String n="";
       int deteksiIndexAkhir=FieldTabel.length-1;
        try {
           for (int i = 0; i < FieldTabel.length; i++){
               
               if (i==deteksiIndexAkhir){
                   n=n+FieldTabel[i];
               } else {
                    n=n+FieldTabel[i]+",";
               }
              
           }
        }catch (Exception e){
            System.out.println(e.toString());
}
        return "("+n+")";
}
    public void SimpanDinamis(String NamaTabel, String[] Fieldnya, String[] Isinya){
           try {
               String SQLSave = "INSERT INTO "+NamaTabel+" "+getfield(Fieldnya)+" VALUES "+getIsiTabel(Isinya);
               Statement perintah=koneksidb().createStatement();
               perintah.executeUpdate(SQLSave);
               perintah.close();
               
               System.out.println("Data Berhasil Disimpan!!");
           } catch (Exception e){
           System.out.println(e.toString());
}
               
 } 
    public Object[][] isiTabel(String SQL, int jumlah){
           Object[][] data = null;
           try {
               Statement perintah = koneksidb().createStatement();
               ResultSet dataset = perintah.executeQuery(SQL);
               dataset.last();
               int baris = dataset.getRow();
               dataset.beforeFirst();
               int j=0;
               
               data = new Object[baris][jumlah];
               
               while (dataset.next()){
                   for (int i=0; i< jumlah; i++){
                       data[j][i]=dataset.getString(i+1);
                   }
                   j++;
               }              
           }catch (Exception e){
    
}
           return data;
       }
    
   public void settingJudulTabel(JTable Tabelnya, String[] JudulKolom){
           try {
               DefaultTableModel Modelnya = new DefaultTableModel();
                Tabelnya.setModel(Modelnya);
                for (int i=0; i< JudulKolom.length;i++){
                    Modelnya.addColumn(JudulKolom[i]);
                }
                
           }catch (Exception e){
           System.out.println(e.toString());
}
         
       }
    
    public void tampilTabel(JTable Tabelnya, String SQL, String[] Judul){
      try {
        Tabelnya.setModel(new DefaultTableModel(isiTabel(SQL,Judul.length), Judul));
           }catch (Exception e){
           System.out.println(e.toString());
}
       }
    
    public void Delete(String NamaTabel, String Key, String Value){
           try {
               
               String SQL="DELETE FROM "+NamaTabel+" WHERE "+Key+"='"+Value+"'";
               
              Statement perintah = koneksidb().createStatement();
               perintah.executeUpdate(SQL);
               perintah.close();
               JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
           }catch (Exception e){
               System.out.println(e.toString());
           }
    }
    
    public String getEdit(String[] Field, String[] value){
             String hasil="";
             int deteksi = Field.length-1;
           try {
              for (int i =0; i< Field.length; i++){
                 if (i ==deteksi){
                     hasil=hasil +Field[i]+" ="+value[i]+"'";
                 } else{
                     hasil=hasil +Field[i]+" ='"+value[i]+"',";
                 } 
              }  
               
           }catch (Exception e){
           System.out.println(e.toString());
               
           }
        return hasil;
       }
    public void Ubahdinamis(String NamaTabel, String PrimaryKey, String IsiPrimary, String[] Field, String[] value){
               try {
                   String SQLUbah = "UPDATE "+NamaTabel+" SET "+getEdit(Field, value)+" WHERE "+PrimaryKey+"='"+IsiPrimary+"'";
                   Statement perintah=koneksidb().createStatement();
                   perintah.close();
                   koneksidb().close();
               }  catch (Exception e){
           System.out.println(e.toString());
             } 
}
    
    public static Date getTanggalTabel(JTable table, int kolom){
            JTable tabel = table;
            String strTanggal = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
            Date tanggal = null;
            try {
                tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(strTanggal);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        return tanggal;
    }
}