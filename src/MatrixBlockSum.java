public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int height = mat[0].length;
        int[][] dp = new int[row][height];
        dp[0][0] = mat[0][0];
        for(int i = 1; i<row;i++) {
            dp[0][i] = dp[0][i-1]+mat[0][i];
        }
        for(int i = 1; i<height;i++) {
            dp[i][0] = dp[i-1][0]+mat[i][0];
        }
        for(int i = 1; i<row; i++) {
            for (int j = 1; j<height; j++){
                dp[i][j] = mat[i][j]+ dp[i-1][j] + dp[i][j-1] -dp[i-1][j-1];
            }
        }

        int m = row;int n = height;
        int[][] ans = new int[m][n];

        for (int i=0; i<m; i++)  for (int j=0; j<n; j++) {
            int ei = Math.min(m-1,i+K), ej = Math.min(n-1,j+K);
            ans[i][j] = dp[ei][ej];
            if (i<=K) {
                if (j>K)  ans[i][j] -= dp[ei][j-K-1];
            } else {
                ans[i][j] -= dp[i-K-1][ej];
                if (j>K) ans[i][j]-= dp[ei][j-K-1]-dp[i-K-1][j-K-1];
            }
        }

        return ans;





    }

    public static void main(String[] args) {
        MatrixBlockSum matrixBlockSum = new MatrixBlockSum();

    }
}
