package com.example.java_interview_questions.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class ReverseString {

    // Reverse String
    @Test
    public void example_1() {
        String str = "virendra";

        StringBuilder sb = new StringBuilder();
        IntStream
                .iterate(str.length() - 1, (x) -> x - 1)
                .limit(str.length())
                .mapToObj(x -> str.toCharArray()[x])
                .forEach(x -> sb.append(x));

        System.out.println(sb);
    }

    // Reverse String
    @Test
    public void example_2() {
        String str = "my name is virendra";
        StringBuilder builder = new StringBuilder();
        Arrays.stream(str.split(" "))
                .forEach(token -> {
                    builder.insert(0, " " + token);
                });

        System.out.println(builder);
    }

    // Reverse String
    @Test
    public void example_3() {
        String str = "my name is virendra";
        StringTokenizer tokenizer = new StringTokenizer(str);

        StringBuilder builder = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            builder.insert(0, " " + tokenizer.nextToken());
        }

        System.out.println(builder);
    }

}
