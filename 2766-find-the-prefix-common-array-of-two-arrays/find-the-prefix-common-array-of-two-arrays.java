class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] C = new int[A.length];
        HashMap<Integer,Integer> map1= new HashMap<>();
        HashMap<Integer,Integer> map2= new HashMap<>();

        for(int i=0;i<A.length;i++) {
            int count=0;
            map1.put(A[i],map1.getOrDefault(A[i],0)+1);
            map2.put(B[i],map2.getOrDefault(B[i],0)+1);
            for(int j=0;j<=i;j++) {
                if(map2.containsKey(A[j])) count++;
            }
            C[i]=count;   
        }
        return C;

    }
}