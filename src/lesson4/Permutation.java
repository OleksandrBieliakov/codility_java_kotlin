package lesson4;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
    public int solution(int[] A) {
        int len = A.length;
        if(len == 0) {
            return 1;
        }
        Set<Integer> numbers = new HashSet<>();
        numbers.add(A[0]);
        int max = A[0];
        for(int i = 1; i < len; i++) {
            numbers.add(A[i]);
            if(A[i] > max) {
                max = A[i];
            }
        }
        if(max == len && numbers.size() == len) {
            return 1;
        }
        return 0;
    }
}
