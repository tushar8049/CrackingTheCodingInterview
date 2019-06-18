package Chapter01_Arrays_and_String;


import java.util.HashMap;

/**
 * 1.5  One Away
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 */

public class Problem_05 {
    public static void main(String[] arg){
        String[][] collection = {{"pale", "ple"},{"pales", "pale"},{"pale", "bale"}, {"pale", "bake"}};

        for(String[] pair : collection){
            System.out.println(oneAway_1(pair[0], pair[1]));
        }
    }
    /**
     *  My Solution!
     */
    public static boolean oneAway_0(String str1, String str2){

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str1.length(); i++){
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }

        int checkCounter = 0;

        if(str1.length() != str2.length())
            checkCounter++;

        for(int i = 0; i < str2.length(); i++){
            if(map.containsKey(str2.charAt(i)) && map.get(str2.charAt(i)) != 0)
                map.put(str2.charAt(i), map.get(str2.charAt(i))-1);
            else
                checkCounter++;
        }

        if(checkCounter != 1)
            return false;

        return true;
    }

    /**
     * Looked Up Solution!
     */
    public static boolean oneAway_1(String str1, String str2){

        if(Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        String large = str1.length() > str2.length() ? str1 : str2;
        String small = str1.length() > str2.length() ? str2 : str1;

        boolean check = false;
        int smallPointer = 0;
        int largePointer = 0;
        while(smallPointer < small.length() && largePointer < large.length()){

            if(large.charAt(largePointer) != small.charAt(smallPointer)){
                if(check)
                    return false;
                check = true;
                if(small.length() == large.length())
                    smallPointer++;
            }
            else
                smallPointer++;
            largePointer++;
        }

        return true;
    }
}
