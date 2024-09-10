package 设计模式.单例模式;


public class Singleton_饿汉式 {

    private static final Singleton_饿汉式 instance = new Singleton_饿汉式();

    private Singleton_饿汉式() {}

    public static Singleton_饿汉式 getInstance() {
        return instance;
    }
}
