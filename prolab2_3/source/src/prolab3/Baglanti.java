
package prolab3;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;

public class Baglanti {

    public static Connection bagla(){
        
String dbPath = "C:/Users/taha/Desktop/";
String dbName = "1_180201019_180201030_db.accdb";
//String dbUrl = "jdbc:ucanaccess://" + dbPath + dbName; /*PROJE GELISTIRME ASAMASINDA KULLANILAN KOD*/
String dbUrl = "jdbc:ucanaccess://" + dbName;   /*PROJE JAR HALINE GETIRILIRKEN KULLANILAN KOD */

        
        Connection con = null;

        try{

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            con = DriverManager.getConnection(dbUrl); 
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());           
        }
        return con;
}
    
}
