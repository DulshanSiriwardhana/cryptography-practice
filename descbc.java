import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;

public abstract class descbc {

    public static void desconnection() throws InvalidKeyException, InvalidKeySpecException,
            NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException, InvalidAlgorithmParameterException {

        // Key and IV (must be 8 bytes for DES)
        String key = "00000000";
        String iv_string = "aaaaaaaa";

        DESKeySpec key_spec = new DESKeySpec(key.getBytes());
        SecretKey sec_key = SecretKeyFactory.getInstance("DES").generateSecret(key_spec);
        IvParameterSpec iv = new IvParameterSpec(iv_string.getBytes());

        Cipher des = Cipher.getInstance("DES/CBC/NoPadding");

        // Message must be a multiple of 8 bytes
        String msg = "1234567812345678";
        byte[] byte_msg = msg.getBytes();
        System.out.println("Plain Text = " + msg);

        // Encryption
        des.init(Cipher.ENCRYPT_MODE, sec_key, iv);
        byte[] cipher_text = des.doFinal(byte_msg);

        // Encoder
        Base64.Encoder encoder = Base64.getEncoder();
        String encoded_cipher = encoder.encodeToString(cipher_text);
        System.out.println("Encrypted Text (Base64) = " + encoded_cipher);

        // Decoder
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded_cipher = decoder.decode(encoded_cipher);

        // Decryption
        des.init(Cipher.DECRYPT_MODE, sec_key, iv);
        byte[] dec_text = des.doFinal(decoded_cipher);
        String string_dec = new String(dec_text);
        System.out.println("Decrypted Text = " + string_dec);
    }
}
