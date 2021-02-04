package com.barabieres.application;

import org.junit.jupiter.api.Test;

import static com.barabieres.application.Application.runProgram;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {

    private static final int EXIT_SUCCESS = 0;
    private static final int EXIT_FAILURE = 1;

    @Test
    void should_run_program_return_exit_success_when_called() {
        int response = runProgram(null);

        assertThat(response).isEqualTo(EXIT_SUCCESS);
    }

}