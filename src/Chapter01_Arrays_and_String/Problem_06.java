package Chapter01_Arrays_and_String;

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
