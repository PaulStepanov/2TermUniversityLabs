package model.logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberHandlerTest {
    @Test
    public void isPalindrome() throws Exception {
        NumberHandler<Double> doubleNumberHandler = new NumberHandler<>();

        assertTrue(doubleNumberHandler.isPalindrome(131.131));
        assertTrue(!doubleNumberHandler.isPalindrome(131.07));

    }

}