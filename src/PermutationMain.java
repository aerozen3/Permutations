import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zennard on 9/9/2015.
 */
public class PermutationMain {
    public static void main (String args[]) {
        printPermutation("","abcde");
        HashSet<String> ret = new HashSet();
        getPerms(5,5,"", ret);
        for (String s : ret) {
            System.out.println(convertParens(s));
        }
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
    public static String convertParens(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int size = Character.getNumericValue(c);
            for (int i = 0; i < size; i++) {
                sb.append("(");
            }
            for (int i = 0; i < size; i++) {
                sb.append(")");
            }
        }
        return sb.toString();
    }
    public static void getPerms(int sum, int max, String prefix, Set<String> ret) {
        if (sum == 0) {
            ret.add(prefix);
            return;
        }

        for (int i = Math.min(max, sum); i >= 1; i--) {
            if (prefix.isEmpty()) {
                getPerms(sum - i, i, ""+i, ret);
            } else {
                for (int y = 0; y < prefix.length(); y++) {
                    String newPrefix = prefix.substring(0, y) + i + prefix.substring(y);
                    getPerms(sum - i, i, newPrefix, ret);
                }
                getPerms(sum - i, i, prefix+i, ret);
            }
        }
    }
}
