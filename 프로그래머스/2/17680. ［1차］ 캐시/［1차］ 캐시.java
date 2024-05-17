import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        
        if (cacheSize == 0)
            return cities.length * 5;
        
        List<String> cache = new ArrayList<>();
        for(String city : cities) {
            city = city.toUpperCase();
            if (cache.contains(city)) {
                time += 1;
                cache.remove(city);
                cache.add(city);
                continue;
            }
            if (cache.size() >= cacheSize)
                cache.remove(0);
            cache.add(city);
            time += 5;
        }
        return time;
    }
}