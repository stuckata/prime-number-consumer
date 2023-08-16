package com.example.primenumberconsumer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CsvGeneratorImpl.class)
class CsvGeneratorImplTest {

    private static final String NUMBERS_STR = "2,3,5,7,11,13,17,19";

    @Autowired
    private CsvGenerator csvGenerator;

    @Test
    void generate() {
        assertDoesNotThrow(() -> this.csvGenerator.generate(NUMBERS_STR));
    }
}