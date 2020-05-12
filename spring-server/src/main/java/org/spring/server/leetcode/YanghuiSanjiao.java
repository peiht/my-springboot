package org.spring.server.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class YanghuiSanjiao {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();

        if (numRows == 0){
            return lists;
        }
        if (numRows == 1){
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            lists.get(0).add(1);
            return lists;
        }

        lists = generate(numRows-1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i=1; i<numRows-1;i++){
            list.add(lists.get(numRows-2).get(i-1) + lists.get(numRows-2).get(i));
        }
        list.add(1);
        lists.add(list);
        return lists;
    }


    public static void main(String[] args) {
        YanghuiSanjiao yanghuiSanjiao = new YanghuiSanjiao();
        List<List<Integer>>  result = yanghuiSanjiao.generate(5);

        List<Integer> result1 = yanghuiSanjiao.getRowData(4);

    }

    public List<Integer> getRowData(int numRows){
        List<Integer> list = new ArrayList<>(numRows);
        if (numRows == 0){
            return list;
        }

        int pre = 1;
        list.add(1);
        for (int i=1; i<numRows;i++){
            for (int j=1; j<i; j++){
                int temp = list.get(j);
                list.set(j, pre + list.get(j));
                pre = temp;
            }
            list.add(1);
        }

        return list;
    }
}
