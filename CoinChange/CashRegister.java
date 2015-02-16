public class CashRegister{
	public static void main(String[] args){
		int[] denom = {1,5,10,25};
                int n = 9;
                int m = denom.length-1;
		allPossibleWayPrint(denom,m,n);
		System.out.println( "Num Ways: " + allPossibleWay(denom,m,n) );	
		Double a=1.2d;
		Double b=1.1;
		if(a%b == 0)
			System.out.println("1.1");
		else
			System.out.println(a%b);
	}
	public static void allPossibleWayPrint(int S[],int m,int n) {
		for(int i=m; i >= 0; i--) {
			int numCoin = n/S[i];
			int remainder = n%S[i];
			System.out.println(numCoin + " of coin " + S[i] + " is used");
			if(remainder == 0)
				break;
			n = remainder;
		}
	}
	public static int allPossibleWay(int S[],int m,int n){
		if (n < 0)
			return 0;
		if (n==0)
			return 1;
		if ( m <0)
			return 0;
		int count = 0;
		int numCoins = n/S[m];
		for(int i=numCoins; i >=0 ;i--){
			System.out.println("Using " + i + " x " + S[m]);
			int remainder = n - (S[m]*i);
			count += allPossibleWay(S,m-1,remainder);
		}
		return count;
	} 
}
