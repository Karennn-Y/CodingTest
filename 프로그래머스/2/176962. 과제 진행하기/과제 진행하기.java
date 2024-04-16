import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        ArrayList<Subject> tasks = new ArrayList<>();
        Stack<Subject> stop = new Stack<>();

        for (String[] plan : plans) {
            String title = plan[0];
            int hour = (Integer.parseInt(plan[1].split(":")[0]) * 60) + Integer.parseInt(plan[1].split(":")[1]);
            int time = Integer.parseInt(plan[2]);
            tasks.add(new Subject(title, hour, time));
        }

        tasks.sort((o1, o2) -> o1.hour - o2.hour);

        int idx = 0;
        int index = 0;
        int current = 0;
        int next = 0;

        while (idx != tasks.size()) {
            Subject subject = tasks.get(idx);
            String type = subject.title;
            int hour = subject.hour;
            int period = subject.time;
            current = hour + period;

            if (idx != tasks.size() - 1) {
                Subject nextSubject = tasks.get(idx + 1);
                next = nextSubject.hour;

                if (current > next) {
                    stop.push(new Subject(type, current - next, period));
                    current = next;
                    idx++;
                    continue;
                }
            }

            answer[index++] = type;

            while (!stop.isEmpty()) {
                int remain = next - current;
                Subject sub = stop.pop();
                int rePeriod = sub.hour;

                if (remain >= rePeriod) {
                    answer[index++] = sub.title;
                    current += rePeriod;
                } else {
                    stop.push(new Subject(sub.title, rePeriod - remain, sub.time));
                    break;
                }
            }

            idx++;
        }

        while (!stop.isEmpty()) {
            answer[index++] = stop.pop().title;
        }

        return answer;
    }
}

class Subject {
    String title;
    int hour;
    int time;

    public Subject (String title, int hour, int time) {
        this.title = title;
        this.hour = hour;
        this.time = time;
    }
}