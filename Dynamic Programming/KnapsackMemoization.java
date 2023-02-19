
import java.util.Scanner;

public class KnapsackMemoization {
    static final int D = 1000; // DP - matrix dimension
    static int[][] t = new int[D][D]; // DP matrix

    static int Knapsack(int[] wt, int[] val, int W, int n) {
        // base case
        if (n == 0 || W == 0) {
            return 0;
        }

        // if already calculated
        if (t[n][W] != -1) {
            return t[n][W];
        }

        // else calculate
        else {
            if (wt[n - 1] <= W) {
                t[n][W] = Math.max(val[n - 1] + Knapsack(wt, val, W - wt[n - 1], n - 1), Knapsack(wt, val, W, n - 1));
            } else if (wt[n - 1] > W) {
                t[n][W] = Knapsack(wt, val, W, n - 1);
            }

            return t[n][W];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of items
        int[] val = new int[n]; // values array
        int[] wt = new int[n]; // weights array

        for (int i = 0; i < n; i++) {
            wt[i] = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            val[i] = input.nextInt();
        }

        int W = input.nextInt(); // Knapsack capacity

        // matrix initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                t[i][j] = -1; // initialize matrix with -1
            }
        }

        System.out.println(Knapsack(wt, val, W, n));
    }
}
