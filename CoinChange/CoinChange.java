//http://sohagbuet.wordpress.com/2014/03/27/coin-change-problem/  : ways to get change
//http://codelist.blogspot.com/2011/01/coin-change-problem.html : min coinchange
//geeksforgeeks.org/dynamic-programming-set-7-coin-change
//http://stackoverflow.com/questions/13557979/why-does-the-greedy-coin-change-algorithm-not-work-for-some-coin-sets //greedy coin change doesn't work
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {
        public static int minCount(int S[],int n) {
                if( n == 0) {
                        return 0;
                }
                int min = Integer.MAX_VALUE;
                for(int i=0; i < S.length; i++) {
                        if( S[i] <= n ) {
                                min = Math.min(min,minCount(S,n-S[i])+1);
                        }
                }
                return min;
        }
        //m : number of coins
        //n : transaction amount
        //Recursive
                //output is 6 because
                // 10+5 = 15
                // 5+5+5 =15
                // 10+1+1+1+1+1 = 15
                //1+1+1+1+1+1+1+1+1+1+1+1+1+1+1 = 15
                //5+5+1+1+1+1+1 =15
                //5+1+1+1+1+1+1+1+1+1+1= 15

        public static int count(int S[],int m,int n) {
                if(n == 0)
                        return 1;
                if(n < 0)
                        return 0;
                if(m < 0 && n >=1)
                        return 0;
                return count(S,m-1,n)+count(S,m,n-S[m]);
        }
        public static int countFreq(int S[],int F[],int m,int n) {
                if(n == 0)
                        return 1;
                if(n < 0)
                        return 0;
                if( m < 0 && n >=1)
                        return 0;
                System.out.println("F[ " + m + "]:" +F[m] + ", n : " + n);
                int withoutCurrCoin = countFreq(S,F,m-1,n);
                int withCurrCoin =0;
                if(F[m] > 0) {
                    F[m]--;
                    withCurrCoin = countFreq(S,F,m,n-S[m]);
                    F[m]++;
                }
                return withoutCurrCoin + withCurrCoin;
        }
        public static void main(String[] args) {
                int[] denom = {1,5,10,25};
                int[] Freq =  {5,2,1,25};
                int n = 15;
                int m = denom.length-1;

//                System.out.println( "Num Ways without limit: " + count(denom,m,n) );
//                System.out.println( "Num Ways with limit: " + countFreq(denom,Freq,m,n) );
                  System.out.println( "Min Coins : " + minCount(denom,n));
        }
}
