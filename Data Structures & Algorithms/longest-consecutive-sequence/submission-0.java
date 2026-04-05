class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int n : numSet) {
            // Check if 'n' is the start of a sequence
            if (!numSet.contains(n - 1)) {
                int length = 1;

                // Count consecutive numbers upwards
                while (numSet.contains(n + length)) {
                    length++;
                }

                // Update the maximum length found
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}