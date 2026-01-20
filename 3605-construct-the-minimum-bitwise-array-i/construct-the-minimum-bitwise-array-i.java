class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int idx = 0; idx < n; idx++) {
            int num = nums.get(idx);

            if (num == 2) {
                ans[idx] = -1;
                continue;
            }

            boolean found = false;

            for (int i = 31; i >= 0; i--) {
                if (((num >> i) & 1) == 1) {

                    boolean ok = true;
                    for (int j = i - 1; j >= 0; j--) {
                        if (((num >> j) & 1) == 0) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok) {
                        ans[idx] = num - (1 << i);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                ans[idx] = num >> 1;
            }
        }

        return ans;
    }
}
