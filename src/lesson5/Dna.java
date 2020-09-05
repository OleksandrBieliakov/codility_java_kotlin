package lesson5;

import java.util.Arrays;

public class Dna {
    public int[] solution(String S, int[] P, int[] Q) {
        int sLen = S.length();
        int qLen = P.length;

        int[][] counters = new int[sLen][4];
        char[] chars = S.toCharArray();

        for (int i = 0, value; i < sLen; i++) {
            switch (chars[i]) {
                case 'A':
                    value = 0;
                    break;
                case 'C':
                    value = 1;
                    break;
                case 'G':
                    value = 2;
                    break;
                default:
                    value = 3;
            }
            if(i != 0) {
                counters[i] = counters[i - 1].clone();
            }
            counters[i][value] += 1;
        }
        int[] answers = new int[qLen];
        for (int i = 0, p, q; i < qLen; i++) {
            p = P[i];
            q = Q[i];
            if (p == 0) {
                for (int j = 0; j < 4; j++) {
                    if (counters[q][j] != 0) {
                        answers[i] = j + 1;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    if (counters[p - 1][j] != counters[q][j]) {
                        answers[i] = j + 1;
                        break;
                    }
                }
            }
        }
        return answers;
    }
}
