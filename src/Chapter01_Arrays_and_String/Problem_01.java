package Chapter01_Arrays_and_String;

/**
 *
 */


import java.util.HashSet;

public class Problem_01 {
    public static void main(String[] args){
        String str1 = "abcde";
        String str2 = "abcdd";
        System.out.println("Str1: "+isUniqueCharacter_1(str1));
        System.out.println("Str2: "+isUniqueCharacter_1(str2));
    }

    /**
     * My Solution!
     */
    public static boolean isUniqueCharacter_0(String str){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            if(set.contains(str.charAt(i)))
                return false;
            else
                set.add(str.charAt(i));
        }
        return true;
    }

    /**
     * Looked Out Solution!
     */
    public static boolean isUniqueCharacter_1(String str){
        boolean[] check = new boolean[128];
        if(str.length() > 128)
            return false;

        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if (check[val])
                return false;
            else
                check[val] = true;
        }
        return true;
    }
}
