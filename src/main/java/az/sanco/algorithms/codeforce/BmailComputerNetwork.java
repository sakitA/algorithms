package az.sanco.algorithms.codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanco on 10/12/18.
 * CodeForce
 */
public class BmailComputerNetwork {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String routerCount = bi.readLine();
        int n = Integer.valueOf(routerCount);
        String line = bi.readLine();
        line = "1 1 "+line;
        String[] routers = line.split(" ");

        List<Integer> result = makePath(routers,n);
        for(int i=result.size()-1;i>=0;i--){
            System.out.print(result.get(i)+" ");
        }
    }

    public static List<Integer> makePath(String[] routers, int n){
        List<Integer> list = new ArrayList<>();
        list.add(n);
        do{
            n= Integer.parseInt(routers[n]);
            list.add(n);
        }while(n!=1);

        return list;
    }
}
