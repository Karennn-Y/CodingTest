class Solution {
    
    int answer = 0;
        
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return answer;
    }
    
    public void dfs(int depth, int total, int target, int[] numbers) {
        if (depth == numbers.length) {
            if (total == target)
                answer++;
            return;
        }
        
        dfs(depth + 1, total + numbers[depth], target, numbers);
        dfs(depth + 1, total - numbers[depth], target, numbers);
    }
}