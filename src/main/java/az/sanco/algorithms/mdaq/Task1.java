package az.sanco.algorithms.mdaq;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by sanco on 15.06.21.
 * algorithms
 */
public class Task1 {
    public int solution(int A, int B) {
        // write your code in Java SE 8
        BigInteger bigA = BigInteger.valueOf(A);
        BigInteger bigB = BigInteger.valueOf(B);

        BigInteger result = bigA.multiply(bigB);

        return result.toString(2).replaceAll("0","").length();
    }

    public static void main(String[] args) {
        Task1 task = new Task1();

        Random r = new Random();

        for(int i=0;i<10;i++){
            int a = r.nextInt(100_000_00);
            int b = r.nextInt(100_000_00);
            System.out.printf("A=%d, B=%d,A*B=%s, 2's=%s, result=%s%n",
                    a, b, BigInteger.valueOf((long)a*b).toString(),
                    BigInteger.valueOf((long)a*b).toString(2),
                    task.solution(a,b)
                    );
        }
    }
}
