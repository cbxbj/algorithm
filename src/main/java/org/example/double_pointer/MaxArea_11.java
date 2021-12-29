package org.example.double_pointer;

/**
 * 11.盛最多水的容器
 * 左右指针
 * 双指针夹逼
 * 中等
 * 总结:利用左右指针
 * 面积=底×高,底👇高👆
 */
public class MaxArea_11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{10, 4, 30, 10}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int area;
        while (left != right) {
            area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(area, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
