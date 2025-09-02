public class PolygonTriangulation {

    // Function to compute minimum score triangulation using tabulation
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n]; // dp[i][j] = min score from polygon [i...j]

        // Start with smaller intervals and build up
        for (int gap = 2; gap < n; gap++) {  // gap = distance between i and j
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible middle points k
                for (int k = i + 1; k < j; k++) {
                    int score = values[i] * values[j] * values[k] 
                              + dp[i][k] + dp[k][j]; // triangle(i,k,j)
                    dp[i][j] = Math.min(dp[i][j], score);
                }
            }
        }

        return dp[0][n - 1]; // minimum score for whole polygon
    }

    // Main function to test the solution
    public static void main(String[] args) {
        PolygonTriangulation solver = new PolygonTriangulation();

        int[] values1 = {1, 2, 3};
        System.out.println("Minimum Score Triangulation (Example 1): " 
                            + solver.minScoreTriangulation(values1));

        int[] values2 = {3, 7, 4, 5};
        System.out.println("Minimum Score Triangulation (Example 2): " 
                            + solver.minScoreTriangulation(values2));

        int[] values3 = {1, 3, 1, 4, 1, 5};
        System.out.println("Minimum Score Triangulation (Custom Example): " 
                            + solver.minScoreTriangulation(values3));
    }
}
