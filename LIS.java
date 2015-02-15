//https://www.youtube.com/watch?v=SZByPn0deMY
import java.util.*;
public class LIS {
	public static void main(String[] args){
		int[] num = {13,14,10,11,12};
		printLIS(num);
	}
	public static void printLIS(int[] num){
		String[] paths = new String[num.length];
		int[] sizes = new int[num.length];
		Arrays.fill(sizes,1);
		for(int i=0; i < num.length;i++){
			paths[i] = new String();
			paths[i] += num[i];
		}
		for(int i=1; i < num.length;i++){
			for(int j=0; j < i; j++){
				if( (num[j] < num[i]) && (sizes[i] < sizes[j]+1)){
					sizes[i] = sizes[j]+1;
					paths[i] = paths[j] + "," + num[i];
				}
			}
		}
		for(int i=0; i < num.length;i++){
			System.out.println("index " + i + ": " + paths[i]);
		}
	}
}
