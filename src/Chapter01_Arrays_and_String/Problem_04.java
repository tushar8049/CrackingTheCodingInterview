package Chapter01_Arrays_and_String;

import java.util.HashSet;

public class Problem_04 {
    public static void main(String[] args){
        String str1 = "Tact Coa";
        String str2 = "taco cat";
        System.out.println("Str1: "+isPalindromePermutation_0(str1));
        System.out.println("Str2: "+isPalindromePermutation_0(str2));
    }

    /**
     * My Solution!
     */
    public static boolean isPalindromePermutation_0(String str){

        str = str.toLowerCase();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                if(set.contains(str.charAt(i)))
                    set.remove(str.charAt(i));
                else
                    set.add(str.charAt(i));
            }
        }

        if(set.size() > 1)
            return false;

        return true;
    }

    /**
     *  Looked Up Solution!
     *  Can be done using the Bit Operations.
     */

}
