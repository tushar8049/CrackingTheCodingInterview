package Chapter01_Arrays_and_String;

/**
 * Problem 6: String Compression:
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a -z).
 */

public class Problem_06 {
    public static void main(String[] arg){
        String str = "aabcccccaaa";
        System.out.println("Answer: " + stringCompression_0(str));
    }

    public static String stringCompression_0(String str){
        StringBuilder result = new StringBuilder();
        char currentChar = str.charAt(0);
        int currentCount = 1;

        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) != currentChar){
                result.append(currentChar);
                result.append(currentCount);
                currentChar = str.charAt(i);
                currentCount = 0;
            }
            currentCount++;
        }
        result.append(currentChar);
        result.append(currentCount);

        if(str.length() <= result.length() )
            return str;
        return new String(result);
    }
}
