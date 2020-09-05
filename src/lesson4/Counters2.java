package lesson4;

import java.util.Arrays;

public class Counters2 {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int sum = 0, ind;
        int i = A.length - 1, nPlusOne = N + 1;
        for(; i >= 0 && A[i] != nPlusOne; i--) {
           counters[A[i] - 1] += 1;
        }
        --i;
        int[] tmpCounters = new int[N];
        int mx = 0;
        while (i >= 0) {
            for(; i >= 0 && A[i] != nPlusOne; i--) {
                ind = A[i] - 1;
                tmpCounters[ind] += 1;
                if(tmpCounters[ind] > mx) {
                    mx = tmpCounters[ind];
                }
            }
            if(mx != 0) {
                tmpCounters = new int[N];
                sum += mx;
                mx = 0;
            }
            i--;
        }
        for(int j = 0; j < N; j++) {
            counters[j] += sum;
        }
        return counters;
    }

    public static void test() {
        Counters2 counters = new Counters2();
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] expected = {3, 2, 2, 4, 2};
        System.out.println("expected: " + Arrays.toString(expected) +
                ", actual: " + Arrays.toString(counters.solution(N, A)));
    }
}
