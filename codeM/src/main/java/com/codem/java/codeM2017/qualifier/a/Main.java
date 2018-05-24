package com.codem.java.codeM2017.qualifier.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangdehao on 18/5/24.
 */



//        给定两个整数 l 和 r ，对于所有满足1 ≤ l ≤ x ≤ r ≤ 10^9 的 x ，把 x 的所有约数全部写下来。对于每个写下来的数，只保留最高位的那个数码。求1～9每个数码出现的次数。
//        输入描述:
//        一行，两个整数 l 和 r (1 ≤ l ≤ r ≤ 10^9)。
//        输出描述:
//        输出9行。

//        第 i 行，输出数码 i 出现的次数。

public class Main {
    public static void main(String[] args){

        // input & output

        Scanner sc = new Scanner(System.in);
        long left = sc.nextLong();
        long right = sc.nextLong();

        String output = getOutputFromInput(left, right);
        System.out.print(output);
    }


    public static String getOutputFromInput(long left, long right){

        String output = "";
        int[] counts = new int[]{0,0,0,0,0,0,0,0,0,0};
        long x = left;
        while(x <= right){
            List<Long> divisors = getDivisors(x);
            for(Long d: divisors){
                int h = getHead(d);
                counts[h] = counts[h]+1;
            }
            x++;
        }
        for(int i = 1; i < counts.length; i++){
            output += counts[i] + "\r\n";
        }
        return output;
    }

    private static int getHead(long d) {
        while (d / 10 > 0){
            d /= 10;
        }
        return (int)d;
    }

    private static List<Long> getDivisors(long x) {
        List<Long> divisors = new ArrayList<Long>();
        long divisor = 1;
        while(divisor <= x){
            if(x % divisor == 0){
                divisors.add(divisor);
            }
            divisor++;
        }
        return divisors;
    }
}
