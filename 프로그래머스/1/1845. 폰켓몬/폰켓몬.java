import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> monsters = new HashSet<>();
        for (int num : nums)
            monsters.add(num);
        return Math.min(monsters.size(), nums.length / 2);
    }
}