import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public abstract class des {
    public static void desconnection() throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        String key ="00000000";
        DESKeySpec key_spec = new DESKeySpec(key.getBytes());
        SecretKey sec_key = SecretKeyFactory.getInstance("DES").generateSecret(key_spec);

        byte[] key_byte = sec_key.getEncoded();

        System.out.println("Generated Secrete Key: "+ key_byte);
        System.out.println("Generated Secrete Key Size: "+ key_byte.length);

        Cipher des;
        des = Cipher.getInstance("DES/ECB/PKCS5Padding");
        des.init(Cipher.ENCRYPT_MODE, sec_key);

        String msg = "Hello World";

        byte[] byte_msg = msg.getBytes();
        System.out.println("Plain Text= "+msg);

        byte[] cipher_text = des.doFinal(byte_msg);
        String string_cipher = new String(cipher_text);
        System.out.println("Encripted Text= " + string_cipher);
    }
}
