package 设计题.设计模式.单例模式;

/**
 * @author Mirac
 * @date 10/9/2024
 */
public class Singleton_懒汉式 {

    private static Singleton_懒汉式 instance;

    private Singleton_懒汉式() {}

    public static synchronized Singleton_懒汉式 getInstance() {
        if (instance == null) {
            instance = new Singleton_懒汉式();
        }
        return instance;
    }
}
