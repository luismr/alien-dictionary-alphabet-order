package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionUsingRecursionTest {

    @Test
    public void testEmptyDictionary() {
        String[] words = {};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("", solution.alienOrder());
    }

    @Test
    public void testSingleWord() {
        String[] words = {"abc"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("abc", solution.alienOrder());
    }

    @Test
    public void testSingleWordWithRepeats() {
        String[] words = {"aaabbbccc"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("abc", solution.alienOrder());
    }

    @Test
    public void testInvalidLengthOrder() {
        String[] words = {"abc", "ab"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("", solution.alienOrder());
    }

    @Test
    public void testValidOrderWithPrefix() {
        String[] words = {"ab", "abc", "abd"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("", solution.alienOrder());
    }

    @Test
    public void testSameLengthWords() {
        String[] words = {"baa", "bbb", "bba"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("", solution.alienOrder());
    }

    @Test
    public void testValidSameLengthOrder() {
        String[] words = {"baa", "bab", "bac"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("abc", solution.alienOrder());
    }

    @Test
    public void testOriginalExample() {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("wertf", solution.alienOrder());
    }

    @Test
    public void testSomeOrder() {
        String[] words = {"z", "x"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("zx", solution.alienOrder());
    }

    @Test
    public void testValidIncreasingLength() {
        String[] words = {"a", "aa", "aaa"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("a", solution.alienOrder());
    }

    @Test
    public void testValidWithDifferentPrefix() {
        String[] words = {"ab", "ac", "bc"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("abc", solution.alienOrder());
    }

    @Test
    public void testEmptyWord() {
        String[] words = {"", "a", "aa"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        assertEquals("a", solution.alienOrder());
    }
} 