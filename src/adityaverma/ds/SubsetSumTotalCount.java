package src.adityaverma.ds;

public class SubsetSumTotalCount {

    int[][] t;

    public int isSubSetSum(int[] arr, int sum, int N) {
        /*Base condition - Smallest possible value
         */
        if (sum == 0)
            return 1;
        if (N <= 0)
            return 0;
        if (t[N][sum]!=0)
            return t[N][sum];

        if (arr[N - 1] <= sum) {
            t[N][sum] = isSubSetSum(arr, sum - arr[N - 1], N - 1) + isSubSetSum(arr, sum, N - 1);
        } else {
            t[N][sum] = isSubSetSum(arr, sum, N - 1);
        }

        return t[N][sum];
    }

    public int isSubSetSumTopDown(int[] arr, int sum, int N) {
        int[][] t = new int[N + 1][sum + 1];
        /*
        i-->N
        j-->sum
         */
        /* Initialization - Base Condition*/
        /*
        Sum=0 is always possible with empty set
         */
        for (int i = 0; i < N + 1; i++) {
            t[i][0] = 1;
        }

        /*Choice diagram*/
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[N][sum];
    }

    public SubsetSumTotalCount(int sum, int N) {
        t = new int[N + 1][sum + 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 10,6};
        int sum = 9, N = (arr != null) ? arr.length : 0;
        SubsetSumTotalCount obj = new SubsetSumTotalCount(sum, N);
        System.out.println("Recursion:" + obj.isSubSetSum(arr, sum, N) + " Top down:" + obj.isSubSetSumTopDown(arr, sum, N));
    }
}
