package org.spring.server.leetcode.competition.week202;

/**
 * @author hitopei
 *
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * 示例 2：
 *
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-consecutive-odds
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return false;
        }

        for (int i = 0; i < len - 2; i++) {
            if (arr[i]%2 == 1 && arr[i+1]%2 == 1 && arr[i+2]%2 == 1){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,5};
        System.out.println(new ThreeConsecutiveOdds().threeConsecutiveOdds(nums));
    }
}
