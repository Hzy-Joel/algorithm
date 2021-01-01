package leetcode.window;

import java.util.HashMap;

/***
 * 567. 字符串的排列 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 
 * 示例1:
 * 
 * 输入: s1 = "ab" s2 = "eidbaooo" 输出: True 解释: s2 包含 s1 的排列之一 ("ba").
 * 
 * 
 * 示例2:
 * 
 * 输入: s1= "ab" s2 = "eidboaoo" 输出: False
 * 
 * 
 * 注意：
 * 
 * 输入的字符串只包含小写字母 两个字符串的长度都在 [1, 10,000] 之间
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class code_567 {
    public static void main(String[] aCharrgs) {
        code_567 c = new code_567();
        System.out.println(c.checkInclusion("ab","eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> match = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0;

        int vaild = 0;
        int len = s1.length() + 1;
        while (right < s2.length()) {
            char ch = s2.charAt(right);
            right++;
            if (need.containsKey(ch)) {
                match.put(ch, match.getOrDefault(ch, 0) + 1);
                if (match.get(ch).equals(need.get(ch)))
                    vaild++;
            }
            while (vaild == need.size()) {
                len = right - left;
                if (len == s1.length()) return true;
                ch = s2.charAt(left);
                left++;
                if (need.containsKey(ch)) {
                    if (match.get(ch).equals(need.get(ch)))
                        vaild--;
                    match.put(ch, match.getOrDefault(ch, 0) - 1);
                }
            }
        }
        return false;
    }

}