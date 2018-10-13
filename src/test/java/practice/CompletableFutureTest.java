package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;


public class CompletableFutureTest {

  private final static Random random = new Random();
  private final ExecutorService executor = Executors.newFixedThreadPool(10);

  @Test
  public void test1() throws ExecutionException, InterruptedException {
    CompletableFuture<String> test1 = CompletableFuture.completedFuture(10000 + "");
    System.out.println("begin:" + test1.get());
    //可以异步的执行，并且可以自己传入线程池
    CompletableFuture<String> test2 = test1.thenApplyAsync(s -> {
      sleep(Integer.parseInt(s));
      return s + ":thenApply";
    }, executor);
    System.out.println("end:" + test2.get());
  }

  @Test
  public void test2() {
    List<Integer> messages = Arrays.asList(2500, 2000, 1500, 3000, 4000, 3500);
    CompletableFuture<Void> allOf = CompletableFuture
        .allOf(messages.stream().map(val ->
            CompletableFuture.completedFuture(val).thenApplyAsync(v -> {
              sleep(v);
              return v;
            })
        ).toArray(CompletableFuture[]::new));
    //等待上面的线程执行完
    allOf.join();
    allOf.whenComplete((aVoid, throwable) -> System.out
        .println("result was completed"));
  }


  private static class RenderImage implements Callable<Integer>, Function<String, Integer> {

    @Override
    public Integer call() throws Exception {
      int i = random.nextInt(1000);
      System.out.println("call:" + i);
      TimeUnit.MILLISECONDS.sleep(i);
      return i;
    }

    @Override
    public Integer apply(String s) {
      System.out.println("apply:" + s);
      sleep(Integer.parseInt(s));
      return Integer.parseInt(s);
    }
  }

  private static void sleep(int time) {
    try {
      TimeUnit.MILLISECONDS.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
