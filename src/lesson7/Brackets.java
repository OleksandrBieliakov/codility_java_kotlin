package lesson7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Brackets {

    public int solution(String S) {
        Set<Character> openingBracketsTypes = new HashSet<>(Arrays.asList('(', '[', '{'));
        LinkedList<Character> bracketsEncountered = new LinkedList<>();

        for (char ch : S.toCharArray()) {
            if (openingBracketsTypes.contains(ch)) {
                bracketsEncountered.add(ch);
            } else {
                if (ch == ')' && (bracketsEncountered.size() == 0 || bracketsEncountered.removeLast() != '(')) {
                    return 0;
                }
                if (ch == ']' && (bracketsEncountered.size() == 0 || bracketsEncountered.removeLast()  != '[')) {
                    return 0;
                }
                if (ch == '}' && (bracketsEncountered.size() == 0 || bracketsEncountered.removeLast()  != '{')) {
                    return 0;
                }
            }
        }
        if (bracketsEncountered.size() != 0) {
            return 0;
        }
        return 1;
    }

}
