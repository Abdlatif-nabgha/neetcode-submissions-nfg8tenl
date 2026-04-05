class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        // check if the sum of first and last elements
        // if greater than the target decrement the right by 1;
        // if less than the target increment the left by 1;
        // if equal return indexes
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left+1, right+1};
            } 
            else if (numbers[left] + numbers[right] > target) {
                right--;
            }
            else left++;
        }
        return new int[]{};
    }
}
