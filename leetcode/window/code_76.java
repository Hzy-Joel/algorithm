package leetcode.window;

import java.util.HashMap;

/***
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 示例 1：
 * 
 * 输入：s = "ADOBECODEBANC", t = "ABC" 输出："BANC" 示例 2：
 * 
 * 输入：s = "a", t = "a" 输出："a"  
 * 
 * 提示：
 * 
 * 1 <= s.length, t.length <= 105 s 和 t 由英文字母组成  
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code_76 {

    public static void main(String[] aCharrgs) {
        code_76 c = new code_76();
        c.minWindow("ADOBECODEBANC", "ABC");
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        HashMap<Character, Integer> match = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            match.put(t.charAt(i), match.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;

        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (match.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(match.get(c)))
                    valid++;
            }
            System.out.println("window: [" + left + ", " + right + ")\n");
            while (valid == match.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (match.containsKey(d)) {
                    if (window.get(d).equals(match.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }

            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}