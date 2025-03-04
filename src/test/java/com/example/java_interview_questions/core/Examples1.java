package com.example.java_interview_questions.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Examples1 {

    //    Find Non Repetable Charactor in String using java Streams and loop
    @Test
    void findNonRepetableChar_1() {
//        String input = "common";
        String input = "swiss";

        char charArray[] = input.toCharArray();

        Map<Character, Long> collect = IntStream.range(0, input.length())
                .mapToObj(x -> charArray[x])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        char found = 'x';
        for (char x : charArray) {
            if (collect.get(x) == 1) {
                found = x;
                break;
            }
        }

        System.out.println("Value >> " + found);

    }


    //    Find Non Repetable Charactor in String using java Streams
    @Test
    void findNonRepetableChar_2() {
//        String input = "common";
        String input = "swiss";

        char charArray[] = input.toCharArray();

        Map<Character, Long> collect = IntStream.range(0, input.length())
                .mapToObj(x -> charArray[x])
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Optional<Character> first = IntStream.range(0, charArray.length)
                .mapToObj(x -> charArray[x])
                .filter(x -> collect.get(x) == 1)
                .findFirst();

        System.out.println(first.orElse('x'));

    }

    //    Find Non Repetable Charactor in String using java Streams. This function is using LinkedHashMap. which maintains order of insertion.
    @Test
    void findNonRepetableChar_3() {
//        String input = "common";
        String input = "swiss";

        char charArray[] = input.toCharArray();

        Map<Character, Long> collect = IntStream.range(0, input.length())
                .mapToObj(x -> charArray[x])
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        collect.entrySet()
                .stream().filter(x -> x.getValue() == 1)
                .limit(1)  // get first occurrence
                .forEach(System.out::println);

    }
    //    Find Non Repetable String in String using java Streams.

    @Test
    void findNonRepetableChar_4() {
        String input = "swiss";

        String[] split = input.split("");

        LinkedHashMap<String, Long> collect = Arrays.stream(split)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        collect.entrySet().stream().filter(x -> x.getValue() == 1)
                .limit(1)
                .forEach(System.out::println);
    }



    }
