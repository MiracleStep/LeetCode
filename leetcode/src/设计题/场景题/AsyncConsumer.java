package 设计题.场景题;

import java.util.concurrent.*;

//实现一个消费者，能单线程的获取消息，并且可以异步的处理消息，最后所有消息处理完返回结果（没具体写过多线程与Future类，大概给面试官讲了一下思路）
public class AsyncConsumer {
//    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.HOURS, new LinkedBlockingQueue<>());

    public void consumeMessages() {
        // 模拟消息队列
        BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 10; i++) {
            messageQueue.add("Message " + i);
        }

        // 单线程获取消息
        while (!messageQueue.isEmpty()) {
            String message = messageQueue.poll();
            if (message != null) {
                // 异步处理消息
                Future<String> future = executor.submit(() -> processMessage(message));
                try {
                    // 获取处理结果
                    String result = future.get();
                    System.out.println("Processed: " + result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

        // 关闭线程池
        executor.shutdown();
    }

    private String processMessage(String message) {
        // 模拟消息处理
        return message + " processed";
    }

    public static void main(String[] args) {
        AsyncConsumer consumer = new AsyncConsumer();
        consumer.consumeMessages();
    }
}
