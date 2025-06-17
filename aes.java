import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.*;
import java.util.Base64;

public abstract class aes {

    public static void aesconnection() throws Exception {
        //Generate AES key (256-bit)
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        //Generate IV (16 bytes for AES)
        SecureRandom secureRandom = new SecureRandom();
        byte[] ivBytes = new byte[16];
        secureRandom.nextBytes(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        //Cipher for AES in CBC mode with PKCS5 padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        String msg = "HiHiHiHiHiHi";
        byte[] msgBytes = msg.getBytes();
        System.out.println("Plain Text = " + msg);

        //Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encryptedBytes = cipher.doFinal(msgBytes);

        //Encode to Base64
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedEncrypted = encoder.encodeToString(encryptedBytes);
        String encodedIV = encoder.encodeToString(ivBytes);
        System.out.println("Encrypted Text (Base64) = " + encodedEncrypted);
        System.out.println("IV (Base64) = " + encodedIV);

        //Decrypt
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedEncrypted = decoder.decode(encodedEncrypted);
        byte[] decryptedBytes = cipher.doFinal(decodedEncrypted);
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted Text = " + decryptedText);
    }
}
