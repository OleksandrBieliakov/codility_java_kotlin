package lesson4;

public class MissingNumber {
    public int solution(int[] A) {
        if(A.length == 0) {
            return 1;
        }
        int max = A[0];
        for(int i = 1; i < A.length; i++) {
            if(A[i] > max) {
                max = A[i];
            }
        }
        if(max < 1) {
            return 1;
        }
        boolean[] counters = new boolean[max + 2];
        for (int value : A) {
            if (value > 0) {
                counters[value] = true;
            }
        }
        for(int i = 0; i < counters.length - 1; i++) {
            if(!counters[i + 1]) {
                return i + 1;
            }
        }
        return max + 1;
    }
}
