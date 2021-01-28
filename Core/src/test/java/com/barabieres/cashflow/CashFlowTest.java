package com.barabieres.cashflow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashFlowTest {

    CashFlow cashFlow;

    @BeforeEach
    void setup() {
        cashFlow = new CashFlow(1000);
    }

    @Test
    void should_increase_cashflow() {
        System.out.println(cashFlow.getValue());
        cashFlow.increaseCashFlow(100);
        assertEquals(1100, cashFlow.getValue());
    }

    @Test
    void should_decrease_cashflow() {
        System.out.println(cashFlow.getValue());
        cashFlow.decreaseCashFlow(100);
        assertEquals(900, cashFlow.getValue());
    }
}