public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int prev = 0;
        int len = A.length;
        for(int i=1 ; i < len; i++){
            if(A[prev] == A[i])
                continue;
            A[++prev] = A[i];
        }
        return prev+1;//0 based index
    }
}
