package org.spring.server.leetcode.string;

/**
 * @author hitopei
 *
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 *
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 *
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 *
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 *
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class PatternMatching {

    public boolean patternMatching(String pattern, String value) {
        //整活前先判断一万个边界条件
        if(value.length() == 0) {
            for(int i = 0; i < pattern.length(); i++) {
                if(i == 0)
                    continue;
                if(pattern.charAt(i) != pattern.charAt(i-1))
                    return false;
            }
            return true;
        }
        if(pattern.length() == 0)
            return false;

        //记录a的数量和b的数量，以及第一个a或b之前有多少个b或a，这样后面可以直接推出第一个a或b的坐标
        //比如第一个b的起始坐标为prea*aLen，那他的字符串为value.substring(prea*aLen, prea*aLen+bLen);
        int aCount = 0, bcount = 0, preb = 0, aPos = -1, prea = 0, bPos = -1;
        for(int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'a') {
                aCount++;
                if(aPos == -1) {
                    preb = bcount;
                    aPos = i;
                }
            }
            else {
                bcount++;
                if(bPos == -1) {
                    prea = aCount;
                    bPos = i;
                }
            }
        }
        if(aCount == 1 || bcount == 1)
            return true;

        if(aCount == 0 && (value.length() % bcount != 0) || (bcount == 0 && (value.length() % aCount != 0)))
            return false;

        //开始整活
        int aLength = 0;
        if(aCount != 0) //如果aCount==0，那么b只有一种可能，这样写防止/zero报错
            aLength = value.length()/aCount;
        for(int aLen = 0; aLen <= aLength; aLen++) {
            if(bcount != 0 && (value.length()-aCount*aLen) % bcount != 0)
                continue;
            int bLen = 0;   //防止报错
            if(bcount != 0)
                bLen = (value.length()-aCount*aLen)/bcount;

            String aAlp = value.substring(preb*bLen, preb*bLen+aLen);
            String bAlp = value.substring(prea*aLen, prea*aLen+bLen);
            int pos = 0, cur = 0;
            while(pos < value.length() && cur < pattern.length()) {
                if(aLen != 0 && pattern.charAt(cur) == 'a') {
                    if(pos+aLen <= value.length() && value.substring(pos, pos+aLen).equals(aAlp))
                        pos += aLen;
                    else
                        break;
                }
                else if(bLen != 0 && pattern.charAt(cur) == 'b') {
                    if(pos+bLen <= value.length() && value.substring(pos, pos+bLen).equals(bAlp))
                        pos += bLen;
                    else
                        break;
                }
                else
                    pos++;
                cur++;
            }
            //pos能走一个流程，说明匹配成功
            if(pos >= value.length())
                return true;
        }
        return false;
    }
}
