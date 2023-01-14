// We have to paint n boards of length {A1, A2…An}. There are k painters available 
// and each takes 1 unit of time to paint 1 unit of the board. The problem is to 
// find the minimum time to get this job was done under the constraints that 
// any painter will only paint continuous sections of boards, say board {2, 3, 4} 
// or only board {1} or nothing but not board {2, 4, 5}.
// Input : k = 2, A = {10, 10, 10, 10} 
// Output : 20
// Explanation: Here we can divide the boards into 2 equal sized 
// partitions, so each painter gets 20 units of board and the total time taken is 20. 

// Input : k = 2, A = {10, 20, 30, 40} 
// Output : 60
// Explanation: Here we can divide first 3 boards for one painter 
// and the last board for second painter.

import java.util.*;
import java.io.*;

class PaintersProblem {

static int sum(int arr[], int from, int to) {
	int total = 0;
	for (int i = from; i <= to; i++)
		total += arr[i];
	return total;
}

static int findMax(int arr[], int n, int k) {
	int dp[][] = new int[k+1][n+1];

	for (int i = 1; i <= n; i++)
		dp[1][i] = sum(arr, 0, i - 1);

	for (int i = 1; i <= k; i++)
		dp[i][1] = arr[0];

	for (int i = 2; i <= k; i++) { 
		for (int j = 2; j <= n; j++) {

			int best = Integer.MAX_VALUE;

			for (int p = 1; p <= j; p++)
				best = Math.min(best, Math.max(dp[i - 1][p],
							sum(arr, p, j - 1)));	

			dp[i][j] = best;
		}
	}

	return dp[k][n];
}

    public static void main(String args[]) {
        int arr[] = {10, 20, 30, 40};
        int n = arr.length;
	    int k = 2;
	    System.out.println(findMax(arr, n, k));
    }
}
