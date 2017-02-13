package tasks;

import java.util.HashMap;

/**
 *  Задача:
 *      - Поиск максимального количества одинаковых элементов.
 *
 *  Описание:
 *      - Необходимо найти маскимальное количество последовательных вхождений символа в строке (элемента в массиве)
 *      На вход метода подаётся строка (так же это может быть массив).
 *      Необходимо на выходе получить список пар ключ/значение, где ключом
 *      является элемент, а значением - самое длинная последовательность этих элементов, входящая в строку.
 *
 * Created by toctep on 13.02.17.
 */
public class CharMaxSequenceCounter {
    public static HashMap<Character, Integer> charMaxSequenceCounter(String source) {
        HashMap<Character, Integer> result = new HashMap<>();

        if (source.length() == 0) return result;
        if (source.length() == 1) {
            result.put(source.charAt(0), 1);
            return result;
        }

        char prev = source.charAt(0);
        int count = 1;

        for (int i = 1; i < source.length(); i++) {
            char curr = source.charAt(i);

            if (curr == prev) {
                count++;
            } else {
                if (result.containsKey(prev)) {
                    if (count > result.get(prev)) {
                        result.put(prev, count);
                        count = 1;
                    }
                } else {
                    result.put(prev, count);
                    count = 1;
                }
            }
            prev = curr;
        }
        if (result.containsKey(prev)) {
            if (count > result.get(prev)) {
                result.put(prev, count);
            }
        } else {
            result.put(prev, count);
        }
        return result;
    }

    // Simple test client
    public static void main(String[] args) {
        System.out.println(charMaxSequenceCounter(""));                         // Nothing
        System.out.println(charMaxSequenceCounter("a"));                        // One character
        System.out.println(charMaxSequenceCounter("aa"));                       // One sequence
        System.out.println(charMaxSequenceCounter("ab"));                       // One change
        System.out.println(charMaxSequenceCounter("aaabbbaaaaaabasdffg"));      // 'g' in the end
        System.out.println(charMaxSequenceCounter("aaabbbaaaaaabgasdffg"));     // 'g' in the middle
    }

}
