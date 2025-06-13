import java.util.Scanner;

public class isCoPrime {
       public static void main(String[] args) {
        while (true) {
            //To get the input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the first integer: ");
            int a = scanner.nextInt();

            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Enter the first integer: ");
            int b = scanner.nextInt();

            boolean isCoPrime = true;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(n + " is a prime number.");
            } else {
                System.out.println(n + " is not a prime number.");
            }
        }
    } 
}
