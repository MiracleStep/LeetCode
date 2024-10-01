package 设计题.设计模式.单例模式;

/**
 * @author Mirac
 * @date 10/9/2024
 */
public class Singleton_双重判定锁 {

    private static Singleton_双重判定锁 instance;

    private Singleton_双重判定锁() {}

    public static Singleton_双重判定锁 getInstance() {
        if (instance == null) {
            synchronized (Singleton_双重判定锁.class) {
                if (instance == null) {
                    instance = new Singleton_双重判定锁();
                }
            }
        }
        return instance;
    }
}
