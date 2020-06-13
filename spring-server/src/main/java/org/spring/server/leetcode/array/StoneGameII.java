package org.spring.server.leetcode.array;

/**
 * @author hitopei
 *
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 *
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 *
 * 游戏一直持续到所有石子都被拿走。
 *
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 *
 *  
 *
 * 示例：
 *
 * 输入：piles = [2,7,9,4,4]
 * 输出：10
 * 解释：
 * 如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
 * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
 * 所以我们返回更大的 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StoneGameII {

    int[][] memo;
    int[] tailSum;

    public int stoneGameII(int[] piles) {
        int N = piles.length;
        memo = new int[N][N];
        tailSum = new int[N];
        tailSum[N - 1] = piles[N - 1];
        for(int i = N - 2; i >= 0; --i) {
            tailSum[i] = piles[i] + tailSum[i + 1];
        }
        return helper(piles, 0, 1);
    }

    public int helper(int[] piles, int start, int M) {
        if(start == piles.length) {
            return 0;
        }
        if(2 * M >= piles.length - start) {
            return tailSum[start];
        }
        if(memo[start][M] != 0) {
            return memo[start][M];
        }
        int max = 0;
        for(int i = 1; i <= 2 * M; ++i) {
            max = Math.max(max, tailSum[start] - helper(piles, start + i, Math.max(M, i)));
        }
        memo[start][M] = max;
        return max;
    }
    public static void main(String[] args) {
        int[] piles = {2,7,9,4,4};
        System.out.println(new StoneGameII().stoneGameII(piles));
    }
}
