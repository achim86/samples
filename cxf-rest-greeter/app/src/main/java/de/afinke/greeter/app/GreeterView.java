package de.afinke.greeter.app;

public class GreeterView {

    private GreeterController greeterController;
    private String greeting;

    public void setGreeterController(GreeterController greeterController) {
        this.greeterController = greeterController;
    }

    public void initializeGreeting() {
        greeting = greeterController.readGreeting();
    }

    public void resetGreeting() {
        greeting = "";
    }

    public String getGreeting() {
        return greeting;
    }
}
