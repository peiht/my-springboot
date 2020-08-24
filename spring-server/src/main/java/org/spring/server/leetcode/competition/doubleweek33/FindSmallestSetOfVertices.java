package org.spring.server.leetcode.competition.doubleweek33;

import java.util.*;

/**
 * @author hitopei
 *
 * 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
 *
 * 找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
 *
 * 你可以以任意顺序返回这些节点编号。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
 * 输出：[0,3]
 * 解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。从 3 出发我们可以到达 [3,4,2,5] 。所以我们输出 [0,3] 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
 * 输出：[0,2,3]
 * 解释：注意到节点 0，3 和 2 无法从其他节点到达，所以我们必须将它们包含在结果点集中，这些点都能到达节点 1 和 4 。
 *
 *
 * 提示：
 *
 * 2 <= n <= 10^5
 * 1 <= edges.length <= min(10^5, n * (n - 1) / 2)
 * edges[i].length == 2
 * 0 <= fromi, toi < n
 * 所有点对 (fromi, toi) 互不相同。
 */
public class FindSmallestSetOfVertices {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //Collections.sort(edges, (e1, e2) -> e1.get(0) - e2.get(0));
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> list = edges.get(i);
            if (!map.containsKey(list.get(0))) {
                set.add(list.get(0));
                map.put(list.get(0), 1);
            }
            map.put(list.get(1), 1);
            if (map.containsKey(list.get(1))){
                set.remove(list.get(1));
            }
        }

        set.forEach(s -> {
            res.add(s);
        });
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(0, 1);
        List<Integer> list2 = Arrays.asList(0, 2);
        List<Integer> list3 = Arrays.asList(2, 5);
        List<Integer> list4 = Arrays.asList(3, 4);
        List<Integer> list5 = Arrays.asList(4, 2);
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(list1);
        edges.add(list2);
        edges.add(list3);
        edges.add(list4);
        edges.add(list5);
        FindSmallestSetOfVertices findSmallestSetOfVertices = new FindSmallestSetOfVertices();
        System.out.println(findSmallestSetOfVertices.findSmallestSetOfVertices(6, edges).toString());
    }
}
