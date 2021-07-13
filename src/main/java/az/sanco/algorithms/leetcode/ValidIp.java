package az.sanco.algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by sanco on 05.07.21.
 * algorithms
 */
public class ValidIp {
    public static void main(String[] args) {
        ValidIp v= new ValidIp();

//        System.out.println(v.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(v.validIPAddress("13.14..12"));
    }
    private char[] VALID_IP4_CHARS = {'0','1','2','3','4','5','6','7','8','9'};
    private char[] VALID_IP6_CHARS = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String validIPAddress(String IP) {
        if(isValidIp4(IP))
            return "IPv4";
        else if(isValidIp6(IP)){
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isValidIp4(String ip) {
        if(ip.length()<7 || ip.length()>15 || ip.startsWith(".")||ip.endsWith("."))
            return false;

        String[] section = ip.split("\\.");
        if(section.length!=4) return false;

        for(String x: section){
            if(x.length()<1 || x.length()>3 || (x.length()>1 && x.startsWith("0")))
                return false;
            for(char c: x.toCharArray()){
                if(Arrays.binarySearch(VALID_IP4_CHARS, c)<0) return false;
            }
            if(x.length()==3 && x.charAt(0)=='2' && (
                    x.charAt(1)>'5' || (x.charAt(1)=='5' && x.charAt(2)>'5')
                    )){
                return false;
            }
        }

        return true;
    }

    private boolean isValidIp6(String ip) {
        if(ip.length()<15 || ip.length()>39 || ip.startsWith(":") || ip.endsWith(":"))
            return false;

        String[] section = ip.split(":");
        if(section.length!=8) return false;

        for(String x: section){
            if(x.length()<1 || x.length()>4) return false;
            for(char c: x.toLowerCase().toCharArray()){
                if(Arrays.binarySearch(VALID_IP6_CHARS, c)<0) return false;
            }
        }

        return true;
    }


}
