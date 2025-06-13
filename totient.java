import java.math.BigInteger;
public class totient {
    public static void main(String[] args) {
        totient(new BigInteger("21"));
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

    public static int totient(BigInteger x){
        int val = 0;
        for(int i=1;i<x.intValue(); i++){
            if(isCoPrime(new BigInteger(String.valueOf(i)),x)){
                val+=1;
            }
        }
        System.out.println("Totient value is "+val);
        return val;
    }
}
