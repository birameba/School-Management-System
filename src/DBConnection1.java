import java.sql.*;
public class DBConnection1 {
    public Connection cn=null;
    public DBConnection1(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","tilak");
        } catch (Exception exxx) {
        }        
    }
}
