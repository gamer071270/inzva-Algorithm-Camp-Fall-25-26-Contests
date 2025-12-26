/*
In a magnificent inzva camp, Ceren and Hacer are playing a game in the garden.
Each round, they randomly choose an integer n.
The problem is to find the maximum number of elements of a subset of {1,…,n} such that the sum of any two integers is not divisible by 11.
They can normally calculate it very quickly but there are lots of hedgehogs in the garden and they distract their attention.
Can you help Hacer and Ceren calculate the answers?
 */

import java.util.Scanner;

public class Kirpiler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        long n;
        for (int i = 0; i < t; i++) {
            n = input.nextLong();
            if (n <= 5) {
                System.out.println(n);
            }
            else if (n <= 10) {
                System.out.println(5);
            }
            else {
                long d = n / 11;
                long remainder = n % 11;
                if (remainder < 6) {
                    long result = n - (6 * d - 1);
                    System.out.println(result);
                } else {
                    long result = 5 * (d+1) + 1;
                    System.out.println(result);
                }
            }
        }
    }
}
