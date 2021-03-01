import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i * 2 < Math.min(matrix[0].length, matrix.length); i++) {
            int row = i;
            int column = i;
            int rl = matrix.length - i - 1;
            int cb = matrix[0].length - i - 1;
            for (int c = column; c <= cb; c++) {
                ans.add(matrix[row][c]);
            }
            for (int r = row + 1; r <= rl; r++) {
                ans.add(matrix[r][cb]);
            }
            for (int c = cb - 1; c >= column && rl != row; c--) {
                ans.add(matrix[rl][c]);
            }
            for (int r = rl - 1; r > row && column != cb; r--) {
                ans.add(matrix[r][column]);
            }
        }
        return ans;
    }

}
// @lc code=end
