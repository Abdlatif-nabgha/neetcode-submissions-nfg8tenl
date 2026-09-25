class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> deque = new ArrayDeque<>(); // stores indices
    int[] result = new int[n - k + 1];
    int ri = 0;

    for (int i = 0; i < n; i++) {
        // remove indices out of this window from the front
        if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
            deque.pollFirst();
        }
        // remove smaller values from the back — they can never be the max
        // while nums[i] is still in the window
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
        }
        deque.offerLast(i);

        if (i >= k - 1) {
            result[ri++] = nums[deque.peekFirst()];
        }
    }
    return result;
}
}
