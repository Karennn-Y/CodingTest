import java.util.Calendar;

class Solution {
    public String solution(int a, int b) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a - 1, b);
        int date = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return days[date];
    }
}