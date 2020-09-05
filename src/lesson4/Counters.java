package lesson4;

import java.util.Arrays;

public class Counters {
    public int[] solution(int N, int[] A) {
        int nPlusOne = N + 1;
        int[] counters = new int[N];
        int mx = 0, oldMx = 0, ind;
        for (int i : A) {
            if (i < nPlusOne) {
                ind = i - 1;
                counters[ind] += 1;
                if (counters[ind] > mx) {
                    mx = counters[ind];
                }
            } else if (oldMx != mx) {
                for (int j = 0; j < N; j++) {
                    counters[j] = mx;
                }
                oldMx = mx;
            }
        }
        return counters;
    }

    public static void test() {
        Counters counters = new Counters();
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] expected = {3, 2, 2, 4, 2};
        System.out.println("expected: " + Arrays.toString(expected) +
                ", actual: " + Arrays.toString(counters.solution(N, A)));
    }

    public static void testKotlin() {
        int N = 1;
        int[] A = {2, 1, 1, 2, 1};
        int[] expected = {3, 2, 2, 4, 2};
        System.out.println("expected: " + Arrays.toString(expected) +
                ", actual: " + Arrays.toString(MaxCountersKt.solution(N, A)));
    }

}
