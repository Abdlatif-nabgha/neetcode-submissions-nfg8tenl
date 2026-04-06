class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] values = new int[k];

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> maxEntry = map.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .orElseThrow(NoSuchElementException::new);

            values[i] = maxEntry.getKey(); // the number, not its frequency
            map.remove(maxEntry.getKey());
        }

        return values;
    }
}