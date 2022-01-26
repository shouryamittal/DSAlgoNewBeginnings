package easy;

public class Palindrome {
    private boolean isPalindrome(String str) {
        int s = 0, e = str.length() - 1;
        boolean isTrue = true;
        for(int i = 0 ; i < str.length(); i++) {
            if(str.charAt(s) != str.charAt(e)) {
                isTrue = false;
                break;
            }
            s++;
            e--;
        }
        return isTrue;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        String str = "nitin";
        System.out.println(str + " is palindrome :" + p.isPalindrome(str));
    }
}
