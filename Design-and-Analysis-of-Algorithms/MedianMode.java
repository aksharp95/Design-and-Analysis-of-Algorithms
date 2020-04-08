//Question 1

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MedianMode {
    public static void main(String[] args) {
        char [] input = {'F','A','D','A','B','A'};
        char median = calculateMedian(input);
        char mode = calculateMode(input);

        System.out.println("Median: "+median+" Mode: "+mode);
    }

    /*
    * This method calculates Median of input array
    * Time Complexity: O(n Log n)
    * Space Complexity: O(1)
    * */
    public static char calculateMedian(char [] input){
        Arrays.sort(input);
        int median = input.length%2==0?(input.length/2)-1:(input.length/2);
        return input[median];
    }

    /*
    * This method calculates Mode of input array
    * Time Complexity: O(n)
    * Space Complexity: O(n)
    * */
    public static char calculateMode(char [] input){
        Map<Character,Integer> hmap = new HashMap<>();
        for(char c: input)
            hmap.put(c,hmap.getOrDefault(c,0)+1);

        int maxValue = 0;
        char mode = '0';
        for(Map.Entry<Character,Integer> entry: hmap.entrySet()){
            if(entry.getValue()>maxValue){
                mode = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return mode;
    }
}
