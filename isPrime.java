import java.util.Scanner;

public class isPrime {
    public static void isPrime() {
            //while (true) {
            //To get the input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an integer: ");
            int n = scanner.nextInt();

            boolean isPrime = true;


            //This if conditoin if set to avoid negative value and, so any integer less than 2 is not a prime!
            if (n <= 1) {
                isPrime = false;
            } else {
                //We can set the for loop starting from 2 - sqrt(n), 
                //because any there are two pair of divisors always if one is less than square root of n other one is greater than that, so checking one is enough
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.println(n + " is a prime number.");
            } else {
                System.out.println(n + " is not a prime number.");
            }
        //}
    }
}
