package com.example.primenumberconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class NumbersMessageProcessorImpl implements NumbersMessageProcessor {

    private static final String COMMA_SEPARATOR = ",";

    private final PrimeNumberChecker primeNumberChecker;
    private final CsvGenerator csvGenerator;

    @Override
    public void process(String numbers) {
        List<Integer> primeNumbers = Arrays.stream(numbers.split(COMMA_SEPARATOR))
                .map(Integer::valueOf)
                .filter(this.primeNumberChecker::isPrimeNumber)
                .collect(Collectors.toList());

        if (!primeNumbers.isEmpty()) {
            log.info("Prime numbers found: {}", primeNumbers);

            String primeNumbersStr = primeNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(COMMA_SEPARATOR));
            this.csvGenerator.generate(primeNumbersStr);
        } else {
            log.info("No prime numbers found");
        }
    }
}
