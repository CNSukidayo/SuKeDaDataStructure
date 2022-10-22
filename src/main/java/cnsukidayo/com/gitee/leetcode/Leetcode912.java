package cnsukidayo.com.gitee.leetcode;

/**
 * @author: sukidayo
 * @date: 2022/10/22 13:52
 */
public class Leetcode912 {
    public int[] sortArray(int[] nums) {
        sort(0, nums.length - 1, nums);
        return nums;
    }

    private void sort(int left, int right, int[] array) {
        if (left == right) {
            return;
        }

        // 中间的节点
        int middle = left + (right - left) / 2;
        // 排序左边的数组
        sort(left, middle, array);
        // 排序右边的数组
        sort(middle + 1, right, array);
        // 合并两边的数组
        merge(left, middle + 1, right, array);
    }

    private void merge(int left, int middle, int right, int[] array) {
        int[] result = new int[right - left + 1];
        int index = 0;
        int leftDead = middle;
        while (left < leftDead && middle <= right) {
            result[index++] = array[left] < array[middle] ? array[left++] : array[middle++];
        }
        while (left < leftDead) {
            result[index++] = array[left++];
        }
        while (middle <= right) {
            result[index++] = array[middle++];
        }
        for (int i = result.length - 1; i > -1; i--) {
            array[right--] = result[i];
        }
    }

}
