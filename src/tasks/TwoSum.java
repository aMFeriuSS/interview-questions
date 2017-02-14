package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Дан массив целых чисел и целевое число.
 * Необходимо вернуть индексы двух чисел,
 * которые в сумме дают целевое число.
 *
 * Created by toctep on 14.02.17.
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    // Test stuff
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 5, 8, 10, 2, 6}, 7)));
    }
}
