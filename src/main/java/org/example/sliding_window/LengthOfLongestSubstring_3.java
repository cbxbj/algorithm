package org.example.sliding_window;

import java.util.HashMap;

/**
 * 3.无重复字符的最长子串
 * 中等
 * 滑动窗口
 * 总结:滑动窗口遇到相同的替换上一个即可
 */
public class LengthOfLongestSubstring_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * map的k为字符,v为字符所在的索引
     * 先判断map中存不存在该字符
     * 存在:把记录该字符的索引字段start换为新的字符索引
     * 接着取 之前的最大值和现在索引减去开始索引 的最大值
     * map存放字符和当前索引
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }
}
