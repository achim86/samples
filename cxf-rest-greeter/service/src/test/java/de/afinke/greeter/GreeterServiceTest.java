package de.afinke.greeter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreeterServiceTest {

    GreeterServiceImpl greeterService = new GreeterServiceImpl();

    @Test
    public void greeting() {
        assertEquals("Greetings!", greeterService.greet());
    }

}
