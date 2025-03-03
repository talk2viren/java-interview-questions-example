package com.example.java_interview_questions.streams;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Number and List Functions

public class FindFrequencyExamples {

    // Type 1:   How Find frequency of character of string
    @Test
    public void example_1() {
        String name = "virendra";

        char[] charArray = name.toCharArray();

        System.out.println(charArray);

        IntStream.range(0, charArray.length)
                .mapToObj(i -> charArray[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .forEach(System.out::println);
    }

    // Type 2:   Fine frequency of character of string
    @Test
    public void example_2() {
        String name = "virendra";
        name.codePoints().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .limit(1)
                .forEach(System.out::println);

    }


//    Option 1: Find the Maximum Number and Minimum Number in a List
    @Test
    public void test_6(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.sort(numbers.reversed());
        System.out.println(numbers.get(0));
    }

    //    Option 2: Find the Maximum Number and Minimum Number in a List
    @Test
    public void test_7(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer first = numbers.stream().sorted(Comparator.reverseOrder())
                .findFirst().get();
        System.out.println(first);
    }

    //    Option 3: Find the Maximum Number and Minimum Number in a List
    @Test
    public void test_8(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        SortedSet<Integer> sortedSet=new TreeSet<>();
        numbers.stream().map(x -> sortedSet.add(x))
                .forEach(System.out::println);

        System.out.println(sortedSet);
    }

    @Test
    public void test_9(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        System.out.println(max.orElse(20));
    }


    // Java 8 Program to Find the Second Largest Number in the List of Integers
    @Test
    public void test_10(){
        List<Integer> numbers = Arrays.asList(10, 20, 35, 50, 50, 75, 65);
        numbers.stream().collect(Collectors.toSet())
                .stream().sorted(Comparator.reverseOrder())
                .skip(1)
                .forEach(System.out::println);
    }

//    Java 8 Program to Find the Sum of All Digits of a Number
    @Test
    public void test_11() {
        String str = "123456789";
        char[] charArray = str.toCharArray();
        long sum = IntStream.range(0, charArray.length)
                .mapToLong(x -> Integer.valueOf(x))
                .sum();
        System.out.println(sum);

    }

//    Java 8 Program to Print Even Numbers from a List
    @Test
    public void test_12(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().filter(x -> x%2 == 0)
                .forEach(System.out::println);
    }

//    Java 8 Program to Remove Duplicate Elements from a List
    @Test
    public void test_13(){
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        numbers.stream().distinct().forEach(System.out::println);
    }

    @Test
    void test_14() {
        System.out.println("test 14");
    }}
