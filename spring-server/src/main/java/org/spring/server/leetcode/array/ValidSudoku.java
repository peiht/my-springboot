package org.spring.server.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author hitopei
 *
 *
 * 最简单的就是三个判断，横着判断、竖着判断、还有小方格也判断
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if(board == null) {
            return false;
        }
        if(board.length !=9) {
            return false;
        }
        int[] map = new int[9];
        for(int y=0; y<9; y++){
            if(board[y] == null || board[y].length != 9) {
                return false;
            }
            for(int x=0; x<9; x++){
                int key = board[y][x] - '1'; //key:数字
                if(key >= 0 && key <= 8) {  //1~9有效数字
                    int index = (1<<x)     //Value:位置编码，最低9位存放列号
                            | (1<<(y+9))    //中间9位存放行号
                            | (1<<(x/3 + y/3*3 + 18));  // z为9宫格区域序号
                    //当有相同的数字的时候，查询已经放入map中的index,位置重复，就说明已经存在此数了
                    int old = map[key];
                    if((old & index) == 0) //无重复，则按位或，加入位置集合
                    {
                        map[key] = old | index;
                    } else    //有重复
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board){
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        ValidSudoku validSudoku = new ValidSudoku();
        boolean result = validSudoku.isValidSudoku1(sudoku);
        System.out.println(result);
    }
}
