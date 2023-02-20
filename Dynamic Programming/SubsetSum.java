import java.util.Scanner;

public class SubsetSum {
    public static boolean isSubsetPossible(int[] arr, int n, int sum) {
        boolean[][] t = new boolean[n + 1][sum + 1]; // DP - matrix
        // initialization
        // here we are setting 1st row and 1st column 
        // i denotes the size of the array 
        // j denotes the target sum (subset sum)
        for (int i = 0; i <= n; i++) { // iterate as long it is less than length of the array
            for (int j = 0; j <= sum; j++) { 
                if (i == 0) // when array(i) is empty than there is no meaning of sum of elements so return false
                    t[i][j] = false;
                if (j == 0) // when sum(j) is zero and there is always a chance of empty subset so return it as true
                    t[i][j] = true;
            }
        }
        // start from 1 since 1st row and column is already considered
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) // after taking an element subtract from the (sum) i.e -> in {3,8} 3 is taken then we want 11-3=8 in the array 
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j]; // either take or(||) do not take 
                else // if sum is less than array size just leave and increment
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum]; // at last return T/F
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int sum = sc.nextInt();
        System.out.println(isSubsetPossible(arr, n, sum) ? "Yes" : "No");
    }
}
/*
Complexity Analysis: 

Time Complexity: O(sum*n), where sum is the ‘target sum’ and ‘n’ is the size of array.
Auxiliary Space: O(sum*n), as the size of 2-D array is sum*n.
*/ 
