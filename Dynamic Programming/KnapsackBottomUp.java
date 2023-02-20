import java.util.*;

class KnapsackBottomUp{
    static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] t = new int[n + 1][W + 1]; // DP matrix

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) // base case
                    t[i][j] = 0;
                else if (wt[i - 1] <= j) { // current wt can fit in bag
                    int val1 = val[i - 1] + t[i - 1][j - wt[i - 1]]; // take current wt
                    int val2 = t[i - 1][j]; // skip current wt
                    t[i][j] = Math.max(val1, val2);
                } else if (wt[i - 1] > j) // current wt doesn't fit in bag
                    t[i][j] = t[i - 1][j]; // move to next
            }
        }

        return t[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of items
        int[] wt = new int[n]; // weights array
        int[] val = new int[n]; // values array
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        int W = sc.nextInt(); // capacity

        System.out.println(knapsack(wt, val, W, n));
    }
}

/* Complexity Analysis: 

Time Complexity: O(N*W). 
where ‘N’ is the number of weight element and ‘W’ is capacity. As for every weight element we traverse through all weight capacities 1<=w<=W.
Auxiliary Space: O(N*W). 
The use of 2-D array of size ‘N*W’.

*/

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
