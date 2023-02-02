import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BalancedWordsCounterTest {
    BalancedWordsCounter balancedWordsCounter;

    @Test
    public void testSimpleCount(){
        String input =  "aabbabcccbac";
        Integer expected =  4;
        assertEquals(expected,balancedWordsCounter.count(input));
    }

    @Test
    public void testEmptyCount(){
        String input = new String(); input = "";
        Integer expected =  0;
        assertEquals(expected,balancedWordsCounter.count(input));
    }

    @Test
    public void testDigitInWordWithExceptionAsAResult(){
        String input =  "abababa1";
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            balancedWordsCounter.count(input);
        });
        assertEquals("Word contain non-letter symbols", exception.getMessage());
    }

    @Test
    public void testNonBalancedWordWithExceptionAsAResult(){
        String input =  "elephant";
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            balancedWordsCounter.count(input);
        });
        assertEquals("Word is not balanced", exception.getMessage());
    }

    @Test
    public void testNullCountWithExceptionAsAResult(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            balancedWordsCounter.count(null);
        });
        assertEquals("Input is NULL", exception.getMessage());

    }
}
