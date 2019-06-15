
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public static void main(String[] args){
        int[] arr = new int[]{2,0,1,1,2,0};
        int[][] matrix = new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 }, { 7, 8, 9 }
};
        String str = "Test1ng-Leet=code-Q!";
        System.out.println("Answer: ");
        sortColors(arr);
    }



    public static void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] arr = new int[]{0,1,2};
        int i = 0;
        for(int a: arr){
            int temp = 0;
            if(map.containsKey(a))
                temp = map.get(a);
            int current = i;
            while(i < current + temp){
                nums[i] = a;
                i++;
            }
        }

        for(int num: nums){
            System.out.println(num);
        }
    }




}