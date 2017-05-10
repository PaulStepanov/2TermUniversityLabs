package model.logic;

public class NumberHandler<T extends Number> {

    public boolean isPalindrome(T number){
        String numStr = number.toString();
        String reversenumStr = new StringBuilder(numStr).reverse().toString();

        return reversenumStr.equals(numStr);
    }
}
