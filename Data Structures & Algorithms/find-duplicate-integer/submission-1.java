class Solution {
    public int findDuplicate(int[] nums) {

        int duplicateNumber = -1;
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] < 0) {
                duplicateNumber = val;
                return duplicateNumber;
            }
            nums[val - 1] *= -1;
        }

        return duplicateNumber;
    }
}
