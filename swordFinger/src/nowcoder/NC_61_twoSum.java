package nowcoder;

import java.util.HashMap;

public class NC_61_twoSum {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int cha = target - numbers[i];
            if(map.containsKey(cha)&&map.get(cha)!=i){
                return new int[]{map.get(cha)+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return new int[]{};

    }
}
