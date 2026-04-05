class Solution {
    public boolean hasDuplicate(int[] nums) {
        // traverse table and check if there are duplicates
        int length = nums.length;

        for(int i = 0; i < length - 1; i++) {
            for(int j = i + 1; j < length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        // if no duplicates found return false 
        return false;
    }
}