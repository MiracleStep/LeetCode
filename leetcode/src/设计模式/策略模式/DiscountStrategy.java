package 设计模式.策略模式;

import java.util.HashMap;
import java.util.Map;

interface Discount {
    void cal();
}

class RateDiscount implements Discount {

    @Override
    public void cal() {
        System.out.println("-20%");
    }
}

class PriceDiscount implements Discount {

    @Override
    public void cal() {
        System.out.println("-10");
    }
}

public class DiscountStrategy {
    private final static Map<String, Discount> strategies = new HashMap<>();
  
    static {
        strategies.put("RateDiscount", new RateDiscount());
        strategies.put("PriceDiscount", new PriceDiscount());
    }  
  
    public static Discount getDiscount(String type) {
        return strategies.get(type);  
    }  
}