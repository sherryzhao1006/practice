//https://www.youtube.com/watch?v=pdmZpAJ2uBM
public class LargestElement{
	public static int FindKthLargest(int[] nums,int k) {
		if ( k < 1 || k > nums.length)
			return -1;
		return FindKthLargest(nums,0,nums.length-1,k);
	}
	public static int FindKthLargest(int[] nums,int start,int end,int k){
		int pivot = end;
		int left = start;
		int right = end;
		while(left <= right) {
			while(left <= right && nums[left] <= nums[pivot])
				++left;
			while(left <= right && nums[right] >= nums[pivot])
				--right;
			if(left < right)
				swap(nums,left,right);	
		}
		//after the loop the correct pivot position should rely on right's pos
		//{1,2,3,2,9,30,50,12}
			//    |
			 //   left
			//    |
			//  right	
		//{1,2,3,2,9,12,50,30}
		swap(nums,pivot,right);
		//now different from quicksort, we firstly check if we can return here
		if(k==right+1) //notice k is nth, start from 1 while index starts from 0
			return nums[right];//we immediately return as right position value is set
		else if(k > right+1){
		//that means we have divided values to 2 groups, and
		//kth largest only exists in right half; 
			return FindKthLargest(nums,right+1,end,k);
		} else
			return FindKthLargest(nums,start,right-1,k);
	}
	private void Swap(int[] nums,int a,int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	public static void main(String[] args){
		int[] nums = {1,2,3,50,9,30,2,12};
	}
}
