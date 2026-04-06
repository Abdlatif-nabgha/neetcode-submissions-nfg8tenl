class Solution {
    public int longestConsecutive(int[] nums) {
        
        // [2,20,4,10,3,4,5]
        // create set from this array
        Set<Integer> set = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        int longest = 0;

        for (Integer v : set) {
            // check if it's the start of a sequence
            if (!set.contains(v-1)) {
                int length = 1;
                while (set.contains(v + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}