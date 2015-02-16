import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChangeGreedy {
        //m : number of coins
	//n : transaction amount
	public static int minCountGreedy(int S[],int m,int n) {
		if (n == 0) {
		    System.out.println();
	            return 1;
                }
		if (n < 0 || m < 0)
		    return 0;
		int numCoins = n/S[m];
		System.out.println("Using " + numCoins + " x "+S[m]);
		int remainder = n%S[m];
		return minCountGreedy(S,m-1,remainder);
	}
	public static int allPossibleWay(int S[],int m,int n) {
		if(n < 0)
			return 0;
		if( n == 0) {
			System.out.println();
			return 1;

		}
		if( m < 0)
			return 0;
		int count =0;
		
		int numCoins = n/S[m];
		for(int i=numCoins ; i >=0 ;i--) {
			 System.out.println("Using " + i + " x "+S[m]);
			int remainder = n - (S[m]*i); 
			count += allPossibleWay(S,m-1,remainder);
		}
		return count;
	}
	public static void main(String[] args) {
		int[] denom = {1,5,10,25};
                int n = 9;
		int m = denom.length-1;

//	        System.out.println( "Num Ways: " + minCountGreedy(denom,m,n) );
	        System.out.println( "Num Ways: " + allPossibleWay(denom,m,n) );
        }
}
