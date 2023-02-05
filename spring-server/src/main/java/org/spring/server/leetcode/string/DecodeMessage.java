package org.spring.server.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hitopei
 *
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 * <p>
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 *
 *
 */
public class DecodeMessage {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (' ' != c) {
                if (!map.containsKey(c)) {
                    map.put(c, (char) index);
                    index++;
                }
            }
        }

        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char x = message.charAt(i);
            if (' ' != x) {
                resBuilder.append((char)(map.get(x) + 97));
            } else {
                resBuilder.append(' ');
            }
        }
        return resBuilder.toString();
    }

    public static void main(String[] args) {
        DecodeMessage decodeMessage = new DecodeMessage();
        String res = decodeMessage.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
        System.out.println(res);
    }
}
