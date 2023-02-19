import java.util.Scanner;

public class RecursiveKnapsack {
    public static int knapsack(int[] wt, int[] val, int W, int n) {
        // every recursive solution will have a base condition
        // for base condition we need to think of the smallest valid input that we can pass
        // array size can be at least 0 || min weight can be 0 but not negative;
        if (n == 0 || W == 0) {
            return 0;
        }

        // these are the choices we are having
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1),
                    knapsack(wt, val, W, n - 1));
        } else if (wt[n - 1] > W) { // if the weight is greater than the required weight there is no sense for taking that value.
            return knapsack(wt, val, W, n - 1); // return as it is by reducing the size of array
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of items
        int[] val = new int[n]; // values of array
        int[] wt = new int[n]; // weights of array
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int W = sc.nextInt(); // Knapsack capacity
        System.out.println(knapsack(wt, val, W, n));
    }
}
// T(N) = 2T(N-1) + O(1), which is simplified to O(2^N).
