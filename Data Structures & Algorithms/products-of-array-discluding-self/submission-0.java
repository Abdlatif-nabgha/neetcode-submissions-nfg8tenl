class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int length = nums.length;
        int[] output = new int[length]; 
         
        // Build prefix products (product of all elements to the left)
        output[0] = 1;
        for (int i = 1; i < length; i++) {
                output[i] = output[i-1] * nums[i-1];
        }

        // Build suffix products and multiply with prefix
        int suffixProduct = 1;
        for (int i = length-1; i >= 0; i--) {
            output[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return output;
    }
}  
