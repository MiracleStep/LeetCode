package 设计题.设计模式.工厂方法模式;

/**
 * @author Mirac
 * @date 10/9/2024
 */
public class Main {
    public static void main(String[] args) {
        ShipFactory shipFactory = new ShipFactory();
        Transport transport = shipFactory.createTransport();
        transport.deliver();

        TruckFactory truckFactory = new TruckFactory();
        Transport transport1 = truckFactory.createTransport();
        transport1.deliver();
    }
}

interface Transport {
    void deliver();
}

class Ship implements Transport{

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

interface TransportFactory {
    Transport createTransport();
}

class TruckFactory implements TransportFactory {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class ShipFactory implements TransportFactory {

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
