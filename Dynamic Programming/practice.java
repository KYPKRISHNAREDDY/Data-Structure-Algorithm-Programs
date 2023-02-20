import java.util.Scanner;

public class practice {

    static final int D=1000;
    static int[][] t=new int[D][D];

    static int countOfSubsetsWithGivenSum(int arr[],int n,int sum)
    {
        int tt[][]=new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                    tt[i][j]=0;
                if(j==0)
                    tt[i][j]=1;
            }
        
        for(int i=1;i<=n;i++)
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]<=j)
                    tt[i][j]=tt[i-1][j-arr[i-1]]+tt[i-1][j];
                else    
                    tt[i][j]=tt[i-1][j];
            }
        return tt[n][sum];
    }
    static boolean isSubsetPossible(int arr[],int n,int sum)
    {
        boolean tt[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                    tt[i][j]=false;
                if(j==0)
                    tt[i][j]=true;
            }
        
        for(int i=1;i<=n;i++)
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]<=j)
                {
                    tt[i][j]=tt[i-1][j-arr[i-1]] || tt[i-1][j];
                }
                else
                    tt[i][j]=tt[i-1][j];
            }
        return tt[n][sum];
    }
    static boolean equalSumPartition(int arr[],int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=arr[i];
        
        if(sum%2!=0)return false;
        else{
            return isSubsetPossible(arr,n, sum/2 );
        }
    }
    static boolean subsetSum(int arr[],int sum,int n)
    {
        boolean tt[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                    tt[i][j]=false;
                if(j==0)
                    tt[i][j]=true;
            }
        
        for(int i=1;i<=n;i++)
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]<=j)
                {
                    tt[i][j]=tt[i-1][j-arr[i-1]] || tt[i-1][j];
                }
                else
                {
                    tt[i][j]=tt[i-1][j];
                }
            }
        return tt[n][sum];
        
    }
    static int KnapsackBottomUp(int wt[],int val[],int w,int n)
    {
        int [][] tt=new int[n+1][w+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=w;j++)
            {
                if(i==0 || j==0)
                    tt[i][j]=0;
                else if(wt[i-1]<=j)
                {
                   
                    
                        int val1=val[i-1]+tt[i-1][j-wt[i-1]];
                        int val2=tt[i-1][j];
                        tt[i][j]=Math.max(val1,val2);
                }
                else if(wt[i-1]>j)
                {
                    tt[i][j]=tt[i-1][j];
                }

            }
        }
        return tt[n][w];
    }
    static int Knapsackmemoization(int wt[],int val[],int w,int n)
    {
        if(n==0||w==0)return 0;

        if(t[n][w]!=-1)
            return t[n][w];
        
        else{
            if(wt[n-1]<=w)
                 t[n][w]=Math.max(val[n-1]+Knapsackmemoization(wt, val, w-wt[n-1], n-1),Knapsackmemoization(wt, val, w, n-1));
            else   
                 t[n][w]=Knapsackmemoization(wt, val, w, n-1);

                return t[n][w];
        }
    }
    static int KnapsackRec(int wt[],int []val,int w,int n)
    {
        if(n==0||w==0)return 0;

        if(wt[n-1]<=w)
            return Math.max(val[n-1]+KnapsackRec(wt, val, w-wt[n-1], n-1),KnapsackRec(wt, val, w, n-1));
        else 
            return KnapsackRec(wt, val, w, n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // int[] val=new int[n];
        // int[] wt=new int[n];
        // for(int i=0;i<n;i++)
        //     wt[i]=sc.nextInt();
        // for(int i=0;i<n;i++)
        //     val[i]=sc.nextInt();
    
        // int w=sc.nextInt();

        // for(int i=0;i<=n;i++)
        //     for(int j=0;j<=w;j++)
        //         t[i][j]=-1;

        // System.out.println(KnapsackBottomUp(wt,val,w,n));

        int n=sc.nextInt();
        int sum=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        System.out.println(subsetSum(arr, sum, n)?"Yes":"No");
        System.out.println(equalSumPartition(arr, n)?"Yes":"No");
        System.out.println(countOfSubsetsWithGivenSum(arr, n, sum));
        sc.close();

    }
}
