package com.example.primenumberconsumer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PrimeNumberCheckerImpl.class)
class PrimeNumberCheckerImplTest {

    private static final Set<Integer> PRIME_NUMBERS;
    private static final Set<Integer> NOT_PRIME_NUMBERS;

    @Autowired
    private PrimeNumberChecker primeNumberChecker;

    static {
        PRIME_NUMBERS = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 3733, 7907));
        NOT_PRIME_NUMBERS = new HashSet<>(Arrays.asList(0, 1, -5, -7, Integer.MIN_VALUE, 100, 90009));
    }

    @Test
    void isPrimeNumber() {
        PRIME_NUMBERS.forEach(
                num -> assertTrue(this.primeNumberChecker.isPrimeNumber(num))
        );
    }

    @Test
    void isNotPrimeNumber() {
        NOT_PRIME_NUMBERS.forEach(
                num -> assertFalse(this.primeNumberChecker.isPrimeNumber(num))
        );
    }
}