package lesson5;

import java.util.Arrays;

public class SliceAverage {
    public int solution(int[] A) {
        int len = A.length;
        int[] sums = new int[len];
        sums[0] = A[0];
        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + A[i];
        }
        boolean firstLevel = true;
        double lastMinAvg = -1;
        int lastMinAvgInd = 0;
        double minAvg = ((double) sums[1]) / 2;
        int minAvgInd = 0;
        double currentAvg;
        for (int i = 2, rightBound; i <= len; i++) {
            rightBound = len - i;
            for (int j = 0; j <= rightBound; j++) {
                if (j == 0) {
                    currentAvg = ((double) (sums[j + i - 1])) / i;
                } else {
                    currentAvg = ((double) (sums[j + i - 1] - sums[j - 1])) / i;
                }
                if (currentAvg < minAvg) {
                    minAvg = currentAvg;
                    minAvgInd = j;
                }
                //System.out.println("i: " + i + ", j: " + j + ", currentAvg: " + currentAvg);
            }
            if (firstLevel) {
                firstLevel = false;
                lastMinAvg = minAvg;
                lastMinAvgInd = minAvgInd;
            } else {
                if (minAvg < lastMinAvg) {
                    lastMinAvg = minAvg;
                    lastMinAvgInd = minAvgInd;
                } else {
                  /*  System.out.println("break");
                    System.out.println("minAvg: " + minAvg + ", minAvgInd: " + minAvgInd);
                    System.out.println("lastMinAvg: " + lastMinAvg + ", lastMinAvgInd: " + lastMinAvgInd);*/
                    break;
                }
            }
            /*System.out.println("minAvg: " + minAvg + ", minAvgInd: " + minAvgInd);
            System.out.println("lastMinAvg: " + lastMinAvg + ", lastMinAvgInd: " + lastMinAvgInd);*/
        }
        return lastMinAvgInd;
    }

    public static void test() {
        SliceAverage sliceAverage = new SliceAverage();
        int[] arr = {-3, -5, -8, -4, -10};
        int expected = 2;
        int actual = sliceAverage.solution(arr);
        System.out.println("arr: " + Arrays.toString(arr) + ", expected: " + expected + ", actual: " + actual);
    }
}
