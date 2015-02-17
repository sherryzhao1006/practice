public class DutchFlag {


	public static void main(String[] args) {

	//http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
		runZeroOne();
//http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
		runZeroOneTwo();
	}
	public static void runZeroOne(){
//		int[] arr = {0,1,1,0,1,1,0,0,0,1};
		int[] arr = {1,1,1,1};
		int zeroPtr = 0;
		int onePtr = arr.length-1;
		while(zeroPtr < onePtr) {
			//zeroPtr < arr.length  can be replaced with zeroPtr < onePtr
			while(zeroPtr < arr.length && arr[zeroPtr] != 0)
				zeroPtr++;
			//same as above
			while(onePtr >= 0 && arr[onePtr] != 1)
				onePtr--;
			if(zeroPtr < onePtr) {
				swap(arr,zeroPtr,onePtr);	
			}
		}
		for(int i : arr) {
			System.out.print(i+" ");	
		}
		System.out.println();
	}
	public static void runZeroOneTwo(){
		int[] arr =  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		int l = 0;
		int h = arr.length-1;
		int mid = 0;
		//why <= ? because say you have 001110 (if = is mising then you miss last 0 
		while(mid <= h) {
			switch(arr[mid]) {
				case 0 : 
					//tricky here 
					//if mid == l then it just increment both index
					//else l is pointing to 1 and mid is pointing to 0
					//they swap
					swap(arr,l,mid);
					l++;
					mid++;
					break;	
				case 1 :
					mid++;
					break;
				case 2 :
					//if h is pointing to 1 then it swap with l(pointing to 2)
					//then mid++ by getting into case 1: 
					//if h is pointing to 0 then it swap with l(pointing to 2)
					//then it will get into case 0 afterwards
					swap(arr,mid,h);
					h--;
			}
		}
		for(int i : arr) {
                        System.out.print(i+" ");
                }
                System.out.println();
	}
	public static void swap(int[] arr,int first,int last){
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp; 
	}
}
