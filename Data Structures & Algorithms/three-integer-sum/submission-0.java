
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array to easily manage duplicates and use two pointers
        Arrays.sort(nums); 

        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Skip duplicate elements for the first number (i)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Use two pointers to find the remaining two numbers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Step 4: Skip duplicate elements for the second number (left)
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum < 0) {
                    // Sum is too small, move left pointer to increase it
                    left++; 
                } else {
                    // Sum is too large, move right pointer to decrease it
                    right--; 
                }
            }
        }
        
        return result;
    }
}