package az.sanco.algorithms.mdaq;

/**
 * Created by sanco on 15.06.21.
 * algorithms
 */
public class Task3 {
    public String solution(String message, int K) {
        // write your code in Java SE 8
        if(message.length()<=K)
            return message;

        String[] words = message.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<words.length;i++){
            if((sb.length()+words[i].length())<=K)
                sb.append(words[i]).append(" ");
            else if(sb.length()==0)
                return "";
            else
                break;
        }

        return sb.toString().trim();
    }


    public static void main(String[] args) {

    }
}
