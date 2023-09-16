class Solution {
    public int[] solution(long n) {
        
        char[] nums = Long.toString(n).toCharArray();
        int[] answer = new int[nums.length];
        int idx = 0;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[idx] = Character.getNumericValue(nums[i]);
            idx++;
        }
        
        return answer;
    }
}