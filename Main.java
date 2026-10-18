import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("a = ");
        int a = input.nextInt();
        System.out.print("b = ");
        int b = input.nextInt();

        System.out.println(Multiplier.byFor(a, b));
        System.out.println(Multiplier.byBigInteger(a, b));
        System.out.println(Multiplier.byRecursion(a, b));
        System.out.println(Multiplier.byArray(a, b));

        input.close();
    }
}

class Multiplier {

    static int applySign(int value, int a, int b) {
        if ((a < 0) != (b < 0)) {
            return -value;
        }
        return value;
    }

    static int byFor(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        int res = 0;
        for (int i = x; i > 0; i--) {
            res += y;
        }
        return applySign(res, a, b);
    }

    static BigInteger byBigInteger(int a, int b) {
        BigInteger bigA = new BigInteger("" + a);
        BigInteger bigB = new BigInteger("" + b);
        return bigA.multiply(bigB);
    }

    static int byRecursion(int a, int b) {
        int res = step(Math.abs(a), Math.abs(b), 0);
        return applySign(res, a, b);
    }

    static int step(int left, int value, int acc) {
        if (left == 0) {
            return acc;
        }
        return step(left - 1, value, acc + value);
    }

    static int byArray(int a, int b) {
        int[] arr = new int[Math.abs(a)];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = Math.abs(b);
        }
        int res = 0;
        int j = 0;
        while (j < arr.length) {
            res += arr[j];
            j++;
        }
        return applySign(res, a, b);
    }
}
