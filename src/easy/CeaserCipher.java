package easy;
import java.util.Arrays;

/**
 * Q: Implement ceaser cipher encryptor
 */
public class CeaserCipher {

    //method 1: use ASCII code of each character in the string. When it goes > 122, round it back to 96
    // Time: O(N), Space: O(N) -> bcz we are using newArr
    // Edge case -> if key is large number such as 50 -> to solve this, we must take key's modulo
    // with 26 so that we get a number with a range 0-26
    private String encryptString(String str, int key) {
        key = key % 26;
        char newArr[] = new char[str.length()];
        for(int i = 0 ; i < str.length(); i++) {
            int code = str.charAt(i);
            int newCode = code + key;
            if(newCode <= 122) {
                newArr[i] = (char)newCode;
            }
            else {
                newArr[i] = (char)((newCode%122) + 96);
            }
        }
        StringBuilder string = new StringBuilder();
        for(char ele: newArr) {
            string.append(ele);
        }
        return string.toString();
    }

    public static void main(String[] args) {
        CeaserCipher c = new CeaserCipher();
        String str = "shourya";
        int key = 2;
        System.out.println("Encrypted String is: " + c.encryptString(str, key));
    }
}
