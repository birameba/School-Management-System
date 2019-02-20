
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

 

public class passencrypt {
   private static MessageDigest md;

   public String passen(String pass){
    try {
        md = MessageDigest.getInstance("MD5");
        byte[] passBytes = pass.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(passencrypt.class.getName()).log(Level.SEVERE, null, ex);
    }
        return null;


   }
   
   public static void main(String args[]){
       passencrypt pn=new passencrypt();
       System.out.println(pn.passen("ktm1"));
   }
}