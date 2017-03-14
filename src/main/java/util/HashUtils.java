package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by anderson on 13/03/17.
 */
public class HashUtils {

    public static String stringParaHash(String senha) {
        String senhaHash = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)  {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            senhaHash = sb.toString();
        }
        catch (NoSuchAlgorithmException e)  {
            e.printStackTrace();
        }

        return senhaHash;
    }

}
