package lesson1;

public class BinaryGap {
    public int solution(int N) {
        int currentGapSize = 0;
        int longestGapSize = 0;
        boolean rightmostZeroBits = true;
        for (int i = 0; i < 32; i++, N = N >> 1) {
            if ((N & 1) != 0) {
                if (currentGapSize > longestGapSize) {
                    longestGapSize = currentGapSize;
                }
                rightmostZeroBits = false;
                currentGapSize = 0;
            } else if (!rightmostZeroBits) {
                currentGapSize++;
            }
        }
        return longestGapSize;
    }

    public static void testBinaryGap() {
        BinaryGap binaryGap = new BinaryGap();
        int[] numbers = {1041, 32};
        int[] answers = {5, 0};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("number: " + numbers[i] +
                    ", expected: " + answers[i] +
                    ", actual: " + binaryGap.solution(numbers[i]));
        }
    }
}
