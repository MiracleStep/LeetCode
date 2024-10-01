package 设计题.设计模式.单例模式;

/**
 * @author Mirac
 * @date 10/9/2024
 */
public class Singleton_静态内部类 {
    private Singleton_静态内部类() {}

    private static class SingletonHolder {
        private static final Singleton_静态内部类 INSTANCE = new Singleton_静态内部类();
    }

    public static Singleton_静态内部类 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
