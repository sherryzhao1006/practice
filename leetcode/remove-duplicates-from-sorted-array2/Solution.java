public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length ==0)
            return 0;
        int prev = 0;
        int count =1;
        for(int i=1;i < A.length;i++){
            if(A[i] == A[prev] && count >1){
                continue;
            }
            if(A[i] != A[prev])
                count=1;
            else
                count++;
            A[++prev] = A[i];
            
        }
        return prev+1;
    }
}
