import java.util.*;

public class UnboundedKnapsack{
    static int unboundedKnapsackk(int W, int[] val, int[] wt, int n) {
        int[] dp = new int[W + 1];
        for (int i = 0; i <= W; i++)
            for (int j = 0; j < n; j++)
                if (wt[j] <= i)
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
        return dp[W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of items
        int[] val = new int[n]; // values array
        int[] wt = new int[n]; // weights array
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        int W = sc.nextInt(); // knapsack capacity
        System.out.println(unboundedKnapsackk(W, val, wt, n));
    }
}
