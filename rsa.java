import java.math.BigInteger;

public class rsa {

    static BigInteger getPower(BigInteger x, BigInteger n, BigInteger m){
        return x.modPow(n, m);
    }

    static BigInteger encrypt(BigInteger m, BigInteger e, BigInteger n) {
        return getPower(m, e, n);
    }

    static BigInteger decrypt(BigInteger c, BigInteger d, BigInteger n) {
        return getPower(c, d, n);
    }

    static BigInteger modInverse(BigInteger e, BigInteger phi) {
        return e.modInverse(phi);
    }

    static void generateKey(BigInteger[] keys) {
        BigInteger p = new BigInteger("4583");
        BigInteger q = new BigInteger("875689");

        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

                BigInteger e = BigInteger.ZERO;
        for (e = new BigInteger("2"); e.compareTo(phi) < 0; e = e.add(BigInteger.ONE)) {
            if (e.gcd(phi).equals(BigInteger.ONE)) {
                break;
            }
        }

        BigInteger d = modInverse(e, phi);

        keys[0] = e;
        keys[1] = d;
        keys[2] = n; 
    }

    public static void rsainit(){
        BigInteger[] keys = new BigInteger[3];
        
        generateKey(keys);
      
        System.out.println("Public Key (e, n): (" + keys[0] + ", " + keys[2] + ")");
        System.out.println("Private Key (d, n): (" + keys[1] + ", " + keys[2] + ")");

        BigInteger M = new BigInteger("10001001001001");
        System.out.println("Original Message: " + M);

        BigInteger C = encrypt(M, keys[0], keys[2]);
        System.out.println("Encrypted Message: " + C);

        BigInteger decrypted = decrypt(C, keys[1], keys[2]);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
