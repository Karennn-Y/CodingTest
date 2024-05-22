import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<Integer>();
        int t_weight = 0;
        
        for (int truck : truck_weights) {
            
            while(true) {
                if(bridge.isEmpty()) {
                    bridge.offer(truck);
                    t_weight += truck;
                    answer++;
                    break;
                } else if (bridge.size() == bridge_length) t_weight -= bridge.poll();
                else {
                    if(t_weight + truck > weight) {
                        bridge.offer(0);
                        answer++;
                    } else{
                        bridge.offer(truck);
                        t_weight += truck;
                        answer++;
                        break;
                    }
                }   
            }
        }
        
        return answer + bridge_length;
    }
}