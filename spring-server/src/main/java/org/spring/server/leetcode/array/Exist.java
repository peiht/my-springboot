package org.spring.server.leetcode.array;

/**
 * @author hitopei
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0){
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int cur){
        if (word.length() == cur){
            flag = true;
            return false;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(cur)){
            return false;
        }
        if (!flag) {
            char c = board[i][j];
            board[i][j] = '.';
            boolean res1 = dfs(board, i + 1, j, word, cur + 1);
            boolean res2 = dfs(board, i, j + 1, word, cur + 1);
            boolean res3 = dfs(board, i - 1, j, word, cur + 1);
            boolean res4 = dfs(board, i, j - 1, word, cur + 1);
            board[i][j] = c;
            return res1 || res2 || res3 || res4;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] board = {  {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}};

        System.out.println(new Exist().exist(board, "ABF"));
    }
}
