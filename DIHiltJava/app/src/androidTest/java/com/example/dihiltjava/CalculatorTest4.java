package com.example.dihiltjava;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest4 {
    Calculator calculator = new Calculator();

    @Test
    public void testSucees() {
        Integer result = calculator.divider(2,1);
        assertEquals( (int)3, (int)result);
    }

    @Test
    public void testError() {
        Integer result = calculator.divider(2,1);

    }
}