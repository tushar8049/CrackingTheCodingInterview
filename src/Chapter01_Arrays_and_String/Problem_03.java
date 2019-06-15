package Chapter01_Arrays_and_String;

public class Problem_03 {
    public static void main(String[] args){
        String str1 = "abc de  ";
        String str2 = "abcdd";
        System.out.println("Str1: "+URLify_0(str1));
        System.out.println("Str2: "+URLify_0(str2));
    }

    /**
     * My Solution!
     */
    public static String URLify_0(String str){

        char[] content = str.toCharArray();
        int i = content.length - 1;
        int j = i;

        // Set the i pointer to the last element of the String.
        while(content[i] == ' '){
            i--;
        }

        // Iterate from the back and Copy the Characters from ith Location to jth Location.
        while (i >= 0){
            if(content[i] != ' '){
                content[j] = content[i];
                j--;
            }
            else{
                content[j--] = '0';
                content[j--] = '2';
                content[j--] = '%';
            }
            i--;
        }
        return new String(content);
    }

}
