/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p_uts_22090169_d;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author muhammadzulfans
 */
public class koneksi {
        public static MongoDatabase konekMongoDB(){
        try {
            MongoClient client = MongoClients.create();
            MongoDatabase database = client.getDatabase("UTS_22090169_D");
            System.out.println("Koneksi Sukses");
            return database;
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        
        return null;
    }
}
