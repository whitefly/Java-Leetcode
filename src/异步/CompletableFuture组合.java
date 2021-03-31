package 异步;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuture组合 {
    static ExecutorService pool = Executors.newFixedThreadPool(4);
    static Random random = new Random();
    int studentCount = 3;

    private CompletableFuture<Void> stage1() {
        //举手回答问题阶段
        List<CompletableFuture<String>> list = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            CompletableFuture<String> handUp = CompletableFuture.completedFuture(i + "").thenApplyAsync(this::handUp, pool);
            list.add(handUp);
        }
        CompletableFuture<Object> handUps = CompletableFuture.anyOf(list.toArray(new CompletableFuture[0]));
        return handUps.thenAcceptAsync(x -> question((String) x), pool);
    }

    private CompletableFuture<Void> stage2() {
        //考试阶段
        List<CompletableFuture<Void>> list = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            CompletableFuture<Void> handUp = CompletableFuture.completedFuture(i + "").thenAcceptAsync(this::submitPaper, pool);
            list.add(handUp);
        }
        CompletableFuture<Void> submits = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]));
        return submits.thenRunAsync(this::correct, pool);
    }


    private static void process() {
        CompletableFuture组合 demo = new CompletableFuture组合();
        CompletableFuture<Void> s1 = demo.stage1();
        CompletableFuture<Void> voidCompletableFuture = s1.thenComposeAsync(x -> demo.stage2(), pool);
        try {
            voidCompletableFuture.get();
            pool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    private void waitSeconds() {
        try {
            Thread.sleep(random.nextInt(5) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String handUp(String studentId) {
        waitSeconds();
        System.out.println("举手: " + studentId);
        return studentId;
    }

    private void question(String studentId) {
        System.out.println("老师: " + studentId + "起立");
    }

    private void correct() {
        System.out.println("老师: 批改作业");
    }

    private void submitPaper(String studentId) {
        waitSeconds();
        System.out.println("提交卷子: " + studentId);
    }

    public static void main(String[] args) {
        process();
    }
}
