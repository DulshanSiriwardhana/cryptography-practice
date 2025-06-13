import java.math.BigInteger;

public class isCoPrime {
    public static void isCoPrimePrint(BigInteger x, BigInteger y) {
        if(isCoPrime(x, y)){
            System.out.println(x.toString() +", "+ y.toString()+" are co-prime to each others");
        }
        else{
            System.out.println(x.toString()+ ", " + y.toString()+" are not co-prime to each others");
        }
        //isCoPrime(new BigInteger("10"), new BigInteger("7"));
    }

    public static Boolean isCoPrime(BigInteger x, BigInteger y) {
        BigInteger c = x.gcd(y);

        if(c.intValue()==1) {
            return true;
        }
        else{
            return false;
        }
    }
}

