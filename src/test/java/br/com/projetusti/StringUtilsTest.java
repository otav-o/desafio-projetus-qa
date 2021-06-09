package br.com.projetusti;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    private static final Map<Boolean, List<String>> MAP_PALINDROME;

    static {
        final Map<Boolean, List<String>> auxMap = new HashMap<>();
        auxMap.put(true, Arrays.asList("Now I won", "Pull up", "Madam"));
        auxMap.put(false, Arrays.asList("Java", "Groovy", "Flex"));

        MAP_PALINDROME = Collections.unmodifiableMap(auxMap);
    }

    @Test
    public void evaluateIsPalindromeTest() {
        MAP_PALINDROME.forEach((key, values) -> values.forEach(s -> Assert.assertEquals(key, StringUtils.isPalindrome(s))));
    }

    @Test
    public void evaluateIsIsEmptyTest() {
        Assert.assertEquals(true, StringUtils.isEmpty(null));
        Assert.assertEquals(true, StringUtils.isEmpty(""));
        Assert.assertEquals(true, StringUtils.isEmpty(" "));
        Assert.assertEquals(false, StringUtils.isEmpty(" a"));
    }
}