import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class BalancedWordsCounter {
    public static Integer count(String input) {
        if(input == null) {
            throw new RuntimeException("Input is NULL");
        } else if (input.length() == 0) {
             return 0;
        } else if(!Pattern.matches("[a-zA-Z]+", input)) {
            throw new RuntimeException("Word contain non-letter symbols");
        } else {

            Map<String, Integer> letters = new HashMap<String, Integer>();
            Integer counter = numberOfLettersInWord(input,input.charAt(0));
            letters.put(String.valueOf(input.charAt(0)),counter);

            for(int i = 0; i < input.length(); i++) {
                letters.putIfAbsent(String.valueOf(input.charAt(i)),numberOfLettersInWord(input,input.charAt(i)));
            }
            System.out.println(letters);

            for (String key : letters.keySet()){
                if(!Objects.equals(counter, letters.get(key))){
                    throw new RuntimeException("Word is not balanced");
                }
            }
            return counter;
        }
    }

    private static Integer numberOfLettersInWord(@NotNull String inputWord, char letter){
        int counter = 0;
        for(int i = 0; i <inputWord.length(); i++) {
            if(letter == inputWord.charAt(i)){
                counter++;
            } else continue;
        }
        return counter;
    }
}
