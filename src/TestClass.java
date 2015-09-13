/**
 * Created by Zennard on 9/9/2015.
 */
public class TestClass {
    public static void main (String args[]) {
        printPermutation("","abcde");
    }
    public static void printPermutation(String prefix, String s) {
        if (s.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            printPermutation(prefix+c, s.substring(0,i) + s.substring(i+1));
        }
    }
}
