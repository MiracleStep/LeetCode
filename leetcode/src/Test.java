import java.text.ParseException;

public class Test {
    public static Transport createTransport(String type) {
        if ("ship".equals(type)) {
            return new Ship();
        } else if ("truck".equals(type)) {
            return new Truck();
        }
        return null;
    }
    public static void main(String[] args) throws ParseException {
    }


}

interface Transport {
    void deliver();
}

class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("海上运输");
    }
}

class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("路上运输");
    }
}


