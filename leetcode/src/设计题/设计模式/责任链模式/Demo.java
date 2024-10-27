package 设计题.设计模式.责任链模式;

/**
 * @author Mirac
 * @date 25/10/2024
 */
public class Demo {
    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        handlerA.setNextHandler(handlerB);

        handlerA.handleRequest("B");
    }
}

abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String request);
}

class HandlerA extends Handler {

    @Override
    public void handleRequest(String request) {
        if (request.equals("A")) {
            System.out.println("handler A running");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}


class HandlerB extends Handler {

    @Override
    public void handleRequest(String request) {
        if (request.equals("B")) {
            System.out.println("handler B running");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
