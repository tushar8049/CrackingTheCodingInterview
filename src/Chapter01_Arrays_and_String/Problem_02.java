package Chapter01_Arrays_and_String;

import java.util.HashMap;

public class Problem_02 {
    public static void main(String[] args){
        String str1 = "abcde";
        String str2 = "abedc";
        System.out.println("Str1: "+isPermutation_0(str1,str2));
        System.out.println("Str2: "+isPermutation_1(str2, str1));
    }

    /**
     *  My Solution!
     */
    public static boolean isPermutation_0(String str1, String str2){
        if (str1.length() != str2.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str1.length(); i++){
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }

        for(int i = 0; i< str2.length(); i++){
            if(map.containsKey(str2.charAt(i))){
                map.put(str2.charAt(i),map.get(str2.charAt(i))-1);
                if(map.get(str2.charAt(i))== -1)
                    return false;
            }
            else
                return false;
        }
        return true;
    }

    /**
     *  Looked Up Solution!
     */
    public static boolean isPermutation_1(String str1, String str2){
        return sort(str1).equals(sort(str2));
    }
    public static String sort(String str){
        char[] c = str.toCharArray();
        java.util.Arrays.sort(c);
        return new String(c);
    }
}
