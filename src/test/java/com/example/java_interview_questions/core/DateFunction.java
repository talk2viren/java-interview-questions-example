package com.example.java_interview_questions.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

//Date Functions
public class DateFunction {

//    Find the Age of a Person if the Birthday Date has Given
    @Test
    public void example_1(){
        String birthDate = "14-05-1978";
        LocalDate localDate = LocalDate.of(1978, Month.MAY,14);
        Period between = Period.between(localDate, LocalDate.now());
        System.out.println(between.getYears());

    }
}
