package lesson3;

public class Frog {
    public int solution(int X, int Y, int D) {
        int jumps = (Y - X) / D;
        if((Y - X) % D == 0)
            return jumps;
        return jumps + 1;
    }

    public static void testFrog() {
        Frog frog = new Frog();
        int X = 10, Y = 85, D = 30;
        int expected = 3;
        System.out.println("expected: " + expected +
                ", actual: " + frog.solution(X, Y, D));
    }
}
