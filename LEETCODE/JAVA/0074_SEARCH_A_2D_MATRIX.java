class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[m - 1].length;
        
        int lo = 0;
        int hi = m * n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int rowMid = mid / n;
            int colMid = mid % n;

            if (matrix[rowMid][colMid] == target) {
                return true;
            }
            else if (matrix[rowMid][colMid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        return false;
    }
}
