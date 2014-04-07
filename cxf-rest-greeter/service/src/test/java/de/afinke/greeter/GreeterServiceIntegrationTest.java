package de.afinke.greeter;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreeterServiceIntegrationTest {

    static final String URL = System.getProperty("tomcat.url");

    GreeterService greeterService = JAXRSClientFactory.create(URL, GreeterService.class);

    @Test
    public void greeting() throws InterruptedException {
        assertEquals("Greetings!", greeterService.greet());
    }

}
