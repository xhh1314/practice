package practice.algorithm.other;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 *
 * @author lh
 * @date 2018/7/10
 * @since
 */
public class ContainarWithMostWater {

    public int maxArea(int[] height) {
        if (height == null)
            return 0;
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int l = i, r = height.length - 1;
            while (l <= r) {
                int temp = Math.min(height[l], height[r]) * (r - l);
                if (temp > max)
                    max = temp;
                r--;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int[] height = {1, 2, 4, 3};
        ContainarWithMostWater instance = new ContainarWithMostWater();
        System.out.println(instance.maxArea(height));
    }


    //----------优化解法---------------
    public int maxArea1(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

}
/*
* 给定n个非负整数a1,a2,...,an，其中每个代表一个点坐标（i,ai）。

n个垂直线段例如线段的两个端点在（i,ai）和（i,0）。

找到两个线段，与x轴形成一个容器，使其包含最多的水。

解题思路：1、 穷举法 时间复杂度O(n平方)
2、稍微优化下：距离小的往前移动 时间复杂度O(n)

* */