class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2;i<nums.length;i++) {
            int n1 = arr1.size();
            int n2 = arr2.size();
            if(arr1.get(n1-1)>arr2.get(n2-1)) arr1.add(nums[i]);
            else arr2.add(nums[i]);
        }
        int[] res = new int[arr1.size() + arr2.size()];
        int k=0;
        for(int i=0;i<arr1.size();i++) {
            res[i]=arr1.get(i);
            k++;
        }
        for(int i=0;i<arr2.size();i++) {
            res[i+k]=arr2.get(i);
        }
        return res;

    }
}