/*************************************************************************
 *  Compilation:  javac RunLengthEncoding.java
 *  Execution:    java RunLengthEncoding
 *
 *  @author: Kerem Sahin
 *
 *************************************************************************/

public class RunLengthEncoding {

    /* 
     * Encode the original string by finding sequences in the string
     * where the same character repeats. Replace each such sequence
     * by a token consisting of: the number of characters in the sequence
     * followed by the repeating character.
     * Return the encoded string.
     */
    public static String encode (String original)  {

    String str = original;
	
    int n = original.length(); 
        for (int i = 0; i < n; i++) { 
  
            int count = 1; 
            while (i < n - 1 && original.charAt(i) == original.charAt(i + 1)) { 
                count++; 
                i++; 
            } 

    }
        return original;
}
    /*
     * Decodes the original string encoded with the encode method.
     * Returns the decoded string.
     *
     * YOUR decode METHOD MUST BE RECURSIVE, do not use while, do/while, 
     * or for loops
     */
    public static String decode (String original)  {

	char c = ' ';
    String temp;

    if(original.length() != 1){
        c = original.charAt(1);
    }if(original.length() == 1){
        return original;       
    }else if(original.charAt(0) == '0' && original.length() != 2){
        return decode(original.substring(2));
    }else if(original.charAt(0) == '0' && original.length() == 2){
        original = "\0";
        return original;
    }else if(Character.isDigit(original.charAt(0)) == true){
        int i = Integer.parseInt(original.substring(0,1));
        i = i-1;
        temp = Integer.toString(i);
        return c + decode(temp.concat(original.substring(1)));
    }
    return original.charAt(0)+decode(original.substring(1));

    }

    public static void main (String[] args) {

	  /* string str = "wwwwaaadexxxxxxywww"; 
       encode(str);
       decode(str);*/ 
    }
}
