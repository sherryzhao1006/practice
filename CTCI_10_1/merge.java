//http://www.careercup.com/question?id=14747675
public class merge {
	public static void main(String[] args) {
		int[] A = {2,4,6,0,0,0,0};
		int[] B = {1,3,5,8};
		int firstL = 3;
		int secondL = 4;
		merge(A,B,firstL,secondL);

		// Merge sort
//		int[] m = {8,1,5,4,6,3};
		int[]m = {2,1};
		MergeSort(m,0,m.length-1);

		for(int i : m) {
			System.out.println(i + ",");
		}
	}
	public static void MergeSort(int[] a, int l, int r) {

		if(r == l)//one element left
			return;

		int mid = l+(r-l)/2;
		MergeSort(a,l,mid);
		MergeSort(a,mid+1,r);
		MergeM(a,l,mid,r);	
	}
	public static void MergeM(int[] A, int l,int mid,int r) {
		int[] tmp = new int[r-l+1];
		int i = l;
		int j= mid+1; //<< mid+1 is the bug
		int index = 0;
		while(i <= mid && j <= r) {
			if(A[i] < A[j]) {
				tmp[index++] = A[i++];
			} else {
				tmp[index++] = A[j++];
			}
		}
		while(i <= mid) {
			tmp[index++] = A[i++];
		}
		while(j <= r)
			tmp[index++] = A[j++];
		System.out.println("l : " + l + ",mid : " + mid+ ",r : " + r);
		for( int o : tmp) {
			System.out.print("tmp: " + o);
		}
		System.out.println();

		for(int k=0; k < index; k++) {
			A[l+k] = tmp[k];
		}
	}
	public static void merge(int[] A,int[] B,int firstL,int secondL) {

		int finalI = firstL+secondL-1;

		firstL--;
		secondL--;

		while(firstL >=0 && secondL >=0) {
			if(A[firstL] > B[secondL]) {
				A[finalI] = A[firstL];
				finalI--;
				firstL--;
			} else {
				A[finalI] = B[secondL];
				finalI--;
				secondL--;
			}
		}
		while(firstL >=0 ) {
			A[finalI--] = A[firstL--];
		}
		while(secondL >=0) {
			A[finalI--] = B[secondL--];
		}
	}
}
