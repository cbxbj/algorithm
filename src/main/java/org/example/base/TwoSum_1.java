package org.example.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * 简单
 * 总结:利用hash
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            throw new IllegalArgumentException("Array length is less than 2");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int local = nums[i];
            int result = target - local;
            if (map.containsKey(result))
                return new int[]{map.get(result), i};
            map.put(local, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
