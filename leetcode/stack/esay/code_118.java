package leetcode.stack.esay;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
class code_118 {
    public static void main(String[] args) {
        List<List<Integer>> rs = generate(2);
        for (List<Integer> list : rs) {
            for (Integer num : list) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new ArrayList<>();
        if (numRows <= 0)
            return rs;
        ArrayList<Integer> lastRow = new ArrayList<>();
        lastRow.add(1);
        rs.add(lastRow);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> newRow = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                newRow.add(getNum(lastRow, j));
            }
            lastRow = newRow;
            rs.add(newRow);
        }
        return rs;
    }

    public static Integer getNum(List<Integer> row, int i) {
        int last1 = i - 1 >= 0 ? row.get(i - 1) : 0;
        int last2 = i < row.size() ? row.get(i) : 0;
        return last1 + last2;
    }
}
