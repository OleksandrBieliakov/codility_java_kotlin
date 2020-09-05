package lesson4;

public class Counters3 {
    public int[] solution(int N, int[] A) {
        int nPlusOne = N + 1;
        int[] counters = new int[N];
        int max = 0, ind, sum = 0;
        for (int i : A) {
            if (i < nPlusOne) {
                ind = i - 1;
                counters[ind] += 1;
                if (counters[ind] > max) {
                    max = counters[ind];
                }
            } else if (max != 0) {
                sum += max;
                max = 0;
                counters = new int[N];
            }
        }
        if (sum != 0) {
            for (int j = 0; j < N; j++) {
                counters[j] += sum;
            }
        }
        return counters;
    }
}
