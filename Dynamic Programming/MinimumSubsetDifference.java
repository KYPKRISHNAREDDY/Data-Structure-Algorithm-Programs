import java.util.*;

public class MinimumSubsetDifference {

    public static List<Integer> isSubsetPoss(int arr[], int n, int sum) {
        boolean t[][] = new boolean[n + 1][sum + 1]; // DP - matrix
        // initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }
        // taking from the 2nd row and 2nd column
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j]; // include or exclude
                else
                    t[i][j] = t[i - 1][j]; // exclude
            }
        }

        List<Integer> v = new ArrayList<Integer>(); 
        // contains all subset sums possible with n elements
        // creating a list to store all the elements of the last row
        for (int j = 0; j <= sum; j++) // from the range we need to exclude the element which is not there in the existing problem
            if (t[n][j] == true) // keep true to only those places whose subset sum exists
                v.add(j); // store in the list

        return v;
    }

    public static int minSubsetSumDiff(int arr[], int n) {
        int range = 0;
        for (int i = 0; i < n; i++)
            range += arr[i]; // taking sum of the array for range

        List<Integer> v = isSubsetPoss(arr, n, range);
        int mn = Integer.MAX_VALUE;
        
        for (int i = 0; i < v.size(); i++) // iterating through the last row of the matrix
            mn = Math.min(mn, Math.abs(range - 2 * v.get(i))); // taking minimum from the last row

        return mn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(minSubsetSumDiff(arr, n));
        sc.close();
    }
}
