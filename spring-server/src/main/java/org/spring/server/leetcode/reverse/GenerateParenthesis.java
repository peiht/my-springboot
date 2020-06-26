package org.spring.server.leetcode.reverse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hitopei
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis (int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String str) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > 0) {
            dfs(left - 1, right, str + "(");
        }
        if (right > left) {
            dfs(left, right - 1, str + ")");
        }
    }


    public static void main(String[] args) {
        List<String> res = new GenerateParenthesis().generateParenthesis(3);
        res.forEach(System.out::println);
    }
}
