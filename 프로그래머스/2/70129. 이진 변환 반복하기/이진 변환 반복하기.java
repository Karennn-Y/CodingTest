class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int times = 0;
        while (!s.equals("1")) {
            times++;
            cnt += s.length() - s.replaceAll("0", "").length();
            s = Integer.toBinaryString(s.replaceAll("0", "").length());
        }
        return new int[] {times, cnt};
    }
}