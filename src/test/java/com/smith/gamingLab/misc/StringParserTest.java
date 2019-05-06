package com.smith.gamingLab.misc;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StringParserTest {

    @Test
    public  void test_parseString() {
        String t1 = "hello,world,my,name,is,faith";
        String token = ",";
        String[] expectedOutput = {"hello", "world", "my", "name", "is", "faith"};
        String[] actualOutput = StringParser.parseString(t1, token);
        for (int i = 0; i < expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], actualOutput[i]);
        }

        t1 = "hello, world, my, name, is, faith";
        token = ", ";
        actualOutput = StringParser.parseString(t1, token);
        for (int i = 0; i < expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], actualOutput[i]);
        }
    }

    @Test
    public void test_parseStringUnfoundToken() {
        String title = "hello, what, is, up";
        String token = "@";
        String[] expectedOutput = {title};
        String[] actual = StringParser.parseString(title, token);
        assertEquals(expectedOutput.length, actual.length);
        assertEquals(expectedOutput[0], actual[0]);
    }

    @Test
    public void test_parseStringEmptyTitle() {
        String title = "";
        String token = ",";
        String[] expected = new String[0];
        String[] actual = StringParser.parseString(title, token);
        assertEquals(expected.length, actual.length);
    }

    @Test
    public void test_parseStringEmptyToken() {
        String title = "tomb";
        String token  = "";
        String[] expected = {"t", "o","m","b"};
        String[] actual = StringParser.parseString(title, token);
        assertEquals(expected.length, actual.length);
        assertEquals(expected[0], actual[0]);
    }


}
