class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // create list that holds the elements
        List<List<Integer>> output = new ArrayList<>();
        int length = nums.length;
        
        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            int j = i+1, k = length-1;
            int target = - nums[i];
            if (i != 0 && nums[i] == nums[i-1]) continue;
            while (j < k) {
                if (nums[j] + nums[k] < target) j++;
                else if (nums[j] + nums[k] > target) k--;
                else {
                    output.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    while(j < length && nums[j] == nums[j-1]) j++;
                }
            }
        }
        return output;
    }
}
