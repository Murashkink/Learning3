package Chain;

abstract class Handler {
    private Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public void handle(String request) {
        if (!process(request) && next != null) {
            next.handle(request);
        }
    }

    protected abstract boolean process(String request);
}

class AuthHandler extends Handler {
    protected boolean process(String request) {
        if (request.contains("auth")) {
            System.out.println("Авторизация выполнена");
            return true;
        }
        return false;
    }
}

class DataHandler extends Handler {
    protected boolean process(String request) {
        if (request.contains("data")) {
            System.out.println("Обработка данных выполнена");
            return true;
        }
        return false;
    }
}


public class ChainDemo {
    public static void main(String[] args) {
        Handler auth = new AuthHandler();
        Handler data = new DataHandler();
        auth.setNext(data);

        auth.handle("auth request");
        auth.handle("data request");
        auth.handle("unknown request");
    }
}
