import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (isLeft(ch))
                stack.push(ch);
            else {
                if (stack.isEmpty() || stack.pop() != getLeft(ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(Character ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private Character getLeft(Character ch) {
        if (ch == ')')
            return '(';
        else if (ch == ']')
            return '[';
        else if (ch == '}')
            return '{';
        else return '\0';

    }
}
// @lc code=end
