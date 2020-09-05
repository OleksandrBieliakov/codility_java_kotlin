package lesson2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Unpaired {
    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : A) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void testUnpaired() {
        Unpaired unpaired = new Unpaired();
        int[] arr = {9, 3, 9, 3, 9, 7, 9};
        int expected = 7;
        System.out.println("arr: " + Arrays.toString(arr) +
                ", expected: " + expected +
                ", actual: " + unpaired.solution(arr));
    }
}
