class Solution {
    /**
     * Optimal solution using Bucket Sort
     * Time: O(n), Space: O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies - O(n)
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Create buckets where index = frequency -> O(n)
        // bucket[i] contains all numbers with frequency i
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        
        for (int num : count.keySet()) {
            int freq = count.get(num);
            bucket[freq].add(num);
        }
        
        // Step 3: Collect top k from highest frequency - O(n)
        int[] result = new int[k];
        int idx = 0;
        
        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            for (int num : bucket[i]) {
                result[idx++] = num;
                if (idx == k) {
                    return result;
                }
            }
        }
        
        return result;
    }
}