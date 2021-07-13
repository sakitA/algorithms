package az.sanco.algorithms.other;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

/**
 * Created by sanco on 12.05.21.
 * algorithms
 */
public class HolidayTest {
    @Test
    public void testResult(){
        Holiday h = new Holiday();
        Random r = new Random();
        for(int i=0;i<1000;i++){
            int year = 2000+r.nextInt(100);
            int bm = 1+r.nextInt(12);
            int em = 1+r.nextInt(12);
            if(em<bm){
                int t = em;
                em = bm;
                bm = t;
            }
            LocalDate jan = LocalDate.of(year, Month.JANUARY, 1);
            System.out.printf("Year: %d, bm: %d, em: %d, dw: %d%n", year, bm,em, jan.getDayOfWeek().getValue());
            Assert.assertEquals(
                    h.slowSolution(year, Month.of(bm), Month.of(em)),
                    h.solution(year, Month.of(bm).name(), Month.of(em).name(), jan.getDayOfWeek().name())
            );
        }
    }

    @Test
    public void print(){
        Holiday h = new Holiday();
        Random r = new Random();
        for(int i=0;i<10;i++){
            int year = 2000+r.nextInt(100);
            int bm = 1+r.nextInt(12);
            int em = 1+r.nextInt(12);
            if(em<bm){
                int t = em;
                em = bm;
                bm = t;
            }
            LocalDate jan = LocalDate.of(year, Month.JANUARY, 1);
            System.out.printf("print(solution(%d, '%s', '%s', '%s'))%n",
                    year, Month.of(bm).name().toLowerCase(), Month.of(em).name().toLowerCase(),
                    jan.getDayOfWeek().name().toLowerCase());
            System.out.println(h.solution(year, Month.of(bm).name(), Month.of(em).name(),
                    jan.getDayOfWeek().name()));
        }
    }
}
