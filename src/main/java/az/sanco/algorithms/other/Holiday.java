package az.sanco.algorithms.other;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * Created by sanco on 12.05.21.
 * algorithms
 */
public class Holiday {
    public static void main(String[] args) {
        Holiday h = new Holiday();
        int year = 2004;
        Month bm = Month.FEBRUARY;
        Month em = Month.JULY;
        DayOfWeek dw = LocalDate.of(year, Month.JANUARY, 1).getDayOfWeek();
        System.out.println(h.solution(year, bm.name(), em.name(), dw.name()));
        System.out.println(h.slowSolution(year,bm,em));

        for (Month m: Month.values()){
            System.out.println(m.name().toLowerCase());
        }
        for(DayOfWeek w: DayOfWeek.values()){
            System.out.println(w.name().toLowerCase());
        }
    }
    /**
     *
     * @param Y - 4 digit year [2001-2099]
     * @param A - valid month names(begin month)
     * @param B - valid month names(end month)
     * @param W - correct week day 1st January of year
     * @return - max holiday week
     */
    public int solution(int Y, String A, String B, String W){
        Month start = Month.valueOf(A.toUpperCase());
        Month end = Month.valueOf(B.toUpperCase());

        int vacationDays = 0;
        for(int i=start.getValue();i<=end.getValue();i++){
            vacationDays+=Month.of(i).length(Y%4==0);
        }

        int sumOfDays = 0;
        for(int i=Month.JANUARY.getValue();i<start.getValue();i++){
            sumOfDays+=Month.of(i).length(Y%4==0);
        }
        int dw = DayOfWeek.valueOf(W.toUpperCase()).getValue();
        int lostDay = (8-dw)%7;
        if(sumOfDays>0)
            lostDay = (7 - (sumOfDays-lostDay)%7)%7;

        return (vacationDays-lostDay)/7;
    }

    public int slowSolution(int year, Month begin, Month end){
        LocalDate beginDate = LocalDate.of(year, begin, 1);
        LocalDate endDate = LocalDate.of(year, end, end.length(year%4==0));

        DayOfWeek bDow = beginDate.getDayOfWeek();
        DayOfWeek eDow = endDate.getDayOfWeek();
        if(bDow != DayOfWeek.MONDAY){
            beginDate = beginDate.plusDays(8-bDow.getValue());
        }

        if(eDow != DayOfWeek.SUNDAY){
            endDate = endDate.minusDays(eDow.getValue()-1);
        }else
            endDate = endDate.plusDays(1);
        return (int)ChronoUnit.WEEKS.between(beginDate, endDate);
    }
}
