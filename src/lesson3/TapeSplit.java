package lesson3;

public class TapeSplit {
    public int solution(int[] A) {
        //  [-1000, 1000]
        // l = -1000 r= 0 + 1000 = 1000 md = 1000 + 1000 = 2000
        // l = 0 r = 0
        int rightSum = 0;
        for(int n : A) {
            rightSum += n;
        }
        int leftSum = A[0];
        rightSum -= leftSum;
        int len = A.length - 1;
        int minDiff = Math.abs(leftSum - rightSum);
        for(int i = 1, diff; i < len; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            diff = Math.abs(leftSum - rightSum);
            if(diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }
}
