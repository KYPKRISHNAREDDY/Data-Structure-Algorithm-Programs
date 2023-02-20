import java.util.*;

public class RodCuttingProblem {

    public static int getMaxProfit(int[] length, int[] price, int n, int L) {
        int[][] dp = new int[n + 1][L + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= L; j++)
                if (j == 0 || i == 0)
                    dp[i][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= L; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - length[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][L];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] length = new int[n];
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        int L = sc.nextInt();

        System.out.println(getMaxProfit(length, price, n, L));
    }
}
