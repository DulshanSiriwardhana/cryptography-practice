import java.math.BigInteger;

public class isCoPrime {
       public static void main(String[] args) {
        isCoPrime(new BigInteger("10"), new BigInteger("7"));
    } 

    public static void isCoPrime(BigInteger x, BigInteger y) {
        BigInteger c = x.gcd(y);

        if(c.intValue()==1) {
            System.out.println("These number are co-prime to each others");
        }
        else{
            System.out.println("These number are not co-prime to each others");
        }
        return ;
    }
}
