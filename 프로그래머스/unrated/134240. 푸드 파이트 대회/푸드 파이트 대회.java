class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int div = food[i] / 2;
            sb.append(String.valueOf(i).repeat(Math.max(0, div)));
            sbRight.append(String.valueOf(i).repeat(Math.max(0, div)));
        }
        sbRight.reverse();
        sb.append(0);
        sb.append(sbRight);
        return sb.toString();
    }
}