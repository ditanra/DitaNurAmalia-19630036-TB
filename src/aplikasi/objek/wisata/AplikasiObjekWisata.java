/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.objek.wisata;

import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class AplikasiObjekWisata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        new koneksi().koneksidb();
    }
    
}
