import java.math.BigInteger;

public class euclide {
    public static int gcd(BigInteger a, BigInteger b) {
        while (b.byteValue() != 0) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return Math.abs(a.byteValue());
    }

    public static void getGcd(BigInteger num1, BigInteger num2) {
        int result = gcd(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + result);
    }
}
