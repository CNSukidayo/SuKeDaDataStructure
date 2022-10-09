package cnsukidayo.com.gitee.offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: sukidayo
 * @date: 2022/10/8 20:04
 */
public class Offer40 {


    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int left = 0;
        int right = 1;
        int max = 0;
        int[] result = new int[k];
        while (right != arr.length) {
            queue.add(Math.min(arr[left], arr[right]));
            right++;
            left++;
            max++;
        }
        int count = 0;
        Integer pre = null;
        while (!queue.isEmpty() && queue.size() != k) {
            Integer first = null;
            Integer second = null;
            if (count == 0) {
                first = queue.poll();
                second = queue.poll();
            } else {
                second = queue.poll();
                first = pre;
            }
            pre = second;
            queue.add(Math.min(first, second));
            count++;
            if (max == count + 1) {
                count = 0;
                max--;
            }
        }
        int index = 0;
        for (Integer integer : queue) {
            result[index++] = integer;
        }
        return result;
    }

}
