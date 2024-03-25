import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = bf.readLine().split(" ");
        long sum = Long.parseLong(line[0]);
        long zone = Long.parseLong(line[1]);
        boolean flag = true;
        
        int min = 0;
        
        while (flag) {
            min = (int)((sum / zone) - ((zone - 1) / 2));
            
            if (min < 0 || zone > 100) {
                min = -1;
                flag = false;
            } else {
                long tmpSum = (min * 2 + zone -1) * zone / 2;
                
                if(tmpSum == sum)
                    flag = false;
                else
                    zone++;
            }
        }
        
        if (min == -1)
            System.out.println(min);
        else {
            for (int i = 0; i < zone; i++) {
                System.out.print((min + i) + " ");
            }
        }
    }
}