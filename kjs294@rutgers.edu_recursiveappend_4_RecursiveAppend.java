/*************************************************************************
 *  Compilation:  javac RecursiveAppend.java
 *  Execution:    java RecursiveAppend
 *
 *  @author:Kerem Sahin
 *
 *************************************************************************/

public class RecursiveAppend {

    // Returns the original string appended to the original string n times 
    public static String appendNTimes(String original, int n) {

		if (n == 0) {
        	return original;
    }
   	  return original + appendNTimes(original, n - 1);
    }

    public static void main (String[] args) {
		String name = StdIn.readString();
		int num = StdIn.readInt();

		System.out.println(appendNTimes(name,num));


    }
}
