class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r= n-1, idx= n-1;

        while (l <= r){
            int left = nums[l] * nums[l];
            int right = nums[r] * nums[r];

            if(left > right) {
                res[idx--] = left;
                l++;
            } else {
                res[idx--] = right;
                r--;
            }
        }

        return res;
        
    }
}