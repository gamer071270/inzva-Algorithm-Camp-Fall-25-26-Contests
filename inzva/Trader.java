/*
Ramazan is a Bitcoin enjoyer and as you know, Bitcoin price isn't going well these days.
That's why Ramazan decided to make small profits by making swaps.
He looks at the price at the end of each day, and he either buys, sells, or does nothing at that price.
Melih has an incredible forecasting ability and knows closing prices for the end of the next N days.
Help Ramazan to buy and sell from the right places. But be careful, Ramazan holds a maximum of 1 Bitcoin so as not to risk too much.
*/


import java.util.Scanner;

public class Trader {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();
        String[] s = input.nextLine().split(" ");
        int[] prices = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prices[i] = Integer.parseInt(s[i-1]);
        }
        int[][] dp = new int[2][n+1];
        dp[0][1] = 0;
        dp[1][1] = -prices[1];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]+prices[i]);
            dp[1][i] = Math.max(dp[0][i-1]-prices[i], dp[1][i-1]);
        }
        System.out.println(Math.max(dp[0][n], dp[1][n]));
    }
}
