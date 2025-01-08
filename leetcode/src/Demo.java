/**
 * @author Mirac
 * @date 8/1/2025
 */
public class Demo {
    static Object resource1 = new Object();
    static Object resource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (resource1) {
                System.out.println("Thread1 running");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("get resource2");
                }
            }
        });

        Thread t2 = new Thread(()-> {
            synchronized (resource2) {
                System.out.println("Thread2 running");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println("get resource1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
