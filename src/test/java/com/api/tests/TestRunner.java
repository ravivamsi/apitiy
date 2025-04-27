package com.api.tests;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestRunner {

    @Test
    void testAll() {
        Results results = Runner.path("classpath:features")
                              .tags("@jsonplaceholder")
                              .parallel(1);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
} 