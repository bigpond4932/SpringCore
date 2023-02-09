package hello.core.this_is_java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int parameter = sc.nextInt();
        Character a = 65;
        System.out.println("a = " + a);
        int b = Integer.parseInt(String.valueOf(a));


    }
    static int hansu_checker(int parameter){
        int count = 0;

        for(int i = 1; i<= parameter; i++ ){
            if( i <= 99){
                count++;
                continue;
            } else {

            String x = String.valueOf(i);

            String[] arr = new String[x.length()];
            arr = x.split("");
            Integer[] int_arr = new Integer[arr.length];
            }

        }

        return count;
    }
}
