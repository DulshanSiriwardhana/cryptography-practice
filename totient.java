import java.math.BigInteger;
public class totient {
    public static int totient(BigInteger x){
        int val = 0;
        for(int i=1;i<x.intValue(); i++){
            if(isCoPrime.isCoPrime(new BigInteger(String.valueOf(i)),x)){
                val+=1;
            }
        }
        System.out.println("Totient value is "+val);
        return val;
    }
}
