package az.sanco.algorithms.codeforce;

public class QN {
    public static void main(String[] args) {
        int count = 0;
        for(int n=1;n<=30;n++) {
            long start = System.currentTimeMillis();
            System.out.println();
            count=0;
            for (long i = 1; i <= Math.pow(2,n)-1; i += 2) {
                boolean res = include(i);
                if (res) {
                    ++count;
                }
            }

            double Q = (count) / Math.pow(2, n - 1);
            long end = System.currentTimeMillis();
            System.out.println("n=" + n + " N=" + count + " Q=" + Q+"[time="+ (end-start) +" ms]");
        }
    }

    private static boolean include(long num){
        if(num==1) {
            return true;
        }else if(num==5 || num==17) {
            return false;
        }else{
            if(num%2==0){
                //eger 2^n dirse bize lazim olan ededdir
                if((num & (num-1))==0)
                    return true;
                else if (tester(num)) return false;
                return include(num/2);
            }else {
                if (tester(num)) return false;
                return include(3 * num - 1);
            }
        }
    }

    private static boolean tester(long num) {
        if(num%5==0){
            long a = num/5;
            return (a & (a - 1)) == 0;
        }else if(num%17==0){
            long a = num/17;
            return (a & (a - 1)) == 0;
        }
        return false;
    }
}
