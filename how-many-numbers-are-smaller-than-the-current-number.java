class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bigger = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int check = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                } else if (check > nums[j]) {
                    sum += 1;
                }
            }
            bigger[i] = sum;
        }
        return bigger;
    }
}
