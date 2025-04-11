package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionUsingGraphsTest {

    @Test
    public void testEmptyDictionary() {
        String[] words = {};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("", solution.alienOrder());
    }

    @Test
    public void testSingleWord() {
        String[] words = {"abc"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("abc", solution.alienOrder());
    }

    @Test
    public void testSingleWordWithRepeats() {
        String[] words = {"aaabbbccc"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("abc", solution.alienOrder());
    }

    @Test
    public void testInvalidLengthOrder() {
        String[] words = {"abc", "ab"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("", solution.alienOrder());
    }

    @Test
    public void testValidOrderWithPrefix() {
        String[] words = {"ab", "abc", "abd"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("", solution.alienOrder());
    }

    @Test
    public void testSameLengthWords() {
        String[] words = {"baa", "bbb", "bba"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("", solution.alienOrder());
    }

    @Test
    public void testValidSameLengthOrder() {
        String[] words = {"baa", "bab", "bac"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("abc", solution.alienOrder());
    }

    @Test
    public void testOriginalExample() {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("wertf", solution.alienOrder());
    }

    @Test
    public void testSomeOrder() {
        String[] words = {"z", "x"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("zx", solution.alienOrder());
    }

    @Test
    public void testValidIncreasingLength() {
        String[] words = {"a", "aa", "aaa"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("a", solution.alienOrder());
    }

    @Test
    public void testValidWithDifferentPrefix() {
        String[] words = {"ab", "ac", "bc"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("abc", solution.alienOrder());
    }

    @Test
    public void testEmptyWord() {
        String[] words = {"", "a", "aa"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        assertEquals("a", solution.alienOrder());
    }
} 