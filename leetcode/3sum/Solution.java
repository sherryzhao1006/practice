import java.util.*;

public class Solution {
    public static void main(String args[]){
	int[] num = {-9,14,-7,-8,9,1,-10,-8,13,12,6,9,3,-3,-15,-15,1,8,-7,-4,-6,8,2,-10,8,11,-15,3,0,-11,-1,-1,10,0,6,5,-14,3,12,-15,-7,-5,9,11,-1,1,3,-15,-5,11,-12,-4,-4,-2,-6,-10,-6,-6,0,2,-9,14,-14,-14,-9,-1,-2,-7,-12,-13,-15,-4,-3,1,14,3,-12,3,3,-10,-9,-1,-7,3,12,-6,0,13,4,-15,0,2,6,1,3,13,8,-13,13,11,11,13,14,-6};
	ArrayList<ArrayList<Integer>> res = threeSum(num);
    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length;i++){
            int start = i+1;
            int end = num.length-1;
            int prevStart = Integer.MAX_VALUE;
	   
            int prevEnd = Integer.MAX_VALUE;
            int prevFirst= Integer.MAX_VALUE;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while(start < end){
                int sum = num[i] + num[start] + num[end];
                if(sum == 0){
		            temp.add(num[i]);
		            temp.add(num[start]);
		            temp.add(num[end]);

			    if(!res.contains(temp)){
		            	res.add(temp);
			    }
		            temp = new ArrayList<Integer>();
			    prevFirst = num[i];
			    prevStart = num[start];
			    prevEnd = num[end];
                    start++;
                    end--;
                } else if(sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }
}
