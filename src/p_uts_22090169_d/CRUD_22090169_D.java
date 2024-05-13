/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p_uts_22090169_d;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;
/**
 *
 * @author muhammadzulfans
 */
public class CRUD_22090169_D {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        try {
            // koneksi ke database MongoDB
            MongoDatabase database = koneksi.konekMongoDB();

            // melihat daftar koleksi (table)
            System.out.println("==========================");
            System.out.println("Daftar Tabel dalam Database");
            MongoIterable<String> tables = database.listCollectionNames();

            for (String name : tables) {
                System.out.println(name);
            }

            // Menambah data
            System.out.println("==========================");
            System.out.println("Menambahkan data");
            MongoCollection<Document> col = database.getCollection("col_22090169_D");
            Document doc1 = new Document();
            doc1.put("nama", "Printer Inkjet");
            doc1.put("nama", 1204000);
            col.insertOne(doc1);
            System.out.println("Data telah disimpan dalam koleksi");
            
            System.out.println("Menambahkan data");
            Document doc2 = new Document();
            doc2.put("nama", "Printer Inkjet");
            doc2.put("harga", 1204000);
            doc2.put("tanggal", new Date());
            col.insertOne(doc2);
            System.out.println("Data telah disimpan dalam koleksi");
            
            System.out.println("Menambahkan data");
            Document doc3 = new Document();
            doc3.put("nama", "Printer Inkjet");
            doc3.put("harga", 1204000);
            doc3.put("kategori", "elektronik");
            doc3.put("tanggal", new Date());
            col.insertOne(doc3);
            System.out.println("Data telah disimpan dalam koleksi");

            // Melihat atau menampilkan data
            System.out.println("==========================");
            System.out.println("Data dalam koleksi produk");
            MongoCursor<Document> cursor = col.find().iterator();
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }


            // Mengedit data
            Document docs2 = new Document();
            docs2.put("nama", "Canon");
            Document doc_edit = new Document("$set", docs2);
            UpdateResult hasil_edit = col.updateOne(eq("_id", doc2), doc_edit);
            System.out.println(hasil_edit.getModifiedCount());
            
            // Melihat atau menampilkan data
            System.out.println("==========================");
            System.out.println("Data dalam koleksi produk");
            cursor = col.find().iterator();
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
            
//            // Menghapus data
//            col.deleteOne(eq("_id", doc3));
//            System.out.println("==========================");
//            System.out.println("Data dalam koleksi produk");
//            cursor = col.find().iterator();
//            while(cursor.hasNext()){
//                System.out.println(cursor.next().toJson());
//            }
//            
         
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
