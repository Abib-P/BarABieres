package com.barabieres.cashflow;

import com.barabieres.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CashFlowTest {

    CashFlow cashFlow = new CashFlow(1000);

    @Test
    void should_increase_cashflow() {
        cashFlow.increaseCashFlow(100);
        assertEquals(1100, cashFlow.getValue());
    }

    @Test
    void should_decrease_cashflow() {
        cashFlow.decreaseCashFlow(100);
        assertEquals(900, cashFlow.getValue());
    }

}
