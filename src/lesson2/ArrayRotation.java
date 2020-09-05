package lesson2;

import java.util.Arrays;

public class ArrayRotation {
    public int[] solution(int[] A, int K) {
        int len = A.length;
        int[] rotated = new int[len];
        for (int i = 0, to; i < len; i++) {
            to = (i + K) % len;
            rotated[to] = A[i];
        }
        return rotated;
    }

    public static void testArrayRotation() {
        ArrayRotation arrayRotation = new ArrayRotation();
        int[] arr = {3, 8, 9, 7, 6};
        int[] expected = {9, 7, 6, 3, 8};
        int k = 3;
        System.out.println("arr: " + Arrays.toString(arr) +
                ", expected: " + Arrays.toString(expected) +
                ", actual: " + Arrays.toString(arrayRotation.solution(arr, k)));
    }
}
