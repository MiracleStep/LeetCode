package 设计模式.简单工厂模式;

/**
 * @author Mirac
 * @date 10/9/2024
 */
public class SimpleFactory {
    public static Transport createTransport(String type) {
        if ("truck".equals(type)) {
            return new Truck();
        } else if ("ship".equals(type)) {
            return new Ship();
        }
        return null;
    }

    public static void main(String[] args) {
        Transport truck = SimpleFactory.createTransport("truck");
        truck.deliver();
        Transport ship = SimpleFactory.createTransport("ship");
        ship.deliver();
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
        System.out.println("陆上运输");
    }
}