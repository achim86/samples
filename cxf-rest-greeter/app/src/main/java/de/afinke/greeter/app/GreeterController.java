package de.afinke.greeter.app;

import de.afinke.greeter.GreeterService;

public class GreeterController {

    private GreeterService greeterService;

    public void setGreeterService(GreeterService greeterService) {
        this.greeterService = greeterService;
    }

    public String readGreeting() {
        return greeterService.greet();
    }
}