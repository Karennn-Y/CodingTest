class Solution {
    public int solution(int[][] sizes) {
        int widthMax = 0;
        int heightMax = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            
            widthMax = Math.max(widthMax, Math.max(a, b));
            heightMax = Math.max(heightMax, Math.min(a, b));
        }
        return widthMax * heightMax;
    }
}